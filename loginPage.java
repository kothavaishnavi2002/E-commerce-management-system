import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class loginPage {

	JFrame frame = new JFrame("loginPage");

	JLabel heading = new JLabel("CUSTOMER");
	JLabel usid = new JLabel("Enter user Id :");
	JLabel password = new JLabel("Enter password : ");
	JLabel go_to = new JLabel("GO TO");

	JButton button1 = new JButton("Login");
	JButton button2 = new JButton("Register");
	JButton home = new JButton("Home");

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 17);
	Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

	Color lightBlue = new Color(164, 206, 237);
	Color Blue = new Color(52, 158, 235);

	public loginPage() {

		// setBounds(x, y,width, height);
		heading.setBounds(250, 20, 100, 100);
		button1.setBounds(150, 120, 80, 30);
		button2.setBounds(400, 120, 100, 30);
		go_to.setBounds(100, 150, 50, 50);
		home.setBounds(100, 200, 80, 30);

		heading.setFont(f1);
		button1.setFont(f3);
		button2.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		button1.setBackground(lightBlue);
		button2.setBackground(lightBlue);
		home.setBackground(lightBlue);

		frame.add(heading);
		frame.add(button1);
		frame.add(button2);
		frame.add(go_to);
		frame.add(home);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new customerLogin();
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new registerPage();
			}
		});

		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Gui();
			}
		});

		frame.setLayout(null);
		frame.setSize(600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
