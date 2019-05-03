package runner;

import java.util.*;

import dao.TransactionDao;
import model.transaction;

public class Transaction_runnable {
	
	Scanner sc = new Scanner(System.in);
	
	public void gettransbyzip() throws Exception {
		
		boolean iszipcorrect= false, ismonth= false, isyear=false;
		
		while(!(iszipcorrect && ismonth && isyear)) {
			try {
				
			System.out.println("Enter Zip code: ");
			
			String zip = sc.next();
				
				if(zip.matches("[a-zA-Z]+") && zip.length() != 5){
					System.out.println("wrong zip");
					
				} else {
				
			System.out.println("Enter Month: Format(MM)");
				int month = sc.nextInt();
				
				
			System.out.println("Enter Year: Format(YYYY)");
			
				int year = sc.nextInt();


			TransactionDao tz= new TransactionDao();
	
			tz.gettransbyZip(zip, month, year);
			
			iszipcorrect= true;
			ismonth= true;
			isyear= true;
		}
	}catch(Exception e) {
		System.out.println("Invalid Input");
		sc.next();
		iszipcorrect= false;
		ismonth= false;
		isyear= false;
		
		
	}
}
		
}
 

public void getTotalByType(){	
	boolean istypecorrect= false;
	while(!(istypecorrect)) {
		try {
			System.out.println("Please enter transaction Type:");
		
			String type = sc.next();
		
			TransactionDao tt = new TransactionDao();
			transaction t= tt.gettotalbyType(type);
			
			System.out.println(String.format("%70s %18s", "Total Transactions", "Total Value:"));
			System.out.println(String.format("%100s","-----------------------------------------------------------"));
			System.out.println(String.format("%61s %25s", t.getCount(), t.getValue()));
			System.out.println(String.format("%100s","-----------------------------------------------------------"));
			istypecorrect =true;
			
		}catch(Exception e) {
			System.out.println("Try Again");
			sc.nextLine();
			istypecorrect= false;
		}
	}
}

public void getTotalBybranch(){
	boolean isBranchvalid = false;
	
	while(!isBranchvalid) {
		
		try {
			System.out.println("Enter the State of the Branch please: For Example Type NY for New York");
			String branch = sc.next();
	
			TransactionDao tb = new TransactionDao();
			transaction mytrans= tb.gettotalbyBranch(branch);
			
			System.out.println(String.format("%70s %18s","Total Transactions ", "Total Value"));
			System.out.println(String.format("%100s", "------------------------------------------------------------"));
			System.out.println( String.format("%65s %20s", mytrans.getValue(), mytrans.getCount()));
			System.out.println(String.format("%100s", "------------------------------------------------------------"));

			isBranchvalid = true;
			
		}catch(Exception e) {
				System.out.println("Wrong Input! Try Again! ");
					sc.nextLine();
					isBranchvalid = false;
			}
		}
	}
}
	

	

