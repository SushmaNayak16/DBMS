import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class Guest_insert extends GenericServlet {
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
		String GID=request.getParameter("gid");  
		String GFNAME=request.getParameter("fname");  
		String GLNAME=request.getParameter("lname");  
		String MAIL=request.getParameter("mail");  
		String GENDER=request.getParameter("gender");
		String PHO=request.getParameter("phone");
		
		int PHONE=Integer.parseInt(PHO);
		
		
		
try{  
		  

PreparedStatement ps=con.prepareStatement("insert into GUEST values(?,?,?,?,?,?)");  

		ps.setString(1,GID);  
		ps.setString(2,GFNAME);  
		ps.setString(3,GLNAME);  
		ps.setString(4,MAIL);  
		ps.setString(5,GENDER);  
		ps.setDouble(6,PHONE);  
		int i=ps.executeUpdate();  
		if(i>0) 
		{	
		pw.print("You are successfully inserted...");  
		pw.print("<a href='registration.html'>OK</a>");
		}
		else
		{	
		pw.print("You are Not successfully inserted...");
		pw.print("<a href='guest_insert.html'>TRY AGAIN</a>");
		}
		  
		}catch(Exception e2) {System.out.println(e2);}  
			
			pw.close();
			}
}
