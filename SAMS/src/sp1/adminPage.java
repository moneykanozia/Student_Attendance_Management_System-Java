package sp1;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
public class adminPage extends JPanel implements ActionListener{
	home homeReference;
	login loginReference;
	JButton b_AddFaculty,b_ViewFaculty,b_AddStudent,b_ViewStudent,b_Logout,b_dg_cancel,b_dg_ok; 
	JDialog dg;
	JLabel l_dg_id,l_dg_showMessage;
	JTextField t_dg_id;
	int f_s;
	adminPage(home homeReference,login loginReference)
	{
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setLayout(null);
		setBounds(430,90,500,510);
		setBorder(blackline);
//		setBackground(new Color(50, 141, 168));
		homeReference.add(this);
		homeReference.getContentPane().setBackground(new Color(252, 186, 143));
		buttons();
	}
	public void buttons() {
		b_AddFaculty = new JButton("Add Faculty");
		b_ViewFaculty = new JButton("View Faculty");
		b_AddStudent = new JButton("Add Student");
		b_ViewStudent = new JButton("View Student");
		b_Logout = new JButton("logout");
		dg = new JDialog(homeReference);
		l_dg_id = new JLabel();
		l_dg_showMessage = new JLabel();
		t_dg_id = new JTextField();
		b_dg_cancel = new JButton("Cancel");
		b_dg_ok = new JButton("Ok");
		b_AddFaculty.setBounds(174,50,150,25);
		b_ViewFaculty.setBounds(174,98,150,25);
		b_AddStudent.setBounds(174,150,150,25);
		b_ViewStudent.setBounds(174,200,150,25);
		b_Logout.setBounds(208,290,80,25);
		dg.setLayout(null);
		l_dg_showMessage.setForeground(Color.red);
		dg.setBounds(540,150,300,300);
		l_dg_id.setBounds(50,50,150,25);
		t_dg_id.setBounds(50,80,150,25);
		l_dg_showMessage.setBounds(63,140,225,25);
		b_dg_cancel.setBounds(70,170,80,25);
		b_dg_ok.setBounds(160,170,80,25);
		dg.getContentPane().setBackground(new Color(255, 253, 208));
		dg.setUndecorated(true);
		dg.setResizable(false);
		add(b_AddFaculty);
		add(b_ViewFaculty);
		add(b_AddStudent);
		add(b_ViewStudent);
		add(b_Logout);
		dg.add(l_dg_id);
		dg.add(t_dg_id);
		dg.add(l_dg_showMessage);
		dg.add(b_dg_cancel);
		dg.add(b_dg_ok);
		b_AddFaculty.addActionListener(this);
		b_ViewFaculty.addActionListener(this);
		b_AddStudent.addActionListener(this);
		b_ViewStudent.addActionListener(this);
		b_Logout.addActionListener(this);
		b_dg_cancel.addActionListener(this);
		b_dg_ok.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String view_data[]=null;
		String buttonString = ae.getActionCommand();
		if(buttonString.equals("Add Faculty")) 
		{
			setVisible(false);
			facultyProfile a_fty = new facultyProfile(homeReference,loginReference,this,view_data,buttonString);
		}
		else if(buttonString.equals("View Faculty")) 
		{
			f_s=1;
			l_dg_id.setText("Enter Faculty Id");
			dg.setVisible(true);
		}
		else if(buttonString.equals("Add Student"))
		{
			setVisible(false);
			studentProfile a_sp = new studentProfile(homeReference,loginReference,this,null,view_data,buttonString);
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
			homeReference.repaint();
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
						facultyProfile a_fty = new facultyProfile(homeReference,loginReference,this,view_data,buttonString);
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
						studentProfile a_stu = new studentProfile(homeReference,loginReference,this,null,view_data,buttonString);
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
	}
}
