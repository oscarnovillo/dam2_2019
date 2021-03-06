package testBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class TestUpdate {

    public static final String UPDATE_TABLE_FECHAS_SET_NAME_WHERE_ID =
            "update table_fechas set name= ?,numero = ? where id = ?";

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = db.getConnection();

            Thread.sleep(100000);
            stmt = con.prepareStatement
                    (UPDATE_TABLE_FECHAS_SET_NAME_WHERE_ID);
            stmt.setInt(3,
                    15);
            stmt.setInt(2,
                    100);
            stmt.setString(1, "cambiado");

            int numeroFilas = stmt.executeUpdate();

            System.out.println("numero de filas afecto " + numeroFilas);
        } catch (Exception e) {
            Logger.getLogger("Main").info(e.getMessage());
        } finally {
            db.cerrarStatement(stmt);
            db.cerrarConexion(con);
        }
    }
}
