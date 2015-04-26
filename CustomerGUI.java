package Customer;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import Login.LoginWindow;
import Shared.ADT.*;
import Shared.ADT.MenuItem;
import Shared.Gradients.*;
import Shared.Notifications.NotificationGUI;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;



public class CustomerGUI extends JFrame implements ActionListener{

	
	/**
	 * Author: Rob
	 */
	private static final long serialVersionUID = 7540704493585273347L;
		//Parent Panels
		public JPanel rootPanel,titlePanel,buttonPanel;
		public GradientPanel backgroundPanel,buttonPanelBackground,cardPanel;
		public GradientPanel card1,card3;
		//Swing Objects
		public GradientButton backButton,bCallWaiter,bToggleAR,bPlaceOrder,bPayOrder;
		public JLabel titleLabel,dateAndTime;
		//Swing Layouts
		public CardLayout c;
		//Other Variables
		public Timer timer;
		public Timer updateMenu;
		public CustomerHandler patron;
		public JTable tableOfOrders;
		public JScrollPane scrollPane;
		public ArrayList<GradientButton> menuButtons;
		public JPanel panel;
		public JScrollPane scrollPane_1;
		public JLabel lCost;
		public GradientButton bHelp;
		public JPanel panel_1;
		public NotificationGUI note;
		public boolean dis_inter;
		Box b;
			
		public CustomerGUI()
		{
			super();
			
			init();
			if(patron.TABLE_ID == -1) {
				closeWindow();
				new LoginWindow();
			}
		}

