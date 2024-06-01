
package com.mycompany.feat1motorphapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AllEmployees{
	
	JFrame frame;        //attributes
	JPanel panel;
	JTable table;
	JScrollPane sp;
	JButton button;	 

	public AllEmployees(){   //constructor

		frame = new JFrame("All Employees");
		frame.setSize(900,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		panel = new JPanel(new BorderLayout());

		button = new JButton("View Selected Employee"); //button to add array of info
		panel.add(button);                              //and send to NetWage Class JLabels
		frame.add(panel, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent ae){

				int indexs[] = table.getSelectedRows();
				Object[] column = new Object[9];
				NetWage sendInfo = new NetWage();

				column[0] = table.getValueAt(indexs[0], 0);
				String sendEmployeeNum = String.valueOf(column[0]);	
				sendInfo.idNum.setText(sendEmployeeNum);

				column[1] = table.getValueAt(indexs[0], 1);
				String sendEmployeeName = String.valueOf(column[1]);	
				sendInfo.name.setText(sendEmployeeName);

				column[2] = table.getValueAt(indexs[0], 2);
				String sendEmployeeName2 = String.valueOf(column[2]);	
				sendInfo.name2.setText(sendEmployeeName2);

				column[3] = table.getValueAt(indexs[0], 3);
				String sendEmployeeBday = String.valueOf(column[3]);	
				sendInfo.bday.setText(sendEmployeeBday);

				column[4] = table.getValueAt(indexs[0], 4);
				String sendEmployeeSss = String.valueOf(column[4]);	
				sendInfo.sssLabelOut.setText(sendEmployeeSss);

				column[5] = table.getValueAt(indexs[0], 5);
				String sendEmployeePhilHealth = String.valueOf(column[5]);	
				sendInfo.philHealthLabelOut.setText(sendEmployeePhilHealth);

				column[6] = table.getValueAt(indexs[0], 6);
				String sendEmployeeTin = String.valueOf(column[6]);	
				sendInfo.tinLabelOut.setText(sendEmployeeTin);

				column[7] = table.getValueAt(indexs[0], 7);
				String sendEmployeePagIbig = String.valueOf(column[7]);	
				sendInfo.pagIbigLabelOut.setText(sendEmployeePagIbig);

				column[8] = table.getValueAt(indexs[0], 8);
				String sendEmployeeBasicSalary = String.valueOf(column[8]);	
				sendInfo.basicSalaryOut.setText(sendEmployeeBasicSalary);


				frame.dispose();		
			}
		});  

		Object[][] rows = {
			{"Employee#1", "LastName1", "First Name1", "BirthDay1", "SSS No.1", "PhilHealth No.1", "TIN No.1", "PagIbig No.1", "500000.0"},
			{"Employee#2", "LastName2", "First Name2", "BirthDay2", "SSS No.2", "PhilHealth No.2", "TIN No.2", "PagIbig No.2", "500000.0"},
			{"Employee#3", "LastName3", "First Name3", "BirthDay3", "SSS No.3", "PhilHealth No.3", "TIN No.3", "PagIbig No.3", "500000.0"},
			{"Employee#4", "LastName4", "First Name4", "BirthDay4", "SSS No.4", "PhilHealth No.4", "TIN No.4", "PagIbig No.4", "500000.0"},
			{"Employee#5", "LastName5", "First Name5", "BirthDay5", "SSS No.5", "PhilHealth No.5", "TIN No.5", "PagIbig No.5", "500000.0"}
		};		
		String[] columnNames = {"Employee Number", "Last Name", "First Name", "Birth Day", "SSS No.", "Phil Health No.", "TIN No.", "PagIbig No.", "Basic Salary"};
		table = new JTable(rows, columnNames);

		sp = new JScrollPane(table);
		frame.add(sp, BorderLayout.NORTH); 
				
		frame.setVisible(true); 
	}
}
