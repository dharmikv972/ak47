//import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/Register")
public class Register extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521;xe","system","12345");
			
			
			
			PreparedStatement ps = con.prepareStatement("insert into users (name , password , email , country) values(?,?,?,?)");
			 
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, country);
			
			int i = ps.executeUpdate();
			if(i>0) {
				pw.print("<p>Record saved sucessfully....</p>");
				req.getRequestDispatcher("index.html").include(req, res);
			}
			else
			{
				pw.print("Sorry ! Unable to save record....");
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
