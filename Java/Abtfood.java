
import java.io.*;
import javax.servlet.*;

import java.sql.*;


public class Abtfood extends GenericServlet {
	Connection con;
	public void init()throws ServletException
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini","root","root");	
		}catch(Exception e)
		{
			System.out.print(e);
		}	
	}
	public void service(ServletRequest request,
			ServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter();  
		
		
		try{
			CallableStatement st=con.prepareCall("{call FOOD()}");
		 
			ResultSet rs=st.executeQuery();
			
					
			pw.print("<html><body bgcolor='GreenYellow'>");   
			
		     pw.print("<center><table border=2><tr><td><h2>FOOD NAME</h2></td><td><h2>PRICE</h2></td><td><h2>DESCRIPTION</h2></td></tr>");
			 while(rs.next())  
				{
				 String fname=rs.getString("FNAME");	
					String price=rs.getString("PRICE");
					String description=rs.getString("DESCRIPTION");
				
				pw.print("<tr>");
				pw.print("<td><h3>"+fname+"</h3></td>");
				
				
				
				pw.print("<td><h3>"+price+"</h3></td>");
				pw.print("<td><h3>"+description+"</h3></td>");

				pw.print("</tr>");
			
				   
				}
				pw.print("</table>");

			
		}catch(Exception e)
		{
			
			pw.println(e);
		}
		
		pw.print("<center><a href='analysis.html'><h3>ANALYSIS</h3></a>");
		pw.close();
		pw.print("</body></html>");
	}

}
