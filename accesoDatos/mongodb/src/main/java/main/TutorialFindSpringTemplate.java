package main;

import com.mongodb.client.MongoClients;
import modelo.Persona;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class TutorialFindSpringTemplate {

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");



    MongoTemplate mp = new MongoTemplate(MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334"), "oscar");


    Query query = new Query().addCriteria(Criteria.where("name").regex("^L"));
    query.fields().include("name").exclude("_id");


    Persona p = mp.findOne(query, Persona.class);

    System.out.println(p);






  }
}
