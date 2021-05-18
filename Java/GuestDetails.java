import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class GuestDetails extends GenericServlet {
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
		String name=request.getParameter("n");  
		String gid=request.getParameter("g");  
		String email=request.getParameter("e");  
		String contact=request.getParameter("c");  
		
		int phone=Integer.parseInt(contact);
		
try{  
		  

PreparedStatement ps=con.prepareStatement("insert into guest values(?,?,?,?)");  

		ps.setString(1,name);  
		ps.setString(2,gid);  
		ps.setString(3,email);  
		ps.setDouble(4,phone);  		
		int i=ps.executeUpdate();  
		if(i>0) 
		{	
		pw.print("You are successfully registered...");  
		pw.print("<a href='guest.html'><button type='submit'>OK</button></a>");
		}
		else
		{	
		pw.print("You are Not successfully registered...");
		pw.print("<a href='GuestDetails.html'></a>");
		}
		  
		}catch(Exception e2) {System.out.println(e2);}  
			
			pw.close();
			}
}
