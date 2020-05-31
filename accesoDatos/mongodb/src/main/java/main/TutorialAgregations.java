package main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TutorialAgregations {

  public static void main(String[] args) {
    /*
    {$match: {"asignaturas.nombre" : { $in : ["Lengua","Quimica"]}}},
    {$unwind : "$asignaturas"},
    {$group: {_id : "$asignaturas.nombre",numeroAlumnos : { $sum: 1} }},
    {$project: { nombre: "$_id",numeroAlumnos:1,_id:0}}

 */

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
    MongoClient mongo = MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334");

    MongoDatabase db = mongo.getDatabase("oscar");

    MongoCollection<Document> col = db.getCollection("profesores");

    col.aggregate(List.of(Document.parse("{$match: {\"asignaturas.nombre\" : { $in : [\"Lengua\",\"Quimica\"]}}}"),
        Document.parse("{$unwind : \"$asignaturas\"}"),
        Document.parse("{$group: {_id : \"$asignaturas.nombre\",numeroAlumnos : { $sum: 1} }}"),
        Document.parse("{$project: { nombre: \"$_id\",numeroAlumnos:1,_id:0}}")
    ))
        .map(document -> document.getString("nombre")+" tiene "+document.getInteger("numeroAlumnos")+ " alumnos ").into(new ArrayList<>()).forEach(System.out::println);

    col = db.getCollection("profesores");
    col.aggregate(List.of(Document.parse("{$unwind : \"$asignaturas\"}"),
        Document.parse("{ $lookup:  {from: \"estudiantes\",\n" +
            "           localField: \"asignaturas.nombre\",\n" +
            "           foreignField: \"asignaturas.nombre\",\n" +
            "           as: \"asi\"\n" +
            "        }\n" +
            "    }"),
        Document.parse("{$set : {tam: {$size: \"$asi\"}}}"),
        Document.parse("{$project : { nif: \"$nif\",asignatura: \"$asignaturas.nombre\",tam: 1, _id:0}}")
    ))
        .map(document -> "profesor " + document.getString("nif")+ " "+document.getString("asignatura")+" tiene "+document.getInteger("tam")+ " alumnos ").into(new ArrayList<>()).forEach(System.out::println);





/*




//Buena
{$unwind: "$asignaturas"},
{$set : {maxConv : {$max:"$asignaturas.notas.convocatoria"}}},
{$unwind: "$asignaturas.notas"},
{$match : { $expr: { $eq: [ "$asignaturas.notas.convocatoria" , "$maxConv" ] } }},
{$set : {nota: "$asignaturas.notas.nota",nombre:"$asignaturas.nombre"}},
{$project : {"nota":1,"nombre":1,"_id":0}}


// numero alumnos por asignatura
{$match: {"asignaturas.nombre" : { $in : ["Lengua","Quimica"]}}},
{$unwind : "$asignaturas"},
{$group: {_id : "$asignaturas.nombre",numeroAlumnos : { $sum: 1} }},
{$project: { nombre: "$_id",numeroAlumnos:1,_id:0}}


// otra opcion con el lookup dando el profesor.
{$unwind : "$asignaturas"},
{ $lookup:  {from: "estudiantes",
           localField: "asignaturas.nombre",
           foreignField: "asignaturas.nombre",
           as: "asi"
        }
    },
    {$set : {tam: {$size: "$asi"}}},
    {$project : { nif: "$nif",asignatura: "$asignaturas.nombre",tam: 1, _id:0}}
 */


  }
}
