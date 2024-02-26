package sp1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import sp1.home;
public class classAttendance extends JTable implements ActionListener{
	home homeReference;
	login loginReference;
	JButton b_submit,b_update,b_logout,b_dg_ok;
	JLabel l_title,l_dg_success;
	JComboBox combo_1,combo_2,combo_3,combo_4,combo_5,combo_6,combo_7,combo_8,combo_9,combo_10,combo_11,combo_12,combo_13,combo_14,combo_15,combo_16,combo_17,combo_18,combo_19,combo_20,combo_21,combo_22,combo_23,combo_24,combo_25,combo_26,combo_27,combo_28,combo_29,combo_30,combo_31;
	JDialog dg;
	JScrollPane jsp;
	int currentDay,currentYear;
	String unirollno[],gottenCurrentDayAttendance[],subjectName,course,sem,branch,currentMonth;
	boolean allDisabled;
	boolean updateNotClicked = true;
	classAttendance(home homeReference,login loginReference,String[][] ob,String[] hd,String[] unirollno,int days,String currentMonth,int currentDay,int currentYear,String subjectName,String course,String sem,String branch)
	{
		super(ob,hd);
		setFillsViewportHeight(true); 
		getColumnModel().getColumn(0).setPreferredWidth(150);
		jsp = new JScrollPane(this);
		jsp.setBounds(12, 30, 1330, 600);
		this.homeReference = homeReference;
		this.loginReference = loginReference;
		this.currentDay = currentDay;
		this.currentMonth = currentMonth;
		this.currentYear = currentYear;
		this.unirollno = unirollno;
		this.subjectName = subjectName;
		this.course = course;
		this.sem = sem;
		this.branch = branch;
		Border blackline = BorderFactory.createLineBorder(Color.black);	
		setBorder(blackline);
//		setBackground(new Color(50, 141, 168));
		homeReference.add(jsp);
//		homeReference.getContentPane().setBackground(new Color(245, 66, 173));
		buttonLabel(currentMonth+" "+currentYear);
		createComboBoxes();
		setrollnos(unirollno);
		setcomboBoxes(days,unirollno.length);
		if(attendanceService.checkAttendance(currentMonth,currentDay,currentYear,subjectName,sem))
		{
			allDisabled = true;
			b_submit.setEnabled(false);
			setDisabled(days,unirollno.length);
			getCurrentDayAttendance();
		}
		else
		{
			setDisabled(days,unirollno.length);
		}
	}
	
	void buttonLabel(String title)
	{
		l_title = new JLabel(title);
		b_submit = new JButton("Submit");
		b_update = new JButton("Update");
		b_logout = new JButton("Logout");
		dg = new JDialog(homeReference);
		l_dg_success = new JLabel("Successful.......");
		l_title.setBounds(550,15,95,10);
		b_submit.setBounds(350,650,80,25);
		b_update.setBounds(440,650,80,25);
		b_logout.setBounds(530,650,80,25);
		dg.setLayout(null);
		dg.setBounds(540,150,300,260);
		l_dg_success.setBounds(85,60,120,20);
		l_dg_success.setFont(new Font("Verdana", Font.PLAIN, 18));
		homeReference.add(l_title);
		homeReference.add(b_submit);
		homeReference.add(b_update);
		homeReference.add(b_logout);
		dg.add(l_dg_success);
		b_submit.addActionListener(this);
		b_update.addActionListener(this);
		b_logout.addActionListener(this);
		dg.addWindowListener(new WindowAdapter() 
		{
	        public void windowClosing(WindowEvent arg) 
	        {
	        	b_update.setEnabled(true);
	        	b_logout.setEnabled(true);
	        }
	     });
	}	
	void createComboBoxes()
	{
		String att[] = {"A","P"};
		combo_1 = new JComboBox(att);
		combo_2 = new JComboBox(att);
		combo_3 = new JComboBox(att);
		combo_4 = new JComboBox(att);
		combo_5 = new JComboBox(att);
		combo_6 = new JComboBox(att);
		combo_7 = new JComboBox(att);
		combo_8 = new JComboBox(att);
		combo_9 = new JComboBox(att);
		combo_10 = new JComboBox(att);
		combo_11 = new JComboBox(att);
		combo_12 = new JComboBox(att);
		combo_13 = new JComboBox(att);
		combo_14 = new JComboBox(att);
		combo_15 = new JComboBox(att);
		combo_16 = new JComboBox(att);
		combo_17 = new JComboBox(att);
		combo_18 = new JComboBox(att);
		combo_19 = new JComboBox(att);
		combo_20 = new JComboBox(att);
		combo_21 = new JComboBox(att);
		combo_22 = new JComboBox(att);
		combo_23 = new JComboBox(att);
		combo_24 = new JComboBox(att);
		combo_25 = new JComboBox(att);
		combo_26 = new JComboBox(att);
		combo_27 = new JComboBox(att);
		combo_28 = new JComboBox(att);
		combo_29 = new JComboBox(att);
		combo_30 = new JComboBox(att);
		combo_31 = new JComboBox(att);
	}
	
