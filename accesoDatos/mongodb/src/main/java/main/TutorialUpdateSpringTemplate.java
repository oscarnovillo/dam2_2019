package main;

import com.mongodb.client.MongoClients;
import modelo.Persona;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class TutorialUpdateSpringTemplate {
  public static void main(String[] args) {


    MongoTemplate mp = new MongoTemplate(MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334"), "oscar");

    System.out.println(mp.updateMulti(new Query().addCriteria(Criteria.where("cosas.nombre").is("cachos")),
        new Update().inc("cosas.$[cosas].cantidad",2).filterArray(Criteria.where("cosas.nombre").is("cachos")), Persona.class).getModifiedCount());

  }
}
