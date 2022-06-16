

import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/Login")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out2 = response.getWriter ();

       String phn = request.getParameter ("phone");
       String pass = request.getParameter ("password");
       if(Validate.checkUser(phn, pass))
       {
           RequestDispatcher rst = request.getRequestDispatcher("display.html");
           rst.forward(request, response);
       }
       else
       {
          out2.println("Username or Password incorrect");
          RequestDispatcher rst = request.getRequestDispatcher("registration.html");
          rst.include(request, response);
       }
   }  
}

               
        
        
       