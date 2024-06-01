
package com.mycompany.feat1motorphapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Window.*;

public class NetWage{
	
	JFrame myFrame;                 //frame attributes

	JLabel idNumber;                //label attributes
	JLabel lastName;
	JLabel firstName;
	JLabel birthDay;
	JLabel sssLabel;
	JLabel philHealthLabel;
	JLabel tinLabel;
	JLabel pagIbigLabel;
	JLabel basicPayLabel;

	JLabel idNum;                  //labels that display info from
	JLabel name;                   //AllEmployees JTable
	JLabel name2;
	JLabel bday;
	JLabel sssLabelOut;
	JLabel philHealthLabelOut;
	JLabel tinLabelOut;
	JLabel pagIbigLabelOut;
	JLabel basicPayLabelOut;

	JLabel basicSalary;    
	JLabel basicSalaryOut;
	JButton monthPay;             //Button that calculates Monthly Salary
	JButton monthPayButton;       //using Basic Pay as Gross.

	JLabel or;

	JLabel totalWkHrs;
	JButton attendanceButton;    //opens WeekHours Frame to update attendance

	JLabel prHrIn;
	JTextField prHrInput;       //to display total Hours for the week from 
	JButton prHrButton;         //week hours frame and calculates Week Salary.

	JLabel headPaySlip;         //below displays Payslip information and
                                    //methods used for calculating both week and month Payslip.
	JLabel grossWk, sss, philHealth, pagIbig, total, taxIncome, withTax, netWk;
	JLabel outGrossWk, outSss, outPhilHealth, outPagIbig, outTotal, outTaxIncome, outWithTax, outNetWk;

