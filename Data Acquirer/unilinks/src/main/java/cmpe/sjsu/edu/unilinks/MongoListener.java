/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cmpe.sjsu.edu.unilinks;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;
import org.fusesource.stomp.jms.message.StompJmsMessage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;
import com.mongodb.DBCursor;

import java.net.UnknownHostException;



class MongoListener {

    public static void main(String []args) throws JMSException, UnknownHostException {
	
    	String textUri = "mongodb://unilinks:unilinks@ds053818.mongolab.com:53818/unilinks";
		MongoClientURI uri = new MongoClientURI(textUri);
		MongoClient m = new MongoClient(uri); 
		DB db= m.getDB(uri.getDatabase());
		DBCollection collection = db.getCollection("univinfo");
					
		String user = "admin";
		String password = "password";
		String host = "54.215.151.111";
		int port = 61613;
		String destination = "/queue/unilinks";
		
		StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
		factory.setBrokerURI("tcp://" + host + ":" + port);

		Connection connection = factory.createConnection(user, password);
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = new StompJmsDestination(destination);

		MessageConsumer consumer = session.createConsumer(dest);
		System.out.println("Waiting for messages from " + destination + "...");
		while(true) {
			Message msg = consumer.receive();
			if( msg instanceof  TextMessage ) {
				String body = ((TextMessage) msg).getText();
				if( "SHUTDOWN".equals(body)) {
					break;
				}
			//	System.out.println("Received message = " + body);
				Gson gson =new GsonBuilder().create();
				UniversityObject universityobject = gson.fromJson(body,UniversityObject.class);
				int id = universityobject.getId();
				BasicDBObject query = new BasicDBObject("_id",id);
				collection.findAndRemove(query);
				
				DBObject univinfobj = (DBObject) JSON.parse(body);
				collection.insert(univinfobj);
			} 
			else if (msg instanceof StompJmsMessage) {
				StompJmsMessage smsg = ((StompJmsMessage) msg);
				String body = smsg.getFrame().contentAsString();
				if ("SHUTDOWN".equals(body)) {
					break;
				}
			}
			else {
				System.out.println("Unexpected message type: "+msg.getClass());
			}
		}
		connection.close();
    }
}
