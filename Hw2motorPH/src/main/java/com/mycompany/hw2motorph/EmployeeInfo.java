
package com.mycompany.hw2motorph;

import java.util.Scanner;

public class EmployeeInfo{
	
	Scanner input = new Scanner(System.in);
	
	private int idNumber;                 //attributes
	private String employeeName;
	private String birthDay;

	//constructor
	public EmployeeInfo(int idNumber, String employeeName, String birthDay){
		this.idNumber = idNumber;
		this.employeeName = employeeName;
		this.birthDay = birthDay;
	}
	
	//sets ID num
	public int setIdNumber(){ 
		System.out.print("Enter Employee Number:");
		int idNumber = Integer.valueOf(input.nextLine());
		this.idNumber = idNumber;
		return idNumber;
	}

	//sets Employee Name
	public String setEmployeeName(){
		System.out.print("Enter Employee Last Name, First Name: ");
		employeeName = input.nextLine();
		this.employeeName = employeeName;
		return employeeName;
	}

	//Sets Bday
	public String setBirthDay(){
		System.out.print("Enter Birth Date in MM/DD/YY format: ");
		birthDay = input.nextLine();
		this.birthDay = birthDay;
		return birthDay;
	}

	//function to display Info
	public String getInfo(){
		String info = "EMPLOYEE INFORMATION";
		System.out.println(info);
		System.out.println("Employee ID:          "+idNumber);
		System.out.println("Employee Name:        "+employeeName);
		System.out.println("Birth Date:           "+birthDay);
		return info;
	} 
}
