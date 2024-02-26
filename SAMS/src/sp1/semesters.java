package sp1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.*;
import sp1.home;
public class semesters extends JPanel implements ActionListener{
	home homeReference;
	login loginReference;
	String sem,_class,subjectName,course;
	JLabel l_title;
	JButton b_s1,b_s2,b_s3,b_s4,b_s5,b_s6,b_s7,b_s8,b_logout;
	semesters(home homeReference,login loginReference,String sem,String _class,String subjectName,String course){
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		this.sem = sem;
		this._class = _class;
		this.subjectName = subjectName;
		this.course = course;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setLayout(null);
		setBounds(430,90,500,510);
		setBorder(blackline);
//		setBackground(new Color(50, 141, 168));
		homeReference.add(this);
		homeReference.getContentPane().setBackground(new Color(168, 50, 123));
		buttons();
	}
	void buttons() {
		l_title = new JLabel("SEMESTERS");
		b_s1 = new JButton("1ST");
		b_s2 = new JButton("2ND");
		b_s3 = new JButton("3RD");
		b_s4 = new JButton("4TH");
		b_s5 = new JButton("5TH");
		b_s6 = new JButton("6TH");
		b_s7 = new JButton("7TH");
		b_s8 = new JButton("8TH");
		b_logout = new JButton("logout");
		l_title.setBounds(641,38,132,33);
		b_s1.setBounds(174,50,150,25);
		b_s2.setBounds(174,98,150,25);
		b_s3.setBounds(174,150,150,25);
		b_s4.setBounds(174,200,150,25);
		b_s5.setBounds(174,250,150,25);
		b_s6.setBounds(174,300,150,25);
		b_s7.setBounds(174,350,150,25);
		b_s8.setBounds(174,400,150,25);
		b_logout.setBounds(208,470,80,25);
		l_title.setFont(new Font("Verdana", Font.PLAIN, 21));
		l_title.setBackground(new Color(255, 253, 208));
		l_title.setOpaque(true);
		homeReference.add(l_title);
		add(b_s1);
		add(b_s2);
		add(b_s3);
		add(b_s4);
		add(b_s5);
		add(b_s6);
		add(b_s7);
		add(b_s8);
		add(b_logout);
		b_s1.addActionListener(this);
		b_s2.addActionListener(this);
		b_s3.addActionListener(this);
		b_s4.addActionListener(this);
		b_s5.addActionListener(this);
		b_s6.addActionListener(this);
		b_s7.addActionListener(this);
		b_s8.addActionListener(this);
		b_logout.addActionListener(this);
		setDisabled();
		setEnabled();
	}
	
	void setDisabled()
	{
		b_s1.setEnabled(false);
		b_s2.setEnabled(false);
		b_s3.setEnabled(false);
		b_s4.setEnabled(false);
		b_s5.setEnabled(false);
		b_s6.setEnabled(false);
		b_s7.setEnabled(false);
		b_s8.setEnabled(false);
	}
	
	void setEnabled() 
	{
		if(b_s1.getText().equals(sem))
			b_s1.setEnabled(true);
		else if(b_s2.getText().equals(sem))
			b_s2.setEnabled(true);
		else if(b_s3.getText().equals(sem))
			b_s3.setEnabled(true);
		else if(b_s4.getText().equals(sem))
			b_s4.setEnabled(true);
		else if(b_s5.getText().equals(sem))
			b_s5.setEnabled(true);
		else if(b_s6.getText().equals(sem))
			b_s6.setEnabled(true);
		else if(b_s7.getText().equals(sem))
			b_s7.setEnabled(true);
		else if(b_s8.getText().equals(sem))
			b_s8.setEnabled(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		String buttonString = ae.getActionCommand();
		if(buttonString.equals("logout"))
		{
			homeReference.getContentPane().remove(this);
			removeTitle();
			homeReference.getContentPane().setBackground(new Color(180, 215, 195));
			homeReference.l_homeTitle.setVisible(true);
			loginReference.setVisible(true);
		}	
		else
		{
			toClasses(buttonString);
		}
	}
	
	void toClasses(String buttonString)
	{
		setVisible(false);
		removeTitle();
		classes c = new classes(homeReference,loginReference,_class,subjectName,course,buttonString);
	}
	
	void removeTitle()
	{
		homeReference.getContentPane().remove(l_title);
		homeReference.repaint();
	}
}
