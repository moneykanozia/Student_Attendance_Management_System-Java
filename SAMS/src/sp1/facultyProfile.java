package sp1;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.*;
public class facultyProfile extends JPanel implements ActionListener {
	 home homeReference;
	 login loginReference;
	 adminPage adminReference;
	 String buttonString,arr[];
	 JLabel l_FacultyId,l_FacultyName,l_FacultyPass,l_Subject,l_Class,l_Sem,l_showmessage,l_dg_successfulMessage,l_title;
	 JTextField t_FacultyId,t_FacultyName,t_Subject,t_Class,t_Sem;
	 JDialog dg_successful;
	 JPasswordField t_FacultyPass;
	 JButton b_Submit,b_Logout,b_back,b_dg_ok; 
	facultyProfile(home homeReference,login loginReference,adminPage adminReference,String[] arr,String buttonString)
	{
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		this.adminReference = adminReference;
		this.buttonString = buttonString;
		this.arr = arr;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setLayout(null);
		setBounds(430,110,550,440);
		setBorder(blackline);
//		setBackground(new Color(50, 141, 168));
		homeReference.add(this);
		homeReference.getContentPane().setBackground(new Color(252, 186, 143));
		labelsTextfields();
	}
	public void labelsTextfields() {
//		l_title = new JLabel("FACULTY PROFILE");
		l_FacultyId = new JLabel("FacultyId :");
		l_FacultyName = new JLabel("Faculty Name :");
		l_FacultyPass = new JLabel("Faculty Password :");
		l_Subject = new JLabel("Subject :");
		l_Class = new JLabel("Class :");
		l_Sem = new JLabel("Sem :");
		l_showmessage = new JLabel("");
		t_FacultyId = new JTextField("");
		t_FacultyName = new JTextField("");
		t_FacultyPass = new JPasswordField("");
		t_Subject = new JTextField("");
		t_Class = new JTextField("");
		t_Sem = new JTextField("");
		b_Submit = new JButton("Submit");
		b_Logout = new JButton("Logout");
		b_back = new JButton("Back");
		dg_successful = new JDialog(homeReference);
		l_dg_successfulMessage = new JLabel("Successful....");
		b_dg_ok = new JButton("Ok");
		l_FacultyId.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_FacultyName.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_FacultyPass.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Subject.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Class.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_Sem.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_showmessage.setForeground(Color.red);
		t_FacultyId.setFont(new Font("Serif", Font.PLAIN, 18));
		t_FacultyName.setFont(new Font("Serif", Font.PLAIN, 18));
		t_FacultyPass.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Subject.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Class.setFont(new Font("Serif", Font.PLAIN, 18));
		t_Sem.setFont(new Font("Serif", Font.PLAIN, 18));
		l_dg_successfulMessage.setFont(new Font("Serif", Font.PLAIN, 30));
//		l_title.setBounds(641,38,160,33);
		l_FacultyId.setBounds(45,35,150,25);
		l_FacultyName.setBounds(45,83,150,25);
		l_FacultyPass.setBounds(45,135,170,25);
		l_Subject.setBounds(45,185,150,25);
		l_Class.setBounds(45,235,150,25);
		l_Sem.setBounds(45,285,150,25);
		l_showmessage.setBounds(180,330, 150, 30);
		t_FacultyId.setBounds(235,35,250,25);
		t_FacultyName.setBounds(235,83,250,25);
		t_FacultyPass.setBounds(235,135,250,25);
		t_Subject.setBounds(235,185,250,25);
		t_Class.setBounds(235,235,250,25);
		t_Sem.setBounds(235,285,250,25);
		b_Submit.setBounds(100,375,80,25);
		b_Logout.setBounds(211,375,80,25);
		b_back.setBounds(320,375,80,25);
//		l_title.setFont(new Font("Verdana", Font.PLAIN, 21));
//		l_title.setOpaque(true);
//		l_title.setBackground(new Color(255, 253, 208));
		dg_successful.setLayout(null);
		dg_successful.setUndecorated(true);
		dg_successful.setResizable(false);
		dg_successful.getContentPane().setBackground(new Color(255, 253, 208));
		dg_successful.setBounds(459,165,464,383);
		l_dg_successfulMessage.setBounds(170,120,150,35);
		b_dg_ok.setBounds(195,200,80,25);
//		homeReference.add(l_title);
		add(l_FacultyId);
		add(l_FacultyName);
		add(l_FacultyPass);
		add(l_Subject);
		add(l_Class);
		add(l_Sem);
		add(l_showmessage);
		add(t_FacultyId);
		add(t_FacultyName);
		add(t_FacultyPass);
		add(t_Subject);
		add(t_Class);
		add(t_Sem);
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
		t_FacultyId.setText(arr[0]);
		t_FacultyName.setText(arr[1]);
		t_FacultyPass.setText(arr[2]);
		t_Subject.setText(arr[3]);
		t_Class.setText(arr[4]);
		t_Sem.setText(arr[5]);
	}	
	void setDisable() 
	{	
		t_FacultyId.setEnabled(false);
		t_FacultyName.setEnabled(false);
		t_FacultyPass.setEnabled(false);
		t_Subject.setEnabled(false);
		t_Class.setEnabled(false);
		t_Sem.setEnabled(false);
		b_Submit.setEnabled(false);
	}
	
	void setEnable() 
	{	
		t_FacultyId.setEnabled(true);
		t_FacultyName.setEnabled(true);
		t_FacultyPass.setEnabled(true);
		t_Subject.setEnabled(true);
		t_Class.setEnabled(true);
		t_Sem.setEnabled(true);
		b_Submit.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Submit"))
		{
			if(!t_FacultyId.getText().equals("") && !t_FacultyName.getText().equals("") && !t_FacultyPass.getText().equals("") && !t_Subject.getText().equals("") && !t_Class.getText().equals("") && !t_Sem.getText().equals("")) 
			{
				int check = service.insertFaculty(t_FacultyId.getText(),t_FacultyName.getText(),t_FacultyPass.getText(),t_Subject.getText(),t_Class.getText(),t_Sem.getText());
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
//			removeTitle();
			loginReference.setVisible(true);
		}
		else if(ae.getActionCommand().equals("Back"))
		{
			setFieldsEmpty();
			setEnable();
			homeReference.getContentPane().remove(this);
//			removeTitle();
			this.adminReference.setVisible(true);			
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
			l_showmessage.setText("faculty id already exists");
		}
	}
	
	void setFieldsEmpty() 
	{
		t_FacultyId.setText("");
		t_FacultyName.setText("");
		t_FacultyPass.setText("");
		t_Subject.setText("");
		t_Class.setText("");
		t_Sem.setText("");
	}
	
	void showSuccessfulMessage() 
	{
		dg_successful.setVisible(true);
	}
	
//	void removeTitle()
//	{
//		homeReference.getContentPane().remove(l_title);
//		homeReference.repaint();
//	} 
}
