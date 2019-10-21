package utils;

import java.util.stream.Collectors;

public class CifradoCesar {


  public String cifra(String valor, int clave) {
    return valor.chars().map(operand -> operand + clave)
        .mapToObj(value -> String.valueOf((char) value))
        .collect(Collectors.joining());
  }


  public String descifra(String valor, int clave) {
    return valor.chars().map(operand -> operand - clave)
        .mapToObj(value -> String.valueOf((char) value))
        .collect(Collectors.joining());
  }

  public void dummy()
  {

  }

}
