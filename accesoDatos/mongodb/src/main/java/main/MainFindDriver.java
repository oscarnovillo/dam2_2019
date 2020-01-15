package main;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.Persona;
import modelo.PersonaConverter;
import modelo.Things;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MainFindDriver {

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");

    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
        fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://dam2.tomcat.iesquevedo.es:3334"));

    MongoDatabase db = mongoClient.getDatabase("oscar");

    MongoCollection<Document> col = db.getCollection("est");
    PersonaConverter pc = new PersonaConverter();
    col.find(Document.parse("{$expr:{$gt:[{$size:\"$cosas\"}, 2]}}")).forEach((Consumer<Document>)document ->
        System.out.println(pc.convertDocumentPersona(document)));


    List<Persona> personas = new ArrayList<>();
    col.find(Document.parse("{\"name\":\"kk\"}"))
        .forEach((Consumer<Document>)document -> personas.add(pc.convertDocumentPersona(document)));

    personas.forEach(System.out::println);


    // System.out.println(col1.deleteMany(new Document()).getDeletedCount());
  }


}
