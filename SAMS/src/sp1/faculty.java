package sp1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.*;
import sp1.home;
public class faculty extends JPanel implements ActionListener
{
	home homeReference;
	login loginReference;
	String facultyid;
	JButton b_attendancePercent,b_AddStudentAttendance,b_AddClassAttendance,b_UpdateStudentAttendance,b_UpdateClassAttendance,b_ViewStudent,b_logout,b_dg_cancel,b_dg_ok;
	JDialog dg,dg_percentAttendance;
	JLabel l_dg_id,l_dg_showMessage,l_title;
	JTextField t_dg_id;
	int f_s;
	faculty(home homeReference,login loginReference,String facultyid){
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		this.facultyid = facultyid;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setLayout(null);
		setBounds(430,90,500,510);
		setBorder(blackline);
//		setBackground(new Color(50, 141, 168));
		homeReference.add(this);
		homeReference.getContentPane().setBackground(new Color(185, 205, 111));
		buttons();
	}
	void buttons()
	{
		l_title = new JLabel("FACULTY");
		b_attendancePercent = new JButton("Percentage of Attendance");
		b_AddStudentAttendance = new JButton("Add Student Attendance");
		b_AddClassAttendance = new JButton("Add Class Attendance");
		b_UpdateStudentAttendance = new JButton("Update Student Attendance");
		b_UpdateClassAttendance = new JButton("Update Class Attendance");
		b_ViewStudent = new JButton("View Student");
		b_logout = new JButton("logout");
		dg = new JDialog(homeReference);
//		dg_percentAttendance = new JDialog(homeReference);
		l_dg_id = new JLabel();
		l_dg_showMessage = new JLabel();
		t_dg_id = new JTextField();
		b_dg_cancel = new JButton("Cancel");
		b_dg_ok = new JButton("Ok");
		l_title.setBounds(641,38,100,33);
//		b_attendancePercent.setBounds(174,10,185,25);
		b_AddStudentAttendance.setBounds(174,70,185,25);
		b_AddClassAttendance.setBounds(174,130,185,25);
		b_UpdateStudentAttendance.setBounds(174,190,185,25);
		b_UpdateClassAttendance.setBounds(174,250,185,25);
		b_ViewStudent.setBounds(174,310,185,25);
		b_logout.setBounds(208,370,80,25);
		l_title.setFont(new Font("Verdana", Font.PLAIN, 21));
		l_title.setBackground(new Color(255, 253, 208));
		l_title.setOpaque(true);
		dg.setLayout(null);
		l_dg_showMessage.setForeground(Color.red);
		dg.setBounds(540,150,300,367);
		l_dg_id.setBounds(50,50,150,25);
		t_dg_id.setBounds(50,80,150,25);
		l_dg_showMessage.setBounds(63,140,225,25);
		b_dg_cancel.setBounds(70,170,80,25);
		b_dg_ok.setBounds(160,170,80,25);
		dg.getContentPane().setBackground(new Color(255, 253, 208));
		dg.setUndecorated(true);
		dg.setResizable(false);
		homeReference.add(l_title);
		add(b_attendancePercent);
		add(b_AddStudentAttendance);
		add(b_AddClassAttendance);
		add(b_UpdateStudentAttendance);
		add(b_UpdateClassAttendance);
		add(b_ViewStudent);
		add(b_logout);
		dg.add(l_dg_id);
		dg.add(t_dg_id);
		dg.add(l_dg_showMessage);
		dg.add(b_dg_cancel);
		dg.add(b_dg_ok);
//		dg_percentAttendance.add(l_dg_id);
//		dg_percentAttendance.add(l_dg_id);
//		b_attendancePercent.addActionListener(this);
		b_AddStudentAttendance.addActionListener(this);
		b_AddClassAttendance.addActionListener(this);
		b_UpdateStudentAttendance.addActionListener(this);
		b_UpdateClassAttendance.addActionListener(this);
		b_ViewStudent.addActionListener(this);
		b_logout.addActionListener(this);
		b_dg_cancel.addActionListener(this);
		b_dg_ok.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		String view_data[]=null;
		String buttonString = ae.getActionCommand();
		if(buttonString.equals("Percentage of Attendance"))
		{
			
		}
		else if(buttonString.equals("View Student")) 
		{
			f_s=0;
			l_dg_id.setText("Enter Student University RollNo");
			dg.setVisible(true);
		}
		else if(buttonString.equals("logout"))
		{
			homeReference.getContentPane().remove(this);
			removeTitle();
			homeReference.l_homeTitle.setVisible(true);
			homeReference.getContentPane().setBackground(new Color(180, 215, 195));
			loginReference.setVisible(true);
		}
		else if(buttonString.equals("Cancel")) 
		{
			t_dg_id.setText("");
			l_dg_showMessage.setText("");
			dg.setVisible(false);
		}
		else if(buttonString.equals("Ok")) 
		{
			if(!t_dg_id.getText().equals("")) 
			{
				l_dg_showMessage.setText("");
				if(f_s==1) 
				{
					view_data=service.viewFaculty(t_dg_id.getText());
					if(view_data[0]!=null) 
					{	
						t_dg_id.setText("");
						setVisible(false);
						dg.setVisible(false);
						removeTitle();
//						facultyProfile a_fty = new facultyProfile(homeReference,loginReference,this,view_data,buttonString);
					}
					else 
					{
						l_dg_showMessage.setText("faculty id is not available");
					}
				}	
				else 
				{
					view_data=service.viewStudent(t_dg_id.getText());
					if(view_data[0]!=null) 
					{	
						t_dg_id.setText("");
						setVisible(false);
						dg.setVisible(false);
						removeTitle();
						studentProfile a_stu = new studentProfile(homeReference,loginReference,null,this,view_data,buttonString);
					}
					else 
					{
						l_dg_showMessage.setText("student university rollno is not available");
					}
			    }
			}
			else 
			{
				if(f_s==1) 
				{
					l_dg_showMessage.setText("enter faculty id");
				}
				else 
				{
					System.out.println(f_s);
					l_dg_showMessage.setText("enter student university rollno");
				}
			}
		}
		else if(buttonString.equals("Add Class Attendance")) 
		{
			setVisible(false);
			removeTitle();
			courses attd = new courses(homeReference,loginReference,facultyid);
		}
//		else if(buttonString.equals("Update Class Attendance")) 
//		{
//			setVisible(false);
//			courses attd = new courses(homeReference,facultyid);
//		}
	}
	
	void removeTitle()
	{
		homeReference.getContentPane().remove(l_title);
		homeReference.repaint();
	}

}
