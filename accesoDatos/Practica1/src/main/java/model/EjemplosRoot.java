/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oscar
 */
@XmlRootElement
public class EjemplosRoot {

  public EjemplosRoot(List<Ejemplo> ejemplos) {
    this.ejemplos = ejemplos;
  }

  public EjemplosRoot() {
  }
  
  private List<Ejemplo> ejemplos;

  public List<Ejemplo> getEjemplos() {
    return ejemplos;
  }

  public void setEjemplos(List<Ejemplo> ejemplos) {
    this.ejemplos = ejemplos;
  }
  
  
}
