import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class admChoice {

	JFrame frame = new JFrame("Choice");

	JLabel heading = new JLabel("Welcome VaishPreethi,\n what operation do you want to perform?");
	JLabel go_to = new JLabel("GO TO");

	JButton insert = new JButton("SUBMIT");
	JButton update = new JButton("MODIFY");
	JButton delete = new JButton("DELETE");
	JButton home = new JButton("Home");

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 17);
	Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

	Color lightBlue = new Color(164, 206, 237);
	Color Blue = new Color(52, 158, 235);

	public admChoice() {

		// setBounds(x, y,width, height);
		heading.setBounds(50, 20, 1000, 100);
		insert.setBounds(100, 120, 100, 30);
		update.setBounds(250, 120, 100, 30);
		delete.setBounds(400, 120, 100, 30);
		go_to.setBounds(100, 250, 50, 50);
		home.setBounds(100, 300, 80, 30);

		heading.setFont(f1);
		insert.setFont(f3);
		update.setFont(f3);
		delete.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		insert.setBackground(lightBlue);
		update.setBackground(lightBlue);
		delete.setBackground(lightBlue);
		home.setBackground(lightBlue);

		frame.add(heading);
		frame.add(insert);
		frame.add(update);
		frame.add(delete);
		frame.add(go_to);
		frame.add(home);

		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new insertProduct();
			}
		});

		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new updateProduct();
			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new deleteProduct();
			}
		});

		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Gui();
			}
		});

		frame.setLayout(null);
		frame.setSize(680, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
