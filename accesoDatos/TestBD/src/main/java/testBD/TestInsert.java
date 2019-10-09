package testBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class TestInsert {

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            stmt = con.prepareStatement
                    ("insert into table_fechas (name,date,numero) values (?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            stmt.setTimestamp(2,
                    java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setString(1, "nma");
            stmt.setInt(3, 7);
            int numeroFilas = stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            long id = 0;
            if (rs != null && rs.next()) {
                id = rs.getLong(1);
            }
            System.out.println("numero de filas afecto " + numeroFilas + " con id " + id);
        } catch (Exception e) {
            Logger.getLogger("Main").info(e.getMessage());
        } finally {
            db.cerrarResultSet(rs);
            db.cerrarStatement(stmt);
            db.cerrarConexion(con);
        }
    }
}
