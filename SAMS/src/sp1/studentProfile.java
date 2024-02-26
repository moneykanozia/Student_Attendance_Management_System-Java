package sp1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.*;
public class studentProfile extends JPanel implements ActionListener{
	home homeReference;
	login loginReference;
	adminPage adminReference;
	faculty facultyReference;
	String buttonString,stu_data[];
	JLabel l_UniRollNo,l_StudentName,l_Course,l_Branch,l_Sem,l_Batch,l_Class,l_showmessage,l_dg_successfulMessage;
	JTextField t_UniRollNo,t_StudentName,t_Course,t_Branch,t_Sem,t_Batch,t_Class;
	JButton b_Submit,b_Logout,b_back,b_dg_ok;
	JDialog dg_successful;
	studentProfile(home homeReference,login loginReference,adminPage adminReference,faculty facultyReference,String[] stu_data,String buttonString)
	{
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		this.adminReference = adminReference;
		this.facultyReference = facultyReference;
		this.buttonString = buttonString;
		this.stu_data = stu_data;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setLayout(null);
		setBounds(430,90,500,510);
		setBorder(blackline);
//		setBackground(new Color(50, 141, 168));
		homeReference.add(this);
		homeReference.getContentPane().setBackground(new Color(252, 186, 143));
		labelsTextfields();
	}
	public void labelsTextfields() {
		l_UniRollNo = new JLabel("Uni.RollNo :");
		l_StudentName = new JLabel("Student Name :");
		l_Course = new JLabel("Course :");
		l_Branch = new JLabel("Branch :");
		l_Sem = new JLabel("Sem :");
		l_Batch = new JLabel("Batch :");
		l_Class = new JLabel("Class :");
		l_showmessage = new JLabel("");
		t_UniRollNo = new JTextField("");
		t_StudentName = new JTextField("");
		t_Course = new JTextField("");
		t_Branch = new JTextField("");
		t_Sem = new JTextField("");
		t_Batch = new JTextField("");
		t_Class = new JTextField("");
		b_Submit = new JButton("Submit");
		b_Logout = new JButton("logout");
		b_back = new JButton("Back");
		dg_successful = new JDialog(homeReference);
		l_dg_successfulMessage = new JLabel("Successful....");
		b_dg_ok = new JButton("Ok");
		l_UniRollNo.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_StudentName.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Course.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Branch.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Sem.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Batch.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Class.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_showmessage.setForeground(Color.red);
		t_UniRollNo.setFont(new Font("Serif", Font.PLAIN, 18));
		t_StudentName.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Course.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Branch.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Sem.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Batch.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Class.setFont(new Font("Serif", Font.PLAIN, 18));
		l_dg_successfulMessage.setFont(new Font("Serif", Font.PLAIN, 30));
		l_UniRollNo.setBounds(60,50,150,25);
		l_StudentName.setBounds(60,98,150,25);
		l_Course.setBounds(60,150,150,25);
		l_Branch.setBounds(60,200,150,25);
		l_Sem.setBounds(60,250,150,25);
		l_Batch.setBounds(60,300,150,25);
		l_Class.setBounds(60,350,150,25);
		l_showmessage.setBounds(180,385,150,30);
		t_UniRollNo.setBounds(235,50,250,25);
		t_StudentName.setBounds(235,98,250,25);
		t_Course.setBounds(235,150,250,25);
		t_Branch.setBounds(235,200,250,25);
		t_Sem.setBounds(235,250,250,25);
		t_Batch.setBounds(235,300,250,25);
		t_Class.setBounds(235,350,250,25);
		b_Submit.setBounds(100,450,80,25);
		b_Logout.setBounds(211,450,80,25);
		b_back.setBounds(320,450,80,25);
		dg_successful.setLayout(null);
		dg_successful.setUndecorated(true);
		dg_successful.setResizable(false);
		dg_successful.getContentPane().setBackground(new Color(255, 253, 208));
		dg_successful.setBounds(459,165,464,383);
		l_dg_successfulMessage.setBounds(170,120,150,35);
		b_dg_ok.setBounds(195,200,80,25);
		add(l_UniRollNo);
		add(l_StudentName);
		add(l_Course);
		add(l_Branch);
		add(l_Sem);
		add(l_Batch);
		add(l_Class);
		add(l_showmessage);
		add(t_UniRollNo);
		add(t_StudentName);
		add(t_Course);
		add(t_Branch);
		add(t_Sem);
		add(t_Batch);
		add(t_Class);
		add(b_Submit);
		add(b_Logout);
		add(b_back);
		dg_successful.add(l_dg_successfulMessage);
		dg_successful.add(b_dg_ok);
		b_Submit.addActionListener(this);
		b_Logout.addActionListener(this);
		b_back.addActionListener(this);
		b_dg_ok.addActionListener(this);
		if(buttonString.equals("Ok")) 
		{
			setValue();
			setDisable();
		}
	}
	void setValue()
	{
		t_UniRollNo.setText(stu_data[0]);
		t_StudentName.setText(stu_data[1]);
		t_Course.setText(stu_data[2]);
		t_Branch.setText(stu_data[3]);
		t_Sem.setText(stu_data[4]);
		t_Batch.setText(stu_data[5]);
		t_Class.setText(stu_data[6]);
	}	
	void setDisable() 
	{	
		t_UniRollNo.setEnabled(false);
		t_StudentName.setEnabled(false);
		t_Course.setEnabled(false);
		t_Branch.setEnabled(false);
		t_Sem.setEnabled(false);
		t_Batch.setEnabled(false);
		t_Class.setEnabled(false);
		b_Submit.setEnabled(false);
	}
	
