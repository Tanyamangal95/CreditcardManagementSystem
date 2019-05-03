package resources;

public class myQuries {
//Transaction Details 	
	//1	
	public final static String transByzip = "SELECT CC.*"
										  + "FROM CDW_SAPP_CREDITCARD CC INNER JOIN CDW_SAPP_CUSTOMER CS ON CS.SSN = CC.CUST_SSN "
										  + "WHERE  CS.CUST_ZIP = ? And CC.MONTH= ? AND CC.YEAR= ? ORDER BY CC.DAY DESC";
	//2	
	public final static String totalByType = "SELECT sum(transaction_value), count(*)" +
											"FROM CDW_SAPP_CREDITCARD " +
											"WHERE TRANSACTION_TYPE = ? " +
											"GROUP by TRANSACTION_TYPE;";
	//3	
	public final static String totalbyBranch = "SELECT SUM(transaction_value), count(*)" +
											    "FROM CDW_SAPP_CREDITCARD C JOIN CDW_SAPP_BRANCH B ON B.BRANCH_CODE=C.BRANCH_CODE" +
												" WHERE BRANCH_STATE = ?" +
												" GROUP by BRANCH_STATE";
//Customer Details 
	
	//1
	public final static String checkAccount = "SELECT * FROM CDW_SAPP_CUSTOMER WHERE SSN = ?;";
	
	//2
	public final static String updateCustomerinfo = "UPDATE CDW_SAPP_CUSTOMER SET %s=? WHERE SSN=?";
	
	//3
	public final static String monthlyBill = "SELECT *" + 
											 "FROM CDW_SAPP_CREDITCARD " + 
											 "WHERE CUST_SSN = ? AND MONTH =? AND YEAR =? " + 
											 "ORDER BY DAY";
	
	public final static String TotalMonthlyBill = "SELECT SUM(TRANSACTION_VALUE)"
												+ "FROM CDW_SAPP_CREDITCARD "
												+ "WHERE CUST_SSN =? AND MONTH =? AND YEAR =?;";
												
	public final static String Transbtween2dates = "SELECT YEAR, MONTH, DAY, TRANSACTION_TYPE, TRANSACTION_VALUE "
												 + "FROM CDW_SAPP_CREDITCARD "
												 + "WHERE cust_ssn =? "
												 + "AND str_to_date(CONCAT(YEAR ,\" \",MONTH,\" \",DAY),\"%Y%m%d\") >= ? "
												 + "AND str_to_date(CONCAT(YEAR ,\" \",MONTH,\" \",DAY),\"%Y%m%d \") <= ? "
												 + "ORDER BY MONTH DESC, DAY DESC, YEAR DESC;";
}
