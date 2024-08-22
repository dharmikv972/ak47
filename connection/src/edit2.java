//import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/edit2")

public class edit2 extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res ) throws ServletException , IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users","root","");
			
			Statement st;
			st = con.createStatement();
			
			st.execute("update registeruser set name = '" + name +"',"
					+ " password = '" + password +"',"
							+ " email = '" + email + "',"
									+ " country = '" + country +"' where id='"+id+"'");
			res.sendRedirect("display");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
