import java.io.*;
import java.sql.*;
import javax.servlet.*;
public class Abtbill extends GenericServlet {
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
		
try{  
		  

PreparedStatement ps=con.prepareStatement("select distinct g.gid,g.gfname,g.glname,m.fname,b.amount from guest g,orders o,menu_items m,bill b where g.gid=b.gid and g.gid=o.gid and o.fid=m.fid and g.gid=?");  

		ps.setString(1,GID);        
		
		ResultSet rs=ps.executeQuery();
		pw.print("<html><body bgcolor='GreenYellow'>");    
		
		
	     while(rs.next())  
		{
		String gid=rs.getString("g.gid");	
		String fname=rs.getString("g.gfname");
		String lname=rs.getString("g.glname");
		String mfname=rs.getString("m.fname");
		String amount=rs.getString("b.amount");
		
		pw.print("<table>");
		pw.print("<tr>");
		pw.print("<td>"+"ADHAR NO:"+gid+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>"+"FIRST NAME:"+fname+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>"+"LAST NAME:"+lname+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>"+"FOOD NAME:"+mfname+"</td>");
		pw.print("</tr>");
		
		pw.print("<tr>");
		pw.print("<td>"+"BILL AMOUNT:"+amount+"</td>");
		pw.print("</tr>");
		
		pw.print("</table><br/>");
		
		   
		}
		
	}catch(Exception e)
	{
		
		pw.println(e);
	}
	
	pw.print("<center><a href='analysis.html'><h3>ANALYSIS</h3></a>");
	pw.close();
	pw.print("</body></html>");
}
}
