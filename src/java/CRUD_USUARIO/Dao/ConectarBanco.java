/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD_USUARIO.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author maste
 */
public class ConectarBanco {
        public static Connection abrirConexao() throws SQLException, ClassNotFoundException{
        Connection driver = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            driver = DriverManager.getConnection("jdbc:mysql://localhost:3306/CrudUsuario"
            +"?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull",
                    "root","admin");
        } catch (SQLException e) {
            System.err.println("erro na conexão com o banco: "+ e.getMessage());
        }
            System.out.println("");
        return driver;
    }
  public static void fecharConexao(Connection conn, Statement psmt, ResultSet rs) throws SQLException {
        rs.close();
        conn.close();
        psmt.close();
    }
   public static void fecharConexao(Connection conn, Statement psmt) throws SQLException {
        conn.close();
        psmt.close();
    }
}

