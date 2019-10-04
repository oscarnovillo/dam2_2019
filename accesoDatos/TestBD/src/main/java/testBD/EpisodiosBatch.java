package testBD;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EpisodiosBatch {

    public static void main(String[] args) throws Exception {

        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        Faker f = new Faker();

        PreparedStatement stmt = con.prepareStatement("insert into episodios (numero,id_serie) values (?,?)", Statement.RETURN_GENERATED_KEYS);
        for (int i = 200001; i < 300000; i++) {
            int numeroEpisodios = f.random().nextInt(20,50);
            for (int j = 1; j < numeroEpisodios; j++) {
                long idEpisodio = 0;
                stmt.setInt(1, j);
                stmt.setLong(2, i);
                stmt.addBatch();
            }

        }
        stmt.executeBatch();
        for (int i = 400001; i < 500000; i++) {
            int numeroEpisodios = f.random().nextInt(20,50);
            for (int j = 1; j < numeroEpisodios; j++) {
                long idEpisodio = 0;
                stmt.setInt(1, j);
                stmt.setLong(2, i);
                stmt.addBatch();
            }

        }
        stmt.executeBatch();
        for (int i = 300001; i < 400000; i++) {
            int numeroEpisodios = f.random().nextInt(20,50);
            for (int j = 1; j < numeroEpisodios; j++) {
                long idEpisodio = 0;
                stmt.setInt(1, j);
                stmt.setLong(2, i);
                stmt.addBatch();
            }

        }
        stmt.executeBatch();
    }
}
