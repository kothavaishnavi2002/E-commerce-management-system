import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

@SuppressWarnings("serial")
class viewProducts extends JFrame {
	DefaultTableModel model = new DefaultTableModel();
	Container cnt = this.getContentPane();
	JTable jtbl = new JTable(model);
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

	public viewProducts(String type, String spec) {

		connDb();
		cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
		model.addColumn("ID");
		model.addColumn("Product name");
		model.addColumn("price");
		model.addColumn("Brand");
		jtbl.setBounds(50, 50, 300, 300);
		String dburl = "jdbc:oracle:thin:@218.248.07:1521:rdbms";
		String us = "it19737053";
		String pas = "vasavi";
		PreparedStatement pstm;
		try {
			Connection conn = DriverManager.getConnection(dburl, us, pas);
			System.out.println("Connected");
			pstm = conn.prepareStatement("SELECT * FROM product");
			if (type.equals("category")) {
				pstm = conn.prepareStatement("SELECT * FROM product WHERE category = '" + spec + "'");
			} else if (type.equals("price") && spec.equals("0-500")) {
				pstm = conn.prepareStatement("SELECT * FROM product WHERE price between 0 and 500");
			} else if (type.equals("price") && spec.equals("500-5000")) {
				pstm = conn.prepareStatement("SELECT * FROM product WHERE price between 500 and 5000");
			} else if (type.equals("price") && spec.equals("5000-10,000")) {
				pstm = conn.prepareStatement("SELECT * FROM product WHERE price between 5000 and 10000");
			} else if (type.equals("stock") && spec.equals("0-100")) {
				pstm = conn.prepareStatement("SELECT * FROM product WHERE stock between 0 and 100");
			} else if (type.equals("stock") && spec.equals("100-200")) {
				pstm = conn.prepareStatement("SELECT * FROM product WHERE stock between 100 and 200");
			} else if (type.equals("stock") && spec.equals("200-500")) {
				pstm = conn.prepareStatement("SELECT * FROM product WHERE stock between 200 and 500");
			}

			ResultSet Rs = pstm.executeQuery();
			while (Rs.next()) {

				model.addRow(new Object[] { Rs.getInt("p_id"), Rs.getString("p_name"), Rs.getInt("price"),
						Rs.getString("brand") });
			}

		} catch (SQLException e) {

			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		JScrollPane pg = new JScrollPane(jtbl);
		cnt.add(pg);

		this.pack();

		this.setTitle("All Projects");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setBackground(Blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}