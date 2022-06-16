import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
    public static boolean checkUser(String pn,String pss) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
        	   Class.forName ("com.mysql.jdbc.Driver");
            //creating connection with the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Sonisha@100");
            PreparedStatement pst = conn.prepareStatement("select * from login where phone=? and password=?");
            pst.setString(1, pn);
            pst.setString(2, pss);
            ResultSet rset =pst.executeQuery();
            st = rset.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}