	void setEnable() 
	{	
		t_UniRollNo.setEnabled(true);
		t_StudentName.setEnabled(true);
		t_Course.setEnabled(true);
		t_Branch.setEnabled(true);
		t_Sem.setEnabled(true);
		t_Batch.setEnabled(true);
		t_Class.setEnabled(true);
		b_Submit.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Submit"))
		{
			if(!t_UniRollNo.getText().equals("") && !t_StudentName.getText().equals("") && !t_Course.getText().equals("") && !t_Branch.getText().equals("") && !t_Sem.getText().equals("") && !t_Batch.getText().equals("") && !t_Class.getText().equals("")) 
			{
				int check = service.insertStudent(t_UniRollNo.getText(),t_StudentName.getText(),t_Course.getText(),t_Branch.getText(),t_Sem.getText(),t_Batch.getText(),t_Class.getText());
				showinsertstatus(check);
			}
			else 
			{
				l_showmessage.setText("All fields are Required");
			}
		}
		else if(ae.getActionCommand().equals("logout"))
		{
			homeReference.getContentPane().remove(this);
			homeReference.repaint();
			homeReference.l_homeTitle.setVisible(true);
			loginReference.setVisible(true);
		}
		else if(ae.getActionCommand().equals("Back"))
		{
			setFieldsEmpty();
			setEnable();
			homeReference.getContentPane().remove(this);
			homeReference.repaint();
			if(this.adminReference!=null)
			{
				this.adminReference.setVisible(true);			
			}	
			else
			{
				this.facultyReference.setVisible(true);
			}
		}	
		else if(ae.getActionCommand().equals("Ok")) 
		{
			l_showmessage.setText("");
			dg_successful.setVisible(false);
		}
	}
		
	void showinsertstatus(int check)
	{
		if(check==0) 
		{
			l_showmessage.setText("Some error is there");
		}
		else if(check==1) 
		{
			setFieldsEmpty();
			showSuccessfulMessage();
			
		}
		else 
		{
			l_showmessage.setText("student id already exists");
		}
	}
	
	void setFieldsEmpty() 
	{
		t_UniRollNo.setText("");
		t_StudentName.setText("");
		t_Course.setText("");
		t_Branch.setText("");
		t_Sem.setText("");
		t_Batch.setText("");
		t_Class.setText("");
	}
	
	void showSuccessfulMessage() 
	{
		dg_successful.setVisible(true);
	}
}
