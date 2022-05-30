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
import java.sql.Statement;
import java.time.LocalDate;
/**
 *
 * @author maste
 */
public class UsuarioDAO {
   protected Connection conexao;
   protected PreparedStatement preparando;
   protected ResultSet resultSet;
   protected String sql;
    
   public Boolean AnalisaUsuario (Usuario usuario) throws SQLException, ClassNotFoundException{
       try{
       sql = "SELECT * FROM Usuario WHERE cpf = ? or email = ?";
       conexao = ConectarBanco.abrirConexao();
       preparando = conexao.prepareStatement(sql);
       preparando.setString(2,usuario.getEmail());
       preparando.setString(1,usuario.getCpf());
       resultSet = preparando.executeQuery();
           if (resultSet.next()) {
               return false;
           } 
       }catch(ClassNotFoundException e){
       }finally{ConectarBanco.fecharConexao(conexao, preparando, resultSet);}
       return true;
    }
   public void RegistraUsuario(Usuario usuario) throws SQLException, ClassNotFoundException{
        sql = "insert into usuario(cpf,email,senha,sexo,dataRegistro) value(?,?,?,?,now());";
       conexao = ConectarBanco.abrirConexao();
       preparando = conexao.prepareStatement(sql);
       preparando.setString(1,usuario.getCpf());
       preparando.setString(2,usuario.getEmail());
       preparando.setString(3,usuario.getSenha());
       preparando.setString(4,usuario.getSexo());
       preparando.executeUpdate();
   }
}
