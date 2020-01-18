package main;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import modelo.Persona;
import modelo.PersonaConverter;
import modelo.Things;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MainDriver {

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");

    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
        fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://dam2.tomcat.iesquevedo.es:3334"));

    MongoDatabase db = mongoClient.getDatabase("oscar");

    MongoCollection<Persona> col = db.getCollection("est", Persona.class).withCodecRegistry(pojoCodecRegistry);
    Persona p = new Persona();
    p.setName("jj");
    List<Things> cosas;
    cosas = new ArrayList<>();
    cosas.add(Things.builder().nombre("cachos").cantidad(2).build());
    p.setCosas(cosas);
    col.insertOne(p);
    System.out.println(p.get_id());


    Gson gson = new Gson();
    MongoCollection<Document> col1 = db.getCollection("est");
    Document d = Document.parse( gson.toJson(p));
    col1.insertOne(d);
    System.out.println(d.getObjectId("_id"));



    PersonaConverter pc = new PersonaConverter();
    p.getCosas().add(Things.builder().nombre("extra").cantidad(1).build());
    Document d1 = pc.convertPersonaDocument(p);
    col1.insertOne(d1);
    p = pc.convertDocumentPersona(d1);
    System.out.println(p);


    p.setName("kk");
    p.setFecha(LocalDate.of(1000,1,1));
    col1.updateOne(new Document().append("_id",p.get_id()),
       new Document().append("$set",pc.convertPersonaDocument(p)));

    col1.updateOne(new Document().append("_id",p.get_id()),
        new Document().append("$set",pc.convertPersonaDocument(p)));


    d = col1.find(eq("_id",p.get_id())).first();
    p = pc.convertDocumentPersona(d);
    System.out.println("START");

    col1.find(Document.parse("{$expr:{$gt:[{$size:\"$cosas\"}, 2]}}")).forEach((Consumer<Document>)document ->
        System.out.println(pc.convertDocumentPersona(document)));


    // System.out.println(col1.deleteMany(new Document()).getDeletedCount());
  }


}
