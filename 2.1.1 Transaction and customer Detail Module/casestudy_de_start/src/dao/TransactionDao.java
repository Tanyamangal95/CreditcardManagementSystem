package dao;

import model.transaction;
import resources.myQuries;

public class TransactionDao extends dbconnection_abstract {
	
	public void  gettransbyZip (String zip, int month, int year) throws Exception {
		myconnection();
		ps = con.prepareStatement(myQuries.transByzip);
		ps.setString(1, zip);
		ps.setInt(2, month);
		ps.setInt(3, year);
		rs = ps.executeQuery();
		
	
		transaction tz = new transaction();
		
		
		System.out.println(String.format("%38s %18s %9s %15s %20s %20s", "Date", "Card Number", "SSN", "Branch Code", "Transaction Type","Transaction Value"));
		System.out.println(String.format("%130s","-----------------------------------------------------------------------------------------------------------"));
			if(rs.next()) {
				do {
		        	tz.setDay(rs.getInt("Day"));
		        	tz.setMonth(rs.getInt("MONTH"));
		        	tz.setYear(rs.getInt("YEAR"));
		        	tz.setCardNo(rs.getString("CREDIT_CARD_NO"));
		        	tz.setSsn(rs.getInt("CUST_SSN"));
		        	tz.setBranchCode(rs.getInt("BRANCH_CODE"));
		        	tz.setType(rs.getString("TRANSACTION_TYPE"));
		        	tz.setValue(rs.getDouble("TRANSACTION_VALUE"));
		    		
		    		System.out.println(String.format("%40s %18s %10s %8s %20s %15s", tz.getMonth()+"/"+ tz.getDay()+"/"+ tz.getYear(),tz.getCardNo(), tz.getSsn(),tz.getBranchCode(),tz.getType(),tz.getValue()));
		    		System.out.println("");
		    		
				}while(rs.next());
			
			}else {
				
				System.out.println(String.format("%100s", "Input doesnt match our records! please try again!"));
			}
		    
			System.out.println(String.format("%130s","-----------------------------------------------------------------------------------------------------------"));
	} 
	
	
	
	public transaction gettotalbyType(String type) throws Exception {
		myconnection();
		ps = con.prepareStatement(myQuries.totalByType);
		ps.setString(1, type);
		rs = ps.executeQuery();
		transaction t = new transaction();
		
		if(rs.next()) {
			
			t.setValue(rs.getDouble(1));
			t.setCount(rs.getInt(2));
			return t;
			
		}else {
			
			System.out.println("Type doesnt Exist!");
		}
		
		return null;
	}
	
	
	public transaction gettotalbyBranch(String Branch)throws Exception{
		myconnection();
		ps = con.prepareStatement(myQuries.totalbyBranch);
		ps.setString(1, Branch);
		rs = ps.executeQuery();
		transaction b = new transaction();
		
		if(rs.next()) {
			b.setValue(rs.getDouble(1));
			b.setCount(rs.getInt(2));
			return b;
		}
		
		return null;
	}
		
}
	
	
