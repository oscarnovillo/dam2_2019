package main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;

public class TutorialUpdate {

  public static void main(String[] args) {
    MongoClient mongo = MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334");

    MongoDatabase db = mongo.getDatabase("oscar");

    MongoCollection<Document> est = db.getCollection("est");


    est.updateOne(
        eq("_id", new ObjectId("57506d62f57802807471dd41")),
        Updates.combine(set("stars", 1), set("contact.phone", "228-555-9999"), currentDate("lastModified")));

    System.out.println(est.updateMany(
        eq("name","kkl"),
        set("cosas.$.cantidad","1")).getModifiedCount());

    // updates $pull, $push, $[<identifier>] update options

  }
}
