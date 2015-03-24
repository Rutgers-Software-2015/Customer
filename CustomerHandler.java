package Handlers;
import java.util.LinkedList;
import java.util.Queue;

import ADT.*;

/**
 * 
 * @author Bolt
 *
 */

public class CustomerHandler {
	
	private int TABLE_ID; //Which table the customers are sitting.
	private int CUSTOMER_COUNT; //The amount of customers sitting at the table.
	private int TABLE_STATUS; //Current status of the table. 
	public double TOTAL_COST; //The total cost of all the menu items in TOTAL ORDER.
	public LinkedList<Order> TOTAL_ORDERS; //Queue of all the orders placed by the customer.
	private boolean TABLE_OCCUPANCY; //TRUE if there is at least one customer as this table, and FALSE if the table is vacant.
	private Employee waiter;
	
	public CustomerHandler(int TABLE_ID) {
		this.TABLE_ID = TABLE_ID;
		TOTAL_ORDERS = new LinkedList<Order>();
	}
	
	public void setNumberCustomers(int n) {
		this.CUSTOMER_COUNT = n;
	}
	
	/*
	 * This creates an Order object given 3 parameters, 
	 * and returns it the system.
	 * 
	 */
	public TableOrder Place_Order(int MENU_ID) {
		/*
		 * mySQL statement to get an available employee
		 */
		TableOrder temp = new TableOrder(TOTAL_ORDERS, new Employee(0), TABLE_ID);
		return temp;
	}
	
	/*
	 * This function adds an order to the TOTAL ORDER queue, 
	 * and updates the TOTAL COST field. Returns TRUE if successful.
	 */
	public boolean Add_Order(Order n) {
		if(n != null) {
			TOTAL_ORDERS.add(n);
			TOTAL_COST += n.item.PRICE * n.Quantity;
			return true;
		}
		return false;
	}
	
	/*
	 * This function removes a certain Order from the TOTAL ORDER queue, 
	 * and readjusts the TOTAL COST field. Returns TRUE if successful.
	 */
	public boolean Remove_Order(int ORDER_ID) {
		Order temp;
		double cost = 0;
		boolean found = false;
		LinkedList<Order> other = new LinkedList<Order>();
		for(int i = 0; i < TOTAL_ORDERS.size(); i++) {
			temp = TOTAL_ORDERS.get(i);
			cost = temp.item.PRICE * temp.Quantity;
			if(temp.Order_ID == ORDER_ID) {
				TOTAL_ORDERS.remove(i);
				TOTAL_COST -= cost;
				found = true;
			}
		}
		return found;
	}
	
	/*
	 * This function confirms the TOTAL ORDER and TOTAL COST and sends the information to the 
	 * Kitchen and Waiting staff. Returns TRUE if successful.
	 */
	public boolean ConfirmOrder() {
		/*
		 *  mySQL statement
		 */
		return false;
	}
	
	/*
	 * This function notifies a waiter on duty that the customer would 
	 * like their bill. Returns TRUE if a waiter can be notified.
	 */
	public boolean Pay_Bill() {
		/*
		 *  mySQL statement
		 */
		return false;
	}

	/*
	 * This function gives an option to split the bill, and customize 
	 * the TOTAL ORDER. Returns TRUE if it is successful.
	 */
	public boolean Split_Bill() {
		/*
		 *  mySQL statement
		 */
		return false;
	}
	
	/*
	 * This function calls the waiter to the table. Returns TRUE if successful.
	 */
	public boolean Call_Waiter() {
		/*
		 *  mySQL statement
		 */
		return false;
	}
}
