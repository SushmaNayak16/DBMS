import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class Emp_insert extends GenericServlet {
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
		String ENAME=request.getParameter("ename");  
		String ADDRESS=request.getParameter("address");  
		String MAIL=request.getParameter("mail");  
		String PHO=request.getParameter("phone");
		String GENDER=request.getParameter("gender");
		
		int PHONE=Integer.parseInt(PHO);
		
		
try{  
		  

PreparedStatement ps=con.prepareStatement("insert into EMPLOYEE values(?,?,?,?,?,?)");  

		ps.setString(1,EID);  
		ps.setString(2,ENAME);  
		ps.setString(3,ADDRESS);  
		ps.setString(4,MAIL);  
		ps.setInt(5,PHONE);  
		ps.setString(6,GENDER);  
		int i=ps.executeUpdate();  
		if(i>0) 
		{	
		pw.print("You are successfully inserted...");  
		pw.print("<a href='insert_values.html'>Bach to Home Page</a>");
		}
		else
		{	
		pw.print("You are Not successfully inserted...");
		pw.print("<a href='emp_insert.html'>TRY AGAIN</a>");
		}
		  
		}catch(Exception e2) {System.out.println(e2);}  
			
			pw.close();
			}
}
