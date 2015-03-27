package Customer;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPanel;

import ADT.Employee;
import ADT.MenuItem;
import ADT.Order;
import ADT.TableOrder;
import KitchenStaff.KitchenStaffHandler;
import Login.LoginWindow;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

public class CustomerGUI extends JFrame implements ActionListener {

	/*
	public static void main(String[] args) {
		new CustomerGUI();
	}
	*/
	private boolean done = false;
	private JButton buttonAddOrder;
	private JButton buttonRemoveOrder;
	private JButton ButtonPlaceOrder;
	private JButton ButtonCallWaiter;
	private JButton ButtonPay;
	private JScrollPane scrollPane;
	private JTable tableOfOrders;
	private JPanel panel;
	private JLabel payInfo;
	private JLabel quantityInfo;
	private CustomerHandler patron;
	private JPanel Overall;
	private JPanel Menu;
	private JButton buttondone_add;
	private JPanel appetizerTab;
	private JPanel drinksTab;
	private JPanel entreesTab;
	private JPanel dessertsTab;
	private JTabbedPane tabbedPane;
	private JButton bApp4;
	private JButton[] appbuttons;
	private JButton[] dributtons;
	private JButton[] entbuttons;
	private JButton[] desbuttons;
	private MenuItem[] appitems;
	private MenuItem[] driitems;
	private MenuItem[] entitems;
	private MenuItem[] desitems;
	private int orderNumber = 0;
	private int orderCount = 0;
	private JButton btnLogOut;
	
