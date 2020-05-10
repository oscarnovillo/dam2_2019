package main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Updates.*;

public class TutorialUpdate {

  public static void main(String[] args) {
    MongoClient mongo = MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334");

    MongoDatabase db = mongo.getDatabase("oscar");

    MongoCollection<Document> est = db.getCollection("est");


    est.updateOne(
        eq("name", "nuevo"),
        Updates.combine(set("cosas.$[].nombre", "nuevo2")));


    System.out.println(est.updateOne(
        eq("name", "nuevo"),
        inc("cosas.$[].cantidad", 1)).getModifiedCount());

    System.out.println(est.updateOne(
        eq("name", "nuevo"),
        push("cosas",
            new Document("nombre","nuevo2").append("cantidad",10)))
        .getModifiedCount());

    System.out.println(est.updateOne(
        eq("name", "nuevo"),
        pull("cosas",
            new Document("nombre","nuevo2")))
        .getModifiedCount());


    System.out.println(est.updateOne(eq("name", "kkl"),
       inc("cosas.$[cosa].cantidad",1),
        new UpdateOptions().arrayFilters(
            List.of(regex("cosa.nombre","^c.*")))).getModifiedCount());

//    System.out.println(est.updateMany(
//        eq("name","kkl"),
//        set("cosas.$.cantidad","1")).getModifiedCount());

    // updates $pull, $push, $[<identifier>] update options

  }
}
