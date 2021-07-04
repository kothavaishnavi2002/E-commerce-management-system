import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

@SuppressWarnings("serial")
class viewCustProducts extends JFrame {
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

	public viewCustProducts(String id) {

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
			pstm = conn.prepareStatement(
					"select * from product where p_id in(select p_id from customer where id = " + id + ")");
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