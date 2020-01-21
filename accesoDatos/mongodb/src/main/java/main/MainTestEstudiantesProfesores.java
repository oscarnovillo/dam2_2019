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

    //col.updateOne(Document.parse("{\"nif\":\"profe\"}"),Document.parse("{\"$push\":{\"asignaturas\":{\"nombre\":\"testing\"}}}"));

    col.distinct("asignaturas.nombre",String.class).into(new ArrayList<>()).forEach(System.out::println);

    col.updateOne(Document.parse("{\"asignaturas.nombre\":\"testing\"}"),Document.parse("{\"$set\":{\"asignaturas.$$.nombre\":\"cambio\"}}"));

    col.distinct("asignaturas.nombre",String.class).into(new ArrayList<>()).forEach(System.out::println);

    //col.updateOne(Document.parse("{\"nif\":\"profe\"}"),Document.parse("{\"$pull\":{\"asignaturas\":{\"nombre\":\"testing\"}}}"));


    col = db.getCollection("estudiantes");


    col.aggregate(List.of(Document.parse("{$unwind : \"$asignaturas\"}"),Document.parse("{$set : {maxConv : {$max:\"$asignaturas.notas.convocatoria\"}}}"),
        Document.parse("{$unwind: \"$asignaturas.notas\"}"),
            Document.parse("{$match : { $expr: { $eq: [ \"$asignaturas.notas.convocatoria\" , \"$maxConv\" ] } }}"),
            Document.parse("{$set : {nota: \"$asignaturas.notas.nota\",asignatura:\"$asignaturas.nombre\"}}"),
            Document.parse("{$project : {\"nota\":1,\"nombre\":1,\"asignatura\":1,\"_id\":0}}")
            ))
        .map(document -> document.getString("nombre")+" tiene "+document.getInteger("nota")).into(new ArrayList<>()).forEach(System.out::println);


/*




//Buena
{$unwind: "$asignaturas"},
{$set : {maxConv : {$max:"$asignaturas.notas.convocatoria"}}},
{$unwind: "$asignaturas.notas"},
{$match : { $expr: { $eq: [ "$asignaturas.notas.convocatoria" , "$maxConv" ] } }},
{$set : {nota: "$asignaturas.notas.nota",nombre:"$asignaturas.nombre"}},
{$project : {"nota":1,"nombre":1,"_id":0}}


 */
  }

}
