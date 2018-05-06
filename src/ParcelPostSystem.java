/*
 * Name: Jake Duran Zerafa
 * Student ID: s3679109
 * 
 */

import java.util.Scanner;

public class ParcelPostSystem
{
   // create a Scanner
   private static Scanner sc = new Scanner(System.in);

   // declare Parcel array and parcel count variable
   private static Parcel[] parcels = new Parcel[10];
   private static int parcelCount = 0;

   public static void main(String[] args)
   {

      String selection;

      do
      {

         // display menu options
         System.out.println("   ***** Parcel Post System Menu *****");
         System.out.println("A. Add New Parcel");
         System.out.println("B. Display All Parcels");
         System.out.println("C. View Delivery Details");
         System.out.println("D. Select Satchel");
         System.out.println("E. Update Tracking History");
         System.out.println("F. Complete Delivery");
         System.out.println("X. Exit the program");
         System.out.println();

         // prompt user to enter selection
         System.out.print("Enter selection: ");
         selection = sc.nextLine();

         System.out.println();

         // validate selection input length
         if (selection.length() != 1)
         {
            System.out.println("Error - invalid selection!");
         }
         else
         {

            // process user's selection
            switch (selection.toUpperCase())
            {
               case "A":
                  addNewParcel();
                  break;

               case "B":
                  displayAllParcels();
                  break;

               case "C":
                  viewDeliveryDetails();
                  break;

               case "D":
                  selectSatchel();
                  break;

               case "E":
                  updateTrackingHistory();
                  break;

               case "F":
                  completeDelivery();
                  break;

               case "X":
                  System.out.println("Exiting the program...");
                  break;

               default:
                  System.out.println("Error - invalid selection!");
            }
         }
         System.out.println();

      } while (!selection.equalsIgnoreCase("X"));
   }

   private static void addNewParcel() 
   {
   		
   		System.out.println("Add New Parcel Feature");
   		System.out.println();

      Scanner details = new Scanner(System.in);
      
      //Get user input
      System.out.print("Enter a Parcel Number: ");
      String parcelNumber = details.nextLine();
      System.out.print("Enter the Senders Name: ");
      String senderName = details.nextLine();
      System.out.print("Enter a Return Address: ");
      String returnAddress = details.nextLine();
      System.out.print("Enter the Recipients Name: ");
      String recipientName = details.nextLine();
      System.out.print("Enter the Delivery Address: ");
      String deliveryAddress = details.nextLine();
      System.out.print("Enter a Contact Number: ");
      String contactNumber = details.nextLine();
      
      //create new parcel using Parcel constructor
      parcels[parcelCount] = new Parcel(parcelNumber, senderName, returnAddress,
   			recipientName, deliveryAddress, contactNumber);
      parcelCount++;
      
      for (int i = 0; i < parcelCount ; i++)
      {
      		parcelNumber = parcels[i].getParcelNumber();	
      }  	   
   }

   private static void displayAllParcels()
   {
      System.out.println("Display All Parcels Feature");
      System.out.println();
      
      //iterate through array and display all parcels
      for (int i = 0; i < parcelCount ; i++)
      {
      		parcels[i].printDetails();	
      }
   }

   private static void viewDeliveryDetails()
   {
      System.out.println("Viewing Delivery Details Feature");
      System.out.println();

      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter a Parcel Number: ");
      String parcelNumber = input.nextLine();
      
      //create temp variable
      Parcel temp = null;
      
      //iterate through array and assign to temp variable if a match is found
      for (int i = 0; i < parcelCount ; i++)
      {
      		if (parcels[i].getParcelNumber().equals(parcelNumber))
      		{
      			temp = parcels[i];
      		}
      }
      		if (temp == null)
      		{
      			System.out.println("Error!! Specified parcel wasn't found");
      		}
      		else
      		{
      			//Display accessor details for matching parcel
      			System.out.println("Matching Parcel Found");
      			System.out.println("Parcel Number: " + temp.getParcelNumber());
      			System.out.println("Recipient Name: " + temp.getRecipientName());
      			System.out.println("Delivery Address: " + temp.getDeliveryAddress());
      			System.out.println("Contact Number: " + temp.getContactNumber());
      		}	
   }

