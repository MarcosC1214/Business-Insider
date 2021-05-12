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

public class bikeMenu {
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
		
		frame = new JFrame("Bikes N' More");
		frame.setBounds(100, 100, 780, 550);
		
		
		final ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/resources/bike.jpg"));
        
        final JLabel Label_1 = new JLabel(imgIcon); 
        
       
       java.net.URL daffyURL = getClass().getResource("/resources/bike.jpg");
       Image daffyDuckImage = ImageIO.read( daffyURL );
       
		frame.setIconImage(daffyDuckImage);

		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		
		frame.setResizable(false);
		
		
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblFoodOrdered = new JLabel("Products Ordered");
		lblFoodOrdered.setBounds(535, 11, 98, 14);

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
		table_1.setBounds(529, 36, 1, 1); // int x, int y, int width, int height
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
		lblTotal.setBounds(529, 350, 46, 14);
		frame.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(593, 347, 86, 20);
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
					//order.setVisible(true);
					
			}
			
		});
		orderButton_1.setBounds(527, 385, 89, 23);
		frame.getContentPane().add(orderButton_1);
		backButton_1 = new JButton("Back");
		backButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		backButton_1.setBounds(633, 385, 89, 23);
		frame.getContentPane().add(backButton_1);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		addIt(tabbedPane, "Gear");
		addIt1(tabbedPane, "Accessories");
		addIt2(tabbedPane, "Bikes");
		
		tabbedPane.setBounds(10, 11, 515, 450);
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
		
		file[0] = new String("/bike1.jpg");
		file[1] = new String("/shim.jpg");
		file[2] = new String("/adapt.jpg");
		file[3] = new String("/dera.jpg");
		file[4] = new String("/chain.jpg");
		file[5] = new String("/bling.jpg");
		file[6] = new String("/quill.jpg");
		file[7] = new String("/alloy.jpg");
		file[8] = new String("/crankarm.jpg");
		
		foodLabel[0] = new JLabel("Oval Direct Mount");
		foodLabel[1] = new JLabel("Handle Bar Shim");
		foodLabel[2] = new JLabel("BBright Adapter");
		foodLabel[3] = new JLabel("Derailleur Hangar");
		foodLabel[4] = new JLabel("1-Piece Chainring");
		foodLabel[5] = new JLabel("Bling Tape");
		foodLabel[6] = new JLabel("Adjustable Quill Stem");
		foodLabel[7] = new JLabel("Alloy Single Speed Crankset");
		foodLabel[8] = new JLabel("Aluminum Crankarm");
		
		price[0] = 90.00;
		price[1] = 13.50;
		price[2] = 50.00;
		price[3] = 37.00;
		price[4] = 15.00;
		price[5] = 40.00;
		price[6] = 25.00;
		price[7] = 32.00;
		price[8] = 19.50;
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
		fileDesserts[0] = new String("/resources/trek.jpg");
		fileDesserts[1] = new String("/resources/trek2.jpg");

		dessertLabel[0] = new JLabel("Trek Pro");
		dessertLabel[1] = new JLabel("Trek Precalibur");

		priceDesserts[0] = 2399.00;
		priceDesserts[1] = 100.00;

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
		fileDrinks[0] = new String("/resources/plate.jpg");
		fileDrinks[1] = new String("/resources/delta.jpg");
		fileDrinks[2] = new String("/resources/bike2.jpg");
		fileDrinks[3] = new String("/resources/glasses.jpg");
		fileDrinks[4] = new String("/resources/fly.jpeg");

		drinkLabel[0] = new JLabel("Plate Mate");
		drinkLabel[1] = new JLabel("Delta");
		drinkLabel[2] = new JLabel("Bike Stand");
		drinkLabel[3] = new JLabel("Allient Glasses");
		drinkLabel[4] = new JLabel("Fly Cage");

		priceDrinks[0] = 29.00;
		priceDrinks[1] = 80.00;
		priceDrinks[2] = 52.70;
		priceDrinks[3] = 10.00;
		priceDrinks[4] = 45.00;
		
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
				
				if (dtm.getValueAt(row, 0).equals("Oval Direct Mount")) {
					food1 = p1 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food1), row, 2);
					

				} else if (dtm.getValueAt(row, 0).equals("Handle Bar Shim")) {
					food2 = p2 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food2), row, 2);
					
				} else if (dtm.getValueAt(row, 0).equals("BBright Adapter")) {
					food3 = p3 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food3), row, 2);
					
				} else if (dtm.getValueAt(row, 0).equals("Derailleur Hangar")) {
					food4 = p4 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food4), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("1-Piece Chainring")) {
					food5 = p5 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food5), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Bling Tape")) {
					food6 = p6 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food6), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Adjustable Quill Stem")) {

					food7 = p7 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food7), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Alloy Single Speed Crankset")) {
					food8 = p8 * quantity;
					dtm.setValueAt(quantity, row, 1); // obj, row, column
					dtm.setValueAt(formatNumberToPrice(food8), row, 2);
				} else if (dtm.getValueAt(row, 0).equals("Aluminum Crankarm")) {
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
				case "Oval Direct Mount":
					p1 = 90.00;
					food1 = p1;
					break;
				case "Handle Bar Shim":
					p2 = 13.50;
					food2 = p2;
					break;
				case "BBright Adapter":
					p3 = 50.00;
					food3 = p3;
					break;
				case "Derailleur Hangar":
					p4 = 37.00;
					food4 = p4;
					break;
				case "1-Piece Chainring":
					p5 = 15.00;
					food5 = p5;
					break;
				case "Bling Tape":
					p6 = 40.00;
					food6 = p6;
					break;
				case "Adjustable Quill Stem":
					p7 = 25.00;
					food7 = p7;
					break;
				case "Alloy Single Speed Crankset":
					p8 = 32.00;
					food8 = p8;
					break;
				case "Aluminum Crankarm":
					p9 = 19.50;
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
					if (dtm.getValueAt(row, 0).equals("Trek Pro")) {
						
						pr1 = de1 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(pr1), row, 2);
					} else if (dtm.getValueAt(row, 0).equals("Trek Precalibur")) {
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
					case "Trek Pro":
						de1 = 2399.00;
						pr = de1;
						
						break;
					case "Trek Precalibur":
						de2 = 100.00;
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
					if (dtm.getValueAt(row, 0).equals("Plate Mate")) {
						drink1 = d1 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink1), row, 2);

					} else if (dtm.getValueAt(row, 0).equals("Delta")) {
						drink2 = d2 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink2), row, 2);

					} else if (dtm.getValueAt(row, 0).equals("Bike Stand")) {
						drink3 = d3 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink3), row, 2);


					} else if (dtm.getValueAt(row, 0).equals("Allient Glasses")) {
						drink4 = d4 * quantity;
						dtm.setValueAt(quantity, row, 1); // obj, row, column
						dtm.setValueAt(formatNumberToPrice(drink4), row, 2);


					} else if (dtm.getValueAt(row, 0).equals("Fly Cage")) {
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
					case "Plate Mate":
						d1 = 29.00;
						drink1 = d1;
						break;
					case "Delta":
						d2 = 80.00;
						drink2 = d2;
						break;
					case "Bike Stand":
						d3 = 52.70;
						drink3 = d3;
						break;
					case "Allient Glasses":
						d4 = 10.00;
						drink4 = d4;
						break;
					case "Fly Cage":
						d5 = 45.00;
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

