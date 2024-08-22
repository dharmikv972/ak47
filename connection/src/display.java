//import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/display")
public class display extends HttpServlet{
	public void doGet(HttpServletRequest req , HttpServletResponse res ) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users","root","");
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from registeruser");
			pw.println(" <style>\r\n" + 
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
			pw.println("<table border = '1'>");
			pw.println("<tr><th>id</th>"
					+"<th>Name</th>"
					+"<th>Password</th>"
					+"<th>Email</th>"
					+"<th>Country</th>"
					+"<th>Edit</th>"
					+"<th>Delete</th></tr>");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt("id") + "</td>" );
				pw.println("<td>" + rs.getString("name") + "</td>" );
				pw.println("<td>" + rs.getString("password") + "</td>" );
				pw.println("<td>" + rs.getString("email") + "</td>" );
				pw.println("<td>" + rs.getString("country") + "</td>" );
				pw.println("<td><a href = edit?id="+id+"> Edit </a></td>" );
				pw.println("<td><a href = delete?id="+id+"> Delete </a></td>" );
				pw.println("</tr>");
			}
			
		}catch(Exception e)
		{
			System.out.print(e);
		}
		pw.println("<table>");
		pw.println("<a href = 'index.html'> Add Record </a>");
		pw.println("</table>");
	}
}
