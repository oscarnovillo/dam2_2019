package main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MainTestEstudiantesProfesores {

  public static void main(String[] args) {


    System.setProperty("log4j.configurationFile", "log4j2.xml");

    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
        fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://dam2.tomcat.iesquevedo.es:3334"));

    MongoDatabase db = mongoClient.getDatabase("carlosmartin_database");

    MongoCollection<Document> col = db.getCollection("profesores");

    col.distinct("asignaturas.nombre",String.class).into(new ArrayList<>()).forEach(System.out::println);

    col.updateOne(Document.parse("{\"nif\":\"profe\"}"),Document.parse("{\"$push\":{\"asignaturas\":{\"nombre\":\"testing\"}}}"));

    col.distinct("asignaturas.nombre",String.class).into(new ArrayList<>()).forEach(System.out::println);

    col.updateOne(Document.parse("{\"nif\":\"profe\"}"),Document.parse("{\"$pull\":{\"asignaturas\":{\"nombre\":\"testing\"}}}"));

    col.aggregate(List.of(Document.parse("{$unwind : \"$asignaturas\"}"),Document.parse("{$unwind: \"$asignaturas.notas\"}"),
        Document.parse("{$group:\n" +
            "    {_id:  {nif: \"$nif\",\n" +
            "     asignatura: \"$asignaturas.nombre\"},\n" +
            "    media:{ $avg: \"$asignaturas.notas.nota\"}}\n" +
            "}")))

        .map(document -> document.getString("nif")+" "+document.getString("asignatura")+ " "+document.getString("media")).into(new ArrayList<>()).forEach(System.out::println);


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


{$unwind : "$asignaturas"},
{$unwind: "$asignaturas.notas"},
{$set : {maxCall : {"$max":"$asignaturas.notas.convocatoria" }},
{$group:
    {_id:{nif: "$nif",asignatura:"$asignaturas.nombre"},
    media:{ $avg: "$asignaturas.notas.nota"}}
}


//Buena

{$unwind: "$asignaturas"},
{$set : {maxConv : {$max:"$asignaturas.notas.convocatoria"}}},
{$unwind: "$asignaturas.notas"},
{$match : { $expr: { $eq: [ "$asignaturas.notas.convocatoria" , "$maxConv" ] } }}


 */
  }

}
