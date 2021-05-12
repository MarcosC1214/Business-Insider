package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class partyMenu {
	static private JFrame frmPartyBakery;
	static private JButton backButton, orderButton;
	private static JButton backButton_1;
	private static JButton orderButton_1;
	static private JTextField textField;
	static private GridBagConstraints gbc;
	private JTable table;
	private JTable table_1;
	DefaultTableModel dtm;
	Double[] price;
	Double[] priceDrinks;
	Double[] priceDesserts;
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	double totalPrice = 0.00;
	
	double p1 = 0.0;
	double p2 = 0.0;
	double p3 = 0.0;
	double p4 = 0.0;
	double p5 = 0.0;
	double p6 = 0.0;
	double p7 = 0.0;
	double p8 = 0.0;
	double p9 = 0.0;
	
	
	double d1, d2, d3, d4, d5;
	
	double de1, de2;

	private JSpinner[] numSpinner;
	static private JLabel[] foodLabel;
	static private JLabel[] foodImage;
	private String[] file;
	
	
	private JSpinner[] numSpinnerDrinks;
	static private JLabel[] drinkLabel;
	static private JLabel[] drinkImage;
	private String[] fileDrinks;

	private JSpinner[] numSpinnerDesserts;
	static private JLabel[] dessertLabel;
	static private JLabel[] dessertImage;
	private String[] fileDesserts;

	private static final int ELEMENTS = 9;
	private static final int DRINK_ELEMENTS = 5;
	private static final int DESSERT_ELEMENTS = 2;

	double total = 0.00;
	double food1, food2, food3, food4, food5, food6, food7, food8, food9;
	double drink1, drink2, drink3, drink4, drink5;
	double pr, pr1;

	double totalForFoods;
	double totalForDrinks;
	double totalForDesserts;


	/**
	 * @wbp.parser.entryPoint
	 */
	void createAndShowGUI() throws IOException {
		
		frmPartyBakery = new JFrame("Main Menu ");
		frmPartyBakery.setTitle("Party Bakery");
		frmPartyBakery.setBounds(100, 100, 780, 550);
		
		final ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/resources/party.jpg"));
        
        final JLabel Label_1 = new JLabel(imgIcon); 
        
       
       java.net.URL daffyURL = getClass().getResource("/resources/party.jpg");
       Image daffyDuckImage = ImageIO.read( daffyURL );
       
		frmPartyBakery.setIconImage(daffyDuckImage);
		
		
		frmPartyBakery.setResizable(false);
		
		frmPartyBakery.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		
		
		
		frmPartyBakery.getContentPane().setLayout(null);
		frmPartyBakery.setLocationRelativeTo(null);
		JLabel lblFoodOrdered = new JLabel("Food Ordered");
		lblFoodOrdered.setBounds(529, 11, 81, 14);

		frmPartyBakery.getContentPane().add(lblFoodOrdered);

		table = new JTable();
		
		backButton = new JButton();
		orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price($)", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.setEnabled(false);
		table_1.setModel(dtm);
		table_1.setBounds(511, 36, 1, 1); // int x, int y, int width, int height
		table_1.setSize(245, 300); // width,height
		table_1.getColumnModel().getColumn(0).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner
															// column
		table_1.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner
															// column
		table_1.setShowGrid(false); // remove cell boarder
		frmPartyBakery.getContentPane().add(table_1);
		JLabel lblTotal = new JLabel("Total  : ");
		lblTotal.setBounds(519, 340, 46, 14);
		frmPartyBakery.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(585, 340, 86, 20);
		frmPartyBakery.getContentPane().add(textField);
		textField.setColumns(10);
		orderButton_1 = new JButton("Order");
		orderButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				allOrderMenus order;
				try {
					order = new allOrderMenus();
					order.createAndShowGUI();
					frmPartyBakery.dispose();
					//order.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		orderButton_1.setBounds(511, 385, 89, 23);
		frmPartyBakery.getContentPane().add(orderButton_1);
		backButton_1 = new JButton("Back");
		backButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPartyBakery.dispose();
				
			}
		});
		backButton_1.setBounds(610, 385, 89, 23);
		frmPartyBakery.getContentPane().add(backButton_1);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		addIt(tabbedPane, "Breakfast");
		addIt1(tabbedPane, "Drinks");
		addIt2(tabbedPane, "Cakes");
		
		tabbedPane.setBounds(18, 11, 490, 450);
		frmPartyBakery.getContentPane().add(tabbedPane);
		frmPartyBakery.setVisible(true);
		
		
	}

	void addIt(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints(); // getting constraints for the specified
										// component
		gbc.insets = new Insets(10, 0, 0, 0);
		foodImage = new JLabel[ELEMENTS];
		foodLabel = new JLabel[ELEMENTS];
		numSpinner = new JSpinner[ELEMENTS];
		file = new String[ELEMENTS];
		price = new Double[ELEMENTS];
		
		file[0] = new String("/ham.png");
		file[1] = new String("/tortilla.jpg");
		file[2] = new String("/cheese.png");
		file[3] = new String("/cross.png");
		file[4] = new String("/scram.png");
		file[5] = new String("/hamcheese.png");
		file[6] = new String("/sausage.png");
		file[7] = new String("/mac.png");
		file[8] = new String("/pan.png");
		
		foodLabel[0] = new JLabel("Ham Croquettes");
		foodLabel[1] = new JLabel("Tortilla");
		foodLabel[2] = new JLabel("Grilled Cheese Sandwhich");
		foodLabel[3] = new JLabel("Crossaint");
		foodLabel[4] = new JLabel("Scrambled Eggs");
		foodLabel[5] = new JLabel("Ham and Cheese Biscut");
		foodLabel[6] = new JLabel("Sausage Brittle");
		foodLabel[7] = new JLabel("Macaroni");
		foodLabel[8] = new JLabel("Pancakes");
		
		price[0] = 3.50;
		price[1] = 4.50;
		price[2] = 3.70;
		price[3] = 4.50;
		price[4] = 5.50;
		price[5] = 4.00;
		price[6] = 3.50;
		price[7] = 6.50;
		price[8] = 6.50;
		for (int i = 0; i < ELEMENTS; i++) {
			
			try {
			
			URL path  = this.getClass().getResource("/resources"+file[i]);	
			Image image = ImageIO.read(path);
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
//			Image image = ImageIO.read(file[i]);
//			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinner[i] = new JSpinner(spnummodel);
			numSpinner[i].addChangeListener(listener);
			foodImage[i] = new JLabel(imageIcon);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		for (int i = 0; i < ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridy += 2;
				gbc.gridx = 0;
			}
			panel.add(foodImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(foodLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinner[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
		}
	}
	
	

	void addIt2(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		dessertImage = new JLabel[DESSERT_ELEMENTS];
		dessertLabel = new JLabel[DESSERT_ELEMENTS];
		numSpinnerDesserts = new JSpinner[DESSERT_ELEMENTS];
		priceDesserts = new Double[DESSERT_ELEMENTS];
		
		fileDesserts = new String[DESSERT_ELEMENTS];
		fileDesserts[0] = new String("/resources/straw.jpg");
		fileDesserts[1] = new String("/resources/choco.jpg");
		
		
		dessertLabel[0] = new JLabel("Strawberry Cake");
		dessertLabel[1] = new JLabel("Chocolate Cake");

		priceDesserts[0] = 2.50;
		priceDesserts[1] = 3.00;

		for (int i = 0; i < DESSERT_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileDesserts[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerDesserts[i] = new JSpinner(spnummodel);
			numSpinnerDesserts[i].addChangeListener(listenerForDesserts);
			dessertImage[i] = new JLabel(imageIcon);
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
		for (int i = 0; i < DESSERT_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			panel.add(dessertImage[i], gbc);
			gbc.gridy++; // gridy---> add one row,for foodLabel
			panel.add(dessertLabel[i], gbc);
			gbc.gridy--; // remove the row
			gbc.gridx++; // move to next column
			panel.add(numSpinnerDesserts[i], gbc);
			gbc.gridx++; // move to next column
			tabbedPane.addTab(text, panel);
			} 
		}

	void addIt1(JTabbedPane tabbedPane, String text) throws IOException {
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		drinkImage = new JLabel[DRINK_ELEMENTS];
		drinkLabel = new JLabel[DRINK_ELEMENTS];
		numSpinnerDrinks = new JSpinner[DRINK_ELEMENTS];
		priceDrinks = new Double[DRINK_ELEMENTS];
	
		fileDrinks = new String[DRINK_ELEMENTS];
		fileDrinks[0] = new String("/resources/mocha.jpg");
		fileDrinks[1] = new String("/resources/exp.jpg");
		fileDrinks[2] = new String("/resources/oj.png");
		fileDrinks[3] = new String("/resources/insta.png");
		fileDrinks[4] = new String("/resources/icemocha.png");

		drinkLabel[0] = new JLabel("Mocha Latte");
		drinkLabel[1] = new JLabel("Expresso");
		drinkLabel[2] = new JLabel("Orange Juice");
		drinkLabel[3] = new JLabel("Instant Coffee");
		drinkLabel[4] = new JLabel("Iced Mocha");

		priceDrinks[0] = 3.50;
		priceDrinks[1] = 4.50;
		priceDrinks[2] = 3.00;
		priceDrinks[3] = 5.00;
		priceDrinks[4] = 3.00;
		
		for (int i = 0; i < DRINK_ELEMENTS; i++) {
			Image image = ImageIO.read(this.getClass().getResource(fileDrinks[i]));
			Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageScaled);
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
			numSpinnerDrinks[i] = new JSpinner(spnummodel);
			numSpinnerDrinks[i].addChangeListener(listenerForDrinks);
			drinkImage[i] = new JLabel(imageIcon);
			
		}
		gbc.gridx = 0; // gridx 0 represent the most left
		gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
		for (int i = 0; i < DRINK_ELEMENTS; i++) {
			if (i % 3 == 0) {
				gbc.gridx = 0;
				gbc.gridy += 2;
			}
			if(drinkImage[i] != null) {
				panel.add(drinkImage[i], gbc);
				gbc.gridy++; // gridy---> add one row,for foodLabel
				panel.add(drinkLabel[i], gbc);
				gbc.gridy--; // remove the row
				gbc.gridx++; // move to next column
				panel.add(numSpinnerDrinks[i], gbc);
				gbc.gridx++; // move to next column
				tabbedPane.addTab(text, panel);

			} else {
				System.out.println(drinkImage[i]);
			}
			
		}
	}

	private String formatNumberToPrice(Number number) {
		String valueFinal = String.format("$%.2f",number);
		return valueFinal;
	}
	private void updateTable(int quantity, Object source ) {
		final int rows = table_1.getRowCount();
		for (int row = 0; row < rows; row++) {
			if (dtm.getValueAt(row, 3) .equals(source)) {
				
				if (dtm.getValueAt(row, 0).equals("Ham Croquettes")) {
					food1 = p1 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food1), row, 2);
					

				} else if (dtm.getValueAt(row, 0).equals("Tortilla")) {
					food2 = p2 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food2), row, 2);
					
				} else if (dtm.getValueAt(row, 0).equals("Grilled Cheese Sandwhich")) {
					food3 = p3 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food3), row, 2);
					
				} else if (dtm.getValueAt(row, 0).equals("Crossaint")) {
					food4 = p4 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food4), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Scrambled Eggs")) {
					food5 = p5 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food5), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Ham and Cheese Biscut")) {
					food6 = p6 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food6), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Sausage Brittle")) {

					food7 = p7 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food7), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Macaroni")) {
					food8 = p8 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food8), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Pancakes")) {
					food9 = p9 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food9), row, 2);
				}

				if (quantity == 0) {
					dtm.removeRow(row);
				}
				totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
				
				total = totalForFoods + totalForDrinks + totalForDesserts;
				
				formatNumberToPrice(totalForFoods);
				
				textField.setText(total + "0");
				return;
			}
		}


		// there was no row with this JSpinner, so we have to add it
		for (int i = 0; i < ELEMENTS; i++) {
			// looking for the "clicked" JSpinner
			if (numSpinner[i].equals(source)) {
				totalPrice = price[i];
				switch (foodLabel[i].getText()) {
				case "Ham Croquettes":
					p1 = 3.50;
					food1 = p1;
					break;
				case "Tortilla":
					p2 = 4.50;
					food2 = p2;
					break;
				case "Grilled Cheese Sandwhich":
					p3 = 3.70;
					food3 = p3;
					break;
				case "Crossaint":
					p4 = 4.50;
					food4 = p4;
					break;
				case "Scrambled Eggs":
					p5 = 5.50;
					food5 = p5;
					break;
				case "Ham and Cheese Biscut":
					p6 = 4.00;
					food6 = p6;
					break;
				case "Sausage Brittle":
					p7 = 3.50;
					food7 = p7;
					break;
				case "Macaroni":
					p8 = 6.50;
					food8 = p8;
					break;
				case "Pancakes":
					p9 = 6.50;
					food9 = p9;
					break;
				}
				totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
				total = totalForFoods + totalForDrinks + totalForDesserts;
				
				textField.setText(total + "0");
				dtm.addRow(new Object[] { foodLabel[i].getText(), quantity,formatNumberToPrice(totalPrice) , numSpinner[i] });
				return;
			}

		}
	}
	ChangeListener listener = new ChangeListener() {
		public void stateChanged(ChangeEvent e) {

			final int quantity = (int) ((JSpinner) e.getSource()).getValue();
			updateTable(quantity,e.getSource());
		
		}
	};
	
		private void updateTable1(int quantity, Object source ) {

			
			final int rows = table_1.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) .equals(source)) {
					if (dtm.getValueAt(row, 0).equals("Strawberry Cake")) {
						
						pr1 = de1 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(pr1), row, 2);
					} else if (dtm.getValueAt(row, 0).equals("Chocolate Cake")) {
						pr1 = de2 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(pr1), row, 2);
					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					
					totalForDesserts = pr + pr1;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "0");
					return;
				}
			}


			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < DESSERT_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerDesserts[i].equals(source)) {
					totalPrice = priceDesserts[i];
					switch (dessertLabel[i].getText()) {
					case "Strawberry Cake":
						de1 = 2.50;
						pr = de1;
						break;
					case "Chocolate Cake":
						de2 = 3.00;
						pr1 = de2;
						break;
					}
					totalForDesserts = pr + pr1;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "0");
					dtm.addRow(new Object[] { dessertLabel[i].getText(), quantity, formatNumberToPrice(totalPrice), numSpinnerDesserts[i] });
					return;
				}

			}
		}
		ChangeListener listenerForDesserts = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				final int quantity = (int) ((JSpinner) e.getSource()).getValue();
				updateTable1(quantity,e.getSource());
		}

	};


	
		private void updateTable2(int quantity, Object source ) {
			final int rows = table_1.getRowCount();
			for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 3) .equals(source)) {
					if (dtm.getValueAt(row, 0).equals("Mocha Latte")) {
						drink1 = d1 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink1), row, 2);

					} else if (dtm.getValueAt(row, 0).equals("Expresso")) {
						drink2 = d2 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink2), row, 2);

					} else if (dtm.getValueAt(row, 0).equals("Orange Juice")) {
						drink3 = d3 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink3), row, 2);


					} else if (dtm.getValueAt(row, 0).equals("Instant Coffee")) {
						drink4 = d4 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink4), row, 2);


					} else if (dtm.getValueAt(row, 0).equals("Iced Mocha")) {
						drink5 = d5 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink5), row, 2);


					}
					if (quantity == 0) {
						dtm.removeRow(row);
					}
					totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "0");

					return;
				}
			}

			// there was no row with this JSpinner, so we have to add it
			for (int i = 0; i < DRINK_ELEMENTS; i++) {
				// looking for the "clicked" JSpinner
				if (numSpinnerDrinks[i] .equals(source)) {
					totalPrice = priceDrinks[i];
					switch (drinkLabel[i].getText()) {
					case "Mocha Latte":
						d1 = 3.50;
						drink1 = d1;
						break;
					case "Expresso":
						d2 = 4.50;
						drink2 = d2;
						break;
					case "Orange Juice":
						d3 = 3.00;
						drink3 = d3;
						break;
					case "Instant Coffee":
						d4 = 5.00;
						drink4 = d4;
						break;
					case "Iced Mocha":
						d5 = 3.00;
						drink5 = d5;
						break;
					}
					totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
					total = totalForFoods + totalForDrinks + totalForDesserts;
					textField.setText(total + "0");
					dtm.addRow(new Object[] { drinkLabel[i].getText(), quantity, formatNumberToPrice(totalPrice), numSpinnerDrinks[i] });
					return;
				}

			}

		}
		ChangeListener listenerForDrinks = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				final int quantity = (int) ((JSpinner) e.getSource()).getValue();
				updateTable2(quantity,e.getSource());
			}
	};
}
