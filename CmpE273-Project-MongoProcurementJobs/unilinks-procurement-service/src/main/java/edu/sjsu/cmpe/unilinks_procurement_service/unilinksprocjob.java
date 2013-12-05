package edu.sjsu.cmpe.unilinks_procurement_service;
import edu.sjsu.cmpe.unilinks_procurement_service.unilinksprocservice;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.core.MediaType;

import org.fusesource.stomp.jms.StompJmsConnectionFactory;
import org.fusesource.stomp.jms.StompJmsDestination;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.Every;


@Every("3660s")
public class unilinksprocjob extends Job{
        
        Connection consumerConnection;
        Connection publisherConnection;
       // @Override
        @Override
        public void doJob() throws FileNotFoundException{
                
             
                
                String user = "admin";
            	String password = "password";
            	String host = "54.215.151.111";
            	Client client = new Client();
            	 //String host = "localhost";
            	int port = 61613;
            	String queue = "/queue/unilinks";
            	//String destination = "";
            	StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
            	factory.setBrokerURI("tcp://" + host + ":" + port);
            	Connection connection;
            	String FileName = new String();
            	try
            	{
            	URL url = getClass().getResource("UniversityDB.txt");
            	FileName = url.getPath();
            	//System.out.println(url.toString());
            	}
            	catch(Exception e)
            	{System.out.println(e);}
            	//BufferedReader reader = new BufferedReader(new FileReader("UniversityDB.txt"));
            	BufferedReader reader = new BufferedReader(new FileReader(FileName));
            	String line = null;
            	String Data = new String();
            	try {
					while ((line = reader.readLine()) != null) {
					    Data=Data + line;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        
         String messageData = new String();
         String[] msg_array = Data.split("%");
         int length = msg_array.length;
         
         String msg_Text = new String();
         
              
            	
         for(int i=1; i<length; i++){
            	
				try {
					connection = factory.createConnection(user, password);
				
            	connection.start();
            	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            	Destination dest = new StompJmsDestination(queue);
            	MessageProducer producer = session.createProducer(dest);
            	producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            	System.out.println("Sending messages to " + queue + "...");
            	
            	//String data = json;
            	msg_Text = msg_array[i];
            	System.out.println(msg_Text);
            	
            	TextMessage msg = session.createTextMessage(msg_Text);
            	msg.setLongProperty("id", System.currentTimeMillis());
            	producer.send(msg);
            	//producer.send(session.createTextMessage("SHUTDOWN"));
            	connection.close();
               
               
               
        } catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
            }
        }
        
}