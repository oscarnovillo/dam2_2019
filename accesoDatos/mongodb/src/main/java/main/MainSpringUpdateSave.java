package main;

import com.mongodb.client.MongoClients;
import modelo.Persona;
import modelo.Things;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDate;

public class MainSpringUpdateSave {

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");



    MongoTemplate mp = new MongoTemplate(MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334"), "oscar");

    Persona p = mp.findOne(new Query().addCriteria(Criteria.where("name").is("update")), Persona.class);

    System.out.println(p);

//    p.setFecha(LocalDate.now());
//    p.getCosas().add(Things.builder().cantidad(12).nombre("teclados").build());
//
//    mp.save(p);


  }
}
