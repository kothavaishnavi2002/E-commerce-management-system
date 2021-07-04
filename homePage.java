import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class homePage {
	public static void main(String[] args) {
		new Gui();
	}
}

class Gui {
	JFrame frame = new JFrame("Welcome to e-commerce site");

	JLabel heading = new JLabel("E-COMMERCE SITE");
	JLabel lb = new JLabel("Login as : ");

	JButton button1 = new JButton("Customer");
	JButton button2 = new JButton("Administator");

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
	Font f2 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 18);
	Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

	Color lightBlue = new Color(164, 206, 237);
	Color Blue = new Color(52, 158, 235);

	public Gui() {
		// setBounds(x, y,width, height);
		heading.setBounds(200, 20, 200, 20);
		lb.setBounds(250, 70, 200, 20);
		button1.setBounds(150, 150, 100, 30);
		button2.setBounds(300, 150, 150, 30);

		heading.setFont(f1);
		lb.setFont(f2);
		button1.setFont(f3);
		button2.setFont(f3);

		frame.add(heading);
		frame.add(lb);
		frame.add(button1);
		frame.add(button2);
		frame.getContentPane().setBackground(Blue);
		button1.setBackground(lightBlue);
		button2.setBackground(lightBlue);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new loginPage();
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new admLogin();
			}
		});

		frame.setLayout(null);
		frame.setSize(600, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}