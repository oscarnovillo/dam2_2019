package main;

import com.github.javafaker.Faker;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.Persona;
import modelo.PersonaConverter;
import modelo.Things;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TutorialInsertDelete {

  public static Faker faker = new Faker();

  public static void main(String[] args) {
    MongoClient mongo = MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334");

    MongoDatabase db = mongo.getDatabase("oscar");

    MongoCollection est = db.getCollection("est");


    Persona p = new Persona();
    p.setName(faker.name().name());
    List<Things> cosas;
    cosas = new ArrayList<>();
    cosas.add(Things.builder().nombre(faker.food().dish()).cantidad(faker.number().numberBetween(10,20)).build());
    p.setCosas(cosas);

    PersonaConverter pc = new PersonaConverter();
    Document d = pc.convertPersonaDocument(p);
    est.insertOne( d);
    p.set_id(d.getObjectId("_id"));
    System.out.println(p);

   // System.out.println(est.deleteOne(new Document("_id", p.get_id())).getDeletedCount());
   // System.out.println(est.deleteOne(Document.parse("{ _id : ObjectId(\""+p.get_id()+"\") }")).getDeletedCount());
    System.out.println(p.get_id());

  }
}
