package runner;

import java.util.Scanner;

public class Main  {
	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner(System.in);
		customer_runnable c = new customer_runnable();
		Transaction_runnable t = new Transaction_runnable();
		System.out.println(String.format("%80s","CREDIT CARD MANAGEMENT SYSTEM"));
		System.out.println(String.format("%100s","----------------------------------------------------------------"));
		System.out.println("");
		System.out.println(String.format("%80s","Welcome! Please make a choice:"));
			int pick =0;
					while(pick != 7) {
						Menu();
						pick= reader.nextInt();
						switch(pick) {
						case 1: 
							t.gettransbyzip();
							break;
						case 2:
							t.getTotalByType();
							break;
						case 3: 
							t.getTotalBybranch();
							break;
						case 4:
							c.getCustomerDetails();
							break;
						case 5:
							c.updateCustomerinfo();
							break;
						case 6:
							c.getTotalmonthlybill();
							break;
						case 7: 
							c.getTransBwDates();
							break;
						}
						
					}
			
			reader.close();
	}

	
	
	public static void Menu() {
		System.out.println(" \n");
		System.out.println(String.format("%80s", "1. Transaction details by zipCode"));
		System.out.println(String.format("%102s", "2. Total number and total value of transaction by type "));
		System.out.println(String.format("%103s", "3. Total number and total value of transaction By branch"));
		System.out.println(String.format("%66s", "4. Customer details"));
		System.out.println(String.format("%73s", "5. Modify customer details"));
		System.out.println(String.format("%115s", "6. Monthly bill for a credit card number for a given month and year."));
		System.out.println(String.format("%99s", "7. Transactions made by a customer between two dates"));
		
		
	}
		
	
}
		

