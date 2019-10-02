package testBD;

import com.github.javafaker.Faker;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class FechaAleatoria {
  public static void main(String[] args) throws ParseException {
    Faker f = new Faker();


    System.out.println(f.date().future(1000, TimeUnit.DAYS));
  }
}
