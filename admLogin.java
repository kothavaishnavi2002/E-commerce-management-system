import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class admLogin {
	JFrame frame = new JFrame("Administaror login");

	JLabel heading = new JLabel("LOGIN");
	JLabel userLabel = new JLabel("USERID");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JLabel go_to = new JLabel("GOTO");

	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();

	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JButton home = new JButton("Home");

	JCheckBox showPassword = new JCheckBox("Show Password");

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
	Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

	Color lightBlue = new Color(164, 206, 237);
	Color Blue = new Color(52, 158, 235);

	public admLogin() {

		heading.setBounds(50, 50, 200, 20);
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
		go_to.setBounds(50, 450, 100, 30);
		home.setBounds(50, 500, 100, 30);

		heading.setFont(f1);
		userLabel.setFont(f3);
		passwordLabel.setFont(f3);
		userTextField.setFont(f3);
		passwordField.setFont(f3);
		showPassword.setFont(f3);
		loginButton.setFont(f3);
		resetButton.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		loginButton.setBackground(lightBlue);
		resetButton.setBackground(lightBlue);
		home.setBackground(lightBlue);
		showPassword.setBackground(Blue);

		frame.add(heading);
		frame.add(userLabel);
		frame.add(passwordLabel);
		frame.add(userTextField);
		frame.add(passwordField);
		frame.add(showPassword);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(go_to);
		frame.add(home);

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 370, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				String userText;
				String pwdText;
				userText = userTextField.getText();
				pwdText = passwordField.getText();
				if (userText.equalsIgnoreCase("VaishPreethi") && pwdText.equalsIgnoreCase("12345")) {
					JOptionPane.showMessageDialog(frame, "Login Successful");
					frame.dispose();
					new admChoice();

				} else {
					JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
				}

			}
		});

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				userTextField.setText("");
				passwordField.setText("");

			}
		});

		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (showPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});

		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Gui();
			}
		});

	}
}
