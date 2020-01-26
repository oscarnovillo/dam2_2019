package main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import modelo.MongoDBConfig;
import modelo.Persona;
import modelo.PersonaRepository;
import modelo.Things;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import servicios.PersonaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainSpring {



  static PersonaRepository rp;

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("servicios");
    ctx.register(MongoDBConfig.class);
    ctx.refresh();


    MongoTemplate mp = ctx.getBean(MongoTemplate.class);

    Persona p = new Persona();
    p.setName("con spring");
    List<Things> cosas;
    cosas = new ArrayList<>();
    cosas.add(Things.builder().nombre("nombre").cantidad(2).build());
    p.setCosas(cosas);
    mp.insert(p);
    System.out.println(p.get_id());

    mp.insert(Persona.class).inCollection("nueva").one(p);

    p.setName("update");
    mp.save(p);

    Query query = new Query();
    query.addCriteria(Criteria.where("name").is("update").and("cosas").exists(true));

    mp.find(query,Persona.class);
    mp.update(Persona.class).apply(new Update().push("array","").filterArray(Criteria.where("ji")));

    rp  = ctx.getBean(PersonaRepository.class);
    rp.findAll().forEach(System.out::println);

    PersonaService ps = ctx.getBean(PersonaService.class);

    ps.findAll().forEach(System.out::println);

    mp.updateMulti(new Query().addCriteria(Criteria.where("cosas.nombre").is("nombre")),
        new Update().inc("cosas.$[cosas].cantidad",2).filterArray(Criteria.where("cosas.nombre").is("nombre")),Persona.class);

    System.out.println("name");
    rp.findByCosasNombre("nombre",4).forEach(System.out::println);

  }
}
