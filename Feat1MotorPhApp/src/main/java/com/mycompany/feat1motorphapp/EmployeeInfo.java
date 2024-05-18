
package com.mycompany.feat1motorphapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeInfo{
	
	JFrame myFrame;               //attributes

	JButton attendanceButton;
	JButton salaryButton;

	JLabel idNumber;
	JLabel employeeName;
	JLabel birthDay;

	JLabel idNum;
	JLabel name;
	JLabel bday;

	public EmployeeInfo(){                    //constructor, contains;
		
		myFrame = new JFrame("Employee Information");   //frame specs
		myFrame.setSize(600, 300);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		idNumber = new JLabel("ID Number:");            //Labels displaying employee info
		idNumber.setBounds(50, 25, 100, 30);
		employeeName = new JLabel("Employee Name:");
		employeeName.setBounds(50, 75, 130, 30);
		birthDay = new JLabel("Birth Date:");
		birthDay.setBounds(50, 125, 160, 30);

		idNum = new JLabel("12345678");
		idNum.setBounds(300, 25, 90, 30);
		name = new JLabel("Full Name");
		name.setBounds(300, 75, 90, 30);
		bday = new JLabel("MM/DD/YYYY");
		bday.setBounds(300, 125, 90, 30);
		
		attendanceButton = new JButton("Attendance");     //button that opens update attendance frame
		attendanceButton.setBounds(50, 180, 140, 40);
		salaryButton = new JButton("Salary Info");        //button that opens salary calculation page
		salaryButton.setBounds(300, 180, 140, 40);
		attendanceButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new WeekHours();
				myFrame.dispose();
			}
		}); 
		salaryButton.addActionListener(new ActionListener(){   
			public void actionPerformed(ActionEvent e){
				new NetWage();
				myFrame.dispose();
			}
		}); 
		
		myFrame.add(attendanceButton); 
		myFrame.add(salaryButton);
		myFrame.add(idNumber);
		myFrame.add(employeeName);
		myFrame.add(birthDay);
		myFrame.add(idNum);
		myFrame.add(name);
		myFrame.add(bday);		
		myFrame.setLayout(null);
		myFrame.setVisible(true); 				

	} 
}
