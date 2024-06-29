
package com.mycompany.feat1motorphapp;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.FlatteningPathIterator;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AllEmployees{
	
	JFrame frame;
	JPanel panel;
	JPanel panel2;
	JTable table;
	JScrollPane sp;
	JButton button;
	JButton addButton;
	JButton delButton;	 

	public AllEmployees(){

		frame = new JFrame("All Employees");
		frame.setSize(1000,520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                table = new JTable();                   //table on stand by
                table.setModel(new DefaultTableModel(
                        new Object[][]{},
                        new String[]{"employeeNumber", "lastName", "firstName", "birthDay", "sssNo", "philHealthNo", "tinNo", "pagIbigNo", "basicSalary"}
                        ));
                sp = new JScrollPane(table);
                frame.add(sp, BorderLayout.NORTH);
             
		panel2 = new JPanel();
		addButton = new JButton("Update");  //updates the table with current data base info
                addButton.addActionListener(new ActionListener(){
                    
                        public void actionPerformed(ActionEvent ae){ 
                                
                                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                                tableModel.setRowCount(0);
                                
                                
                                try{
                                        Class.forName("com.mysql.cj.jdbc.Driver");
                                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/motorhphdb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "admin");
                                        System.out.println("connection solved!!");
                                        Statement statement = connection.createStatement(); 
                                        String query = "SELECT * FROM allemployees";
                                        ResultSet resultSet = statement.executeQuery(query);
                                        
                                        
                                        
                                        while(resultSet.next()){
                                                String employeeNumber = resultSet.getString("EmployeeNumber");
                                                String lastName = resultSet.getString("LastName");
                                                String firstName = resultSet.getString("FirstName");
                                                String birthDay = resultSet.getString("BirthDay");
                                                String sssNo = resultSet.getString("SSSNo");
                                                String philHealthNo = resultSet.getString("PhilHealthNo");
                                                String tinNo = resultSet.getString("TINNo");
                                                String pagIbigNo = resultSet.getString("PagIbigNo");
                                                String basicSalary = resultSet.getString("BasicSalary");
                                                
                                                String column[] = {employeeNumber, lastName, firstName, birthDay, sssNo, philHealthNo, tinNo, pagIbigNo, basicSalary};
                                                
                                                tableModel.addRow(column);
                                        }  
                                        connection.close();
                               
                                }catch(Exception e){
                                        e.printStackTrace(System.err);
                                }
                                
                                
                        }
                   
                });                          

		delButton = new JButton("Delete");  //delete selected row
                panel2.add(addButton);
		panel2.add(delButton);
		frame.add(panel2, BorderLayout.CENTER);
                delButton.addActionListener(new ActionListener(){
                    
                        public void actionPerformed(ActionEvent ae){
                            
                                    int index[] = table.getSelectedRows();
                                    Object[] column = new Object[9];
                                   
                                    column[0] = table.getValueAt(index[0], 0);
                                    String selectedRow = String.valueOf(column[0]);
                                    System.out.println(selectedRow);
                                    
                                    try{
                                            
                                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/motorhphdb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "admin");
                                            System.out.println("Database Connected");
                                            String query = "DELETE FROM motorhphdb.allemployees WHERE `EmployeeNumber` = '"+selectedRow+"'";
                                            PreparedStatement preparedStatement = connection.prepareStatement(query);
                                            preparedStatement.execute();
                                            
                                    }catch(Exception e){
                                            e.printStackTrace(System.err);
                                    }
                            
                        }
                    
                });
	
		panel = new JPanel(new BorderLayout());
		button = new JButton("View Selected Employee");     //opens the salary info page and sends information of selected row
		panel.add(button);
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
				
		frame.setVisible(true); 
	}
}