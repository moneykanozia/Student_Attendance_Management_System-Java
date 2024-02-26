package sp1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.*;
public class classes extends JPanel implements ActionListener{
	 home homeReference;
	 login loginReference;
	 String _class,subjectName,course,sem;
	 JButton b_CSE1,b_CSE2,b_IT1,b_IT2,b_ME1,b_ME2,b_ECE1,b_ECE2,b_EE1,b_EE2,b_CE1,b_CE2,b_logout,b_dg_cancel,b_dg_ok;
	 JLabel l_Section,l_dg_day,l_dg_month,l_dg_year,l_dg_showMessage;
	 JDialog dg;
	 JTextField t_dg_day,t_dg_month,t_dg_year;
	 JComboBox combo_dg_days,combo_dg_months,combo_dg_years;
	classes(home homeReference,login loginReference,String _class,String subjectName,String course,String sem)
	{
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		this._class = _class;
		this.subjectName = subjectName;
		this.course = course;
		this.sem = sem;
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
		l_Section = new JLabel("Sections");
		b_CSE1 = new JButton("CSE1");
		b_CSE2 = new JButton("CSE2");
		b_IT1 = new JButton("IT1");
		b_IT2 = new JButton("IT2");
		b_ME1 = new JButton("ME1");
		b_ME2 = new JButton("ME2");
		b_ECE1 = new JButton("ECE1");
		b_ECE2 = new JButton("ECE2");
		b_EE1 = new JButton("EE1");
		b_EE2 = new JButton("EE2");
		b_CE1 = new JButton("CE1");
		b_CE2 = new JButton("CE2");
		b_logout = new JButton("logout");
		dg = new JDialog(homeReference);
		l_dg_year = new JLabel("Year : ");
		l_dg_month = new JLabel("Month : ");
		l_dg_day = new JLabel("Day : ");
		l_dg_showMessage = new JLabel();
		combo_dg_years = new JComboBox();
		combo_dg_months = new JComboBox();
		combo_dg_days = new JComboBox();
		b_dg_cancel = new JButton("Cancel");
		b_dg_ok = new JButton("Ok");
		l_Section.setBounds(641,38,90,50);
		b_CSE1.setBounds(80,50,150,25);
		b_CSE2.setBounds(270,50,150,25);
		b_IT1.setBounds(80,100,150,25);
		b_IT2.setBounds(270,100,150,25);
		b_ME1.setBounds(80,150,150,25);
		b_ME2.setBounds(270,150,150,25);
		b_ECE1.setBounds(80,200,150,25);
		b_ECE2.setBounds(270,200,150,25);
		b_EE1.setBounds(80,250,150,25);
		b_EE2.setBounds(270,250,150,25);
		b_CE1.setBounds(80,300,150,25);
		b_CE2.setBounds(270,300,150,25);
		b_logout.setBounds(218,390,80,25);
		l_Section.setFont(new Font("Verdana", Font.PLAIN, 21));
		dg.setLayout(null);
		l_dg_showMessage.setForeground(Color.red);
		dg.setBounds(460,150,450,400);
		l_dg_year.setBounds(110,100,50,25);
		combo_dg_years.setBounds(180,100,150,25);
		l_dg_month.setBounds(110,150,50,25);
		combo_dg_months.setBounds(180,150,150,25);
		l_dg_day.setBounds(110,200,50,25);
		combo_dg_days.setBounds(180,200,150,25);
		l_dg_showMessage.setBounds(100,250,225,25);
		b_dg_cancel.setBounds(130,320,80,25);
		b_dg_ok.setBounds(220,320,80,25);
		dg.getContentPane().setBackground(new Color(255, 253, 208));
		dg.setUndecorated(true);
		dg.setResizable(false);
		homeReference.add(l_Section);
		add(b_CSE1);
		add(b_CSE2);
		add(b_IT1);
		add(b_IT2);
		add(b_ME1);
		add(b_ME2);
		add(b_ECE1);
		add(b_ECE2);
		add(b_EE1);
		add(b_EE2);
		add(b_CE1);
		add(b_CE2);
		add(b_logout);
		dg.add(l_dg_year);
		dg.add(l_dg_month);
		dg.add(l_dg_day);
		dg.add(combo_dg_years);
		dg.add(combo_dg_months);
		dg.add(combo_dg_days);
		dg.add(l_dg_showMessage);
		dg.add(b_dg_cancel);
		dg.add(b_dg_ok);
		b_CSE1.addActionListener(this);
		b_CSE2.addActionListener(this);
		b_IT1.addActionListener(this);
		b_IT2.addActionListener(this);
		b_ME1.addActionListener(this);
		b_ME2.addActionListener(this);
		b_ECE1.addActionListener(this);
		b_ECE2.addActionListener(this);
		b_EE1.addActionListener(this);
		b_EE2.addActionListener(this);
		b_CE1.addActionListener(this);
		b_CE2.addActionListener(this);
		b_logout.addActionListener(this);
		combo_dg_years.addActionListener(this);
		combo_dg_months.addActionListener(this);
		combo_dg_days.addActionListener(this);
		b_dg_cancel.addActionListener(this);
		b_dg_ok.addActionListener(this);
		setDisabled();
		setEnabled();
	}
	
