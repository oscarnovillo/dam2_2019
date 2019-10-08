package testBD;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;

public class RetransmisionesBatch {

  public static void main(String[] args) throws Exception {
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    con.setAutoCommit(false);
    Faker f = new Faker();

    PreparedStatement stmt = con.prepareStatement("insert into retransmisiones (id_episodio,fecha) values (?,?)");

    for (int k = 112; k <= 17020706; k++) {
      int episodios = f.random().nextInt(100, 400);
      for (int i = 0; i < episodios; i++) {
        stmt.setLong(1, k);
        stmt.setTimestamp(2, new java.sql.Timestamp(f.date().future(365, TimeUnit.DAYS).getTime()));
        stmt.addBatch();
      }
      System.out.print(k);
      if ((k % 1000)==0)
      {
        System.out.println(k);
        stmt.executeBatch();
        con.commit();
        System.out.println(k);
      }


    }
  }
}
