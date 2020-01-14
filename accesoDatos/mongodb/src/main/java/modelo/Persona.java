package modelo;



import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @AllArgsConstructor
@Builder @ToString
public class Persona {


  private ObjectId _id;

  private String name;
  private LocalDate fecha;

  private List<Things> cosas;

  public Persona() {
    cosas = new ArrayList<>();
    fecha = LocalDate.now();
  }
}
