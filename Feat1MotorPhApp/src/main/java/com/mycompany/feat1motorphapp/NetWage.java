
package com.mycompany.feat1motorphapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Window.*;

public class NetWage{
	
	JFrame myFrame;

	JLabel idNumber;
	JLabel employeeName;
	JLabel birthDay;

	JLabel idNum;
	JLabel name;
	JLabel bday;

	JLabel totalWkHrs;
	JButton attendanceButton;

	JLabel prHrIn;
	JTextField prHrInput;
	JButton prHrButton;

	JLabel headPaySlip;

	JLabel grossWk, sss, philHealth, pagIbig, total, taxIncome, withTax, netWk;
	JLabel outGrossWk, outSss, outPhilHealth, outPagIbig, outTotal, outTaxIncome, outWithTax, outNetWk;

	public NetWage(){
		
		myFrame = new JFrame("Payslip Information");
		myFrame.setSize(600, 700);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		idNumber = new JLabel("ID Number:");
		idNumber.setBounds(50, 25, 100, 30);
		employeeName = new JLabel("Employee Name:");
		employeeName.setBounds(50, 75, 130, 30);
		birthDay = new JLabel("Birth Date:");
		birthDay.setBounds(50, 125, 160, 30);
		myFrame.add(idNumber);
		myFrame.add(employeeName);
		myFrame.add(birthDay);

		idNum = new JLabel("12345678");
		idNum.setBounds(300, 25, 90, 30);
		name = new JLabel("Full Name");
		name.setBounds(300, 75, 90, 30);
		bday = new JLabel("MM/DD/YYYY");
		bday.setBounds(300, 125, 90, 30); 
		myFrame.add(idNum);
		myFrame.add(name);
		myFrame.add(bday);

		totalWkHrs = new JLabel("Please Update Total Hours this Week!");
		totalWkHrs.setBounds(50, 175, 250, 30);
		myFrame.add(totalWkHrs);
		attendanceButton = new JButton("Update Attendance");
		attendanceButton.setBounds(300, 177, 145, 25);
		attendanceButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
			
				new WeekHours();
				myFrame.dispose();
			}
		});
		myFrame.add(attendanceButton);

		prHrIn = new JLabel("Enter Per Hour Rate:");
		prHrIn.setBounds(50, 205, 115, 25);
		myFrame.add(prHrIn);
		prHrInput = new JTextField();
		prHrInput.setBounds(180, 205, 50, 25);
		myFrame.add(prHrInput);
		prHrButton = new JButton("Calculate");
		prHrButton.setBounds(300, 205, 100, 25);
		prHrButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{
					outGrossWk.setText(getGross());
					outSss.setText(getSss());
					outPhilHealth.setText(getPhilHealth());
					outPagIbig.setText(getPagIbig());
					outTotal.setText(getTotalDeduct());
					outTaxIncome.setText(getTaxIncome());
					outWithTax.setText(getWithTax());
					outNetWk.setText(getNetWk());
				}catch(NumberFormatException nfe){
					new WarningFrame();
				}	
			}	
		});	
		myFrame.add(prHrButton);

		headPaySlip = new JLabel("PAYSLIP INFORMATION");
		headPaySlip.setBounds(50, 300, 140, 30);
		grossWk = new JLabel("Gross Week Salary");
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
		netWk = new JLabel("Net Week Salary");
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

	public String getGross(){
		int a = Integer.parseInt(totalWkHrs.getText());
		int b = Integer.parseInt(prHrInput.getText());
		double c = a*b;
		String displayGross = String.valueOf(c);
		return displayGross;	
	}

	public String getSss(){
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

	public String getPhilHealth(){
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
	
	public String getPagIbig(){
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

	public String getTotalDeduct(){
		double sss = Double.parseDouble(getSss());
		double philHealth = Double.parseDouble(getPhilHealth());
		double pagIbig = Double.parseDouble(getPagIbig());
		double total = sss+philHealth+pagIbig;
		String displayTotal = String.valueOf(total);
		return displayTotal;
	}	

	public String getTaxIncome(){
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

	public String getWithTax(){
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

	public String getNetWk(){
		double net = Double.parseDouble(getTaxIncome())-Double.parseDouble(getWithTax());
		String displayNet = String.valueOf(net);
		return displayNet;
	}
		

}
