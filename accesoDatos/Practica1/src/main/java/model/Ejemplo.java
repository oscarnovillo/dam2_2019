/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author oscar
 */
@XmlType(propOrder = { "nombre", "edad","fecha" })
public class Ejemplo {
  
  private String nombre;
  private int edad;
  private LocalDate fecha;

  public LocalDate getFecha() {
    return fecha;
  }

  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }
  

  public Ejemplo() {
  }

  public String getNombre() {
    return nombre;
  }

  @XmlElement(name = "title")
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public Ejemplo(String nombre, int edad,String fecha) {
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    this.fecha = 	LocalDate.parse(fecha); //,formatter);
    this.nombre = nombre;
    this.edad = edad;
  }

  @Override
  public String toString() {
    return "Ejemplo{" + "nombre=" + nombre + ", edad=" + edad + ", fecha=" + fecha + '}';
  }


  
  
}
