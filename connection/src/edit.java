//import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/edit")
public class edit extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		pw.println("<h1>Update Record...</h1>");
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users","root","");
			
			Statement st;
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select *from registeruser where id = '"+ id + "'");
			rs.next();
			pw.println("  <style>\r\n" + 
					"  \r\n" + 
					"  \r\n" + 
					"table {\r\n" + 
					"  width: 50%;\r\n" + 
					"  margin: 0 auto;\r\n" + 
					"  border: 20px;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"th, td {\r\n" + 
					"  padding: 10px;\r\n" + 
					"  text-align: left;\r\n" + 
					"  border-bottom: 1px solid #ddd;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"th {\r\n" + 
					"  background-color: #f2f2f2;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input, select {\r\n" + 
					"  width: 100%;\r\n" + 
					"  padding: 8px;\r\n" + 
					"  border: 1px solid #ccc;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  box-sizing: border-box;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button[type=\"submit\"] {\r\n" + 
					"  background-color: #4CAF50;\r\n" + 
					"  color: white;\r\n" + 
					"  padding: 10px 20px;\r\n" + 
					"  border: none;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  cursor: pointer;\r\n" + 
					"}\r\n" + 
					"  </style>");
			pw.println("<form action = 'edit2' method = 'get'>");
			pw.println("<input type ='hidden' name='id' value ='" + rs.getInt("id") + "'/><br>");
			pw.println("Enter Your Name :<input type ='text' name='name' value ='" + rs.getString("name") + "'/><br>");
			pw.println("Enter Your Password:<input type ='password' name='password' value ='" + rs.getString("password") + "'/><br>");
			pw.println("Enter Your Email:<input type ='text' name='email' value ='" + rs.getString("email") + "'/><br>");
			pw.println("Enter Your Country :");
			pw.println("<select name='country' style='width:150px'>");
			pw.println("<option>india</option>");
			pw.println("<option>USA</option>");
			pw.println("<option>UK</option>");
			pw.println("<option>indonesia</option>");
			pw.println("<option>brazil</option>");
			pw.println("<option>other</option>");
			pw.println("</select><br><br>");
			pw.println("<input type = 'submit' value = 'Edit &amp; Save '/>");
			pw.println("</form>");
			
			
			}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
