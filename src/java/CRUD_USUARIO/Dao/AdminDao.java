/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_USUARIO.Dao;

import CRUD_USUARIO.Entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
   public List<Usuario> TodosUsuarios() throws SQLException, ClassNotFoundException{
    List<Usuario> listaUsuario = new ArrayList<>();
    try {
    sql = "SELECT * FROM usuario";
    conexao = ConectarBanco.abrirConexao();
    preparando = conexao.prepareStatement(sql);
    resultSet = preparando.executeQuery();
        while (resultSet.next()) {            
            Usuario usuario1 = new Usuario();
            usuario1.setCpf(resultSet.getString(2));
            usuario1.setEmail(resultSet.getString(3));
            usuario1.setSenha(resultSet.getString(4));
            usuario1.setSexo(resultSet.getString(5));
            usuario1.setDataregistro(resultSet.getDate(6));
            listaUsuario.add(usuario1);
        }
    } catch (ClassNotFoundException | SQLException e) { 
    
    }finally{ConectarBanco.fecharConexao(conexao, preparando, resultSet);}  
    return listaUsuario;
   }
}
