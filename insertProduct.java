import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class insertProduct {
	JFrame frame = new JFrame("Inserting products");

	JLabel heading = new JLabel("INSERT PRODUCT");

	JLabel pId = new JLabel("Enter product id : ");
	JLabel pName = new JLabel("Enter product name : ");
	JLabel stock = new JLabel("Enter stock : ");
	JLabel price = new JLabel("Enter price : ");
	JLabel type = new JLabel("Enter the type : ");
	JLabel brand = new JLabel("Enter the brand : ");
	JLabel description = new JLabel("Enter the description : ");
	JLabel go_to = new JLabel("GOTO");

	JTextField tpId = new JTextField();
	JTextField tpName = new JTextField();
	JTextField tStock = new JTextField();
	JTextField tPrice = new JTextField();
	JTextField tType = new JTextField();
	JTextField tBrand = new JTextField();
	JTextArea tDescription = new JTextArea();

	JTextArea resultText = new JTextArea();

	JButton home = new JButton("Home");
	JButton insert = new JButton("Insert");
	JButton back = new JButton("Back");

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
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

	public insertProduct() {

		connDb();

		heading.setBounds(50, 50, 200, 20);
		pId.setBounds(50, 100, 200, 30);
		pName.setBounds(50, 150, 200, 30);
		tpId.setBounds(250, 100, 150, 30);
		tpName.setBounds(250, 150, 150, 30);
		stock.setBounds(50, 200, 150, 30);
		tStock.setBounds(250, 200, 150, 30);
		price.setBounds(50, 250, 150, 30);
		tPrice.setBounds(250, 250, 150, 30);
		brand.setBounds(50, 300, 150, 30);
		tBrand.setBounds(250, 300, 150, 30);
		type.setBounds(50, 350, 150, 30);
		tType.setBounds(250, 350, 150, 30);
		description.setBounds(50, 400, 200, 30);
		tDescription.setBounds(250, 400, 150, 30);
		resultText.setBounds(250, 450, 200, 150);

		insert.setBounds(50, 450, 100, 30);
		go_to.setBounds(50, 500, 100, 30);
		home.setBounds(50, 550, 100, 30);
		back.setBounds(50, 600, 100, 30);

		heading.setFont(f1);
		pId.setFont(f3);
		pName.setFont(f3);
		tpId.setFont(f3);
		tpName.setFont(f3);
		stock.setFont(f3);
		tStock.setFont(f3);
		price.setFont(f3);
		;
		tPrice.setFont(f3);
		brand.setFont(f3);
		tBrand.setFont(f3);
		type.setFont(f3);
		tType.setFont(f3);
		description.setFont(f3);
		tDescription.setFont(f3);
		resultText.setFont(f3);
		insert.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);
		back.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		insert.setBackground(lightBlue);
		home.setBackground(lightBlue);
		back.setBackground(lightBlue);

		frame.add(heading);
		frame.add(pId);
		frame.add(pName);
		frame.add(tpId);
		frame.add(tpName);
		frame.add(stock);
		frame.add(price);
		frame.add(brand);
		frame.add(type);
		frame.add(description);
		frame.add(tStock);
		frame.add(tPrice);
		frame.add(tBrand);
		frame.add(tType);
		frame.add(tDescription);
		frame.add(insert);
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

		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {

					String query = "INSERT INTO product VALUES(" + tpId.getText() + ",'" + tpName.getText() + "',"
							+ tStock.getText() + "," + tPrice.getText() + ",'" + tBrand.getText() + "','"
							+ tType.getText() + "','" + tDescription.getText() + "' )";
					int i = stmt.executeUpdate(query);
					resultText.append("\nInserted " + i + " rows successfully");

				} catch (SQLException e) {
					System.out.println(e);
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
				new admChoice();
			}
		});

	}
}