	public CustomerGUI() {
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                new LoginWindow();
                dispose();
            }
        });
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setTitle("Customer");
		this.setSize(960,640);
		getContentPane().setLayout(new CardLayout(0, 0));
		this.patron = new CustomerHandler(orderNumber);
		Overall = new JPanel();
		Overall.setBorder(new TitledBorder(null, "Main Screen", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(Overall, "name_98594042636529");
		Overall.setLayout(null);
		
		buttonAddOrder = new JButton("Add Item to Order");
		buttonAddOrder.addActionListener(this);
		buttonAddOrder.setBounds(10, 460, 322, 130);
		Overall.add(buttonAddOrder);
		
		buttonRemoveOrder = new JButton("Remove Item from Order");
		buttonRemoveOrder.setBounds(342, 460, 310, 130);
		buttonRemoveOrder.addActionListener(this);
		Overall.add(buttonRemoveOrder);
		
		ButtonPlaceOrder = new JButton("Place Order");
		ButtonPlaceOrder.setBounds(342, 333, 310, 114);
		Overall.add(ButtonPlaceOrder);
		ButtonPlaceOrder.addActionListener(this);
		
		ButtonCallWaiter = new JButton("Call Waiter");
		ButtonCallWaiter.setBounds(10, 333, 322, 114);
		Overall.add(ButtonCallWaiter);
		
		ButtonPay = new JButton("Pay");
		ButtonPay.setBounds(662, 333, 272, 257);
		Overall.add(ButtonPay);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 636, 301);
		Overall.add(scrollPane);
		
		tableOfOrders = new JTable();
		tableOfOrders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableOfOrders.setShowGrid(false);
		tableOfOrders.setShowHorizontalLines(false);
		tableOfOrders.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableOfOrders.setShowVerticalLines(false);
		tableOfOrders.setColumnSelectionAllowed(true);
		tableOfOrders.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"#", "Menu Item", "Cost", "Quantity", "Special Requests", "Total Cost"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class, Integer.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableOfOrders.getColumnModel().getColumn(0).setResizable(false);
		tableOfOrders.getColumnModel().getColumn(0).setPreferredWidth(32);
		tableOfOrders.getColumnModel().getColumn(1).setResizable(false);
		tableOfOrders.getColumnModel().getColumn(1).setPreferredWidth(128);
		tableOfOrders.getColumnModel().getColumn(2).setResizable(false);
		tableOfOrders.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableOfOrders.getColumnModel().getColumn(3).setResizable(false);
		tableOfOrders.getColumnModel().getColumn(3).setPreferredWidth(64);
		tableOfOrders.getColumnModel().getColumn(4).setResizable(false);
		tableOfOrders.getColumnModel().getColumn(4).setPreferredWidth(256);
		tableOfOrders.getColumnModel().getColumn(5).setResizable(false);
		tableOfOrders.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane.setViewportView(tableOfOrders);
		
		panel = new JPanel();
		panel.setBounds(662, 152, 272, 170);
		Overall.add(panel);
		panel.setBorder(new TitledBorder(null, "Payment Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		quantityInfo = new JLabel("Total Items:");
		quantityInfo.setFont(new Font("Verdana", Font.PLAIN, 16));
		quantityInfo.setBounds(10, 25, 252, 52);
		panel.add(quantityInfo);
		
		payInfo = new JLabel("Total Cost: ");
		payInfo.setBounds(10, 88, 252, 52);
		panel.add(payInfo);
		payInfo.setHorizontalAlignment(SwingConstants.LEFT);
		payInfo.setFont(new Font("Verdana", Font.PLAIN, 16));
		payInfo.setBackground(Color.WHITE);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBackground(UIManager.getColor("Button.background"));
		btnLogOut.addActionListener(this);
		btnLogOut.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnLogOut.setBounds(662, 21, 272, 120);
		Overall.add(btnLogOut);
		
		Menu = new JPanel();
		Menu.setBorder(new TitledBorder(null, "Menu Screen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(Menu, "name_98651108804210");
		Menu.setLayout(null);
		
		buttondone_add = new JButton("DONE");
		buttondone_add.addActionListener(this);
		buttondone_add.setFont(new Font("Tahoma", Font.PLAIN, 40));
		buttondone_add.setBounds(734, 11, 200, 574);
		Menu.add(buttondone_add);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 714, 574);
		Menu.add(tabbedPane);
		
		setTabButtons();
		this.setVisible(true);
	}
	private void setTabButtons() {
		appetizerTab = new JPanel();
		tabbedPane.addTab("Appetizers", null, appetizerTab, null);
		appetizerTab.setLayout(null);
		
		appbuttons = new JButton[1];
		appitems = new MenuItem[1];
		appitems[0] = new MenuItem(5);
		for(int i = 0; i < 1; i++) {
			appbuttons[i] = new JButton();
			appbuttons[i].addActionListener(this);
			appbuttons[i].setText(appitems[i].STRING_ID + " " + appitems[i].MENU_ID);
			appbuttons[i].setBounds(10 + (164 * i), 11, 164, 64);
			appetizerTab.add(appbuttons[i]);
		}
		
		drinksTab = new JPanel();
		drinksTab.setLayout(null);
		tabbedPane.addTab("Drinks", null, drinksTab, null);
		
		dributtons = new JButton[1];
		driitems = new MenuItem[1];
		driitems[0] = new MenuItem(4);
		for(int i = 0; i < 1; i++) {
			dributtons[i] = new JButton();
			dributtons[i].addActionListener(this);
			dributtons[i].setText(driitems[i].STRING_ID + " " + driitems[i].MENU_ID);
			dributtons[i].setBounds(10 + (164 * i), 11, 164, 64);
			drinksTab.add(dributtons[i]);
		}
		
		entreesTab = new JPanel();
		entreesTab.setLayout(null);
		tabbedPane.addTab("Entrees", null, entreesTab, null);
		
		entbuttons = new JButton[2];
		entitems = new MenuItem[2];
		entitems[0] = new MenuItem(1);
		entitems[1] = new MenuItem(2);
		for(int i = 0; i < 2; i++) {
			entbuttons[i] = new JButton();
			entbuttons[i].addActionListener(this);
			entbuttons[i].setText(entitems[i].STRING_ID + " " + entitems[i].MENU_ID);
			entbuttons[i].setBounds(10 + (174 * i), 11, 164, 64);
			entreesTab.add(entbuttons[i]);
		}
		
		dessertsTab = new JPanel();
		dessertsTab.setLayout(null);
		tabbedPane.addTab("Desserts", null, dessertsTab, null);
		
		desbuttons = new JButton[2];
		desitems = new MenuItem[2];
		desitems[0] = new MenuItem(3);
		desitems[1] = new MenuItem(6);
		for(int i = 0; i < 2; i++) {
			desbuttons[i] = new JButton();
			desbuttons[i].addActionListener(this);
			desbuttons[i].setText(desitems[i].STRING_ID + " " + desitems[i].MENU_ID);
			desbuttons[i].setBounds(10 + (174 * i), 11, 164, 64);
			dessertsTab.add(desbuttons[i]);
		}
	}
	private void pay() {
		
	}
	private void logOut() {
		new LoginWindow();
		dispose();
	}
	private void placeOrder() {
		DefaultTableModel dft = (DefaultTableModel) tableOfOrders.getModel();
		for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
			dft.removeRow(0);
		}
		Employee emp=new Employee();
		TableOrder test=new TableOrder(patron.TOTAL_ORDERS,emp,6);
		KitchenStaffHandler.addTableOrder(test);
		quantityInfo.setText("Total Quantity: ");
		payInfo.setText("Total Cost: ");
		repaint();
	}
	private void removeOrder(int row) {
		try {
			if(patron.TOTAL_QUANTITY > 0) {
				DefaultTableModel dft = (DefaultTableModel) tableOfOrders.getModel();
				Vector data = dft.getDataVector();
				String t = data.elementAt(row).toString();
				boolean gone = patron.Remove_Order(Character.getNumericValue(t.charAt(1)));
				NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
				String w = nf.format(patron.TOTAL_COST);
				quantityInfo.setText("Total Quantity: " + patron.TOTAL_QUANTITY);
				payInfo.setText("Total Cost: " + w);
				if(gone) {
					dft.removeRow(row);
				} else {
					for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
						tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.MENU_ID, i, 0);
						tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.STRING_ID, i, 1);
						tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.PRICE, i, 2);
						tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity, i, 3);
						tableOfOrders.setValueAt("", i, 4);
						tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity * patron.TOTAL_ORDERS.get(i).item.PRICE, i, 5);
						
					}
				}
			}
		} catch (Exception e1) {
			
		}
	}
	private void addOrder(int code) {
		MenuItem temp = new MenuItem(code);
		Order temp2 = new Order(code, 1, temp.STRING_ID, 0);
		temp2.Order_ID = orderNumber;
		patron.Add_Order(temp2);
		for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
			tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.MENU_ID, i, 0);
			tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.STRING_ID, i, 1);
			tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.PRICE, i, 2);
			tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity, i, 3);
			tableOfOrders.setValueAt("", i, 4);
			tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity * patron.TOTAL_ORDERS.get(i).item.PRICE, i, 5);
		}
		NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
		String w = nf.format(patron.TOTAL_COST);
		quantityInfo.setText("Total Quantity: " + patron.TOTAL_QUANTITY);
		payInfo.setText("Total Cost: " + w);
		repaint();
		orderCount++;
		orderNumber++;
	}
	private void checkMenuItemButtons(ActionEvent e) {
		Object s = e.getSource();
		if(s == null) {
			System.out.println(s);
		}
		for(int i = 0; i < appbuttons.length; i++) {
			if(s.equals(appbuttons[i])) {
				String text = appbuttons[i].getText();
				text = text.substring(text.length() - 1, text.length());
				int code = Integer.parseInt(text);
				addOrder(code);
			}
		}
		for(int i = 0; i < dributtons.length; i++) {
			if(s.equals(dributtons[i])) {
				String text = dributtons[i].getText();
				text = text.substring(text.length() - 1, text.length());
				int code = Integer.parseInt(text);
				addOrder(code);
			}
		}
		for(int i = 0; i < entbuttons.length; i++) {
			if(s.equals(entbuttons[i])) {
				String text = entbuttons[i].getText();
				text = text.substring(text.length() - 1, text.length());
				int code = Integer.parseInt(text);
				addOrder(code);
			}
		}
		for(int i = 0; i < desbuttons.length; i++) {
			if(s.equals(desbuttons[i])) {
				String text = desbuttons[i].getText();
				text = text.substring(text.length() - 1, text.length());
				int code = Integer.parseInt(text);
				addOrder(code);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = tableOfOrders.getSelectedRow();
		if(e.getSource() == buttonAddOrder) {
			Overall.setVisible(false);
			Menu.setVisible(true);
		}
		if(e.getSource() == buttondone_add) {
			Overall.setVisible(true);
			Menu.setVisible(false);
		}
		if(e.getSource() == buttonRemoveOrder) {
			removeOrder(row);
		}
		if(e.getSource() == ButtonPlaceOrder) {
			placeOrder();
		}
		if(e.getSource() == btnLogOut) {
			logOut();
		}
		checkMenuItemButtons(e);
	}
}
