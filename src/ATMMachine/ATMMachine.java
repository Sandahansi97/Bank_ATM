package ATMMachine;   //Bank_ATM - Project Name

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  // Importing the Scanner class for user input

public class ATMMachine {   // Main class ATMMachine 
	public static void main (String[] args) {
		
		ATM obj = new ATM();  // ATM = Sub class , object = variable, new = new keyword is used to create a 'new' instance [point] of a class  // Creating an instance of the ATM class
		obj.checkpin();      // Calling the checkpin method to validate user PIN and access the menu

	}
}

class ATM{   //Sub class ATM
	
	float Balance;  // Variable to store account balance
	int PIN = 5674;  // Predefined PIN for the ATM
    List<String> transactionHistory;  // declare transactionHistory
    
    public ATM() {
    	transactionHistory = new ArrayList<>();  // transactionHistory list eka initialize kragatha (TransactionHistory eke object ekk hadgtha )
    	
    }
	
	public void checkpin() {   // Method to check the entered PIN
		System.out.println("Enter your PIN:");     
		Scanner sc = new Scanner(System.in);    // scan the PIN which we have entered  // sc wenuwata oni ekk dana puluwan // new eken krnne new object ekk create krnwa // Creating a Scanner object to read user input
		int enteredpin = sc.nextInt();   // Reading the entered PIN
		
		
		if(enteredpin==PIN) {  // Checking if the entered PIN matches the predefined PIN
			menu();  // If PIN is correct, display the menu
		}
		else {
			System.out.println("Entered an Invalid PIN");   // If PIN is incorrect, display an error message
		}
        sc.close();   // Closing the Scanner object
		
	}
          // private , public access modifiers 
	     // protected   , 
	    //default -> public (access modifier ekak ethan nathnm package eka athule thiyena oni clz ekkt pennwa function)
	
	private void menu() {     // Method to display the ATM menu
		
		System.out.println("Enter your choice");
		System.out.println("1. Check A/C Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Change PIN");
		System.out.println("5. Transaction History");
		System.out.println("6. Exit");
		
		Scanner sc = new Scanner(System.in);  // Creating a new Scanner object for user input
		int opt = sc.nextInt();     // Reading the user's choice
		
//		if (opt == 1) {
//			checkBalance();          // we can use switch case function also 
//		}
//		else if(opt == 2) {
//			withdrawMoney();
//		}
//		else if (opt == 3) {
//			depositMoney();
//		}
//		else if (opt == 4) {
//			System.exit(0);
//		}
//		else {
//			System.out.println("Enter a valid choice");
//		}
		switch(opt) {   // Using switch statement to handle different menu options
		case 1:    // If user chooses 1
			checkBalance();    // Call checkBalance method
			break;   // Exit the switch statement
		case 2:   // If user chooses 2
			withdrawMoney();   // Call withdrawMoney method
			break;    //  Exit the switch statement
		case 3:   // If user chooses 3
			depositMoney();   // Call depositMoney method
			break;   // Exit the switch statement
		case 4:   // If user chooses 3
			changePIN();   // Call changePIN method
			break;   // Exit the switch statement
		case 5:   // If user chooses 3
			transactionHistory();   // Call changePIN method
			break;   // Exit the switch statement
		case 6:  // If user chooses 4
			System.exit(0); // Exit the program
			break;  // Exit the switch statement
		default: // If user enters an invalid choice
			System.out.println("Enter a valid choice");  // Display an error message
			menu();  // Redisplay the menu
			break;  // Exit the switch statement
		}
		sc.close();  // Closing the Scanner object
	}
	
	private void transactionHistory() {
		if(transactionHistory.isEmpty()) {
			System.out.println("No Transaction History Available");
			menu();
		
		} else {
			System.out.println("Transaction History: ");
			for (String s : transactionHistory) {
				System.out.println(s);
			}
		}
		menu();
	}
	
	private void changePIN() {    // Method to check and display the account balance 
		System.out.println("Plase enter your current PIN:   " );
		Scanner sc = new Scanner (System.in);
		int currentPIN = sc.nextInt();
		
		if(PIN==currentPIN) {
			System.out.println("Enter your new PIN:  "); 
			Scanner sc2 = new Scanner (System.in);
			int newPIN = sc2.nextInt();
			
			PIN = newPIN;
			System.out.println("Your PIN has updated");
			checkpin();
			sc2.close(); 
		}
		else {
			System.out.println("Invalid PIN");
			menu();
		}
		sc.close(); 
		
	}
	
	private void checkBalance() {    // Method to check and display the account balance 
		System.out.println("Balance: "+ Balance);   // +" "+ PIN  // Displaying the current balance
		menu();  // Returning to the menu
	}
	private void withdrawMoney() {   // Method to handle money withdrawal
		System.out.println("Enter amount to withdraw: ");  
		Scanner sc = new Scanner (System.in);  // we take an  input from user that's why we use scanner  // Creating a new Scanner object for user input
		float amount = sc.nextFloat();  // Reading the amount to withdraw
		
		
		if(amount>Balance) {  // Checking if there are sufficient funds
			System.out.println("Insufficient Balance");  // Display an error message if funds are insufficient
		}
		else {
			Balance = Balance - amount;  // Deduct the amount from the balance
			transactionHistory.add("Withdrew: " + amount );
			System.out.println("Money withdrawl Successful. Withdrawal Amount: " + amount ); // Display success message
        } 
		
		menu();  // Returning to the menu
		sc.close();  // Closing the Scanner object
	}
	
	private void depositMoney() {    // Method to handle money deposit
		System.out.println("Enter the Amount: ");   
		Scanner sc = new Scanner (System.in);  // Creating a new Scanner object for user input
		float amount = sc.nextFloat();  // Reading the amount to deposit
		Balance = Balance + amount;   // Adding the amount to the balance
		transactionHistory.add("Deposited: " + amount ); 
		System.out.println("Money Deposited Successfuly");  // Display success message
		
		menu();  // Returning to the menu
		sc.close();  // Closing the Scanner object
	}
	
}

/* public class ATMMachine {                   // main class ATMMachine 
	public static void main (String[] args) {
		
		ATM obj = new ATM();     // ATM = class eka, obj = vaiable, new = new keyword is used to create a 'new' instance [waarayak] of a class
		obj.checkpin();      // User should enter the pin to access the menu 	
	
	}
} */ 
