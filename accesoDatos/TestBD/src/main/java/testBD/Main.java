package testBD;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {

  public static void main(String[] args) throws Exception {
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    Faker f = new Faker();

    for (int i=0; i<1000000;i++) {
      PreparedStatement stmt = con.prepareStatement("insert into actores (name) values (?)");
      stmt.setString(1, f.artist().name()+" "+f.number().digits(10));
      stmt.executeUpdate();
    }


    con.close();


  }
}
