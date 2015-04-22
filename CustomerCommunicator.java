package Customer;
import Shared.ADT.MenuItem;
import Shared.ADT.Order;
import Shared.ADT.TableOrder;
import Shared.Communicator.DatabaseCommunicator;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class CustomerCommunicator extends DatabaseCommunicator {

	public static int counter;
	public ArrayList<MenuItem> readMenu() throws SQLException {
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		boolean online = this.isOnline();
		if(online) {
			this.connect("admin", "gradMay17");
			this.tell("use MAINDB;");
			ResultSet rs = this.tell("SELECT * FROM MENU;");
		
			items = new ArrayList<MenuItem>();
			rs.beforeFirst();
			while(rs.next() == true) {
				int MENU_ID = rs.getInt("MENU_ID");
				String STRING_ID = rs.getString("ITEM_NAME");
				double PRICE = rs.getDouble("PRICE");
				PRICE = PRICE + 0.00;
				String DESCRIPTION = rs.getString("DESCRIPTION");
				String section = rs.getString("MENU_SECTION");
				boolean valid = rs.getInt("VALID") == 1 ? true : false;
				MenuItem cur = new MenuItem(0);
				cur.MENU_ID = MENU_ID;
				cur.STRING_ID = STRING_ID;
				cur.PRICE = PRICE;
				cur.DESCRIPTION = DESCRIPTION;
				cur.section = section;
				cur.VALID = valid;
				if(rs.getBoolean("VALID")) {
					items.add(cur);
				}
			}
		}
		this.disconnect();
		return items;
	}
	public void init() throws SQLException {
		
	}
	public void sendOrderOnline(TableOrder e) {
		String template ="INSERT INTO TABLE_ORDER (ORDER_ID, TABLE_ID, EMPLOYEE_ID, ITEM_NAME, PRICE, QUANTITY, SPEC_INSTR, CURRENT_STATUS, MENU_ITEM_ID, SEAT_NUMBER) values (";
		String command = "" + template;
		this.connect("admin", "gradMay17");
		this.tell("use MAINDB;");
		int size = e.FullTableOrder.size();
		int n = 0;
		for(int i = 0; i < size; i++) {
			Order a = e.FullTableOrder.peek();
			command += counter + ", ";
			command += e.TABLE_ID + ", ";
			command += 0 + ", ";
			command += "\"" + a.item.STRING_ID + "\", ";
			command += a.item.PRICE + ", ";
			command += a.Quantity + ", ";
			command += "\"" + a.Spc_Req + "\", ";
			command += "\"NOT READY\", ";
			command += a.item.MENU_ID + ", ";
			command += n%6 + ")";
			update(command);
			command = "" + template;
			e.FullTableOrder.remove();
			n++;
		}
		disconnect();
	}
	
	public boolean isOnline() {
		try
		{
			URL yourl = new URL("http://google.com");
			HttpURLConnection yourlConnect = (HttpURLConnection)yourl.openConnection();
			yourlConnect.setConnectTimeout(2000);
			yourlConnect.getContent();
		}catch(UnknownHostException e)
		{
			return false;
		}
		catch(IOException e)
		{
			return false;
		}
		return true;
	}
	
	public boolean pushTableOrder(TableOrder e) {
		boolean successful = false;
		/*
		 * 
		 */
		return successful;
	}
}
