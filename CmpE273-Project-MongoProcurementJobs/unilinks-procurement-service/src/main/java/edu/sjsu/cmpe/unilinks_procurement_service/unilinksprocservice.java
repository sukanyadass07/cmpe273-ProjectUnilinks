package edu.sjsu.cmpe.unilinks_procurement_service;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.config.Configuration;

import de.spinscale.dropwizard.jobs.JobsBundle;
import edu.sjsu.cmpe.unilinks_procurement_service.RootResource;


/**
 * @author Miti
 *
 */
public class unilinksprocservice extends Service<Configuration> {
	//private final static ArrayList<UniversityObject> University = new ArrayList<UniversityObject>();

    public static void main(String[] args) throws Exception {
    	
  
    	
        new unilinksprocservice().run(args);       
        
        
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.setName("unilinks-procurement-service");
        
        bootstrap.addBundle(new JobsBundle("edu.sjsu.cmpe.unilinks_procurement_service"));
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
            environment.addResource(RootResource.class);
            
            }
    
    
  /*  public static UniversityObject getUniByIndex(int i)
    {
     	 	
    	return University.get(i);
    }*/
}