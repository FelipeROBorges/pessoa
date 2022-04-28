/*
 * Conexao.java
 *
 * Created on 18 de Dezembro de 2008, 18:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ClasseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexao {
    public Conexao() {
    }
    public static Connection getConnection( ) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //db_cobranca nome do bd, root username "" senha
            return DriverManager.getConnection("jdbc:mysql://localhost/db_cobranca", "root", "");
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
    }
    public static void closeConnection(Connection conn,
            Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }
    public static void closeConnection(Connection conn, Statement stmt)     throws Exception {
        close(conn, stmt, null);
    }
    public static void closeConnection(Connection conn)    throws Exception {
        close(conn, null, null);
    }
    private static void close(Connection conn,Statement stmt, ResultSet rs)   throws Exception {
        try {
            if (rs != null) rs.close( );
            if (stmt != null)stmt.close( );
            if (conn != null)conn.close( );
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
}
}
