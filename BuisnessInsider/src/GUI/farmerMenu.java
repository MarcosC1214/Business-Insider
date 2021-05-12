package GUI;

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

public class farmerMenu {
	static private JFrame frame;
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
		
		frame = new JFrame("Local Famers Market");
		frame.setBounds(100, 100, 780, 550);
		
		final ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/resources/farm.png"));
        
        final JLabel Label_1 = new JLabel(imgIcon); 
        
       
       java.net.URL daffyURL = getClass().getResource("/resources/farm.png");
       Image daffyDuckImage = ImageIO.read( daffyURL );
       
		frame.setIconImage(daffyDuckImage);
		
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		frame.setResizable(false);
		
		
		
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblFoodOrdered = new JLabel("Food Ordered");
		lblFoodOrdered.setBounds(529, 11, 81, 14);

		frame.getContentPane().add(lblFoodOrdered);

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
		frame.getContentPane().add(table_1);
		JLabel lblTotal = new JLabel("Total  : ");
		lblTotal.setBounds(519, 340, 46, 14);
		frame.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(585, 340, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		orderButton_1 = new JButton("Order");
		orderButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allOrderMenus order;
				
					order = new allOrderMenus();
					try {
						order.createAndShowGUI();
						frame.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
		});
		orderButton_1.setBounds(511, 385, 89, 23);
		frame.getContentPane().add(orderButton_1);
		backButton_1 = new JButton("Back");
		backButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		backButton_1.setBounds(610, 385, 89, 23);
		frame.getContentPane().add(backButton_1);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		addIt(tabbedPane, "Fruits");
		addIt1(tabbedPane, "Drinks");
		addIt2(tabbedPane, "Vegetables");
		
		tabbedPane.setBounds(18, 11, 490, 450);
		frame.getContentPane().add(tabbedPane);
		frame.setVisible(true);
		
		
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
		
		file[0] = new String("/grape.png");
		file[1] = new String("/banana.png");
		file[2] = new String("/pineapple.png");
		file[3] = new String("/coco.jpg");
		file[4] = new String("/apple.png");
		file[5] = new String("/oranges.jpg");
		file[6] = new String("/strawberry.png");
		file[7] = new String("/mango.png");
		file[8] = new String("/kiwi.jpg");
		
		foodLabel[0] = new JLabel("Grapes");
		foodLabel[1] = new JLabel("Bananas");
		foodLabel[2] = new JLabel("Pineapples");
		foodLabel[3] = new JLabel("Coconuts");
		foodLabel[4] = new JLabel("Apples");
		foodLabel[5] = new JLabel("Oranges");
		foodLabel[6] = new JLabel("Strawberrys");
		foodLabel[7] = new JLabel("Mangos");
		foodLabel[8] = new JLabel("Kiwi");
		
		price[0] = 2.00;
		price[1] = 0.50;
		price[2] = 2.70;
		price[3] = 1.00;
		price[4] = 1.30;
		price[5] = 4.00;
		price[6] = 5.00;
		price[7] = 1.50;
		price[8] = 2.20;
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
		fileDesserts[0] = new String("/resources/lettuce.png");
		fileDesserts[1] = new String("/resources/carrot.png");

		dessertLabel[0] = new JLabel("Lettuce");
		dessertLabel[1] = new JLabel("Carrots");

		priceDesserts[0] = 2.50;
		priceDesserts[1] = 1.00;

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
		fileDrinks[0] = new String("/resources/image_raspberry.jpg");
		fileDrinks[1] = new String("/resources/image_c.jpg");
		fileDrinks[2] = new String("/resources/image_blue_hawailan.jpg");
		fileDrinks[3] = new String("/resources/image_Pina.jpg");
		fileDrinks[4] = new String("/resources/image_lemonice.jpg");

		drinkLabel[0] = new JLabel("Raspberry Splash");
		drinkLabel[1] = new JLabel("Chocolate Shake");
		drinkLabel[2] = new JLabel("Blue Hawaian");
		drinkLabel[3] = new JLabel("Pineapple");
		drinkLabel[4] = new JLabel("Icy Lemonade");

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
				
				if (dtm.getValueAt(row, 0).equals("Grapes")) {
					food1 = p1 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food1), row, 2);
					

				} else if (dtm.getValueAt(row, 0).equals("Bananas")) {
					food2 = p2 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food2), row, 2);
					
				} else if (dtm.getValueAt(row, 0).equals("Pineapples")) {
					food3 = p3 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food3), row, 2);
					
				} else if (dtm.getValueAt(row, 0).equals("Coconuts")) {
					food4 = p4 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food4), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Apples")) {
					food5 = p5 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food5), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Oranges")) {
					food6 = p6 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food6), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Strawberrys")) {

					food7 = p7 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food7), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Mangos")) {
					food8 = p8 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food8), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Kiwi")) {
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
				case "Grapes":
					p1 = 2.00;
					food1 = p1;
					break;
				case "Bananas":
					p2 = 0.50;
					food2 = p2;
					break;
				case "Pineapples":
					p3 = 2.70;
					food3 = p3;
					break;
				case "Coconuts":
					p4 = 1.00;
					food4 = p4;
					break;
				case "Apples":
					p5 = 1.30;
					food5 = p5;
					break;
				case "Oranges":
					p6 = 4.00;
					food6 = p6;
					break;
				case "Strawberry":
					p7 = 5.00;
					food7 = p7;
					break;
				case "Mangos":
					p8 = 1.50;
					food8 = p8;
					break;
				case "Kiwi":
					p9 = 2.20;
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
					if (dtm.getValueAt(row, 0).equals("Lettuce")) {
						
						pr1 = de1 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(pr1), row, 2);
					} else if (dtm.getValueAt(row, 0).equals("Carrots")) {
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
					case "Lettuce":
						de1 = 2.50;
						pr = de1;
						break;
					case "Carrots":
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
					if (dtm.getValueAt(row, 0).equals("Raspberry Splash")) {
						drink1 = d1 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink1), row, 2);

					} else if (dtm.getValueAt(row, 0).equals("Chocolate Shake")) {
						drink2 = d2 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink2), row, 2);

					} else if (dtm.getValueAt(row, 0).equals("Blue Hawaian")) {
						drink3 = d3 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink3), row, 2);


					} else if (dtm.getValueAt(row, 0).equals("Pineapple")) {
						drink4 = d4 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink4), row, 2);


					} else if (dtm.getValueAt(row, 0).equals("Icy Lemonade")) {
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
					case "Raspberry Splash":
						d1 = 3.50;
						drink1 = d1;
						break;
					case "Chocolate Shake":
						d2 = 4.50;
						drink2 = d2;
						break;
					case "Blue Hawaian":
						d3 = 3.00;
						drink3 = d3;
						break;
					case "Pineapple":
						d4 = 5.00;
						drink4 = d4;
						break;
					case "Icy Lemonade":
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
