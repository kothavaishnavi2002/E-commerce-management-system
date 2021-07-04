import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class registerPage {
	JFrame frame = new JFrame("Registration");

	JLabel heading = new JLabel("ENTER DETAILS");

	JLabel cId = new JLabel("Enter customer id : ");
	JLabel cFName = new JLabel("Enter first name : ");
	JLabel cLName = new JLabel("Enter last name : ");
	JLabel dob = new JLabel("Enter date of birth : ");
	JLabel pwd = new JLabel("Enter password : ");
	JLabel gender = new JLabel("Enter gender : ");
	JLabel ph_no = new JLabel("Enter phone number : ");
	JLabel go_to = new JLabel("GOTO");

	JTextField tcId = new JTextField();
	JTextField tcFName = new JTextField();
	JTextField tcLName = new JTextField();
	JTextField tdob = new JTextField();
	JTextField tpwd = new JTextField();
	JTextField tgender = new JTextField();
	JTextArea tPh_no = new JTextArea();

	JTextArea resultText = new JTextArea();

	JButton home = new JButton("Home");
	JButton register = new JButton("Register");
	JButton back = new JButton("Back");

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

	public registerPage() {

		connDb();

		heading.setBounds(50, 50, 150, 20);
		cId.setBounds(50, 100, 250, 30);
		cFName.setBounds(50, 150, 200, 30);
		tcId.setBounds(250, 100, 150, 30);
		tcFName.setBounds(250, 150, 150, 30);
		cLName.setBounds(50, 200, 150, 30);
		tcLName.setBounds(250, 200, 150, 30);
		dob.setBounds(50, 250, 250, 30);
		tdob.setBounds(250, 250, 150, 30);
		pwd.setBounds(50, 300, 150, 30);
		tpwd.setBounds(250, 300, 150, 30);
		gender.setBounds(50, 350, 150, 30);
		tgender.setBounds(250, 350, 150, 30);
		ph_no.setBounds(50, 400, 250, 30);
		tPh_no.setBounds(250, 400, 150, 30);
		resultText.setBounds(250, 450, 200, 150);

		register.setBounds(50, 450, 100, 30);
		go_to.setBounds(50, 500, 100, 30);
		home.setBounds(50, 550, 100, 30);
		back.setBounds(50, 600, 100, 30);

		heading.setFont(f1);
		cId.setFont(f3);
		cFName.setFont(f3);
		tcId.setFont(f3);
		tcFName.setFont(f3);
		cLName.setFont(f3);
		tcLName.setFont(f3);
		dob.setFont(f3);
		tdob.setFont(f3);
		pwd.setFont(f3);
		tpwd.setFont(f3);
		gender.setFont(f3);
		tgender.setFont(f3);
		ph_no.setFont(f3);
		tPh_no.setFont(f3);
		resultText.setFont(f3);
		register.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);
		back.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		register.setBackground(lightBlue);
		home.setBackground(lightBlue);
		back.setBackground(lightBlue);

		frame.add(heading);
		frame.add(cId);
		frame.add(cFName);
		frame.add(tcId);
		frame.add(tcFName);
		frame.add(cLName);
		frame.add(tcLName);
		frame.add(dob);
		frame.add(tdob);
		frame.add(pwd);
		frame.add(tpwd);
		frame.add(gender);
		frame.add(tgender);
		frame.add(ph_no);
		frame.add(tPh_no);
		frame.add(register);
		frame.add(go_to);
		frame.add(home);
		frame.add(resultText);
		frame.add(back);

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 500, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {

					String query = "INSERT INTO customer VALUES(" + tcId.getText() + ",'" + tdob.getText() + "','"
							+ tcFName.getText() + "','" + tcLName.getText() + "','" + tpwd.getText() + "','"
							+ tgender.getText() + "'," + tPh_no.getText() + " , 0 )";
					@SuppressWarnings("unused")
					int i = stmt.executeUpdate(query);
					resultText.append("\nRegistration successfull");
					JOptionPane.showMessageDialog(frame, "Registration Successful");
					new customerChoice(tcFName.getText(), tcLName.getText(), tcId.getText());
					frame.dispose();
				} catch (SQLException e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(frame, "Registration unsuccessful");
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
