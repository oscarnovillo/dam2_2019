package testBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class TestDelete {


    public static final String DELETE_TABLE_FECHAS_WHERE_ID =
            "delete from table_fechas where id = ?";

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = db.getConnection();
            stmt = con.prepareStatement
                    (DELETE_TABLE_FECHAS_WHERE_ID);
            stmt.setInt(1,
                    15);

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
