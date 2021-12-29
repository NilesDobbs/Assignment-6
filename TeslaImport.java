package assignmentSix;

import java.time.YearMonth;

public class TeslaImport {
	private YearMonth date;
	private Integer sales;

	public TeslaImport(YearMonth date, Integer sales) {
		this.date = date;
		this.sales = sales;
	}
	
	/* Create a toString Print out the date and sales data. 
	This will be used in the Tesla Data */
	public String toString() {
		return date + " " + sales;
	}
	
	//Create a getter and setter for Date() 
	public YearMonth getDate() {
		return date;
	}

	public void YearMonth(YearMonth date) {
		this.date = date;
	}
	
	//Create a getter and setter for Sales() 
	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}
}
