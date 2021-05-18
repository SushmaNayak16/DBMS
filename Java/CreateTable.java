import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class CreateTable extends GenericServlet {
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
			ServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter();  
		String tab=request.getParameter("table"); 	
		int n=Integer.parseInt(tab);
switch(n)
{
	case 1:	try{
					Statement st=con.createStatement(); 
					st.executeUpdate("CREATE TABLE EMPLOYEE(EID VARCHAR(10),ENAME VARCHAR(10),ADDRESS VARCHAR(20),MAIL VARCHAR(30),PHONE INT,GENDER VARCHAR(10),PRIMARY KEY(EID));");
					pw.println("EMPLOYEE TABLE CREATED SUCCESSFULLY");
					}
					catch(SQLException e)
		  			{
						pw.println("TABLE ALREADY EXISTS");
		  			}break;
	case 2:	try{
					Statement st=con.createStatement();
					st.executeUpdate("CREATE TABLE MENU_ITEMS(FID VARCHAR(10),FNAME VARCHAR(20),PRICE INT,DESCRIPTION VARCHAR(20),EID VARCHAR(10),FOREIGN KEY(EID)REFERENCES EMPLOYEE(EID) ON DELETE CASCADE,PRIMARY KEY(FID));");
					pw.println("MENU_ITEMS TABLE CREATED SUCCESSFULLY");
					}
					catch(SQLException e)
					{
						pw.println("TABLE ALREADY EXISTS");
					}break;
  case 3:	try{
					Statement st=con.createStatement();
					st.executeUpdate("CREATE TABLE GUEST(GID VARCHAR(10),GFNAME VARCHAR(10),GLNAME VARCHAR(10),MAIL VARCHAR(20),GENDER VARCHAR(10),PHONE INT,PRIMARY KEY(GID));");
					pw.println("GUEST TABLE CREATED SUCCESSFULLY");
    				}
					catch(SQLException e)
					{
						pw.println("TABLE ALREADY EXISTS");
					}break;
  case 4:	try{
		            Statement st=con.createStatement();
		            st.executeUpdate("CREATE TABLE RTABLE(TNO VARCHAR(5),NO_OF_SEATS INT,SEATS_OCCUPIED INT,GID VARCHAR(10),FOREIGN KEY(GID) REFERENCES GUEST(GID) ON DELETE CASCADE,PRIMARY KEY(TNO));");
		            pw.println("'TABLE' TABLE CREATED SUCCESSFULLY");
		            }
		            catch(SQLException e)
	            	{
			           pw.println("TABLE ALREADY EXISTS");
	            	}break;	
  case 5:	try{
                     Statement st=con.createStatement();
                     st.executeUpdate("CREATE TABLE BILL(BID VARCHAR(10),AMOUNT INT,DATE_ISSUED DATE,GID VARCHAR(10),EID VARCHAR(10),FOREIGN KEY(GID) REFERENCES GUEST(GID) ON DELETE CASCADE,FOREIGN KEY(EID) REFERENCES EMPLOYEE(EID) ON DELETE CASCADE,PRIMARY KEY(BID));");
                     pw.println("BILL TABLE CREATED SUCCESSFULLY");
                     }
                     catch(SQLException e)
  	                 {
                         pw.println("TABLE ALREADY EXISTS");
  	                 }break;
  case 6:	try{
                     Statement st=con.createStatement();
                     st.executeUpdate("CREATE TABLE TYPE(EID VARCHAR(10),ETYPE VARCHAR(15),FOREIGN KEY(EID) REFERENCES EMPLOYEE(EID) ON DELETE CASCADE,PRIMARY KEY(EID,ETYPE));");
                     pw.println("EMPLOYEE TYPES TABLE CREATED SUCCESSFULLY");
                     }
                     catch(SQLException e)
                     {
                        pw.println("TABLE ALREADY EXISTS");
                     }break;	
  case 7:	try{
                    Statement st=con.createStatement();
                    st.executeUpdate("CREATE TABLE ORDERS(GID VARCHAR(10),FID VARCHAR(10),FOREIGN KEY(GID) REFERENCES GUEST(GID) ON DELETE CASCADE,FOREIGN KEY(FID) REFERENCES MENU_ITEMS(FID) ON DELETE CASCADE,PRIMARY KEY(GID,FID));");
                    pw.println("ORDERS TABLE CREATED SUCCESSFULLY");
                    }
                    catch(SQLException e)
                    {
                       pw.println("TABLE ALREADY EXISTS");
                    }break;        
  case 8:	try{
                    Statement st=con.createStatement();
                    st.executeUpdate("CREATE TABLE SERVICE(TNO VARCHAR(5),FID VARCHAR(10),TIME VARCHAR(7),FOREIGN KEY(TNO) REFERENCES TABLE(TNO) ON DELETE CASCADE,FOREIGN KEY(FID) RFERENCES MENU_ITEMS(FID) ON DELETE CASCADE,PRIMARY KEY(TNO,FID));");
                    pw.println("SERVICE TABLE CREATED SUCCESSFULLY");
                    }
                    catch(SQLException e)
                   {
                      pw.println("TABLE ALREADY EXISTS");
                   }break;                         
}
		pw.close();	

	}
}



