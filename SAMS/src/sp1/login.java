package sp1;
import sp1.service;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import sp1.home;
import sp1.courses;
import sp1.bTech;
import sp1.semesters;
import sp1.faculty;
import sp1.classAttendance;
public class login extends JPanel implements ActionListener{
	JLabel l_UserLogin,l_UserId,l_pass,l_showmessage,l_homeTitle;
	JTextField t1;
	JTextField t2;
	JButton b_login,b_exit;
	home homeReference;
	login(home homeReference,JLabel l_homeTitle)
	{
		this.homeReference = homeReference;
		this.l_homeTitle = l_homeTitle;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setLayout(null);
		setBounds(430,120,500,400);
		setBorder(blackline);
		labels();
		setBackground(new Color(52, 235, 207));
	}
	public void  labels() {
		l_UserLogin = new JLabel("USER LOGIN");
		l_UserId = new JLabel("UserID");
		l_pass = new JLabel("Password");
		l_showmessage = new JLabel("");
		t1 = new JTextField();
		t2 = new JPasswordField();
		b_login = new JButton("Login");
		b_exit = new JButton("Exit");
		l_UserLogin.setBounds(190,30, 150, 30);
		l_UserLogin.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_UserId.setBounds(80,120,150,30);
		l_UserId.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_pass.setBounds(80,210, 150, 30);
		l_pass.setFont(new Font("Verdana", Font.PLAIN, 18));
		l_showmessage.setBounds(180,285, 160, 30);
		l_showmessage.setForeground(Color.red);
		t1.setBounds(210,122,250,32);
		t1.setFont(new Font("Serif", Font.PLAIN, 18));
		t2.setBounds(210,210,250,32);
		t2.setFont(new Font("Verdana", Font.PLAIN, 18));
		b_login.setBounds(160,330,80,35);
		b_exit.setBounds(270,330,80,35);
		b_login.setFont(new Font("Verdana", Font.PLAIN, 15));
		b_exit.setFont(new Font("Verdana", Font.PLAIN, 15));
		add(l_UserLogin);
		add(l_UserId);
		add(l_pass);
		add(l_showmessage);
		add(t1);
		add(t2);
		add(b_login);
		add(b_exit);
		b_login.addActionListener(this);
		b_exit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Login")) 
		{
			String userid = t1.getText();
			String pass = t2.getText();
			if(!userid.equals("") && !pass.equals(""))
			{
				l_showmessage.setText("");
				String usertype = service.login(userid,pass);
				if(usertype.equals("ADMIN")) 
				{
					t1.setText("");
					t2.setText("");
					setVisible(false);
					l_homeTitle.setVisible(false);
					adminPage admin = new adminPage(homeReference,this);
				}
				else if(usertype.equals("FACULTY"))
				{
					t1.setText("");
					t2.setText("");
					setVisible(false);
					l_homeTitle.setVisible(false);
					faculty fty = new faculty(homeReference,this,userid);
				}
				else 
				{
					l_showmessage.setText("invalid username/password");
				}
			}
			else 
			{
				l_showmessage.setText("Both fields are Required");
			}
		}
		else 
		{
			System.exit(0);
		}
//		String[][] ob = new String[100][31];
//		String[] hd = new String[31];
//		hd[0] = "Uni.RollNo";
//		for(int i=1;i<31;i++) {
//			hd[i] = Integer.toString(i);
//		}
		//classAttendance sp = new classAttendance(homeReference,ob,hd);
	}
}