   private static void selectSatchel()
   {
      System.out.println("Select Satchel Feature");
      System.out.println();

      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter a Parcel Number: ");
      String parcelNumber = input.nextLine();
      
      //create a temp variable
      Parcel temp = null;
      
      //iterate through array and assign to temp variable if a match is found
      for (int i = 0; i < parcelCount; i++)
      {
      		if (parcels[i].getParcelNumber().equals(parcelNumber))
      		{
      			temp = parcels[i];
      		}
      }
      if (temp == null)
		{
			System.out.println("Error!! Specified parcel wasn't found");
		}
      else
      {
      		//get user input 
      		System.out.print("Enter Parcel Length: ");
      		int length = input.nextInt();
      		System.out.print("Enter Parcel Width: ");
   			int width = input.nextInt();
      			 
      		if (temp.selectSatchel(length, width) == -1)
      		{
      			System.out.println("A satchel size has already been selected for this parcel");
      		}
      		else if (temp.selectSatchel(length, width) == 0)
      		{
      			System.out.println("The parcel dimensions are too large to deliver in a satchel");
   			}
      		else
      		{
     			//Display postage costs and satchel size
      			System.out.println();
      			System.out.println("Satchel Size: " + temp.satchelSize);
      			System.out.println("Total Postage Cost: $" + temp.calculatePostageCost());
      		}			
      }
   }

   private static void updateTrackingHistory()
   {
      System.out.println("Update Tracking History Feature");
      System.out.println();

      //create scanner
      Scanner input = new Scanner(System.in);
      
      //Assign temp variable to null
      Parcel temp = null;
      
      //get user input
      System.out.print("Enter a Parcel Number: ");
      String parcelNumber = input.nextLine();
      
      //iterate through array and assign to temp variable if a match is found
      for (int i = 0; i < parcelCount; i++)
      {
      		if (parcels[i].getParcelNumber().equals(parcelNumber))
      		{
      			temp = parcels[i];
      		}
      }
      
      if (temp == null)
		{
			System.out.println("Error!! Specified parcel wasn't found");
		}
      else
      {
      		//get user input and update tracking history
      		System.out.print("Enter Time / Date: ");
      		String timeDate = input.nextLine();
      		System.out.print("Enter Location: ");
   			String location = input.nextLine();
      			 
      		if (temp.updateTrackingHistory(timeDate, location) == false)
      		{
      			System.out.println("Cannot update the tracking history for this parcel");
      		}
      		else
      		{		
      			System.out.println("Tracking Information update for parcel: " + parcelNumber);
      		}
      }
   }
      		
   //
   private static void completeDelivery()
   {
      System.out.println("Complete Delivery Feature");
      System.out.println();
      
      Scanner input = new Scanner(System.in);
      
      //create temp variable
      Parcel temp = null;
      
      System.out.print("Enter a Parcel Number: ");
      String parcelNumber = input.nextLine();
      
      //iterate through array and assign to temp variable if a match is found
      for (int i = 0; i < parcelCount; i++)
      {
      		if (parcels[i].getParcelNumber().equals(parcelNumber))
      		{
      			temp = parcels[i];
      		}
      }
      
      if (temp == null)
		{
			System.out.println("Error!! Specified parcel wasn't found");
		}
      else
      {
      		//get user input and update delivery details
      		System.out.print("Enter Time / Date: ");
      		String timeDate = input.nextLine();
      		System.out.print("Enter Signee: ");
   			String signee = input.nextLine();
      			 
      		if (temp.completeDelivery(timeDate, signee) == false)
      		{
      			System.out.println("Delivery cannot be completed for this parcel");
      		}
      		else
      		{		
      			System.out.println("Delivery completed for Parcel Number: " + parcelNumber);
      		}
      }
   }
}
