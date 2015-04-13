package Customer;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Login.LoginWindow;
import Shared.ADT.*;
import Shared.ADT.MenuItem;
import Shared.Gradients.*;

import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import javax.swing.JButton;



public class CustSub extends JFrame implements ActionListener{

	
		/**
	 * 
	 */
	private static final long serialVersionUID = 7540704493585273347L;
		//Parent Panels
		private JPanel rootPanel,titlePanel,buttonPanel;
		private GradientPanel backgroundPanel,buttonPanelBackground,cardPanel;
		private GradientPanel card1,card3;
		//Swing Objects
		private GradientButton backButton,bCallWaiter,bToggleAR,bPlaceOrder,bPayOrder;
		private GradientButton payWithCash,payWithCard;
		private JLabel titleLabel,dateAndTime;
		//Swing Layouts
		private CardLayout c;
		//Other Variables
		private Timer timer;
		private CustomerHandler patron;
		private JTable tableOfOrders;
		private JScrollPane scrollPane;
		private ArrayList<GradientButton> menuButtons;
		private JPanel panel;
		private JScrollPane scrollPane_1;
		private JLabel lTotal;
		private JLabel lCost;
		private JButton bHelp;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new CustSub();
		}
		
		
		public CustSub()
		{
			super();
			init();
		}


		public void init()
		{
			menuButtons = new ArrayList<GradientButton>();
			patron = new CustomerHandler(0);
			this.setTitle("Place Orders");
			this.setResizable(true);
			this.setSize(1200,700);
			this.frameManipulation();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			this.setResizable(false);
			getContentPane().add(rootPanel);
			
			
			addWindowListener(new WindowAdapter() // To open main window again if you hit the corner "X"
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	                new LoginWindow();
	                dispose();
	            }
	        });
			
			c = (CardLayout)(cardPanel.getLayout());
			
			card3 = new GradientPanel();
			card3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Order View", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			cardPanel.add(card3,"BLANK");
			card3.setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 21, 503, 436);
			card3.add(scrollPane);
			
			tableOfOrders = new JTable();
			tableOfOrders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			tableOfOrders.setShowGrid(false);
			tableOfOrders.setShowHorizontalLines(false);
			tableOfOrders.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			tableOfOrders.setShowVerticalLines(false);
			tableOfOrders.setRowHeight(32);
			tableOfOrders.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"Menu Item", "Cost", "Quantity", "Total Cost"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Object.class, Integer.class, Double.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tableOfOrders.getColumnModel().getColumn(0).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(0).setPreferredWidth(128);
			tableOfOrders.getColumnModel().getColumn(1).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(1).setPreferredWidth(80);
			tableOfOrders.getColumnModel().getColumn(2).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(2).setPreferredWidth(32);
			tableOfOrders.getColumnModel().getColumn(3).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(3).setPreferredWidth(100);
			scrollPane.setViewportView(tableOfOrders);
			
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane_1.setBounds(523, 21, 361, 535);
			card3.add(scrollPane_1);
			
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Menu View", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane_1.setViewportView(panel);
			panel.setLayout(new GridLayout(3, 4, 12, 12));
			
			bHelp = new JButton("Need Help?");
			bHelp.addActionListener(this);
			bHelp.setFont(new Font("Tahoma", Font.PLAIN, 16));
			bHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			bHelp.setBounds(10, 468, 178, 88);
			card3.add(bHelp);
			
			lTotal = new JLabel("Total: ");
			lTotal.setHorizontalAlignment(SwingConstants.CENTER);
			lTotal.setBounds(198, 468, 63, 32);
			card3.add(lTotal);
			
			lCost = new JLabel("$    ");
			lCost.setFont(new Font("Tahoma", Font.PLAIN, 48));
			lCost.setHorizontalAlignment(SwingConstants.LEFT);
			lCost.setBounds(271, 468, 242, 88);
			card3.add(lCost);
			for(GradientButton a : menuButtons) {
				panel.add(a);
			}
			c.show(cardPanel, "BLANK");
			this.setVisible(true);
		}

		public void frameManipulation()
		{
			rootPanel = new JPanel();
			rootPanel.setLayout(null);
			setBackgroundPanel();
			setTitlePanel();
			setCardPanel();
			setButtonPanel();
			setRootPanel();
		}
		
		private void setRootPanel()
		{
			rootPanel.add(titlePanel);
			rootPanel.add(cardPanel);
			rootPanel.add(buttonPanel);
			rootPanel.add(buttonPanelBackground);
			rootPanel.add(backgroundPanel);
		}
		
		private void setBackgroundPanel()
		{
			// Create Button Background Panel
			buttonPanelBackground = new GradientPanel();
			buttonPanelBackground.setGradient(new Color(255,220,220), new Color(255,110,110));
			buttonPanelBackground.setBounds(0, 55, 250, 617);
			buttonPanelBackground.setBorder(new LineBorder(new Color(0, 0, 0)));
			
			// Create Background Panel
			backgroundPanel = new GradientPanel();
			backgroundPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			backgroundPanel.setGradient(new Color(255,255,255), new Color(255,110,110));
			backgroundPanel.setLayout(null);
			backgroundPanel.setBounds(0,0,1194,672);
		}
		
		//************************************************************
		//DO NOT edit the following function except for the title name
		//************************************************************
		
		private void setTitlePanel()
		{
			// Create Title Panel
			titlePanel = new JPanel();
			titlePanel.setBounds(0, 0, 1194, 56);
			titlePanel.setLayout(null);
			titlePanel.setOpaque(false);
			// Set Title
			titleLabel = new JLabel("Customer Interface");
			titleLabel.setHorizontalAlignment(JLabel.CENTER);
			titleLabel.setFont(titleLabel.getFont().deriveFont(38f));
			titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			titleLabel.setBounds(new Rectangle(0, 0, 793, 56));
			
						// Add components to Title Panel
						titlePanel.add(titleLabel);
						// Set Date and Time
						dateAndTime = new JLabel();
						dateAndTime.setBounds(792, 0, 402, 56);
						titlePanel.add(dateAndTime);
						dateAndTime.setHorizontalAlignment(JLabel.CENTER);
						dateAndTime.setFont(dateAndTime.getFont().deriveFont(28f));
						dateAndTime.setBorder(BorderFactory.createLineBorder(Color.black));
						updateClock();
						// Create a timer to update the clock
						timer = new Timer(500,this);
			            timer.setRepeats(true);
			            timer.setCoalesce(true);
			            timer.setInitialDelay(0);
			            timer.start();
		}
		
		//*********************************************************
		//DO NOT change the location of the following panel
		//*********************************************************
		
		private void setButtonPanel()
		{
			// Create Button Panel
			buttonPanel = new JPanel();
			buttonPanel.setBounds(7, 61, 236, 604);
			buttonPanel.setOpaque(false);
			buttonPanel.setBorder(null);
			buttonPanel.setLayout(new GridLayout(5, 0, 5, 5));
			
			// Set Request Table Status Change Button
			bCallWaiter = new GradientButton("<html>Request Table<br />Status Change</html>");
			bCallWaiter.setText("Call Waiter");
			bCallWaiter.addActionListener(this);
			bCallWaiter.setFont(bCallWaiter.getFont().deriveFont(16.0f));
			bCallWaiter.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			bCallWaiter.setFocusPainted(false);
			
			// Set Manage Order Queue Button
			bToggleAR = new GradientButton("Manage Order Queue");
			bToggleAR.setText("Remove Item from Order");
			bToggleAR.addActionListener(this);
			bToggleAR.setFont(bToggleAR.getFont().deriveFont(16.0f));
			bToggleAR.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			bToggleAR.setFocusPainted(false);
			bToggleAR.setVisible(false);
			
			// Set Accept Payment Button
			bPlaceOrder = new GradientButton("Accept Payment");
			bPlaceOrder.setText("Finish Order");
			bPlaceOrder.addActionListener(this);
			bPlaceOrder.setFont(bPlaceOrder.getFont().deriveFont(16.0f));
			bPlaceOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			bPlaceOrder.setFocusPainted(false);
			bPlaceOrder.setVisible(false);
			
			// Set Request Refund Button
			bPayOrder = new GradientButton("Request Refund");
			bPayOrder.setText("Pay for Order");
			bPayOrder.addActionListener(this);
			bPayOrder.setFont(bPayOrder.getFont().deriveFont(16.0f));
			bPayOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			bPayOrder.setFocusPainted(false);
			// Set Back Button
			backButton = new GradientButton("BACK");
			backButton.addActionListener(this);												
			backButton.setFont(backButton.getFont().deriveFont(16.0f));
			backButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			backButton.setFocusPainted(false);
			
			buttonPanel.add(bCallWaiter);
			buttonPanel.add(bToggleAR);
			buttonPanel.add(bPlaceOrder);
			buttonPanel.add(bPayOrder);
			buttonPanel.add(backButton);
		}
		
		//********************************************************************************
		//DO NOT deviate from the card layout or change the size/location of the cardPanel.
		//Creating and adding cards is OK
		//********************************************************************************
		
		private void setCardPanel()
		{
			cardPanel = new GradientPanel();
			cardPanel.setLayout(new CardLayout()); // How to define a Card Layout
			cardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			cardPanel.setGradient(new Color(255,255,255), new Color(255,110,110));
			cardPanel.setBounds(273, 79, 896, 569);
			
			card1 = new GradientPanel(); // Create card with a button YES
			card1.setBorder(new TitledBorder(null, "Menu View", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			cardPanel.add(card1,"YES");
			card1.setLayout(new GridLayout(0, 1, 0, 0));
		
			for(int a = 0; a < 6; a++) {
				MenuItem temp = new MenuItem(1);
				if(a + 1 > 0 && a + 1 < 7) {
					temp = new MenuItem(a + 1);
					patron.items.add(new MenuItem(a+1));
				} else {
					temp = new MenuItem(1);
				}
				menuButtons.add(new GradientButton(temp.STRING_ID + ": $" + temp.PRICE));
				menuButtons.get(a).setFont(new Font("Tahoma", Font.PLAIN, 16));
				menuButtons.get(a).addActionListener(this);
				
			}
			cardPanel.setVisible(true);
		}
		
		public void removeOrder(int row) {
			try {
				if(patron.TOTAL_QUANTITY > 0) {
					DefaultTableModel dft = (DefaultTableModel) tableOfOrders.getModel();
					Vector data = dft.getDataVector();
					String t = data.elementAt(row).toString();
					char[] b = t.toCharArray();
					int f = 0;
					int g = 0;
					int index = -1;
					for(int i = 0; i < b.length; i++) {
						if(b[i] == '[') {
							f = i;
						} else if(b[i] == ',') {
							g = i;
							break;
						}
					}
					t = t.substring(f + 1, g);
					for(int i = 0; i < patron.items.size(); i++) {
						if(t.equals(patron.items.get(i).STRING_ID)) {
							index = i;
							
							break;
						}
					}
					boolean gone = patron.Remove_Order(index+1);
					NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
					String w = nf.format(patron.TOTAL_COST);
					lCost.setText(w);
					if(gone) {
						dft.removeRow(row);
					} else {
						for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
							tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.STRING_ID, i, 0);
							tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.PRICE, i, 1);
							tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity, i, 2);
							tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity * patron.TOTAL_ORDERS.get(i).item.PRICE, i, 3);
							
						}
					}
				}
			} catch (Exception e1) {
				
			}
			repaint();
		}
		
		public void placeOrder() {
			DefaultTableModel dft = (DefaultTableModel) tableOfOrders.getModel();
			for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
				dft.removeRow(0);
			}
			TableOrder current = new TableOrder(patron.TOTAL_ORDERS, new Employee(), 0);
			patron.historyTable.add(current);
			patron.removeAll();
			repaint();
		}
		
		public void addOrder(String name) {
			int code = 0;
			for(MenuItem a : patron.items) {
				if(name.equals(a.STRING_ID)) {
					code = a.MENU_ID;
				}
			}
			MenuItem temp = new MenuItem(code);
			Order temp2 = new Order(code, 1, "", 0);
			temp2.Order_ID = 0;
			patron.Add_Order(temp2);
			for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
				tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.STRING_ID, i, 0);
				tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.PRICE, i, 1);
				tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity, i, 2);
				tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity * patron.TOTAL_ORDERS.get(i).item.PRICE, i, 3);
			}
			NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
			String w = nf.format(patron.TOTAL_COST);
			lCost.setText(w);
			repaint();
		}
		// Action Listener
		public void actionPerformed(ActionEvent e) 
		{
			Object a = e.getSource();
			try {
				if(patron.TOTAL_ORDERS.isEmpty()) {
					bToggleAR.setVisible(false);
					bPlaceOrder.setVisible(false);
				} else {
					bToggleAR.setVisible(true);
		    		bPlaceOrder.setVisible(true);
				}
			} catch(NullPointerException b) {
				
			}
			if(a == backButton)
				{
					new LoginWindow();
					dispose();
				}
			if(a == bCallWaiter)
			{
			    
			}
			if(a == bPlaceOrder)
				{
					placeOrder();
				}
			if(a == bPayOrder)
				{
				
				}
			if(a == bToggleAR)
				{
					int row = tableOfOrders.getSelectedRow();
					if(row == -1) {
						row = patron.TOTAL_ORDERS.size() - 1;
					}
					removeOrder(row);
					if(patron.TOTAL_ORDERS.isEmpty())
			    		bToggleAR.setVisible(false);
				}
			if(a == payWithCash)
				{

				}
			if(a == payWithCard)
				{

				}
			if(a == timer)
				{
					updateClock();
				}
			if(menuButtons != null) {
				for(int i = 0; i < menuButtons.size(); i++) {
					if(a == menuButtons.get(i)) {
						String a1 = menuButtons.get(i).getText();
						for(int j = 0; j < menuButtons.get(i).getText().length(); j++) {
							if(a1.charAt(j) == ':') {
								a1 = a1.substring(0, j);
								break;
							}
						}
						addOrder(a1);
						tableOfOrders.repaint();
					}
				}
			}
			if(a == bHelp) {
				String message = "This is an interface that you can use to order food, \n to order food, simply add items to your order by clicking the item \n in the menu on the right side. When you are finished you may press finish order \n and you food will be delivered.";
				JOptionPane.showConfirmDialog(new JFrame(), message);
			}
		}
		
		private void updateClock() {
            dateAndTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
        }
}
