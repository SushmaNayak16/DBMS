
import java.io.*;
import javax.servlet.*;

import java.sql.*;


public class Abtserv extends GenericServlet {
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
		String tabl=request.getParameter("tno"); 	
		
		try{
			PreparedStatement st=con.prepareStatement("SELECT T.TNO,M.FNAME FROM MENU_ITEMS M,RTABLE T,SERVICE S WHERE M.FID=S.FID AND S.TNO=T.TNO AND S.TNO=?");
		   st.setString(1,tabl);
			ResultSet rs=st.executeQuery();
		    
			pw.print("<html><body bgcolor='GreenYellow'>");    
			
		     pw.print("<center><table border=2><tr><td><h2>TABLE NUMBER</h2></td><td><h2>FOOD NAME</h2></td></tr>");
			 while(rs.next())  
				{
				 String tno=rs.getString("T.TNO");	
					String name=rs.getString("M.FNAME");
				pw.print("<tr>");
				pw.print("<td><h3>"+tno+"</h3></td>");
				
				
				
				pw.print("<td><h3>"+name+"</h3></td>");
				pw.print("</tr>");
			
				   
				}
				pw.print("</table>");
			
		}catch(Exception e)
		{
			
			pw.println(e);
		}
		
		pw.print("<a href='analysis.html'>ANALYSIS</a>");
		pw.close();
		pw.print("</body></html>");
	}

}
