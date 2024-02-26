package sp1;
import java.sql.*;
public class service {
	static String facultyId,facultyName,facultyPass,facultyType;
	public static String login(String userid,String pass) 
	{
		String usertype="";
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st=conn.createStatement();
		   ResultSet rt=st.executeQuery("select * from admin where userid='"+userid+"' and password='"+pass+"'");
		   while(rt.next()) 
		   {
			   usertype=rt.getString("usertype");
		   }
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is :"+e);
		}
		return usertype;
	}
	
	static int insertFaculty(String FacultyId,String FacultyName,String FacultyPass,String Subject,String Class,String Sem) 
	{	
		int i=0;
		facultyId = FacultyId;
		facultyName = FacultyName;
		facultyPass = FacultyPass;
		facultyType = "faculty";
		try
		{
		   java.lang.Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   System.out.println("connection has been ..... established : "+conn);
		   Statement st=conn.createStatement();
		   st.executeUpdate("insert into admin values('"+FacultyId+"','"+FacultyName+"','"+FacultyPass+"','faculty')");
		   st.executeUpdate("insert into faculty values('"+FacultyId+"','"+FacultyName+"','"+Subject+"','"+Class+"','"+Sem+"')");
		   st.close();
		   conn.close();
		   i=1;
		}
		catch(SQLIntegrityConstraintViolationException se) 
		{
			i=2;
		}
		catch(Exception e)
		{
			System.out.println("error is:"+e);
		}
		return i;
	}
	
	static String[] viewFaculty(String facultyid)
	{
		String facultyId="",facultyName="",facultyPass="",Subject="",Class="",Sem="",fac_data[]= new String[6];
		try
		{
		   java.lang.Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   System.out.println("connection has been ..... established : "+conn);
		   Statement st=conn.createStatement();
		   ResultSet rt = st.executeQuery("select * from faculty where facultyid='"+facultyid+"'");
		   System.out.println("hello");
		   while(rt.next())
		   {
			   facultyId = rt.getString("FACULTYID");
			   facultyName = rt.getString("FACULTYNAME");
			   Subject = rt.getString("SUBJECTNAME");
			   Class = rt.getString("CLASS");
			   Sem = rt.getString("SEM");
		   }
		   ResultSet rt1 = st.executeQuery("select * from admin where userid='"+facultyid+"'");
		   while(rt1.next()) 
		   {
			   System.out.println("admin");
			   facultyPass = rt1.getString("password");
		   }
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
			System.out.println("error is:"+e);
		}
		if(!facultyId.equals("")) 
		{
			fac_data[0]=facultyId;
			fac_data[1]=facultyName;
			fac_data[2]=facultyPass;
			fac_data[3]=Subject;
			fac_data[4]=Class;
			fac_data[5]=Sem;
		}
		return fac_data;
	}
	
	static int insertStudent(String UniRollNo,String StudentName,String Course,String Branch,String Sem,String Batch,String Class) 
	{	
		int i=0;
		try
		{
		   java.lang.Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   System.out.println("connection has been ..... established : "+conn);
		   Statement st=conn.createStatement();
		   st.executeUpdate("insert into student values('"+UniRollNo+"','"+StudentName+"','"+Course+"','"+Branch+"','"+Sem+"','"+Batch+"','"+Class+"')");
		   st.close();
		   conn.close();
		   i=1;
		}
		catch(SQLIntegrityConstraintViolationException se) 
		{
			i=2;
		}
		catch(Exception e)
		{
			System.out.println("error is:"+e);
		}
		return i;
	}
	
	static String[] viewStudent(String UniRollNo)
	{
		String uniRollNo="",studentName="",course="",branch="",sem="",batch="",_class="",stu_data[]=new String[7];
		try
		{
		   java.lang.Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st=conn.createStatement();
		   ResultSet rt = st.executeQuery("select * from student where unirollno='"+UniRollNo+"'");
		   while(rt.next())
		   {
			   uniRollNo = rt.getString("UNIROLLNO");
			   studentName = rt.getString("NAME");
			   course = rt.getString("COURSE");
			   branch = rt.getString("BRANCH");
			   sem = rt.getString("SEM");
			   batch = rt.getString("BATCH");
			   _class = rt.getString("CLASS");
			   
		   }
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
			System.out.println("error is:"+e);
		}
		if(!uniRollNo.equals("")) 
		{
			stu_data[0]=uniRollNo;
			stu_data[1]=studentName;
			stu_data[2]=course;
			stu_data[3]=branch;
			stu_data[4]=sem;
			stu_data[5]=batch;
			stu_data[6]=_class;
		}
		return stu_data;
	}
}
