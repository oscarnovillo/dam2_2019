package main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MainSpring {

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");

    MongoClient mongoClient = MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334");

    MongoTemplate mp = new MongoTemplate(mongoClient, "oscar");




  }
}
