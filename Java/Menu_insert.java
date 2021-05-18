import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class Menu_insert extends GenericServlet {
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
		String FID=request.getParameter("fid");  
		String FNAME=request.getParameter("fname");  
		String PRI=request.getParameter("price");  
		String DESCRIPTION=request.getParameter("desc");  
		String EID=request.getParameter("eid");

		double PRICE=Double.parseDouble(PRI);
		
		
try{  
		  

PreparedStatement ps=con.prepareStatement("insert into MENU_ITEMS values(?,?,?,?,?)");  
		ps.setString(1,FID);  
		ps.setString(2,FNAME);  
		ps.setDouble(3,PRICE);  
		ps.setString(4,DESCRIPTION);  
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
		pw.print("<a href='menu_insert.html'>TRY AGAIN</a>");
		}
		  
		}catch(Exception e2) {System.out.println(e2);}  
			
			pw.close();
			}
}