	public NetWage(){
		
		myFrame = new JFrame("Payslip Information");
		myFrame.setSize(600, 700);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		idNumber = new JLabel("ID Number:");
		idNumber.setBounds(50, 25, 100, 30);
		myFrame.add(idNumber);
		lastName = new JLabel("Last Name:");
		lastName.setBounds(50, 50, 130, 30);
		myFrame.add(lastName);
		firstName = new JLabel("First Name:");
		firstName.setBounds(50, 75, 130, 30);
		myFrame.add(firstName);
		birthDay = new JLabel("Birth Date:");
		birthDay.setBounds(50, 100, 160, 30);
		myFrame.add(birthDay);
		sssLabel = new JLabel("SSS No. :");
		sssLabel.setBounds(300, 25, 100, 30);
		myFrame.add(sssLabel);
		philHealthLabel = new JLabel("PhilHealth No. :");
		philHealthLabel.setBounds(300, 50, 130, 30);
		myFrame.add(philHealthLabel);
		tinLabel = new JLabel("TIN No. :");
		tinLabel.setBounds(300, 75, 130, 30);
		myFrame.add(tinLabel);
		pagIbigLabel = new JLabel("Pag Ibig No. :");
		pagIbigLabel.setBounds(300, 100, 160, 30);
		myFrame.add(pagIbigLabel);
		
		idNum = new JLabel("12345678");
		idNum.setBounds(150, 25, 90, 30);
		myFrame.add(idNum);
		name = new JLabel("Last Name");
		name.setBounds(150, 50, 90, 30);
		myFrame.add(name);
		name2 = new JLabel("First Name");
		name2.setBounds(150, 75, 90, 30);
		myFrame.add(name2);
		bday = new JLabel("MM/DD/YYYY");
		bday.setBounds(150, 100, 90, 30); 
		myFrame.add(bday);
		sssLabelOut = new JLabel("SSS No. :");
		sssLabelOut.setBounds(400, 25, 100, 30);
		myFrame.add(sssLabelOut);
		philHealthLabelOut = new JLabel("PhilHealth No. :");
		philHealthLabelOut.setBounds(400, 50, 130, 30);
		myFrame.add(philHealthLabelOut);
		tinLabelOut = new JLabel("TIN No. :");
		tinLabelOut.setBounds(400, 75, 130, 30);
		myFrame.add(tinLabelOut);
		pagIbigLabelOut = new JLabel("Pag Ibig No. :");
		pagIbigLabelOut.setBounds(400, 100, 160, 30);
		myFrame.add(pagIbigLabelOut);

		basicSalary = new JLabel("BASIC SALARY:");
		basicSalary.setBounds(50, 145, 160, 30);
		myFrame.add(basicSalary);
		basicSalaryOut = new JLabel("500000.00");
		basicSalaryOut.setBounds(150, 145, 90, 30); 
		myFrame.add(basicSalaryOut);
		monthPayButton = new JButton("Calculate MONTH Pay");  //Calculates Month Payslip using 
		monthPayButton.setBounds(300, 149, 160, 25);          //Basic Salary
		monthPayButton.addActionListener(new ActionListener(){ 

			public void actionPerformed(ActionEvent e){

				try{
					outGrossWk.setText(getMonthGross()+" this Month.");
					outSss.setText(getMonthSss());
					outPhilHealth.setText(getMonthPhilHealth());
					outPagIbig.setText(getMonthPagIbig());
					outTotal.setText(getMonthTotalDeduct());
					outTaxIncome.setText(getMonthTaxIncome());
					outWithTax.setText(getMonthWithTax());
					outNetWk.setText(getNetMo()+" this Month.");
				}catch(NumberFormatException nfe){
					new WarningFrame();
				}	
			}
				
	
		}); 
		myFrame.add(monthPayButton);  

		or = new JLabel("- OR -");
		or.setBounds(300, 177, 160, 25);
		myFrame.add(or);

		totalWkHrs = new JLabel("Update here to calculate Week Salary!");
		totalWkHrs.setBounds(50, 203, 250, 30);
		myFrame.add(totalWkHrs);
		attendanceButton = new JButton("Update Attendance");  //Proceeds to WeekHours JFrame to update 
		attendanceButton.setBounds(300, 205, 160, 25);        //attendance info       
		attendanceButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
			
				new WeekHours();
				myFrame.dispose();
			}
		});
		myFrame.add(attendanceButton);

		prHrIn = new JLabel("Enter Per Hour Rate:");
		prHrIn.setBounds(50, 233, 115, 25);
		myFrame.add(prHrIn);
		prHrInput = new JTextField();
		prHrInput.setBounds(180, 233, 50, 25);
		myFrame.add(prHrInput);
		prHrButton = new JButton("Calculate Week Pay");   //calculates Week Payslip Info
		prHrButton.setBounds(300, 233, 160, 25);          //using totalHrs from WeekHours JFrame and prHr Input
		prHrButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){

				try{
					outGrossWk.setText(getGross()+" this Week.");
					outSss.setText(getSss());
					outPhilHealth.setText(getPhilHealth());
					outPagIbig.setText(getPagIbig());
					outTotal.setText(getTotalDeduct());
					outTaxIncome.setText(getTaxIncome());
					outWithTax.setText(getWithTax());
					outNetWk.setText(getNetWk()+" this Week.");
				}catch(NumberFormatException nfe){
					new WarningFrame();
				}	
			}	
		});	
		myFrame.add(prHrButton);

		headPaySlip = new JLabel("PAYSLIP INFORMATION");    //Labels displaying all calcaulations
		headPaySlip.setBounds(50, 300, 140, 30);            //and deductions
		grossWk = new JLabel("Gross Salary");
		grossWk.setBounds(50, 325, 130, 30);
		myFrame.add(headPaySlip);
		myFrame.add(grossWk);
		sss = new JLabel("SSS Deduction");
		sss.setBounds(50, 370, 130, 30);
		philHealth = new JLabel("Philhealth Deduction");
		philHealth.setBounds(50, 395, 140, 30);
		pagIbig = new JLabel("Pag-Ibig Deduction");
		pagIbig.setBounds(50, 420, 140, 30);
		total = new JLabel("TOTAL Deductions");
		total.setBounds(50, 445, 140, 30);
		myFrame.add(sss);
		myFrame.add(philHealth);
		myFrame.add(pagIbig);
		myFrame.add(total);
		taxIncome = new JLabel("Taxable Income");
		taxIncome.setBounds(50, 490, 140, 30);
		withTax = new JLabel("Withholding Tax");
		withTax.setBounds(50, 515, 140, 30);
		myFrame.add(taxIncome);
		myFrame.add(withTax);
		netWk = new JLabel("Net Salary");
		netWk.setBounds(50, 565, 140, 30);
		myFrame.add(netWk);

		outGrossWk = new JLabel();
		outGrossWk.setBounds(300, 325, 140, 30);
		outSss = new JLabel();
		outSss.setBounds(300, 370, 140, 30);
		outPhilHealth = new JLabel();
		outPhilHealth.setBounds(300, 395, 140, 30);
		outPagIbig = new JLabel();
		outPagIbig.setBounds(300, 420, 140, 30);
		outTotal = new JLabel();
		outTotal.setBounds(300, 445, 140, 30);
		myFrame.add(outGrossWk);
		myFrame.add(outSss);
		myFrame.add(outPhilHealth);
		myFrame.add(outPagIbig);
		myFrame.add(outTotal);
		outTaxIncome = new JLabel();
		outTaxIncome.setBounds(300, 490, 140, 30);
		outWithTax = new JLabel();
		outWithTax.setBounds(300, 515, 140, 30);
		myFrame.add(outTaxIncome);
		myFrame.add(outWithTax);
		outNetWk = new JLabel();
		outNetWk.setBounds(300, 565, 140, 30);
		myFrame.add(outNetWk);
		
		
		myFrame.setLayout(null);
		myFrame.setVisible(true); 
	}

        //below are the methods for both Monthly and Weekly PAYSLIP calculations
        
	public String getGross(){       //Gross for Week Payslip
		int a = Integer.parseInt(totalWkHrs.getText());
		int b = Integer.parseInt(prHrInput.getText());
		double c = a*b;
		String displayGross = String.valueOf(c);
		return displayGross;
	} 

	public String getMonthGross(){ //Gross for Month Payslip
		double c = Double.parseDouble(basicSalaryOut.getText());
		String displayGross = String.valueOf(c);
		return displayGross;
	} 

	public String getSss(){    //SSS for week Payslip calculation
		double gross = Double.parseDouble(getGross());
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
		String displaySss = String.valueOf(sss);
		return displaySss;
	}	

	public String getMonthSss(){ //SSS for month payslip calculation
		double gross = Double.parseDouble(getMonthGross());
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
		String displaySss = String.valueOf(sss);
		return displaySss;
	}

	public String getPhilHealth(){ //PhilHealth calculation for week payslip 
		double gross = Double.parseDouble(getGross());
		double philHealth = 300;
		if(gross>=10000&&gross<60000){
			philHealth = gross*0.03;
		}else if(gross<10000){
			philHealth = philHealth;
		}else{
			philHealth = 1800;
		}
		philHealth = 1.0*philHealth/2; //50% Employer Share
		String displayPhilHealth = String.valueOf(philHealth);
		return displayPhilHealth;	
	}

	public String getMonthPhilHealth(){ //philhealth calculation for month payslip
		double gross = Double.parseDouble(getMonthGross());
		double philHealth = 300;
		if(gross>=10000&&gross<60000){
			philHealth = gross*0.03;
		}else if(gross<10000){
			philHealth = philHealth;
		}else{
			philHealth = 1800;
		}
		philHealth = 1.0*philHealth/2; //50% Employer Share
		String displayPhilHealth = String.valueOf(philHealth);
		return displayPhilHealth;	
	}
	
	public String getPagIbig(){      //pagibig calculation for week payslip
		double gross = Double.parseDouble(getGross());
		double pagIbig = 0;
		
		if(gross>=1000&&gross<1500){
			pagIbig = gross*0.01;	
		}
		if(gross>1500){
			pagIbig = gross*0.02;
		}
		double pagIbigEmployerShare = gross*0.02; //2% Employer Share
		String displayPagIbig = String.valueOf(pagIbig);
		return displayPagIbig;
	}

	public String getMonthPagIbig(){  //pag ibig calculation for month payslip
		double gross = Double.parseDouble(getMonthGross());
		double pagIbig = 0;
		
		if(gross>=1000&&gross<1500){
			pagIbig = gross*0.01;	
		}
		if(gross>1500){
			pagIbig = gross*0.02;
		}
		double pagIbigEmployerShare = gross*0.02; //2% Employer Share
		String displayPagIbig = String.valueOf(pagIbig);
		return displayPagIbig;
	}

	public String getTotalDeduct(){  //Total Deductions calculation for week payslip
		double sss = Double.parseDouble(getSss());
		double philHealth = Double.parseDouble(getPhilHealth());
		double pagIbig = Double.parseDouble(getPagIbig());
		double total = sss+philHealth+pagIbig;
		String displayTotal = String.valueOf(total);
		return displayTotal;
	}	

	public String getMonthTotalDeduct(){  //total deductions for month payslip
		double sss = Double.parseDouble(getMonthSss());
		double philHealth = Double.parseDouble(getMonthPhilHealth());
		double pagIbig = Double.parseDouble(getMonthPagIbig());
		double total = sss+philHealth+pagIbig;
		String displayTotal = String.valueOf(total);
		return displayTotal;
	}

	public String getTaxIncome(){  //week..
		double sss = Double.parseDouble(getSss());
		double gross = Double.parseDouble(getGross());
		double taxIncome = gross-(Double.parseDouble(getTotalDeduct()));
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
		String displayTaxIncome = String.valueOf(taxIncome);
		return displayTaxIncome;
	}

	public String getMonthTaxIncome(){ //month...
		double sss = Double.parseDouble(getMonthSss());
		double gross = Double.parseDouble(getMonthGross());
		double taxIncome = gross-(Double.parseDouble(getMonthTotalDeduct()));
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
		String displayTaxIncome = String.valueOf(taxIncome);
		return displayTaxIncome;
	}

	public String getWithTax(){  //week..
		double sss = Double.parseDouble(getSss());
		double gross = Double.parseDouble(getGross());
		double taxIncome = gross-(Double.parseDouble(getTotalDeduct()));
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
		String displayWithHoldTax = String.valueOf(withHoldTax);
		return displayWithHoldTax;
	}

	public String getMonthWithTax(){ //month..
		double sss = Double.parseDouble(getMonthSss());
		double gross = Double.parseDouble(getMonthGross());
		double taxIncome = gross-(Double.parseDouble(getMonthTotalDeduct()));
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
		String displayWithHoldTax = String.valueOf(withHoldTax);
		return displayWithHoldTax;
	}

	public String getNetWk(){  //week..
		double net = Double.parseDouble(getTaxIncome())-Double.parseDouble(getWithTax());
		String displayNet = String.valueOf(net);
		return displayNet;
	}

	public String getNetMo(){  //month..
		double net = Double.parseDouble(getMonthTaxIncome())-Double.parseDouble(getMonthWithTax());
		String displayNet = String.valueOf(net);
		return displayNet;
	}  
		

}
