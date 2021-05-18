
import java.io.*;
import javax.servlet.*;

import java.sql.*;


public class query1 extends GenericServlet {
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
			PreparedStatement st=con.prepareStatement("SELECT TNO,NO_OF_SEATS,SEATS_OCCUPIED FROM RTABLE");
		 
			ResultSet rs=st.executeQuery();
			pw.print("<html><body bgcolor='GreenYellow'>");    
			pw.print("<center><table border=2><tr><td><h2>TABLE NO</h2></td><td><h2>NO OF SEATS</h2></td><td><h2>SEATS OCCUPIED</h2></td></tr>");
		     while(rs.next())  
			{
		    	 String T=rs.getString("TNO");	
					String N=rs.getString("NO_OF_SEATS");
					String S=rs.getString("SEATS_OCCUPIED");
				
				pw.print("<tr>");
				pw.print("<td><center><h3>"+T+"</h3></center></td>");
				pw.print("<td><center><h3>"+N+"</h3></center></td>");
				pw.print("<td><center><h3>"+S+"</h3></center></td>");

				pw.print("</tr>");
			}
		     pw.print("</table>");
		}catch(Exception e)
		{
			
			pw.println(e);
		}
		
		pw.print("<center><a href='guest.html'><h3>BACK</h3></a>");
		pw.close();
		pw.print("</body></html>");
	}

}
