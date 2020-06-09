package main;

import org.apache.logging.log4j.LogManager;

public class MainLog {

  public static void main(String[] args) {
    System.setProperty("log4j.configurationFile", "log4j2.xml");


    LogManager.getLogger(MainLog.class)

        .error("esto es un error");

    LogManager.getLogger(MainLog.class)
        .debug("esto es un debug");
  }
}
