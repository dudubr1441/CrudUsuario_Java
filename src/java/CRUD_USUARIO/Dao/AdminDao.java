/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_USUARIO.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luiz.carvalho1
 */
public class AdminDao {
   protected Connection conexao;
   protected PreparedStatement preparando;
   protected ResultSet resultSet;
   protected String sql;
   
   public boolean analisaAdmin(String usuario,String senha) throws SQLException, ClassNotFoundException{
    try {
    sql = "SELECT * FROM admin WHERE usuario = ? and senha = ?";
    conexao = ConectarBanco.abrirConexao();
    preparando = conexao.prepareStatement(sql);
    preparando.setString(1, usuario);
    preparando.setString(2, senha);
    resultSet = preparando.executeQuery();
       if (resultSet.next()) {
           return true;
       }
    } catch (ClassNotFoundException | SQLException e) { 
    
    }finally{ConectarBanco.fecharConexao(conexao, preparando, resultSet);}  
     return false;
   }
}
