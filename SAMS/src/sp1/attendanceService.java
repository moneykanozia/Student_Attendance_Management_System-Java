package sp1;

import java.sql.*;
public class attendanceService {
	
	static String[] getSem(String facultyid) 
	{
		String[] sem_cls_sub = new String[3];
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st=conn.createStatement();
		   ResultSet rt=st.executeQuery("select sem,class,subjectname from faculty where facultyid='"+facultyid+"'");
		   while(rt.next()) 
		   {
			   sem_cls_sub[0] = rt.getString("sem");
			   sem_cls_sub[1] = rt.getString("class");
			   sem_cls_sub[2] = rt.getString("subjectname");
		   }
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is :"+e);
		}
		return sem_cls_sub;
	}
	
	static String[] attendance(String _class) 
	{
		String unirollno[]=null;
		int i=0;
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st=conn.createStatement();
		   ResultSet rt=st.executeQuery("select count(*) from student where class='"+_class+"'");
		   while(rt.next()) {
			   int count = rt.getInt(1);
			   System.out.println(count);
			   unirollno = new String[count];
		   }
		   ResultSet rt1=st.executeQuery("select unirollno from student where class='"+_class+"'");
		   while(rt1.next()) 
		   {
			   unirollno[i] = rt1.getString("unirollno");
			   i++;
		   }
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is :"+e);
		}
		System.out.println(unirollno);
		return unirollno;
	}
	
	static int getdays(String month)
	{
		int days = -1;
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st=conn.createStatement();
		   ResultSet rt=st.executeQuery("select count(*) from all_tab_columns where table_name='"+month+"'");
		   while(rt.next()) 
		   {
			   days = rt.getInt(1);
		   }
		   rt.close();
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is :"+e);
		}
		return days;
	}
	
	static String[] getCurrentYear()
	{
		int currentYear = -1;
		int currentDay = -1;
		String currentMonth = null;
		int lastDateOfMonth = -1;
		String[] arr = new String[4];
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st=conn.createStatement();
		   ResultSet rt=st.executeQuery("select to_char(sysdate,'YYYY'),to_char(sysdate,'DD'),to_char(sysdate,'MONTH'),to_char(last_day(sysdate),'DD') from dual");
		   while(rt.next()) 
		   {
			   currentYear = rt.getInt(1);
			   currentDay = rt.getInt(2);
			   currentMonth = rt.getString(3);
			   lastDateOfMonth = rt.getInt(4);
		   }
		   arr[0] = String.valueOf(currentYear);
		   arr[1] = String.valueOf(currentDay);
		   arr[2] = currentMonth;
		   arr[3] = String.valueOf(lastDateOfMonth);
		   rt.close();
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is :"+e);
		}
		return arr;
	}
	
	static boolean checkAttendance(String currentMonth,int currentDay,int currentYear,String subjectName,String sem)
	{
		String subjectCode = null;
		boolean isData = false;
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st=conn.createStatement();
		   String query = String.format("select subjectcode from subject where subjectname='%s' and year<=%d and sem='%s'",subjectName,currentYear,sem);
		   ResultSet rt1=st.executeQuery(query);
		   while(rt1.next()) 
		   {
			   subjectCode = rt1.getString(1);
		   }
		   String query1 = String.format("select * from %s where attendanceid like '%s' and rownum=1", currentMonth,"%"+subjectCode+"%");
		   System.out.println(query1);
		   ResultSet rt=st.executeQuery(query1);
		   while(rt.next()) 
		   {
			   if(rt.getString(currentDay+1)!=null)
			   {
				   isData = true;
			   }
		   }
		   rt1.close();
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is this :"+e);
		}
		return isData;
	}
	
	static void addAttendance(int currentDay,String currentMonth,int currentYear,String[] unirollno,Object[] attendance,String subjectName,String course,String className)
	{
		String sem = null;
		String subjectCode = null;	
		StringBuffer temp = new StringBuffer(className);
		temp.deleteCharAt(temp.length()-1);
		String branch = temp.toString();
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   PreparedStatement pst_attendanceTable=conn.prepareStatement("insert into attendance(attendanceid,unirollno,course,branch,sem,month,year,subjectcode,subjectname,class) values(?,?,?,?,?,?,?,?,?,?)");
		   PreparedStatement pst_studentTable=conn.prepareStatement("select * from student where unirollno=?");
		   String update = String.format("update %s set %s=? where attendanceid=?",currentMonth,currentMonth.substring(0,3)+String.valueOf(currentDay));
		   String insert = String.format("insert into %s(attendanceid,%s) values(?,?)", currentMonth,currentMonth.substring(0,3)+String.valueOf(currentDay));
		   System.out.println(insert);
		   PreparedStatement pst_monthTable1=conn.prepareStatement(update);
		   PreparedStatement pst_monthTable=conn.prepareStatement(insert);
		   PreparedStatement pst_checkAttendanceId = conn.prepareStatement("select attendanceid from attendance where attendanceid=?");
		   pst_studentTable.setString(1,unirollno[0]);
		   ResultSet rs_studentTable = pst_studentTable.executeQuery();
		   while(rs_studentTable.next())
		   {
			   sem = rs_studentTable.getString(5);
		   }
		   Statement st = conn.createStatement();
		   String query = String.format("select * from subject where subjectname='%s' and year<=%d and sem='%s'",subjectName,currentYear,sem);
		   System.out.println(query);
		   ResultSet rt=st.executeQuery(query);
		   while(rt.next()) 
		   {
			   subjectCode = rt.getString(1);
		   }
		   for(int i=0;i<unirollno.length;i++)
		   {
			   pst_checkAttendanceId.setString(1, unirollno[i]+subjectCode+String.valueOf(currentYear));
			   ResultSet rt3 = pst_checkAttendanceId.executeQuery();
			   if(rt3.next())
			   {
				   pst_monthTable1.setObject(1,attendance[i]);
				   pst_monthTable1.setString(2,unirollno[i]+subjectCode+String.valueOf(currentYear));
			   }
			   else
			   {
				   pst_attendanceTable.setString(1,unirollno[i]+subjectCode+String.valueOf(currentYear));
				   pst_attendanceTable.setString(2,unirollno[i]);
				   pst_attendanceTable.setString(3,course);
				   pst_attendanceTable.setString(4,branch);
				   pst_attendanceTable.setString(5,sem);
				   pst_attendanceTable.setString(6,currentMonth);
				   pst_attendanceTable.setInt(7,currentYear);
				   pst_attendanceTable.setString(8,subjectCode);
				   pst_attendanceTable.setString(9,subjectName);
				   pst_attendanceTable.setString(10,className);
				   pst_monthTable.setString(1,unirollno[i]+subjectCode+String.valueOf(currentYear));
				   pst_monthTable.setObject(2,attendance[i]);
				   pst_attendanceTable.executeUpdate();
				   pst_monthTable.executeUpdate();
			   }
		   }
		   pst_attendanceTable.close();
		   pst_studentTable.close();
		   pst_monthTable.close();
		   pst_monthTable1.close();
		   pst_checkAttendanceId.close();
		   st.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is this :"+e);
		}
	}
	
	static String[] getCurrentDayAttendance(int currentDay,String currentMonth,int currentYear,String[] unirollno,String subjectName,String sem)
	{
		String currentMonthDay = currentMonth.substring(0,3);
		String gottenCurrentDayAttendance[] = new String[unirollno.length];
		String subjectCode = null;
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st = conn.createStatement();
		   String query1 = String.format("select * from subject where subjectname='%s' and year<=%d and sem='%s'",subjectName,currentYear,sem);
		   System.out.println(query1);
		   ResultSet rt1=st.executeQuery(query1);
		   while(rt1.next()) 
		   {
			   subjectCode = rt1.getString(1);
		   }
		   String query2 = String.format("select %s from %s where attendanceid=?",currentMonthDay+String.valueOf(currentDay),currentMonth);
		   PreparedStatement pst=conn.prepareStatement(query2);
		   for(int i=0;i<unirollno.length;i++)
		   {
			   pst.setString(1,unirollno[i]+subjectCode+currentYear);
			   ResultSet rt2=pst.executeQuery();
			   while(rt2.next())
			   {
				   gottenCurrentDayAttendance[i] = rt2.getString(1);
				   System.out.println(gottenCurrentDayAttendance[i]);
			   }
		   }
		   pst.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is this :"+e);
		}
		return gottenCurrentDayAttendance;
	}
	
	static void updateData(int currentDay,String currentMonth,int currentYear,String[] unirollno,Object[] updatedAttendance,String subjectName,String sem)
	{
		String subjectCode = null;
		try
		{
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Money");
		   Statement st = conn.createStatement();
		   String query1 = String.format("select * from subject where subjectname='%s' and year<=%d and sem='%s'",subjectName,currentYear,sem);
		   ResultSet rt1=st.executeQuery(query1);
		   while(rt1.next()) 
		   {
			   subjectCode = rt1.getString(1);
		   } 
		   String update = String.format("update %s set %s=? where attendanceid=?", currentMonth,currentMonth.substring(0,3)+String.valueOf(currentDay));
		   PreparedStatement pst_monthTable=conn.prepareStatement(update);
		   for(int i=0;i<unirollno.length;i++)
		   {
			   pst_monthTable.setObject(1,updatedAttendance[i]);
			   pst_monthTable.setString(2,unirollno[i]+subjectCode+String.valueOf(currentYear));
			   pst_monthTable.executeUpdate();
		   }
		   pst_monthTable.close();
		   conn.close();
		}
		catch(Exception e)
		{
		   System.out.println("error is this :"+e);
		}
	}
}
