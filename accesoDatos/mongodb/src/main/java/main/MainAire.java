package main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MainAire {

  public static void main(String[] args) {


    System.setProperty("log4j.configurationFile", "log4j2.xml");

    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
        fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://dam2.tomcat.iesquevedo.es:3334"));

    MongoDatabase db = mongoClient.getDatabase("oscar");

    MongoCollection<Document> col = db.getCollection("aire");


/*

{$match : {"subjects.name":"Data Access"}},
{$unwind: {path:"subjects.calls"}}
{$project : {"_id":1,"nif":1,"subjects":1}}

{$project : {"subjects":1,nif:1}},
{$unwind : "$subjects"},
{$unwind: "$subjects.calls"},
{$group:
    {_id: "$nif",
    media:{ $avg: "$subjects.calls.mark"}}
}


 */
  }
}