	void setrollnos(String[] unirollno)
	{
		for(int i=0;i<unirollno.length;i++) 
		{
			getModel().setValueAt(unirollno[i],i,0);
			isCellEditable(i,0);
		}
	}
	
	public boolean isCellEditable(int row,int column)
	{	
		if(allDisabled)
		{
			return false;
		}
		else if(column==currentDay)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	void setcomboBoxes(int days,int rows)
	{ 
		getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(combo_1));
		getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(combo_2));
		getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(combo_3));
		getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(combo_4));
		getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(combo_5));
		getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(combo_6));
		getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(combo_7));
		getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(combo_8));
		getColumnModel().getColumn(9).setCellEditor(new DefaultCellEditor(combo_9));
		getColumnModel().getColumn(10).setCellEditor(new DefaultCellEditor(combo_10));
		getColumnModel().getColumn(11).setCellEditor(new DefaultCellEditor(combo_11));
		getColumnModel().getColumn(12).setCellEditor(new DefaultCellEditor(combo_12));
		getColumnModel().getColumn(13).setCellEditor(new DefaultCellEditor(combo_13));
		getColumnModel().getColumn(14).setCellEditor(new DefaultCellEditor(combo_14));
		getColumnModel().getColumn(15).setCellEditor(new DefaultCellEditor(combo_15));
		getColumnModel().getColumn(16).setCellEditor(new DefaultCellEditor(combo_16));
		getColumnModel().getColumn(17).setCellEditor(new DefaultCellEditor(combo_17));
		getColumnModel().getColumn(18).setCellEditor(new DefaultCellEditor(combo_18));
		getColumnModel().getColumn(19).setCellEditor(new DefaultCellEditor(combo_19));
		getColumnModel().getColumn(20).setCellEditor(new DefaultCellEditor(combo_20));
		getColumnModel().getColumn(21).setCellEditor(new DefaultCellEditor(combo_21));
		getColumnModel().getColumn(22).setCellEditor(new DefaultCellEditor(combo_22));
		getColumnModel().getColumn(23).setCellEditor(new DefaultCellEditor(combo_23));
		getColumnModel().getColumn(24).setCellEditor(new DefaultCellEditor(combo_24));
		getColumnModel().getColumn(25).setCellEditor(new DefaultCellEditor(combo_25));
		getColumnModel().getColumn(26).setCellEditor(new DefaultCellEditor(combo_26));
		getColumnModel().getColumn(27).setCellEditor(new DefaultCellEditor(combo_27));
		getColumnModel().getColumn(28).setCellEditor(new DefaultCellEditor(combo_28));
		if(days==29)
		{
			getColumnModel().getColumn(29).setCellEditor(new DefaultCellEditor(combo_29));
		}
		else if(days==30)
		{
			getColumnModel().getColumn(29).setCellEditor(new DefaultCellEditor(combo_29));
			getColumnModel().getColumn(30).setCellEditor(new DefaultCellEditor(combo_30));
		}
		else
		{
			getColumnModel().getColumn(29).setCellEditor(new DefaultCellEditor(combo_29));
			getColumnModel().getColumn(30).setCellEditor(new DefaultCellEditor(combo_30));
			getColumnModel().getColumn(31).setCellEditor(new DefaultCellEditor(combo_31));
		}
	}
	
	void setDisabled(int days,int rows)
	{
		for(int i=0;i<rows;i++)
		{
			for(int j=1;j<=days;j++)
			{
				isCellEditable(i,j);	
			}
		}
	}
	
	void setDisabledCurrentDay(int currentDay,int rows)
	{
		for(int i=0;i<rows;i++)
		{
			isCellEditable(i,currentDay);	
		}
	}
	
	void getCurrentDayAttendance()
	{
		gottenCurrentDayAttendance = attendanceService.getCurrentDayAttendance(currentDay,currentMonth,currentYear,unirollno,subjectName,sem);
		for(int i=0;i<unirollno.length;i++)
		{
			getModel().setValueAt(gottenCurrentDayAttendance[i],i,currentDay);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String buttonName = ae.getActionCommand();
		if(buttonName.equals("Submit") && updateNotClicked)
		{
			System.out.println("submit");
			updateNotClicked = false;
			allDisabled = true;
			b_submit.setEnabled(false);
			setDisabledCurrentDay(currentDay,unirollno.length);
			Object[] currentDayAttendance = new Object[unirollno.length];
			for(int i=0;i<unirollno.length;i++)
			{
				currentDayAttendance[i] = getModel().getValueAt(i,currentDay);
				if(currentDayAttendance[i]==null)
				{
					currentDayAttendance[i] = 'A';
				}
			}
			attendanceService.addAttendance(currentDay,currentMonth,currentYear,unirollno,currentDayAttendance,subjectName,course,branch);
			b_update.setEnabled(false);
			b_logout.setEnabled(false);
			dg.setVisible(true);
		}
		else if(buttonName.equals("Submit") && !updateNotClicked)
		{
			allDisabled = true;
			setDisabledCurrentDay(currentDay,unirollno.length);
			Object[] updatedAttendance = new Object[unirollno.length];
			for(int i=0;i<unirollno.length;i++)
			{
				updatedAttendance[i] = getModel().getValueAt(i,currentDay);
				if(updatedAttendance[i]==null)
				{
					updatedAttendance[i] = 'A';
				}
			}
			attendanceService.updateData(currentDay,currentMonth,currentYear,unirollno,updatedAttendance,subjectName,sem);
			b_submit.setEnabled(false);
			b_update.setEnabled(false);
			b_logout.setEnabled(false);
			dg.setVisible(true);
		}
		else if(buttonName.equals("Update") && !b_submit.isEnabled())
		{
			updateNotClicked = false;
			allDisabled = false;
			b_submit.setEnabled(true);
			b_update.setEnabled(false);
			for(int i=0;i<unirollno.length;i++)
			{
				isCellEditable(i,currentDay);
			}
		}
		else if(buttonName.equals("Logout"))
		{

			homeReference.getContentPane().remove(jsp);
			homeReference.getContentPane().remove(dg);
			homeReference.getContentPane().remove(l_dg_success);
			homeReference.getContentPane().remove(b_submit);
			homeReference.getContentPane().remove(b_update);
			homeReference.getContentPane().remove(b_logout);
			homeReference.getContentPane().remove(l_title);
			homeReference.repaint();
			homeReference.getContentPane().setBackground(new Color(180, 215, 195));
			homeReference.l_homeTitle.setVisible(true);
			loginReference.setVisible(true);
		}
	}
	
	
}
