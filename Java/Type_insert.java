import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class Type_insert extends GenericServlet {
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
		String EID=request.getParameter("eid");  
		String ETYPE=request.getParameter("etype");  
		
		
		
try{  
		  

PreparedStatement ps=con.prepareStatement("insert into TYPE values(?,?)");  

		ps.setString(1,EID);  
		ps.setString(2,ETYPE);  
		 
		int i=ps.executeUpdate();  
		if(i>0) 
		{	
		pw.print("You are successfully inserted...");  
		pw.print("<a href='insert_values.html'>Back to Home Page</a>");
		}
		else
		{	
		pw.print("You are Not successfully inserted...");
		pw.print("<a href='type_insert.html'>TRY AGAIN</a>");
		}
		  
		}catch(Exception e2) {System.out.println(e2);}  
			
			pw.close();
			}
}
