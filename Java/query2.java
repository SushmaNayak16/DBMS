import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class query2 extends GenericServlet {
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
		String SEATS_OCCU=request.getParameter("seats");  
		String GID=request.getParameter("gid");  
		String TNO=request.getParameter("tno");    
		
	
	int SEATS_OCCUPIED=Integer.parseInt(SEATS_OCCU);	
		
try{  
		  

PreparedStatement ps=con.prepareStatement("UPDATE RTABLE SET SEATS_OCCUPIED=?,GID=? WHERE TNO=?");  

		ps.setInt(1,SEATS_OCCUPIED);  
		ps.setString(2,GID);  
		ps.setString(3,TNO);      
		int i=ps.executeUpdate();  
		if(i>0) 
		{	
		pw.print("RESERVATION DONE SUCCESSFULLY<br/>");  
		pw.print("<a href='guest.html'>Bach to Home Page</a>");
		}
		else
		{	
		pw.print("RESERVATION NOT DONE");
		pw.print("<a href='query22.html'>TRY AGAIN</a>");
		}
		  
		}catch(Exception e2)
          {
			System.out.println(e2);} 
			pw.close();
			}
}
