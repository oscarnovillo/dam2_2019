package main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import modelo.MongoDBConfig;
import modelo.Persona;
import modelo.PersonaRepository;
import modelo.Things;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import servicios.PersonaService;

import java.util.ArrayList;
import java.util.List;

public class MainTestEstudiantesProfesoresSpring {




  static PersonaRepository rp;

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");



    MongoTemplate mp = new MongoTemplate(MongoClients.create("mongodb://dam2.tomcat.iesquevedo.es:3334"), "carlosmartin_database");
/*
    {$match: {"asignaturas.nombre" : { $in : ["Lengua","Quimica"]}}},
    {$unwind : "$asignaturas"},
    {$group: {_id : "$asignaturas.nombre",numeroAlumnos : { $sum: 1} }},
    {$project: { nombre: "$_id",numeroAlumnos:1,_id:0}}

 */
    mp.aggregate(Aggregation.newAggregation(Aggregation.match(Criteria.where("asignaturas.nombre").in(List.of("Lengua","Fisica"))),
    Aggregation.unwind("asignaturas"),
    Aggregation.group("asignaturas.nombre").count().as("numeroAlumnos"),
    Aggregation.project().andExpression("_id").as("nombre").andExpression("numeroAlumnos")),"estudiantes",String.class);


  }

}
