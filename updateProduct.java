import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateProduct {
	JFrame frame = new JFrame("Updating products");

	JLabel heading = new JLabel("UPDATE PRODUT");

	JLabel pId = new JLabel("Enter product id : ");
	JLabel pName = new JLabel("Enter product name : ");
	JLabel stock = new JLabel("Enter stock : ");
	JLabel price = new JLabel("Enter price : ");
	JLabel type = new JLabel("Enter the type : ");
	JLabel brand = new JLabel("Enter the brand : ");
	JLabel description = new JLabel("Enter description:");
	JLabel go_to = new JLabel("GOTO");

	List ids = new List(15);

	JTextField tpId = new JTextField();
	JTextField tpName = new JTextField();
	JTextField tStock = new JTextField();
	JTextField tPrice = new JTextField();
	JTextField tType = new JTextField();
	JTextField tBrand = new JTextField();
	JTextArea tDescription = new JTextArea();

	JTextArea resultText = new JTextArea();

	JButton home = new JButton("Home");
	JButton update = new JButton("MODIFY");
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

	public void loadProducts() {

		try {
			ResultSet rs;
			rs = stmt.executeQuery("SELECT P_ID FROM product");
			while (rs.next()) {
				ids.add(rs.getString(1));
			}
		} catch (SQLException e) {
			displaySQLErrors(e);
		}
	}

	private void displaySQLErrors(SQLException e) {
		JOptionPane.showMessageDialog(frame, "Enter valid data types");
		resultText.append("\nSQLException: " + e.getMessage() + "\n");
		resultText.append("SQLState:     " + e.getSQLState() + "\n");
		resultText.append("VendorError:  " + e.getErrorCode() + "\n");
	}

	public updateProduct() {

		connDb();
		loadProducts();

		ids.setBounds(50, 100, 200, 350);
		heading.setBounds(150, 50, 200, 20);
		pId.setBounds(300, 100, 200, 30);
		pName.setBounds(300, 150, 200, 30);
		tpId.setBounds(450, 100, 150, 30);
		tpName.setBounds(450, 150, 150, 30);
		stock.setBounds(300, 200, 150, 30);
		tStock.setBounds(450, 200, 150, 30);
		price.setBounds(300, 250, 150, 30);
		tPrice.setBounds(450, 250, 150, 30);
		brand.setBounds(300, 300, 150, 30);
		tBrand.setBounds(450, 300, 150, 30);
		type.setBounds(300, 350, 150, 30);
		tType.setBounds(450, 350, 150, 30);
		description.setBounds(270, 400, 150, 30);
		tDescription.setBounds(450, 400, 150, 30);
		resultText.setBounds(300, 450, 200, 150);

		update.setBounds(50, 470, 100, 30);
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
		tPrice.setFont(f3);
		brand.setFont(f3);
		tBrand.setFont(f3);
		type.setFont(f3);
		tType.setFont(f3);
		description.setFont(f3);
		tDescription.setFont(f3);
		resultText.setFont(f3);
		update.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);
		back.setFont(f3);
		ids.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		update.setBackground(lightBlue);
		home.setBackground(lightBlue);
		back.setBackground(lightBlue);

		frame.add(ids);
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
		frame.add(update);
		frame.add(go_to);
		frame.add(home);
		frame.add(resultText);
		frame.add(back);

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(10, 10, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		ids.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {

				try {
					ResultSet rs;
					rs = stmt.executeQuery("SELECT * FROM product where P_ID ='" + ids.getSelectedItem() + "'");
					rs.next();
					tpId.setText(rs.getString(1));
					tpName.setText(rs.getString(2));
					tStock.setText(rs.getString(3));
					tPrice.setText(rs.getString(4));
					tType.setText(rs.getString(6));
					tBrand.setText(rs.getString(5));
					tDescription.setText(rs.getString(7));

				} catch (SQLException selectException) {
					displaySQLErrors(selectException);
				}
			}
		});

		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {

					int i = stmt.executeUpdate("UPDATE product " + "SET P_ID=" + tpId.getText() + ", " + "P_NAME='"
							+ tpName.getText() + "', " + "STOCK=" + tStock.getText() + ", " + "PRICE="
							+ tPrice.getText() + ", " + "CATEGORY='" + tType.getText() + "', " + "BRAND='"
							+ tBrand.getText() + "', " + "DESCRIPTION ='" + tDescription.getText() + "' WHERE p_id = "
							+ ids.getSelectedItem());

					resultText.append("\nUpdated " + i + " rows successfully");
					ids.removeAll();
					loadProducts();
				} catch (SQLException insertException) {
					displaySQLErrors(insertException);
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
