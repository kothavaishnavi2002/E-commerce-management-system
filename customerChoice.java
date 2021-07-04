import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class customerChoice {

	JFrame frame = new JFrame("Choice");

	JLabel heading;
	JLabel go_to = new JLabel("GO TO");

	JButton allProd = new JButton("View all products");
	JButton custProd = new JButton("View your products");
	JButton home = new JButton("Home");

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 17);
	Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

	Color lightBlue = new Color(164, 206, 237);
	Color Blue = new Color(52, 158, 235);

	public customerChoice(String fname, String lname, String id) {

		heading = new JLabel("Welcome " + fname + " " + lname + ", ");

		// setBounds(x, y,width, height);
		heading.setBounds(50, 20, 1000, 100);
		allProd.setBounds(100, 120, 200, 30);
		custProd.setBounds(350, 120, 200, 30);
		go_to.setBounds(100, 250, 50, 50);
		home.setBounds(100, 300, 80, 30);

		heading.setFont(f1);
		allProd.setFont(f3);
		custProd.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		allProd.setBackground(lightBlue);
		custProd.setBackground(lightBlue);
		home.setBackground(lightBlue);

		frame.add(heading);
		frame.add(allProd);
		frame.add(custProd);
		frame.add(go_to);
		frame.add(home);

		allProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new productFilter();
			}
		});

		custProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new viewCustProducts(id);
			}
		});

		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Gui();
			}
		});

		frame.setLayout(null);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