	void setDisabled()
	{
		b_CSE1.setEnabled(false);
		b_CSE2.setEnabled(false);
		b_IT1.setEnabled(false);
		b_IT2.setEnabled(false);
		b_ME1.setEnabled(false);
		b_ME2.setEnabled(false);
		b_ECE1.setEnabled(false);
		b_ECE2.setEnabled(false);
		b_EE1.setEnabled(false);
		b_EE2.setEnabled(false);
		b_CE1.setEnabled(false);
		b_CE2.setEnabled(false);
		l_dg_month.setEnabled(false);
		l_dg_day.setEnabled(false);
		combo_dg_months.setEnabled(false);
		combo_dg_days.setEnabled(false);
	}
	
	void setEnabled() 
	{
		if(b_CSE1.getText().equals(_class))
			b_CSE1.setEnabled(true);
		else if(b_CSE2.getText().equals(_class))
			b_CSE2.setEnabled(true);
		else if(b_IT1.getText().equals(_class))
			b_IT1.setEnabled(true);
		else if(b_IT2.getText().equals(_class))
			b_IT2.setEnabled(true);
		else if(b_ME1.getText().equals(_class))
			b_ME1.setEnabled(true);
		else if(b_ME2.getText().equals(_class))
			b_ME2.setEnabled(true);
		else if(b_ECE1.getText().equals(_class))
			b_ECE1.setEnabled(true);
		else if(b_ECE2.getText().equals(_class))
			b_ECE2.setEnabled(true);
		else if(b_EE1.getText().equals(_class))
			b_EE1.setEnabled(true);
		else if(b_EE2.getText().equals(_class))
			b_EE2.setEnabled(true);
		else if(b_CE1.getText().equals(_class))
			b_CE1.setEnabled(true);
		else if(b_CE2.getText().equals(_class))
			b_CE2.setEnabled(true);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		String buttonString = ae.getActionCommand();
//		String selectedYear = (String)combo_dg_years.getSelectedItem();
//		String selectedMonth = (String)combo_dg_months.getSelectedItem();
//		String selectedDay = (String)combo_dg_days.getSelectedItem();
//		if(!selectedYear.equals("Select....") && !selectedYear.equals(null))
//		{
//			combo_dg_months.setEnabled(true);
//			if(!selectedMonth.equals("Select....") && !selectedMonth.equals(null))
//			{
//				
//			}
//		}
//		if(buttonString.equals("Cancel")) 
//		{
//			t_dg_year.setText("");
//			l_dg_showMessage.setText("");
//			dg.setVisible(false);
//		}
//		else if(buttonString.equals("Ok")) 
//		{
//			String day = t_dg_day.getText();
//			String month = t_dg_month.getText();
//			String year = t_dg_year.getText();
//			if(!day.equals("") && !month.equals("") && !year.equals("")) 
//			{
//				l_dg_showMessage.setText("");
//				int days = attendanceService.getdays(month.toUpperCase());
//				System.out.println(days);
//				if(days!=-1)
//				{
//					dg.setVisible(false);
//					homeReference.getContentPane().remove(l_Section);
//					homeReference.repaint();
//					setVisible(false);
//					String unirollno[] = attendanceService.attendance(_class);
//					String[][] ob = new String[unirollno.length][days];
//					String[] hd = new String[days];
//					hd[0] = "Uni.RollNo";
//					for(int i=1;i<days;i++) {
//						hd[i] = Integer.toString(i);
//					}
//					classAttendance sp = new classAttendance(homeReference,ob,hd,unirollno,days);
//				}
//				else 
//				{
//					System.out.println("error there");
//				}
//			}
//			else
//			{
//				l_dg_showMessage.setText("All fields are required");
//			}
//		}
		if(checkButtonClicked(buttonString))
		{
			String[] dateData = attendanceService.getCurrentYear();
			String unirollno[] = attendanceService.attendance(_class);
			int intLastDay = Integer.valueOf(dateData[3]);
			String currentMonth = dateData[2];
			int intCurrentYear = Integer.valueOf(dateData[0]);
			int intCurrentDay = Integer.valueOf(dateData[1]);
			String[][] ob = new String[unirollno.length][intLastDay+1];
			String[] hd = new String[intLastDay+1];
			hd[0] = "Uni.RollNo";
			for(int i=1;i<=intLastDay;i++) {
				hd[i] = Integer.toString(i);
			}
			homeReference.getContentPane().remove(l_Section);
			homeReference.repaint();
			setVisible(false);
			classAttendance sp = new classAttendance(homeReference,loginReference,ob,hd,unirollno,intLastDay,currentMonth,intCurrentDay,intCurrentYear,subjectName,course,sem,buttonString);
//			dg.setVisible(true);
//			setComboBoxesToDG();
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
	
//	void setComboBoxesToDG()
//	{
//		int currentYear = attendanceService.getCurrentYear();
//		combo_dg_years.insertItemAt("Select....", 0);
//		combo_dg_years.addItem(String.valueOf(currentYear));
//		combo_dg_years.setSelectedItem("Select....");
//		String[] monthsName = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
//		combo_dg_months.insertItemAt("Select....", 0);
//		combo_dg_months.setSelectedItem("Select....");
//		for(String monthName:monthsName)
//		{
//			combo_dg_months.addItem(monthName);
//		}	
//	}
	
	boolean checkButtonClicked(String buttonName)
	{
		if(buttonName.equals("CSE1")||buttonName.equals("CSE2")||buttonName.equals("IT1")||buttonName.equals("IT2")||buttonName.equals("ME1")||buttonName.equals("ME2")||buttonName.equals("ECE1")||buttonName.equals("ECE2")||buttonName.equals("EE1")||buttonName.equals("EE2")||buttonName.equals("CE1")||buttonName.equals("CE2"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	void removeTitle()
	{
		homeReference.getContentPane().remove(l_Section);
		homeReference.repaint();
	}
}
