package testBD;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DirectoresEpisodios {


  public static void main(String[] args) throws Exception {
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    Faker f = new Faker();

    PreparedStatement stmt = con.prepareStatement("update episodios set id_director = ? where id = ?");

    for (int i=1; i<= 17020706; i++)
    {
      int idDirector = f.random().nextInt(1,577328);
      stmt.setInt(1,idDirector);
      stmt.setInt(2,i);
      stmt.addBatch();
      if ((i % 10000)==0)
      {
        System.out.println(i);
        stmt.executeBatch();
        System.out.println(i);
      }
    }

  }
}