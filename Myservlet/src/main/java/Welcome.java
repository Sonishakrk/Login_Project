import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.*;
@WebServlet("/Welcome1")
public class Welcome extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
//        PrintWriter out1 = response.getWriter ();
//        String res = request.getParameter ("uname");
//        String res1 = request.getParameter ("lname");
//        out1.println ("</br></br>");
//        
//       out1.print(" <h1> Welcome " + res +" "+ res1 + "</h1>" + "You can now log in. ");
        RequestDispatcher rd = request.getRequestDispatcher("view.html");
       rd.include(request, response);
      
    }
}
