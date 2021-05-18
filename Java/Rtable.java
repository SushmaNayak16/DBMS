import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class Rtable extends GenericServlet {
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
		String TNO =request.getParameter("tno");  
		String TSEATS=request.getParameter("totseats");  
		String SEATS_OCCU=request.getParameter("seatsoccu");  
		String GID=request.getParameter("gid");  
		
	
	int NO_OF_SEATS=Integer.parseInt(TSEATS);	
	int SEATS_OCCUPIED=Integer.parseInt(SEATS_OCCU);	
		
try{  
		  

PreparedStatement ps=con.prepareStatement("insert into RTABLE values(?,?,?,?)");  

		ps.setString(1,TNO);  
		ps.setInt(2,NO_OF_SEATS);  
		ps.setInt(3,SEATS_OCCUPIED);  
		ps.setString(4,GID);    
		int i=ps.executeUpdate();  
		if(i>0) 
		{	
		pw.print("You are successfully inserted...");  
		pw.print("<a href='insert_values.html'>Bach to Home Page</a>");
		}
		else
		{	
		pw.print("You are Not successfully inserted...");
		pw.print("<a href='rtable.html'>TRY AGAIN</a>");
		}
		  
		}catch(Exception e2) {System.out.println(e2);}  
			
			pw.close();
			}
}
