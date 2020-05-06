package modelo;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonaConverter {


  public Document convertPersonaDocument(Persona p) {
    Document d = new Document().append("name", p.getName());
//        .append("fecha", Date.from(p.getFecha().atStartOfDay()
//            .atZone(ZoneId.systemDefault())
//            .toInstant()));

    d.append("cosas", p.getCosas().stream()
        .map(things -> new Document().append("nombre", things.getNombre())
            .append("cantidad", things.getCantidad()))
        .collect(Collectors.toList()));
    return d;
  }

  public Persona convertDocumentPersona(Document d) {

    return Persona.builder().name(d.getString("name"))
        .fecha(Optional.ofNullable(d.getDate("fecha")).orElse(new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
        ._id(d.getObjectId("_id"))
        .cosas((d.getList("cosas",Document.class)).stream().map(document ->
            Things.builder()
            .nombre(document.getString("nombre"))
            .cantidad(document.getInteger("cantidad")).build()).collect(Collectors.toList()))
        .build();
  }
}
