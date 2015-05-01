*****************************************************
****************** Customer Folder ******************
*****************************************************
Contents of this folder:
> CustomerCommunicator.java
> CustomerGUI.java
> CustomerHandler.java

		   		 CustomerGUI.java
						||
						|| (contains)
						||
						\/
				CustomerHandler.java
						||
			  			|| (contains)
			  			||
			  			\/
	 		 CustomerCommunicator.java
			
*The CustomerGUI contains an instance of
 CustomerHandler which contains an instance of
 CustomerCommunicator.