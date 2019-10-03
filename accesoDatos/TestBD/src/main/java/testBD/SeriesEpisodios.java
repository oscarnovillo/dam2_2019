package testBD;

import com.github.javafaker.Faker;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class SeriesEpisodios {
  public static void main(String[] args) throws Exception {
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    Faker f = new Faker();

    for (int i = 0; i < 1000000; i++) {
      PreparedStatement stmt = con.prepareStatement("insert into series (name) values (?)", Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, f.funnyName().name() + " " + f.number().digits(10));
      stmt.executeUpdate();
      ResultSet rs = stmt.getGeneratedKeys();
      long idSerie=0;
      if (rs != null && rs.next()) {
         idSerie = rs.getLong(1);
      }
      for (int j=1; j<50; j++){
        long idEpisodio=0;
        stmt = con.prepareStatement("insert into episodios (numero,id_serie) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, j);
        stmt.setLong(2,idSerie);
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        if (rs != null && rs.next()) {
          idEpisodio = rs.getLong(1);
        }
        for (int k=0;k<5000; k++)
        {
          stmt = con.prepareStatement("insert into retransmisiones (id_episodio,fecha) values (?,?)");
          stmt.setLong(1, idEpisodio);
          stmt.setTimestamp(2,new java.sql.Timestamp(f.date().future(365, TimeUnit.DAYS).getTime()));
          stmt.executeUpdate();
        }

      }


    }


    con.close();
  }
}
