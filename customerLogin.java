import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class customerLogin {
	JFrame frame = new JFrame("customerLogin");

	JLabel heading = new JLabel("LOGIN");
	JLabel userLabel = new JLabel("USERID");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JLabel go_to = new JLabel("GOTO");

	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();

	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JButton home = new JButton("Home");
	JButton back = new JButton("Back");

	JCheckBox showPassword = new JCheckBox("Show Password");

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 17);
	Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

	Color lightBlue = new Color(164, 206, 237);
	Color Blue = new Color(52, 158, 235);

	Statement stmt;

	public void connDb() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@218.248.0.7:1521:rdbms", "it19737053",
					"vasavi");
			stmt = con.createStatement();
			System.out.println("connection successful");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public customerLogin() {

		connDb();

		heading.setBounds(50, 50, 100, 20);
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
		go_to.setBounds(50, 450, 100, 30);
		home.setBounds(50, 500, 100, 30);
		back.setBounds(180, 500, 100, 30);

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
		back.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		loginButton.setBackground(lightBlue);
		resetButton.setBackground(lightBlue);
		home.setBackground(lightBlue);
		showPassword.setBackground(Blue);
		back.setBackground(lightBlue);

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
		frame.add(back);

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 370, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				String userText;
				String pwdText;
				Boolean flag = false;
				userText = userTextField.getText();
				pwdText = passwordField.getText();
				String sql = "select id, pwd, Fname, lname from customer where id =" + userText;
				try {
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						if (rs.getString(2).equals(pwdText)) {
							JOptionPane.showMessageDialog(frame, "Login Successful");
							flag = true;
							new customerChoice(rs.getString(3), rs.getString(4), userText);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
						}

					}
					if (!flag) {
						JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
					System.out.println(e);
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

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new loginPage();
			}
		});

	}
}
