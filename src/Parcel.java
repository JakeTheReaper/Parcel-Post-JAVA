/*
 * Name: Jake Duran Zerafa
 * Student ID: s3679109
 * 
 */
public class Parcel
{
   //Declare Variables
	String parcelNumber, senderName, recipientName, returnAddress;
	String deliveryAddress, contactNumber, satchelSize, trackingHistory = "";
	boolean deliveryComplete;
	
	//Create Constructor
	public Parcel(String parcelNumber, String senderName, String returnAddress,
			String recipientName, String deliveryAddress, String contactNumber)
	{
		this.parcelNumber = parcelNumber;
		this.senderName = senderName;
		this.returnAddress = returnAddress;
		this.recipientName = recipientName;
		this.deliveryAddress = deliveryAddress;
		this.contactNumber = contactNumber;
	}
	
	//Accessors
	public String getParcelNumber()
	{
		return parcelNumber;
	}
	
	public String getRecipientName()
	{
		return recipientName;
	}
	
	public String getDeliveryAddress()
	{
		return deliveryAddress;
	}
	
	public String getContactNumber()
	{
		return contactNumber;
	}
   
	//method to calculate postage cost based on the satchel size
	public int calculatePostageCost()
	{
		final int LARGEPOSTAGECOST = 17;
		final int MEDIUMPOSTAGECOST = 13;
		final int SMALLPOSTAGECOST = 10;
		final int TRACKINGFEE = 5;
		int totalPostageCost = 0;
		
		if (satchelSize.equalsIgnoreCase("Large"))
		{
			satchelSize = "Large";
			totalPostageCost = LARGEPOSTAGECOST + TRACKINGFEE;
		}
		else if (satchelSize.equalsIgnoreCase("Medium"))
		{
			satchelSize = "Medium";
			totalPostageCost = MEDIUMPOSTAGECOST + TRACKINGFEE;
		}
		else if (satchelSize.equalsIgnoreCase("Small"))
		{
			satchelSize = "Small";
			totalPostageCost = SMALLPOSTAGECOST + TRACKINGFEE;
		}
		return totalPostageCost;
	}
	
	//helper method to determine satchel size and return a postage cost
	public int selectSatchel(int parcelLength, int parcelWidth)
	{
		if (satchelSize != null)
		{
			return -1;
		}
		
		if (parcelLength <= 300 && parcelWidth <= 200)
		{
			satchelSize = "Small";
		}
		else if (parcelLength > 300 && parcelLength <= 400
				&& parcelWidth > 200 && parcelWidth <= 300)
		{
			satchelSize = "Medium";
		}
		else if (parcelLength > 400 && parcelLength <= 500
				&& parcelWidth > 300 && parcelWidth <= 400)
		{
			satchelSize = "Large";
		}
		else 
			return 0;
		
		return calculatePostageCost();
	}
	
	//helper method to update tracking history
	public boolean updateTrackingHistory(String dateTime, String location)
	{
		//check whether either condition is met.
		if (satchelSize == null || deliveryComplete == true)
		{
			return false;
		}
		//update tracking history 
		else 
		{
			trackingHistory = trackingHistory + "Date: " + dateTime + ", Location: " + location +"\n";
			return true;
		}
	}
	
	//helper method used to help with delivery completion
	public boolean completeDelivery(String dateTime, String signee)
	{
		if(satchelSize == null || deliveryComplete == true)
    	{
    		return false;
    	}
    	
    	else
    	{
    		trackingHistory = trackingHistory + "Delivered to " + deliveryAddress + " at " + dateTime + " (signed for by " + signee + ")";
    		deliveryComplete = true;
    		
    		return true;
    	}
	}
	
	//Method to print all the details
	public void printDetails()
	{
		System.out.println("Parcel Number: " + parcelNumber);
		System.out.println("Sender: " + senderName);
		System.out.println("Return Address: " + returnAddress);
		System.out.println("Recipient: " + recipientName);
		System.out.println("Delivery Address: " + deliveryAddress);
		System.out.println("Contact Number: " + contactNumber);
		System.out.println("Satchel Size: " + satchelSize);
		System.out.println("Delivery Complete: " + deliveryComplete);
		System.out.println("Tracking History: ");
		System.out.println(trackingHistory);
	
	}
	
}


