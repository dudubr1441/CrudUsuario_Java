/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_USUARIO.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CRUD_USUARIO.Entidade.Admin;
import CRUD_USUARIO.Dao.AdminDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import org.json.JSONObject;

/**
 *
 * @author maste
 */
public class login_admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AdminDao adminDao = new AdminDao();
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            JSONObject json = new JSONObject();
            if(adminDao.analisaAdmin(usuario, senha)){
            json.put("status","sucesso");
            RequestDispatcher rd = request.getRequestDispatcher("admincrud.html");
            rd.forward(request, response);
            response.getWriter().print(json);
            }else{
            json.put("status","erro");
            response.getWriter().print(json);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(login_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
