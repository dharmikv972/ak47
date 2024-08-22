//import java.io.*;
import java.sql.*;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/delete")
public class delete extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res )throws ServletException , IOException
	{
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users","root","");
			
			Statement st;
			st = con.createStatement();
			st.execute("delete from registeruser where id = '" + id + "'");
			res.sendRedirect("display");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
