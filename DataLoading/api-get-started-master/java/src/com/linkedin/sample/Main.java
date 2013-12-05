package com.linkedin.sample;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {

    private static String API_KEY = "xxxxxxxxxxxxxx";
    private static String API_SECRET = "xxxxxxxxxxxxxx";

    public static void main(String[] args) throws Exception{


        Token accessToken = null;

        //Using the Scribe library we enter the information needed to begin the chain of Oauth2 calls.
        OAuthService service = new ServiceBuilder()
                                .provider(LinkedInApi.class)
                                .apiKey("pv1u0dfas1uq")
                                .apiSecret("cdwXcpXzJhdXEI0n")
                                .build();

        /*************************************
         * This first piece of code handles all the pieces needed to be granted access to make a data call
         */

        try{
            File file = new File("service.dat");

            if(file.exists()){
                //if the file exists we assume it has the AuthHandler in it - which in turn contains the Access Token
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
                AuthHandler authHandler = (AuthHandler) inputStream.readObject();
                accessToken = authHandler.getAccessToken();
            } else {
                System.out.println("There is no stored Access token we need to make one");
                //In the constructor the AuthHandler goes through the chain of calls to create an Access Token
                AuthHandler authHandler = new AuthHandler(service);
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("service.dat"));
                outputStream.writeObject( authHandler);
                outputStream.close();
                accessToken = authHandler.getAccessToken();
            }

        }catch (Exception e){
            System.out.println("Threw an exception when serializing: " + e.getClass() + " :: " + e.getMessage());
        }
        /*LinkedInAPI Call*/
        System.out.println();
        System.out.println("**************Insert Data into Database*************");
        
        String url="http://api.linkedin.com/v1/people-search:(people:(first-name,last-name,public-profile-url,headline))?keywords=TAMU&format=json";
               	       
        OAuthRequest request = new OAuthRequest(Verb.GET, url);
        
        service.signRequest(accessToken, request);
        Response response = request.send();         
        String Data=response.getBody(); // reading the string value 
        System.out.println("data:"+Data);
       
       
        try{
        JSONObject json = (JSONObject) new JSONParser().parse(Data);   
        JSONObject people = (JSONObject) json.get("people");
        System.out.println("People::"+people.get("_total"));
        Long _total=(Long) people.get("_total");
        //System.out.println("Check Data::"+_total);
        JSONArray y=(JSONArray) people.get("values");       
        System.out.println("Check Data::"+y.toString());
       // PersonDetails pd= new PersonDetails();
       String textUri =  "mongodb://unilinks:unilinks@ds053818.mongolab.com:53818/unilinks";
        //"mongodb://uniinfo:uniinfo@ds053838.mongolab.com:53838/uniinfo";        
        MongoClientURI uri = new MongoClientURI(textUri);		                  
		MongoClient m = new MongoClient(uri);		  
		DB db= m.getDB(uri.getDatabase());
		DBCollection collection = db.getCollection("university");
        for(int i=0;i<y.size();i++){       
	        String s= y.get(i).toString();	        
	        s= s.replace("publicProfileUrl","url");
	        s=s.replace("}", ",\"SchoolName\":\"Texas A&M University\"}");
	        System.out.println("y.get(i):::"+s);
	        Object o = com.mongodb.util.JSON.parse(s);
	        //System.out.println("our:"+sname.concat(m));
	        DBObject dbObj = (DBObject) o;
		    collection.insert(dbObj);
		    System.out.println("Data inserted successfully");
        }
        
    
        }catch(Exception e){System.out.println("error::"+e.getMessage());}   
       
    }

}
