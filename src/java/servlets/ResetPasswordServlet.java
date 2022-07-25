/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;


public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uuid = request.getParameter("uuid");
        
        if (uuid != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
            return; 
        }
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        return; 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String url = request.getRequestURL().toString(); 
        AccountService accountService = new AccountService();
       
        String action = request.getParameter("action");
        String email  = request.getParameter("email");
        String path = getServletContext().getRealPath("/WEB-INF");
       
        if (action != null) {
            if (action.equals("reset")) {
                try {    
                    accountService.resetPassword(email, path, url);
                } catch (Exception ex) {
                    Logger.getLogger(ResetPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (action.equals("newpassword")) {
                String uuid = request.getParameter("uuid");
                String password = request.getParameter("password");
                accountService.changePassword(uuid, password);
               
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return; 
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        return; 
    }

}