package testBD;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValues;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main2 {
  public static void main(String[] args) throws Exception {
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    Faker f = new Faker();

    for (int i=0; i<1000000;i++) {
      PreparedStatement stmt = con.prepareStatement("insert into directores (name) values (?)");
      stmt.setString(1, f.name().fullName()+ " "+f.number().digits(10));
      stmt.executeUpdate();
    }


    con.close();
  }
}
