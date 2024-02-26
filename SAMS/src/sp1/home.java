package sp1;
import javax.swing.*;
import sp1.login;
import java.awt.Color;
import java.awt.Font;
public class home extends JFrame {
	JLabel l_homeTitle;
	home()
	{ 
		setTitle("Desktop App");
		l_homeTitle = new JLabel("STUDENTS ATTENDANCE MANAGEMENT SYSTEM");
		l_homeTitle.setFont(new Font("TimesRoman", Font.PLAIN, 57));
		setSize(1350,733);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login lg = new login(this,l_homeTitle);
		getContentPane().setBackground(new Color(180, 215, 195));
		add(lg);
		setLayout(null);
		l_homeTitle.setBounds(7,2,1350,50);
		l_homeTitle.setForeground(new Color(234, 94, 87));
		l_homeTitle.setOpaque(true);
		l_homeTitle.setBackground(Color.black);
		add(l_homeTitle);
		setVisible(true);
	}
	public static void main(String[] args) {
		home hm = new home();
	}
}
