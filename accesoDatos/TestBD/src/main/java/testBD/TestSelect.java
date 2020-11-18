package testBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class TestSelect {


    public static final String SELECT_FROM_TABLE_FECHAS =
            "select * from table_fechas2";

    public static void main(String[] args) {
        DBConnection db = new DBConnection();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs=null;

        try {
            con = db.getConnection();
            stmt = con.createStatement();

            rs = stmt.executeQuery(SELECT_FROM_TABLE_FECHAS);

            while (rs.next())
            {
                System.out.print(rs.getInt("id"));
                System.out.print(" "+rs.getString("name"));
                System.out.print(" "+rs.getTimestamp("date").toLocalDateTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
                System.out.print(" "+rs.getInt("numero"));
                System.out.println();
            }

        } catch (Exception e) {
            Logger.getLogger("Main").info(e.getMessage());
        } finally {
            db.cerrarResultSet(rs);
            db.cerrarStatement(stmt);
            db.cerrarConexion(con);
        }
    }


}
