package sp1;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.*;
import sp1.home;
public class bTech extends JPanel{
	home homeReference;
	JButton b_CSE,b_IT,b_ME,b_ECE,b_EE,b_CE,b_Logout;
	bTech(home homeReference){
		this.homeReference = homeReference;
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
		b_CSE = new JButton("CSE");
		b_IT = new JButton("IT");
		b_ME = new JButton("ME");
		b_ECE = new JButton("ECE");
		b_EE = new JButton("EE");
		b_CE = new JButton("CE");
		b_Logout = new JButton("logout");
		b_CSE.setBounds(174,50,150,25);
		b_IT.setBounds(174,98,150,25);
		b_ME.setBounds(174,150,150,25);
		b_ECE.setBounds(174,200,150,25);
		b_EE.setBounds(174,250,150,25);
		b_CE.setBounds(174,300,150,25);
		b_Logout.setBounds(208,390,80,25);
		add(b_CSE);
		add(b_IT);
		add(b_ME);
		add(b_ECE);
		add(b_EE);
		add(b_CE);
		add(b_Logout);
	}
}
