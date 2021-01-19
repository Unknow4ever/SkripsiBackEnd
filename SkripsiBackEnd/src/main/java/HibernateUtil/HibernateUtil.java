package main.java.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static StandardServiceRegistry standardServiceRegistry;
  private static SessionFactory sessionFactory;

  static{
	    if (sessionFactory == null) {
	      try {	        
	        standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();	       
	        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry); 
	        Metadata metadata = metadataSources.getMetadataBuilder().build();
	        sessionFactory = metadata.getSessionFactoryBuilder().build();
	    	  
	    	//sessionFactory = new Configuration().configure().buildSessionFactory();
	      } catch (Exception e) {
	        e.printStackTrace();
	        if (standardServiceRegistry != null) {
	          StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
	        }
	      }
	    }
  }
  //Utility method to return SessionFactory
  public static SessionFactory getSessionFactory() {
	  return sessionFactory;
  }
}
