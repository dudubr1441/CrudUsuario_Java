/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_USUARIO.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CRUD_USUARIO.Dao.UsuarioDAO;
import CRUD_USUARIO.Entidade.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author maste
 */
public class RegistraUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = new Usuario();
            usuario.setCpf(request.getParameter("cpf"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setSexo(request.getParameter("sexo"));
            if (usuarioDAO.AnalisaUsuario(usuario)) {
                usuarioDAO.RegistraUsuario(usuario);
                RequestDispatcher tt = request.getRequestDispatcher("indexCerto.html");
                tt.forward(request, response);
            } else {
                RequestDispatcher tt = request.getRequestDispatcher("indexErrado.html");
                tt.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistraUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistraUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
