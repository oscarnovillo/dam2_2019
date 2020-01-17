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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
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
    col.find(Document.parse("{\"name\":/kk/}"))
        .forEach((Consumer<Document>)document -> personas.add(pc.convertDocumentPersona(document)));

    personas.forEach(System.out::println);

    MongoCollection<Document> colMadrid = db.getCollection("madrid");
    colMadrid.find(Document.parse("{\"title\":{\"$regex\":\"amor.*e$\"}}"))
        .forEach((Consumer<Document>)document -> System.out.println(document.toJson()));

    List<String> dates = colMadrid.find(Document.parse("{\"title\":/^C.*amor.*e$/}")).projection(Document.parse("{\"dtstart\":1}"))
        .map(document -> document.getString("dtstart")).into(new ArrayList<String>());

    dates.forEach(System.out::println);


    colMadrid.find(Document.parse("{\"dtstart\":{\"$gt\":ISODate(\"2010-01-01\")}}"))
        .forEach((Consumer<Document>)document -> System.out.println(document.toJson()));

    Calendar c = Calendar.getInstance();
    c.set(2010,1,1);

    colMadrid.find(gt("dtstart", c.getTime()))
        .forEach((Consumer<Document>)document -> System.out.println(document.toJson()));

    System.out.println("count " +colMadrid.countDocuments());

    System.out.println("count date " +colMadrid.countDocuments(exists("dtstart", true)));

    System.out.println("count filtrado " +colMadrid.countDocuments(Document.parse("{\"title\":/^C.*amor.*e$/}")));

    System.out.println(" numero de organizaciones "+colMadrid.distinct("organization",Document.class).into(new ArrayList<>()).size());

    System.out.println(" numero de CP "+colMadrid.distinct("address.area",Document.class).into(new ArrayList<>()).size());

    colMadrid.distinct("address.area",Document.parse("{\"address.area.postal-code\":\"28045\"}"),Document.class).map(document -> document.getString("postal-code")+" "+document.getString("street-address")).into(new ArrayList<>()).forEach(System.out::println);

  }


}
