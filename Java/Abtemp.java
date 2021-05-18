
import java.io.*;
import javax.servlet.*;

import java.sql.*;


public class Abtemp extends GenericServlet {
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
		String emp=request.getParameter("etype"); 	
		
		try{
			PreparedStatement st=con.prepareStatement("SELECT E.EID,E.ENAME FROM EMPLOYEE E,TYPE T WHERE E.EID=T.EID AND ETYPE=?");
		   st.setString(1,emp);
			ResultSet rs=st.executeQuery();
			pw.print("<html><body bgcolor='GreenYellow'>");
			pw.print("<center><table border=2><tr><td><h2>EMPLOYEE ID</h2></td><td><h2>EMPLOYEE NAME</h2></td></tr>");
		 while(rs.next())  
			{
			String eid=rs.getString("E.EID");	
			String name=rs.getString("E.ENAME");
			
			pw.print("<tr>");
			pw.print("<td><h3>"+eid+"</h3></td>");
			
			
			
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
