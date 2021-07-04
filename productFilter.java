import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class productFilter {

	JFrame frame = new JFrame("Apply Filter");

	JLabel heading;
	JLabel go_to = new JLabel("GO TO");

	JButton category = new JButton("CATEGORY");
	JButton price = new JButton("PRICE");
	JButton stock = new JButton("STOCK");
	JButton all = new JButton("View all");
	JButton home = new JButton("Home");

	List lcat;
	List lprice;
	List lstock;

	Font f1 = new Font(Font.DIALOG_INPUT, Font.BOLD, 17);
	Font f3 = new Font(Font.DIALOG_INPUT, Font.PLAIN, 14);

	Color lightBlue = new Color(164, 206, 237);
	Color Blue = new Color(52, 158, 235);

	String type = "";
	String specification = "";

	public productFilter() {

		lcat = new List(5);
		lprice = new List(5);
		lstock = new List(5);

		heading = new JLabel("On what basis do you want to search?");

		lcat.add("CLOTHING");
		lcat.add("FOOTWARE");
		lcat.add("FOOD");
		lcat.add("ACCESSORIES");
		lprice.add("0-500");
		lprice.add("500-5000");
		lprice.add("5000-10,000");
		lstock.add("0-100");
		lstock.add("100-200");
		lstock.add("200-500");

		// setBounds(x, y,width, height);

		heading.setBounds(50, 20, 1000, 100);
		category.setBounds(250, 120, 100, 30);
		price.setBounds(100, 120, 100, 30);
		stock.setBounds(400, 120, 100, 30);
		lcat.setBounds(250, 180, 100, 100);
		lprice.setBounds(100, 180, 100, 100);
		lstock.setBounds(400, 180, 100, 100);
		all.setBounds(250, 300, 100, 30);
		go_to.setBounds(100, 320, 50, 50);
		home.setBounds(100, 370, 80, 30);

		heading.setFont(f1);
		lcat.setFont(f3);
		lprice.setFont(f3);
		lstock.setFont(f3);
		category.setFont(f3);
		price.setFont(f3);
		stock.setFont(f3);
		go_to.setFont(f3);
		home.setFont(f3);
		all.setFont(f3);

		frame.getContentPane().setBackground(Blue);
		category.setBackground(lightBlue);
		price.setBackground(lightBlue);
		stock.setBackground(lightBlue);
		home.setBackground(lightBlue);
		all.setBackground(lightBlue);

		frame.add(lcat);
		frame.add(lprice);
		frame.add(lstock);
		frame.add(heading);
		frame.add(category);
		frame.add(price);
		frame.add(stock);
		frame.add(all);
		frame.add(go_to);
		frame.add(home);

		category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				type = "category";
				specification = lcat.getSelectedItem();
				if (specification.equals("")) {
					JOptionPane.showMessageDialog(frame, "Select the parameter");
				} else {
					new viewProducts(type, specification);
				}

			}
		});

		price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				type = "price";
				specification = lprice.getSelectedItem();
				if (specification.equals("")) {
					JOptionPane.showMessageDialog(frame, "Select the parameter");
				} else {
					new viewProducts(type, specification);
				}
			}
		});

		stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				type = "stock";
				specification = lstock.getSelectedItem();
				if (specification.equals("")) {
					JOptionPane.showMessageDialog(frame, "Select the parameter");
				} else {
					new viewProducts(type, specification);
				}
			}
		});

		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Gui();
			}
		});

		lcat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				type = "category";
				specification = lcat.getSelectedItem();

			}
		});

		lstock.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				type = "stock";
				specification = lstock.getSelectedItem();

			}
		});

		lprice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				type = "price";
				specification = lcat.getSelectedItem();

			}
		});

		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				type = "";
				specification = "";
				new viewProducts(type, specification);
			}
		});

		frame.setLayout(null);
		frame.setSize(600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
