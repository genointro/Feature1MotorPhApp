/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hw2motorphapp;

/**
 *
 * @author Administrator
 */
public class NetWage extends WeekHours{
    
        private double sss;             //attributes
	private double pagIbig;
	private double philHealth;

	//constructor
	public NetWage(int day, int wkHrs, double gross, int prHr){
		super(day, wkHrs, gross, prHr);
		this.sss = sss;
		this.pagIbig = pagIbig;
		this.philHealth = philHealth;
	}

	//calculates sss, uses return value of getGross method from WeekHours class as gross.
	public void getSSS(double gross){
		gross = gross;
		int i = 1;
		int startRange = 3250;
		int endRange = 3750;
		double sss = 135;
		while(i<41){
			if(gross>=startRange&&gross<endRange){
				sss = 135+(22.50*i);
				break;
			}else if(gross<3250){
				sss = 135;
				break;
			}else if(gross>24750){
				sss = 1125;
				break;
			}else{
				startRange+=500;
				endRange+=500;
			}
			i++;
		}
		this.sss = sss;
	}

	//calculates PhilHealth, uses return value of getGross method from WeekHours class as gross.
	public void getPhilHealth(double gross){
		gross = gross;
		double philHealth = 300;
		if(gross>=10000&&gross<60000){
			philHealth = gross*0.03;
		}else if(gross<10000){
			philHealth = philHealth;
		}else{
			philHealth = 1800;
		}
		philHealth = 1.0*philHealth/2; //50% Employer Share
		this.philHealth = philHealth;		
	}

	//calculates PagIbig, uses return value of getGross method from WeekHours class as gross.
	public void getPagIbig(double gross){
		gross = gross;
		double pagIbig = 0;
		
		if(gross>=1000&&gross<1500){
			pagIbig = gross*0.01;	
		}
		if(gross>1500){
			pagIbig = gross*0.02;
		}
		double pagIbigEmployerShare = gross*0.02; //2% Employer Share
		this.pagIbig = pagIbig;
	}

	//Calculates deductions, uses return value of getGross method from WeekHours class as gross.
	public void getNet(double gross){
		gross = gross;
		double taxIncome = gross-(pagIbig+philHealth+sss);
		double withHoldTax = 0;
		if(taxIncome<20832){
			withHoldTax = withHoldTax;
		}else if(taxIncome>=20833&&taxIncome<33333){
			withHoldTax = (taxIncome-20833)*0.20;
		}else if(taxIncome>=33333&&taxIncome<66667){
			withHoldTax = 2500+((taxIncome-33333)*0.25);
		}else if(taxIncome>=66667&&taxIncome<166667){
			withHoldTax = 10833+((taxIncome-66667)*0.30);
		}else if(taxIncome>=166667&&taxIncome<666667){
			withHoldTax = 40833.33+((taxIncome-166667)*0.32);
		}else{
			withHoldTax = 200833.33+((taxIncome-666667)*0.35);
		}
		
		System.out.println("NET WEEK SALARY CALCULATION");
		System.out.println("Gross Salary:         "+gross);
		System.out.println("");
		System.out.println("SSS Deduction         "+sss);
		System.out.println("PhilHealth Deduction  "+philHealth);
		System.out.println("Pag-Ibig Deduction    "+pagIbig);
		System.out.println("TOTAL DEDUCTIONS      "+(sss+philHealth+pagIbig));
		System.out.println("");
		System.out.println("TAXABLE INCOME        "+taxIncome);
		System.out.println("");
		System.out.println("WITHHOLDING TAX       "+withHoldTax);
		System.out.println("");
		System.out.println("Net Wage              "+(taxIncome-withHoldTax));
		
	}
}
