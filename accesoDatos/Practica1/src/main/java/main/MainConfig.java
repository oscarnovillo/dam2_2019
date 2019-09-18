/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.ConfigurationProperties;
import config.YamlConfig;
import java.awt.print.Book;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import model.Ejemplo;
import model.EjemplosRoot;

/**
 *
 * @author oscar
 */
public class MainConfig {

  public static void main(String[] args) {
    try {
      //ConfigurationProperties c = new ConfigurationProperties();

      System.out.println(ConfigurationProperties.getInstance().getClave());
      System.out.println(ConfigurationProperties.getInstance().getP().getProperty("claves"));
      ConfigurationProperties.getInstance().getClaves()
              .forEach(System.out::println);

      System.out.println(YamlConfig.getInstance().getClave());
      YamlConfig.getInstance().getClaves().forEach(System.out::println);

      // leer ficheros
      List<String> lineas;
//              = Files.lines(Paths.get("files/file.txt"))
//                      .collect(Collectors.toList());
//      lineas.forEach(System.out::println);

      lineas = Files.readAllLines(Paths.get("files/file.txt"));
      lineas.forEach(System.out::println);
      lineas.add("2009-10-10,Linea Nueva,6");
      String todoFicheros = lineas.stream()
              .collect(Collectors.joining("\n"));
      Files.write(Paths.get("files/file.txt"),
              todoFicheros.getBytes());

      String lineaNueva = "\n2009-10-10,nueva Linea APPEND,89";
      Files.write(Paths.get("files/file.txt"),
              lineaNueva.getBytes(), StandardOpenOption.APPEND);

//      List<Ejemplo> ej = new ArrayList<>();
//      for (String linea: lineas)
//      {
//        String[] campos = linea.split(",");
//        Ejemplo e = new Ejemplo(campos[0],
//                Integer.parseInt(campos[1])); 
//        ej.add(e);
//      }
      List<Ejemplo> ej = lineas.stream().map((linea) -> {
        String[] campos = linea.split(",");
        Ejemplo e = new Ejemplo(campos[1],
                Integer.parseInt(campos[2]),campos[0]);
        return e; //
      }).collect(Collectors.toList());

      ej.forEach(System.out::println);

      JAXBContext context = JAXBContext.newInstance(EjemplosRoot.class);
      Marshaller mar = context.createMarshaller();
      mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      mar.marshal(new EjemplosRoot(ej),
              Files.newBufferedWriter(
                      Paths.get("files/ejemplo.xml")));
      
      EjemplosRoot root = 
              (EjemplosRoot)context.createUnmarshaller().unmarshal(Files.newBufferedReader(
                      Paths.get("files/ejemplo.xml")));
      root.getEjemplos().forEach(System.out::println);

    } catch (Exception ex) {
      Logger.getLogger(MainConfig.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
