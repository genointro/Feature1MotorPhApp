/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hw2motorphapp;

/**
 *
 * @author Administrator
 */
public class Hw2motorPhApp {

        public static void main(String arg[]){
		
		//objects
		EmployeeInfo staffInfo = new EmployeeInfo(123, "String", "String");
		WeekHours arrayHrs = new WeekHours(123, 123, 123, 123);
		NetWage deduct = new NetWage(123, 123, 123, 123);
		
		/*input Employee Info*/
		staffInfo.setBirthDay();		
		staffInfo.setIdNumber();
		staffInfo.setEmployeeName();
		
		
		//input Time In, Time out and calculates total hrs for the week. 
		arrayHrs.setWkHrs();
		arrayHrs.getWkHrs();
		arrayHrs.setPrHr();
		System.out.println("");

		//calculates the necessary deductions, using the value from the getGrossWk() method from WeekHours class.
		deduct.getSSS(arrayHrs.getGrossWk());
		deduct.getPhilHealth(arrayHrs.getGrossWk());
		deduct.getPagIbig(arrayHrs.getGrossWk());

		//Displays Employee Info and Salary Computation
		System.out.println("");
		System.out.println("");
		staffInfo.getInfo();
		System.out.println("");
		System.out.println("");
		deduct.getNet(arrayHrs.getGrossWk());
	
	}
}