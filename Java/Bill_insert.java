import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class Bill_insert extends GenericServlet {
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
		String BID=request.getParameter("bid");  
		String AMT=request.getParameter("amount");  
		String DATE_ISSUED=request.getParameter("date");  
		String GID=request.getParameter("gid");  
		String EID=request.getParameter("eid");
		
		int AMOUNT=Integer.parseInt(AMT);
		
try{  
		  

PreparedStatement ps=con.prepareStatement("insert into BILL values(?,?,?,?,?)");  

		ps.setString(1,BID);  
		ps.setInt(2,AMOUNT);  
		ps.setString(3,DATE_ISSUED);  
		ps.setString(4,GID);  
		ps.setString(5,EID); 
		
		
		int i=ps.executeUpdate();
		if(i>0) 
		{	
		pw.print("You are successfully inserted...");  
		pw.print("<a href='insert_values.html'>Bach to Home Page</a>");
		}
		else
		{	
		pw.print("You are Not successfully inserted...");
		pw.print("<a href='bill_insert.html'>TRY AGAIN</a>");
		}
		  
		}catch(Exception e2) {System.out.println(e2);}  
			
			pw.close();
			}
}
