package sp1;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.*;
public class courses extends JPanel implements ActionListener{
	home homeReference;
	login loginReference;
	String facultyid;
	JLabel l_title;
	JButton b_BTech,b_BCA,b_BCom,b_BA,b_BBA,b_Agriculture,b_Logout;
	courses(home homeReference,login loginReference,String facultyid){
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		this.facultyid = facultyid;
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setLayout(null);
		setBounds(430,90,500,510);
		setBorder(blackline);
//		setBackground(new Color(50, 141, 168));
		homeReference.add(this);
		homeReference.getContentPane().setBackground(new Color(168, 50, 50));
		buttons();
	}
	public void buttons() {
		l_title = new JLabel("COURSES");
		b_BTech = new JButton("B.Tech");
		b_BCA = new JButton("BCA");
		b_BCom = new JButton("BCom");
		b_BA = new JButton("BA");
		b_BBA = new JButton("BBA");
		b_Agriculture = new JButton("Agriculture");
		b_Logout = new JButton("logout");
		l_title.setBounds(641,38,105,33);
		b_BTech.setBounds(174,50,150,25);
		b_BCA.setBounds(174,98,150,25);
		b_BCom.setBounds(174,150,150,25);
		b_BA.setBounds(174,200,150,25);
		b_BBA.setBounds(174,250,150,25);
		b_Agriculture.setBounds(174,300,150,25);
		b_Logout.setBounds(208,390,80,25);
		l_title.setFont(new Font("Verdana", Font.PLAIN, 21));
		l_title.setBackground(new Color(255, 253, 208));
		l_title.setOpaque(true);
		homeReference.add(l_title);
		add(b_BTech);
		add(b_BCA);
		add(b_BCom);
		add(b_BA);
		add(b_BBA);
		add(b_Agriculture);
		add(b_Logout);
		b_BTech.addActionListener(this);
		b_Logout.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		String buttonString = ae.getActionCommand();
		String sem_cls_sub[];
		if(buttonString.equals("B.Tech"))
		{	
			setVisible(false);
			removeTitle();
			sem_cls_sub = attendanceService.getSem(facultyid);
			semesters sems = new semesters(homeReference,loginReference,sem_cls_sub[0],sem_cls_sub[1],sem_cls_sub[2],buttonString);
		}
		else if(buttonString.equals("logout"))
		{
			homeReference.getContentPane().remove(this);
			removeTitle();
			homeReference.getContentPane().setBackground(new Color(180, 215, 195));
			homeReference.l_homeTitle.setVisible(true);
			loginReference.setVisible(true);
		}
	}
	
	void removeTitle()
	{
		homeReference.getContentPane().remove(l_title);
		homeReference.repaint();
	}
}
	
