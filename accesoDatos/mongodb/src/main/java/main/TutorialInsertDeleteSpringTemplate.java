package main;

import com.github.javafaker.Faker;
import com.mongodb.client.MongoClients;
import modelo.Persona;
import modelo.Things;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TutorialInsertDeleteSpringTemplate {


  public static Faker faker = new Faker();

  public static void main(String[] args) {

    Persona p = new Persona();
    p.setName(faker.name().name());
    List<Things> cosas;
    cosas = new ArrayList<>();
    cosas.add(Things.builder().nombre(faker.food().dish()).cantidad(faker.number().numberBetween(10,20)).build());
    p.setCosas(cosas);

    MongoTemplate mp = new MongoTemplate(MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334"), "oscar");

    mp.insert(p);

    mp.insert(Persona.class).inCollection("nueva").one(p);

    System.out.println(p);

    System.out.println(mp.remove(new Query().addCriteria(Criteria.where("name").is("update")),Persona.class).getDeletedCount());
  }
}
