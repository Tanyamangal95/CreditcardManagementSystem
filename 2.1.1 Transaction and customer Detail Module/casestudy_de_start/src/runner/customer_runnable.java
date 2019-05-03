package runner;

import java.util.Scanner;

import dao.CustomerDao;


public class customer_runnable {
	Scanner sc = new Scanner(System.in);

	public void getCustomerDetails() {
		boolean ssniscorrect = false;
		while (!ssniscorrect) {
			try {
		
				System.out.println("Enter SSN: ");
				int SSN = sc.nextInt();
			
				CustomerDao cd= new CustomerDao(); 
				cd.getCustomerDetails(SSN);
				ssniscorrect = true;
				
			}catch(Exception e) {
				
				System.out.println("Wrong Input! please try again!");
				System.out.println();
				sc.nextLine();
				ssniscorrect = false;
			}
		}
		
	}
	
	
	public void updateCustomerinfo() {
		boolean ssniscorrect = false;
		while (!ssniscorrect) {
			
			try {
				String[] columnChange = {"","FIRST_NAME","MIDDLE_NAME","LAST_NAME","SSN","CREDIT_CARD_NO", "APT_NO",
									"STREET_NAME", "CUST_CITY" ,"CUST_STATE", "CUST_COUNTRY", "CUST_ZIP" , "CUST_PHONE","CUST_EMAIL"};
				String change = "";
			
			
				System.out.println("Enter SSN: ");
				int ssn = sc.nextInt();
			
				CustomerDao display = new CustomerDao();
			
				display.getCustomerDetails(ssn);
			
				int pick = 0;
			
					while(pick!=12) {
						System.out.println("What would you like to update?");
						System.out.println("1. FirstName \n" + "2. Middle Name \n" + "3. Last Name \n" + "4. Apt no \n" + "5. Street Name \n" + "6. City \n"
									+ "7. State \n" + "8. Country \n" + "9. Zip code \n" + "10. Phone Number \n" + "11. Email \n"
									+ "12. Return to Main Menu");
						pick = sc.nextInt();
						String columnName = columnChange[pick];
			
							switch(pick) {
							case 1:
								System.out.println("Enter First Name: ");
								change = sc.next();
								break;
							case 2:
								System.out.println("Enter Middle Name: ");
								change =sc.next();
								break;
							case 3:
								System.out.println("Enter Last Name: ");
								change =sc.next();
								break;
							case 4:
								System.out.println("Enter Apt No: ");
								change =sc.next();
								break;
							case 5:
								System.out.println("Enter Street Name: ");
								change =sc.next();
								break;
							case 6:
								System.out.println("Enter City: ");
								change =sc.next();
								break;
							case 7:
								System.out.println("Enter State: ");
								change =sc.next();
								break;
							case 8:
								System.out.println("Enter Country: ");
								change =sc.next();
								break;
							case 9:
								System.out.println("Enter Zip Code: ");
								change =sc.next();
								break;
							case 10:
								System.out.println("Enter Phone Number: ");
								change =sc.next();
								break;
							case 11:
								System.out.println("Enter Email: ");
								change =sc.next();
								break;
							case 12:
								System.out.println("Returning.......");
								continue;
							}
		
					
						CustomerDao ci = new CustomerDao();
						ci.UpdateCustomerDetail(columnName, change, ssn);
						
						}
					ssniscorrect = true;
					
				}catch(Exception e) {
					System.out.println("Wrong Input! Please try again");
					System.out.println(" ");
					sc.nextLine();
					ssniscorrect = false;
				}
		}
		
	}
	
	public void getTotalmonthlybill() {
		boolean ssniscorrect = false, monthiscorrect= false, yeariscorrect = false;
		while(!(ssniscorrect && monthiscorrect && yeariscorrect)) {
			try {
				System.out.println("Enter SSN: ");
				int ssn = sc.nextInt();
				System.out.println("Enter Month: Format(MM)");
				int month = sc.nextInt();
				System.out.println("Enter Year: Format(YYYY)");
				int year = sc.nextInt();
				
				CustomerDao ct = new CustomerDao();
				ct.getMonthlyBill(ssn, month, year);
				
				System.out.println("--------------------------");
				ct.getTotalMonthlyBill(ssn, month, year);
				System.out.println("--------------------------" );
				
				ssniscorrect = true;
				monthiscorrect=true;
				yeariscorrect=true;
				
			}catch(Exception e) {
				System.out.println("Wrong Input! Try Again");
				System.out.println();
				sc.next();
				ssniscorrect = false;
				monthiscorrect=false;
				yeariscorrect= false;
			}
		}
	}
	
	public void getTransBwDates(){
		boolean ssniscorrect = false, date1isValid = false, date2isValid = false;
		
		while(!(ssniscorrect && date1isValid && date2isValid)) {
			try {
				System.out.println("");
				System.out.println("Enter SSN: ");
				int ssn = sc.nextInt();
				
				System.out.println("Enter the Start Date: Format YYYY/MM/DD");
				String date1 = sc.next();
	
				System.out.println("Enter the End Date: Format YYYY/MM/DD");
				String date2 = sc.next();
				CustomerDao tbd = new CustomerDao();
				
				if(tbd.dateisvalid(date1) && tbd.dateisvalid(date2)) {
						date1.replaceAll("/", "");
						date2.replaceAll("/", "");
					
						tbd.gettransbwdates(ssn, date1, date2);
						ssniscorrect = true; 
						date1isValid = true; 
						date2isValid = true;
				}else {
					
					System.out.print("Invalid Date Format");
				
				}
				
			}catch(Exception e) {
				
				System.out.println("Wrong Input! Try Again!");
				System.out.println("");
				sc.nextLine();
				
				ssniscorrect = false;
				date1isValid = false;
				date2isValid = false;
			}
		}
	}
}

