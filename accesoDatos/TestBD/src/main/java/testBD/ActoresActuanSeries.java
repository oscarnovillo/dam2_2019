package testBD;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ActoresActuanSeries {

  public static void main(String[] args) throws Exception {
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    con.setAutoCommit(false);
    Faker f = new Faker();

    PreparedStatement stmt = con.prepareStatement("insert into  actuan (id_actor,id_serie) values (?,?)");

    for (int i = 1; i <= 601008; i++) {
      int numeroActores = f.random().nextInt(10, 200);

      for (int j = 0; j < numeroActores; j++) {
        int id_actor = f.random().nextInt(5685,581198);
        stmt.setInt(1,id_actor);
        stmt.setInt(2,i);
        stmt.addBatch();
      }
      if ((i % 10000)==0)
      {
        System.out.println(i);
        stmt.executeBatch();
        con.commit();
        System.out.println(i);
      }
    }
  }
}
