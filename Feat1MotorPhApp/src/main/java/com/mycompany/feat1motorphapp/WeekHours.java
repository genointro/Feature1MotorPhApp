
package com.mycompany.feat1motorphapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeekHours{
	
	JFrame myFrame;                    //attributes

	JLabel idNumber, employeeName, birthDay, idNum, name, bday;
	
	JLabel headDate, headTimeInHr, headTimeInMin, headTimeOutHr, headTotalHrs;

	JLabel day1, day2, day3, day4, day5;

	JTextField date1, date2, date3, date4, date5;

	JTextField hIn1, minIn1, hOut1;
	JTextField hIn2, minIn2, hOut2;
	JTextField hIn3, minIn3, hOut3;
	JTextField hIn4, minIn4, hOut4;
	JTextField hIn5, minIn5, hOut5;

	JLabel hrs1, hrs2, hrs3, hrs4, hrs5; //total hours for the day
	JLabel totalHrs;            //total hours for the week
	
	JButton updateButton;
	JButton salaryButton; 

	public WeekHours(){       //contructor
		
		myFrame = new JFrame("Attendance Information");  //frame specs
		myFrame.setSize(600, 550);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		idNumber = new JLabel("ID Number:");         //labels showing employee info
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

		headDate = new JLabel("DATE");               //row of headers
		headDate.setBounds(110, 175, 35, 30);
		headTimeInHr = new JLabel("TIME IN(hh)");
		headTimeInHr.setBounds(160, 175, 65, 30);
		headTimeInMin = new JLabel("TIME IN(mm)");
		headTimeInMin.setBounds(225, 175, 75, 30);
		headTimeOutHr = new JLabel("TIME OUT(hh)");
		headTimeOutHr.setBounds(298, 175, 80, 30);
		headTotalHrs = new JLabel("TOTAL(hrs)");
		headTotalHrs.setBounds(380, 175, 75, 30);
		myFrame.add(headDate);
		myFrame.add(headTimeInHr);
		myFrame.add(headTimeInMin);
		myFrame.add(headTimeOutHr);
		myFrame.add(headTotalHrs);

		day1 = new JLabel("Day 1");         //column indicating day#
		day1.setBounds(50, 200, 35, 30);
		day2 = new JLabel("Day 2");
		day2.setBounds(50, 225, 35, 30);
		day3 = new JLabel("Day 3");
		day3.setBounds(50, 250, 35, 30);
		day4 = new JLabel("Day 4");
		day4.setBounds(50, 275, 35, 30);
		day5 = new JLabel("Day 5");
		day5.setBounds(50, 300, 35, 30);

		myFrame.add(day1);	
		myFrame.add(day2);
		myFrame.add(day3);
		myFrame.add(day4);
		myFrame.add(day5);	

		date1 = new JTextField();            //column of textFields for date input
		date1.setBounds(90, 205, 70, 20);
		date2 = new JTextField();
		date2.setBounds(90, 230, 70, 20);
		date3 = new JTextField();
		date3.setBounds(90, 255, 70, 20);
		date4 = new JTextField();
		date4.setBounds(90, 280, 70, 20);
		date5 = new JTextField();
		date5.setBounds(90, 305, 70, 20);

		myFrame.add(date1);
		myFrame.add(date2);
		myFrame.add(date3);
		myFrame.add(date4);
		myFrame.add(date5);

		hIn1 = new JTextField();             //columns of textFields for Time In and Time Out Input
		hIn1.setBounds(205, 205, 20, 20);
		minIn1 = new JTextField();
		minIn1.setBounds(225, 205, 20, 20);
		hOut1 = new JTextField();
		hOut1.setBounds(300, 205, 20, 20);
		hIn2 = new JTextField();
		hIn2.setBounds(205, 230, 20, 20);
		minIn2 = new JTextField();
		minIn2.setBounds(225, 230, 20, 20);
		hOut2 = new JTextField();
		hOut2.setBounds(300, 230, 20, 20);
		hIn3 = new JTextField();
		hIn3.setBounds(205, 255, 20, 20);
		minIn3 = new JTextField();
		minIn3.setBounds(225, 255, 20, 20);
		hOut3 = new JTextField();
		hOut3.setBounds(300, 255, 20, 20);
		hIn4 = new JTextField();
		hIn4.setBounds(205, 280, 20, 20);
		minIn4 = new JTextField();
		minIn4.setBounds(225, 280, 20, 20);
		hOut4 = new JTextField();
		hOut4.setBounds(300, 280, 20, 20);
		hIn5 = new JTextField();
		hIn5.setBounds(205, 305, 20, 20);
		minIn5 = new JTextField();
		minIn5.setBounds(225, 305, 20, 20);
		hOut5 = new JTextField();
		hOut5.setBounds(300, 305, 20, 20);
		myFrame.add(hIn1);
		myFrame.add(minIn1);
		myFrame.add(hOut1);
		myFrame.add(hIn2);
		myFrame.add(minIn2);
		myFrame.add(hOut2);
		myFrame.add(hIn3);
		myFrame.add(minIn3);
		myFrame.add(hOut3);
		myFrame.add(hIn4);
		myFrame.add(minIn4);
		myFrame.add(hOut4);
		myFrame.add(hIn5);
		myFrame.add(minIn5);
		myFrame.add(hOut5);

		hrs1 = new JLabel();                   //column of labels that will output total hours for a particular day#
		hrs1.setBounds(380, 205, 20, 20);
		hrs2 = new JLabel();
		hrs2.setBounds(380, 230, 20, 20);
		hrs3 = new JLabel();
		hrs3.setBounds(380, 255, 20, 20);
		hrs4 = new JLabel();
		hrs4.setBounds(380, 280, 20, 20);
		hrs5 = new JLabel();
		hrs5.setBounds(380, 305, 20, 20);
		totalHrs = new JLabel();
		totalHrs.setBounds(380, 330, 30, 25);
		myFrame.add(hrs1);
		myFrame.add(hrs2);
		myFrame.add(hrs3);
		myFrame.add(hrs4);
		myFrame.add(hrs5);
		myFrame.add(totalHrs);

		updateButton = new JButton("Update");        //update button that totals hours for each Day and the entire Week
		updateButton.setBounds(300, 330, 75, 25);
		updateButton.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){

				try{
					totalHrs.setText(totalHours());
				}catch(NumberFormatException nfe){
					new WarningFrame();
				}
			} 
		});

		
		salaryButton = new JButton("View Pay Slip");          //button for viewing payslip info, and sending
		salaryButton.setBounds(300, 360, 145, 25);            //data of total hours for the week in payslip info page
		salaryButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				NetWage sendTotal = new NetWage();
				myFrame.dispose();

				try{
					sendTotal.totalWkHrs.setText(totalHours());
				}catch(NumberFormatException nfe){
					new WarningFrame();
				}
				
			}
		});
		myFrame.add(updateButton);
		myFrame.add(salaryButton);

		myFrame.setLayout(null);
		myFrame.setVisible(true); 
	}

	public String totalHours(){                           //method to calculate all total hours for each day and for the entire week
	
		int h1 = Integer.parseInt(hIn1.getText());
		int m1 = Integer.parseInt(minIn1.getText());
		int ho1 = Integer.parseInt(hOut1.getText());
		int th1 = ho1-h1;
		hrs1.setText(String.valueOf(th1));

		h1 = Integer.parseInt(hIn2.getText());
		m1 = Integer.parseInt(minIn2.getText());
		ho1 = Integer.parseInt(hOut2.getText());
		int th2 = ho1-h1;
		hrs2.setText(String.valueOf(th2));

		h1 = Integer.parseInt(hIn3.getText());
		m1 = Integer.parseInt(minIn3.getText());
		ho1 = Integer.parseInt(hOut3.getText());
		int th3 = ho1-h1;
		hrs3.setText(String.valueOf(th3));

		h1 = Integer.parseInt(hIn4.getText());
		m1 = Integer.parseInt(minIn4.getText());
		ho1 = Integer.parseInt(hOut4.getText());
		int th4 = ho1-h1;
		hrs4.setText(String.valueOf(th4));

		h1 = Integer.parseInt(hIn5.getText());
		m1 = Integer.parseInt(minIn5.getText());
		ho1 = Integer.parseInt(hOut5.getText());
		int th5 = ho1-h1;
		hrs5.setText(String.valueOf(th5));

		int th=th1+th2+th3+th4+th5;
		String displayTotal = String.valueOf(th);

		return displayTotal;
	}

}

