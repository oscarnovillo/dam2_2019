package testBD;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EpisodiosBatch {

    public static void main(String[] args) throws Exception {

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        con.setAutoCommit(false);
        Faker f = new Faker();

        PreparedStatement stmt = con.prepareStatement("insert into episodios (numero,id_serie) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        for (int i = 200000; i < 300000; i++) {
            int numeroEpisodios = f.random().nextInt(20,50);
            for (int j = 1; j < numeroEpisodios; j++) {
                long idEpisodio = 0;
                stmt.setInt(1, j);
                stmt.setLong(2, i);
                stmt.addBatch();
            }

        }
        System.out.println("ejecutando 200000");
        stmt.executeBatch();
        System.out.println("ejecutando 200000");
        for (int i = 400000; i < 500000; i++) {
            int numeroEpisodios = f.random().nextInt(20,50);
            for (int j = 1; j < numeroEpisodios; j++) {
                long idEpisodio = 0;
                stmt.setInt(1, j);
                stmt.setLong(2, i);
                stmt.addBatch();
            }

        }
        System.out.println("ejecutando 400000");
        stmt.executeBatch();
        System.out.println("ejecutando 400000");
        for (int i = 300000; i < 400000; i++) {
            int numeroEpisodios = f.random().nextInt(20,50);
            for (int j = 1; j < numeroEpisodios; j++) {
                long idEpisodio = 0;
                stmt.setInt(1, j);
                stmt.setLong(2, i);
                stmt.addBatch();
            }

        }
        System.out.println("ejecutando 400000");
        stmt.executeBatch();
        System.out.println("ejecutando 400000");

        con.commit();
    }
}
