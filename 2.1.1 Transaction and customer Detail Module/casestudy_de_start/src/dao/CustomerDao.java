package dao;

import java.text.*;
import java.util.Date;

import model.customer;
import model.transaction;
import resources.myQuries;

public class CustomerDao extends dbconnection_abstract {
	
	public void  getCustomerDetails(int ssn) throws Exception {
	
	myconnection();
		
	ps = con.prepareStatement(myQuries.checkAccount);
	ps.setInt(1, ssn);
	rs = ps.executeQuery();
	
	customer cd = new customer();
	
	if(rs.next()) {
		do {
		cd.setFname(rs.getString("FIRST_NAME"));
		cd.setLname(rs.getString("LAST_NAME"));
		cd.setMidname(rs.getString("MIDDLE_NAME"));
		cd.setSsn(rs.getInt("SSN"));
		cd.setCreditcard(rs.getString("CREDIT_CARD_NO"));
		cd.setState(rs.getString("CUST_STATE"));
		cd.setApt_no(rs.getInt("APT_NO"));
		cd.setStreet(rs.getString("STREET_NAME"));
		cd.setCity(rs.getString("CUST_CITY"));
		cd.setCountry(rs.getString("CUST_COUNTRY"));
		cd.setZip(rs.getString("CUST_ZIP"));
		cd.setPhone(rs.getInt("CUST_PHONE"));
		cd.setEmail(rs.getString("CUST_EMAIL"));
		
		System.out.println(String.format("%41s %15s %25s %30s %30s %13s %13s", "Name", "SSN", "Credit Card No", "Address", "Country", "Phone", "Email"));
		System.out.println(String.format("%185s", "------------------------------------------------------------------------------------------------------------------------------------------------------------"));
		System.out.println(String.format("%35s %3s %3s %12s %22s %7s %3s %13s, %2s %5s %18s %10s %20s", cd.getFname(), cd.getMidname(), cd.getLname(), cd.getSsn(), cd.getCreditcard(), cd.getApt_no(), cd.getStreet(), cd.getCity(),cd.getState(),cd.getZip(),cd.getCountry(), cd.getPhone(),cd.getEmail()));
		
		}while(rs.next());
		
	}else {
		
		System.out.println("SSN doesnt exist!");
	}
	
			
}

	
	
	
	public void UpdateCustomerDetail(String columnName, String change, int ssn)throws Exception{
		int changed;
		try {
		myconnection();
		String format = String.format(myQuries.updateCustomerinfo, columnName);
		ps = con.prepareStatement(format);
		ps.setString(1, change);
		ps.setInt(2, ssn);
		changed=ps.executeUpdate();
		
		}catch(Exception e) {
			changed=0;
			e.printStackTrace();
		}
		
		if (changed < 1) {
			System.out.println("Error in making a change. No changes were made!");
			
		} else {
			
			getCustomerDetails(ssn);
		}
		
	}
		 
	
	public void getMonthlyBill(int ssn, int month, int year) throws Exception{
		myconnection();
		ps=con.prepareStatement(myQuries.monthlyBill);
		ps.setInt(1, ssn);
		ps.setInt(2, month);
		ps.setInt(3, year);
		rs=ps.executeQuery();
		
		customer mb = new customer();
		transaction mbt = new transaction();
		
		while(rs.next()) {
			mb.setDay(rs.getInt("DAY"));
			mb.setMonth(rs.getInt("MONTH"));
			mb.setYear(rs.getInt("YEAR"));
			mbt.setType(rs.getString("Transaction_type"));
			mbt.setValue(rs.getDouble("Transaction_value"));
			
			System.out.println();
			System.out.println("Date : " + mb.getMonth() + "/" + mb.getDay() + "/" + mb.getYear());
			System.out.println("Type : " + mbt.getType());
			System.out.println("Value: " + mbt.getValue());
			
			System.out.println();
		}
	}
		
	public void getTotalMonthlyBill(int ssn, int month, int year) throws Exception{
		myconnection();
		transaction mbt2 = new transaction();
		ps=con.prepareStatement(myQuries.TotalMonthlyBill);
		ps.setInt(1, ssn);
		ps.setInt(2, month);
		ps.setInt(3, year);
		rs=ps.executeQuery();
		
		if(rs.next()) {
			mbt2.setValue(rs.getDouble(1));
		}
		 System.out.println("Total : " + mbt2.getValue());
		
	}
	
	
	public void gettransbwdates(int ssn, String date1, String date2) throws Exception{
		myconnection();
		ps=con.prepareStatement(myQuries.Transbtween2dates);
		ps.setInt(1, ssn);
		ps.setString(2, date1);
		ps.setString(3, date2);
		rs=ps.executeQuery();
		
		transaction td = new transaction();
		
		while(rs.next()) {
			td.setDay(rs.getInt("DAY"));
			td.setMonth(rs.getInt("MONTH"));
			td.setYear(rs.getInt("YEAR"));
			td.setValue(rs.getDouble("TRANSACTION_VALUE"));
			td.setType(rs.getString("TRANSACTION_TYPE"));
			
			System.out.println();
			System.out.println("Date: " + td.getMonth()+"/"+td.getDay()+"/"+td.getYear());
			System.out.println("Transaction Type: " + td.getType());
			System.out.println("Transaction Value: " + td.getValue());
			System.out.println("----------------------------------------");
			
		}
		
		
	}
	
	
	 public boolean dateisvalid(String date) {
	
		if (date.trim().equals("")){
		    return true;

		}else{
		   
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/MM/dd");
		    sdfrmt.setLenient(false);
		   
		    try{
		        sdfrmt.parse(date); 
		        
		       
		    }catch (ParseException e){
		        
		        return false;
		    }
		    
		    return true;
			}
	   }

		
		
}



