import java.sql.*;
class f1
{
     public static void main(String[] arg)
     {	
	try
	{
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
	   System.out.println("connection has been established : "+conn);
	   Statement st=conn.createStatement();
	   ResultSet rt=st.executeQuery("select * from emp");
	   while(rt.next()){
		   System.out.println(rt.getString(2));
	   }
	   st.close();
	   conn.close();
	}
	catch(Exception e)
	{
	   System.out.println("error is :"+e);
	}
     }	
}