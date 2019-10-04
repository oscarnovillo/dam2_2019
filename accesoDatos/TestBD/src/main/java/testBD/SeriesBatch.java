package testBD;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SeriesBatch {

    public static void main(String[] args) throws Exception {
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        Faker f = new Faker();
        con.setAutoCommit(false);
        PreparedStatement stmt = con.prepareStatement("insert into series (name) values (?)", Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < 500000; i++) {
            stmt.setString(1, f.funnyName().name() + " " + f.number().digits(10));
            stmt.addBatch();
            if (i%100000 == 0)
                System.out.println(i);
        }

        stmt.executeBatch();
        con.commit();

    }
}
