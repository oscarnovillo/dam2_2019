package main;

import com.github.javafaker.Faker;
import com.mongodb.client.*;
import modelo.Persona;
import modelo.PersonaConverter;
import modelo.Things;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Transacciones {
  public static Faker faker = new Faker();
  public static void main(String[] args) {
    MongoClient mongo = MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334");
    ClientSession s = mongo.startSession();

    MongoDatabase db = mongo.getDatabase("oscar");


    MongoCollection<Document> est = db.getCollection("est");
    Persona p = new Persona();
    p.setName(faker.name().name());
    List<Things> cosas;
    cosas = new ArrayList<>();
    cosas.add(Things.builder().nombre(faker.food().dish()).cantidad(faker.number().numberBetween(10,20)).build());
    p.setCosas(cosas);

    PersonaConverter pc = new PersonaConverter();
    Document d = pc.convertPersonaDocument(p);
    est.insertOne( d);

    s.abortTransaction();
    mongo.close();

  }
}