		public void init()
		{
			dis_inter = false;
			menuButtons = new ArrayList<GradientButton>();
			patron = new CustomerHandler(0);
			patron.TABLE_ID = patron.net.getTableID();
			
			patron.setMenu();
			updateMenu = new Timer(5000,this);
			updateMenu.setRepeats(true);
			updateMenu.setCoalesce(true);
            updateMenu.setInitialDelay(5000);
            updateMenu.start();
            
            
            
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
	               
	            	closeWindow();
	            	new LoginWindow();
	            }
	        });
			
			
			
			c = (CardLayout)(cardPanel.getLayout());
			
			card3 = new GradientPanel();
			card3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Order View", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			cardPanel.add(card3,"BLANK");
			card3.setLayout(null);
			
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane_1.setBounds(10, 21, 220, 559);
			card3.add(scrollPane_1);
			
			b = Box.createVerticalBox();
			
			panel = new JPanel();
			scrollPane_1.setViewportView(b);
			panel.setLayout(new GridLayout(5, 2, 2, 2));
			
			scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(240, 21, 672, 436);
			card3.add(scrollPane);
			
			tableOfOrders = new JTable();
			tableOfOrders.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			tableOfOrders.setShowGrid(false);
			tableOfOrders.setShowHorizontalLines(false);
			tableOfOrders.setFont(new Font("Arial", Font.PLAIN, 20));
			tableOfOrders.setShowVerticalLines(false);
			tableOfOrders.setRowHeight(24);
			tableOfOrders.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"Menu Item", "Spc Req?", "Cost", "#", "Total Cost"
				}
			));
			tableOfOrders.getColumnModel().getColumn(0).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(0).setPreferredWidth(150);
			tableOfOrders.getColumnModel().getColumn(1).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(1).setPreferredWidth(200);
			tableOfOrders.getColumnModel().getColumn(2).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(2).setPreferredWidth(26);
			tableOfOrders.getColumnModel().getColumn(3).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(3).setPreferredWidth(16);
			tableOfOrders.getColumnModel().getColumn(4).setResizable(false);
			tableOfOrders.getColumnModel().getColumn(4).setPreferredWidth(32);
			
			scrollPane.setViewportView(tableOfOrders);
			
			bHelp = new GradientButton("Need Help?");
			bHelp.addActionListener(this);
			bHelp.setFont(new Font("arial", Font.PLAIN, 18));
			bHelp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			bHelp.setBounds(686, 468, 226, 112);
			card3.add(bHelp);
			
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Total", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(240, 468, 205, 88);
			card3.add(panel_1);
			panel_1.setLayout(null);
			
			lCost = new JLabel("$0.00");
			lCost.setBounds(0, 0, 216, 88);
			panel_1.add(lCost);
			lCost.setFont(new Font("arial", Font.PLAIN, 48));
			lCost.setHorizontalAlignment(SwingConstants.CENTER);
			for(GradientButton a : menuButtons) {
				b.add(a);
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
			note = new NotificationGUI(42, "Customer");
			rootPanel.add(note);
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
		private void pingDatabase() {
			patron.items = new ArrayList<MenuItem>();
			patron.setMenu();
			panel.removeAll();
			scrollPane_1.setViewportView(panel);
			panel.setLayout(new GridLayout(0, 4, 0, 0));
			menuButtons.clear();
			NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
			for(int i = 0; i < patron.items.size(); i++) {
				if(patron.items.get(i).VALID) {
					menuButtons.add(new GradientButton("<html><br>" + patron.items.get(i).STRING_ID + "<br> <br>" + "</html>"));
					menuButtons.get(i).setFont(new Font("arial", Font.PLAIN, 18));
					menuButtons.get(i).addActionListener(this);
					menuButtons.get(i).setToolTipText("(" + nf.format(patron.items.get(i).PRICE) + ") " + patron.items.get(i).DESCRIPTION);
				}
				
			}
			for(GradientButton c : menuButtons) {
				b.add(c);
			}
			repaint();
		}
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
			bCallWaiter.setToolTipText("Press here to call a waiter");
			// Set Manage Order Queue Button
			bToggleAR = new GradientButton("Manage Order Queue");
			bToggleAR.setText("Remove Item from Order");
			bToggleAR.addActionListener(this);
			bToggleAR.setFont(bToggleAR.getFont().deriveFont(16.0f));
			bToggleAR.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			bToggleAR.setFocusPainted(false);
			bToggleAR.setVisible(false);
			bToggleAR.setToolTipText("Press here to remove an item that is selected");
			
			// Set Accept Payment Button
			bPlaceOrder = new GradientButton("Accept Payment");
			bPlaceOrder.setText("Finish Order");
			bPlaceOrder.addActionListener(this);
			bPlaceOrder.setFont(bPlaceOrder.getFont().deriveFont(16.0f));
			bPlaceOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			bPlaceOrder.setFocusPainted(false);
			bPlaceOrder.setVisible(false);
			bPlaceOrder.setToolTipText("Press here to pay");
			// Set Back Button
			backButton = new GradientButton("BACK");
			backButton.addActionListener(this);												
			backButton.setFont(backButton.getFont().deriveFont(16.0f));
			backButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			backButton.setFocusPainted(false);
			backButton.setToolTipText("Press here to log out");
			
			buttonPanel.add(bCallWaiter);
			
			// Set Request Refund Button
			bPayOrder = new GradientButton("Request Refund");
			bPayOrder.setToolTipText("Pay?");
			bPayOrder.setText("Pay for Order");
			bPayOrder.addActionListener(this);
			bPayOrder.setFont(bPayOrder.getFont().deriveFont(16.0f));
			bPayOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			bPayOrder.setFocusPainted(false);
			buttonPanel.add(bPayOrder);
			buttonPanel.add(bToggleAR);
			buttonPanel.add(bPlaceOrder);
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
			cardPanel.setBounds(260, 67, 924, 593);
			
			card1 = new GradientPanel(); // Create card with a button YES
			
			
			cardPanel.add(card1,"YES");
			card1.setLayout(new GridLayout(0, 1, 0, 0));
			NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
			for(int i = 0; i < patron.items.size(); i++) {
				menuButtons.add(new GradientButton("<html><br>" + patron.items.get(i).STRING_ID + "<br> <br>" + "</html>"));
				menuButtons.get(i).setFont(new Font("arial", Font.PLAIN, 18));
				menuButtons.get(i).addActionListener(this);
				menuButtons.get(i).setBounds(200,200, 200, 200);
				menuButtons.get(i).setToolTipText("(" + nf.format(patron.items.get(i).PRICE) + ") " + patron.items.get(i).DESCRIPTION);
			}
			cardPanel.setVisible(true);
		}
		
		public boolean removeOrder(int row) {
			boolean gone = false;
			boolean removed = false;
			try {
				if(patron.TOTAL_QUANTITY > 0) {
					DefaultTableModel dft = (DefaultTableModel) tableOfOrders.getModel();	
					String name =  (String) tableOfOrders.getValueAt(row, 0);
					String s = (String) tableOfOrders.getValueAt(row, 1);
					if(s == null) {
						s = "";
					}
					
					gone = patron.Remove_Order(name, s);
					NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
					String w = nf.format(patron.TOTAL_COST);
					lCost.setText(w);
					if(gone) {
						dft.removeRow(row);
					} else {
						for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
							tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.STRING_ID, i, 0);
							tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Spc_Req, i, 1);
							tableOfOrders.setValueAt(nf.format(patron.TOTAL_ORDERS.get(i).item.PRICE), i, 2);
							tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity, i, 3);
							tableOfOrders.setValueAt(nf.format(patron.TOTAL_ORDERS.get(i).Quantity * patron.TOTAL_ORDERS.get(i).item.PRICE), i, 4);
						}
						removed = true;
					}
				}
				
			} catch (Exception e1) {
				
			}
			repaint();
			return (gone || removed);
		}
		
		public void placeOrder() {
			DefaultTableModel dft = (DefaultTableModel) tableOfOrders.getModel();
			for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
				dft.removeRow(0);
			}
			TableOrder current = new TableOrder(patron.TOTAL_ORDERS, new Employee(), patron.TABLE_ID);
			patron.net.sendOrderOnline(current);
			patron.historyTable.add(current);
			patron.removeAll();
			NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
			lCost.setText(nf.format(patron.TOTAL_COST));
			repaint();
		}
		
		public boolean addOrder(String name, String instr) {
			int code = 0;
			MenuItem t = null;
			for(MenuItem a : patron.items) {
				if(name.equals(a.STRING_ID)) {
					code = a.MENU_ID;
					t = a;
				}
			}
			if(t == null) {
				return false;
			}
			Order s = new Order(code, 1, "", 0);
			s.item = t;
			s.Order_ID = 0;
			s.Spc_Req = instr;
			boolean done = patron.Add_Order(s);
			NumberFormat nf = NumberFormat.getCurrencyInstance( java.util.Locale.US );
			String w = nf.format(patron.TOTAL_COST);
			for(int i = 0; i < patron.TOTAL_ORDERS.size(); i++) {
				tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).item.STRING_ID, i, 0);
				tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Spc_Req, i, 1);
				tableOfOrders.setValueAt(nf.format(patron.TOTAL_ORDERS.get(i).item.PRICE), i, 2);
				tableOfOrders.setValueAt(patron.TOTAL_ORDERS.get(i).Quantity, i, 3);
				tableOfOrders.setValueAt(nf.format(patron.TOTAL_ORDERS.get(i).Quantity * patron.TOTAL_ORDERS.get(i).item.PRICE), i, 4);
			}
			
			lCost.setText(w);
			repaint();
			return done;
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
						closeWindow();
						new LoginWindow();
				}
			if(a == bCallWaiter)
			{
				String[] options = {"Okay"};
				enable();
				JOptionPane.showOptionDialog(new JFrame(), "NOT YET IMPLEMENTED.", 
					"...", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
				disable();
			}
			if(a == bPlaceOrder)
				{
					enable();
					placeOrder();
					String[] options = {"Okay!"};
					JOptionPane.showOptionDialog(new JFrame(), "Your Order has been sent to the Kitchen!", 
						"Order Placed!!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
					disable();
				}
			if(a == bPayOrder)
				{
				enable();
				String[] options = {"Okay"};
				JOptionPane.showOptionDialog(new JFrame(), "NOT YET IMPLEMENTED.", 
					"...", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
				disable();
				}
			if(a == bToggleAR)
				{
					enable();
					int row = tableOfOrders.getSelectedRow();
					if(row == -1) {
						row = patron.TOTAL_ORDERS.size() - 1;
					}
					removeOrder(row);
					if(patron.TOTAL_ORDERS.isEmpty())
			    		bToggleAR.setVisible(false);
					disable();
				}
			if(a == timer && !dis_inter)
				{
					enable();
					updateClock();
					disable();
				}
			if(a == updateMenu && !dis_inter) {
				enable();
				pingDatabase();
				disable();
			}
			if(menuButtons != null) {
				for(int i = 0; i < menuButtons.size(); i++) {
					if(a == menuButtons.get(i)) {
						enable();
						String a1 = menuButtons.get(i).getText();
						a1 = a1.replaceAll("<html>", "");
						a1 = a1.replaceAll("</html>", "");
						a1 = a1.replaceAll("<br>", "");
						a1 = a1.substring(0, a1.length()-1);
						String instr = JOptionPane.showInputDialog("Let us know if you'd like your " + a1 + " prepared differently:");
						if(instr == null) {
							instr = "";
						}
						addOrder(a1, instr);
						tableOfOrders.repaint();
						disable();
					}
				}
			}
			if(a == bHelp) {
				enable();
				String message = "This is an interface that you can use to order food, just simply add items to your order by clicking the item in the menu on the right side.\nWhen you are finished you may press finish order and your food will be delivered.";
				String[] options = {"Okay!"};
					JOptionPane.showOptionDialog(new JFrame(), message, 
						"Need Help?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
				disable();
			}
		}
		@SuppressWarnings("deprecation")
		public void closeWindow() {
			if(note != null) {
				note.close();
			}
			patron.net.disconnect();
			this.dispose();
		}
		private void updateClock() {
            dateAndTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
        }
		public synchronized void enable() {
			dis_inter = true;
			timer.stop();
			updateMenu.stop();
		}
		public synchronized void disable() {
			dis_inter = false;
			timer.start();
			updateMenu.start();
		}
}
