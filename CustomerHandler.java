package Customer;
import java.util.LinkedList;
import java.util.Queue;

import ADT.*;

/**
 * 
 * @author Bolt
 *
 */

public class CustomerHandler {
	
	public int TABLE_ID; //Which table the customers are sitting.
	public int CUSTOMER_COUNT; //The amount of customers sitting at the table.
	public int TABLE_STATUS; //Current status of the table. 
	public double TOTAL_COST; //The total cost of all the menu items in TOTAL ORDER.
	public LinkedList<Order> TOTAL_ORDERS; //Queue of all the orders placed by the customer.
	public boolean TABLE_OCCUPANCY; //TRUE if there is at least one customer as this table, and FALSE if the table is vacant.
	public int TOTAL_QUANTITY;
	public Employee waiter;
	
	public CustomerHandler(int TABLE_ID) {
		this.TABLE_ID = TABLE_ID;
		TOTAL_ORDERS = new LinkedList<Order>();
		TOTAL_QUANTITY = 0;
	}
	
	public void setNumberCustomers(int n) {
		this.CUSTOMER_COUNT = n;
	}
	
	/*
	 * This creates an Order object given 3 parameters, 
	 * and returns it the system.
	 * 
	 */
	public TableOrder Place_Order() {
		/*
		 * mySQL statement to get an available employee
		 */
		TableOrder temp = new TableOrder(TOTAL_ORDERS, new Employee(), TABLE_ID);
		TOTAL_ORDERS.clear();
		TOTAL_QUANTITY = 0;
		TOTAL_COST = 0;
		return temp;
	}
	
	/*
	 * This function adds an order to the TOTAL ORDER queue, 
	 * and updates the TOTAL COST field. Returns TRUE if successful.
	 */
	public boolean Add_Order(Order n) {
		boolean inside = false;
		for(int i = 0; i < TOTAL_ORDERS.size(); i++) {
			if(n.item.MENU_ID == TOTAL_ORDERS.get(i).item.MENU_ID) {
				TOTAL_ORDERS.get(i).Quantity++;
				TOTAL_COST += n.item.PRICE;
				updateCount();
				return true;
			}
		}
		if(n != null && !inside) {
			TOTAL_ORDERS.add(n);
			TOTAL_COST += n.item.PRICE;
			updateCount();
			return true;
		}
		return false;
	}
	
	private void updateCount() {
		TOTAL_QUANTITY = 0;
		for(int i = 0; i < TOTAL_ORDERS.size(); i++){
			TOTAL_QUANTITY += TOTAL_ORDERS.get(i).Quantity;
		}
	}

	/*
	 * This function removes a certain Order from the TOTAL ORDER queue, 
	 * and readjusts the TOTAL COST field. Returns TRUE if successful.
	 */
	public boolean Remove_Order(int MENU_ID) {
		Order temp;
		double cost = 0;
		boolean found = false;
		LinkedList<Order> other = new LinkedList<Order>();
		for(int i = 0; i < TOTAL_ORDERS.size(); i++) {
			temp = TOTAL_ORDERS.get(i);
			cost = temp.item.PRICE;
			if(temp.item.MENU_ID == MENU_ID) {
				if(temp.Quantity > 1) {
					temp.Quantity -= 1;
				} else {
					TOTAL_ORDERS.remove(i);
					found = true;
				}
				updateCount();
				TOTAL_COST -= cost;
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
