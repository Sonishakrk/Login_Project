

import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet ("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String fname = request.getParameter ("uname");
        String mname = request.getParameter ("mname");
        String lname = request.getParameter ("lname");
        String email = request.getParameter ("email");
        String phone = request.getParameter ("phone");
        String password = request.getParameter ("password");
        //String gender = request.getParameter ("gender");
        
        
        
        
        
        
        
//        HttpSession session = request.getSession ();
//        session.setAttribute ("phone", phone);
        try
        {
            Class.forName ("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/login", "root", "Sonisha@100");
            PreparedStatement ps = con.prepareStatement ("insert into login values(?,?,?,?,?,?)");
            ps.setString (1, fname);
            ps.setString (2, mname);
            ps.setString (3, lname);
            ps.setString (4, email);
            ps.setString (5, phone);
            ps.setString (6, password);
           // ps.setString (7, gender);
            int i = ps.executeUpdate ();
            if (i > 0)
             out.print ("Welcome" +fname +lname + "You are successfully registered...");
//            RequestDispatcher rs = request.getRequestDispatcher("view.html");
//            rs.include(request, response);
           // out.print("Hello" +fname);
           request.getRequestDispatcher ("Welcome1").include (request, response);
            //RequestDispatcher rd = request.getRequestDispatcher("login.html");
            //rd.forward(request, response);
        }
        catch (Exception e2)
        {
            System.out.println (e2);
           
        }
        out.close ();
    }
    
 
    
}