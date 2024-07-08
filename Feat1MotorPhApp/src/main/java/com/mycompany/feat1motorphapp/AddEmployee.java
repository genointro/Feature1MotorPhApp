
package com.mycompany.feat1motorphapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee {
    
        JFrame addFrame;                                      //attributes
    
        JLabel employeeNumber, lastName, firstName, birthDay, sssNo, philHealthNo, tinNo, pagIbigNo, basicSalary, password;
        
        JTextField employeeN, lastN, firstN, birthD, sssN, philHealthN, tinN, pagIbigN, basicS, passW;
        
        JButton addButton;
        
        public AddEmployee(){                                //constructor
            
                addFrame = new JFrame("ADD EMPLOYEE");                 //frame
                addFrame.setSize(350, 540);           
                              
                employeeNumber = new JLabel("Employee Number");      
                employeeNumber.setBounds(50, 25, 130, 30);
                employeeN = new JTextField();
                employeeN.setBounds(180, 25, 110, 30);
                addFrame.add(employeeNumber);
                addFrame.add(employeeN);
                
                lastName = new JLabel("Last Name");
                lastName.setBounds(50, 65, 110, 30);
                lastN = new JTextField();
                lastN.setBounds(180, 65, 110, 30);
                addFrame.add(lastName);
                addFrame.add(lastN);
                
                firstName = new JLabel("First Name");
                firstName.setBounds(50, 105, 110, 30);
                firstN = new JTextField();
                firstN.setBounds(180, 105, 110, 30);
                addFrame.add(firstName);
                addFrame.add(firstN);
                
                birthDay = new JLabel("Birth Day");
                birthDay.setBounds(50, 145, 110, 30);
                birthD = new JTextField();
                birthD.setBounds(180, 145, 110, 30);
                addFrame.add(birthDay);
                addFrame.add(birthD);
                
                sssNo = new JLabel("SSS Number");
                sssNo.setBounds(50, 185, 110, 30);
                sssN = new JTextField();
                sssN.setBounds(180, 185, 110, 30);
                addFrame.add(sssNo);
                addFrame.add(sssN);
                
                philHealthNo = new JLabel("PhilHealth Number");
                philHealthNo.setBounds(50, 225, 110, 30);
                philHealthN = new JTextField();
                philHealthN.setBounds(180, 225, 110, 30);
                addFrame.add(philHealthNo);
                addFrame.add(philHealthN);
                
                tinNo = new JLabel("TIN Number");
                tinNo.setBounds(50, 265, 110, 30);
                tinN = new JTextField();
                tinN.setBounds(180, 265, 110, 30);
                addFrame.add(tinNo);
                addFrame.add(tinN);
                
                pagIbigNo = new JLabel("Pag Ibig Number");
                pagIbigNo.setBounds(50, 305, 110, 30);
                pagIbigN = new JTextField();
                pagIbigN.setBounds(180, 305, 110, 30);
                addFrame.add(pagIbigNo) ;
                addFrame.add(pagIbigN);
                
                basicSalary = new JLabel("Basic Salary");
                basicSalary.setBounds(50, 345, 110, 30);
                basicS = new JTextField();
                basicS.setBounds(180, 345, 110, 30);
                addFrame.add(basicSalary);
                addFrame.add(basicS);
                
                password = new JLabel("Password");
                password.setBounds(50, 385, 110, 30);
                passW = new JTextField();
                passW.setBounds(180, 385, 110, 30);
                addFrame.add(password);
                addFrame.add(passW);
                
                addButton = new JButton("ADD Info");                   //add button function, adds all input into database
                addButton.setBounds(180, 425, 110, 30);
                addFrame.add(addButton);
                addButton.addActionListener(new ActionListener(){
                    
                        public void actionPerformed(ActionEvent ae){
                            
                                String employeeNn = employeeN.getText();
                                String lastNn = lastN.getText();
                                String firstNn = firstN.getText();
                                String birthDd = birthD.getText();
                                String sssNn = sssN.getText();
                                String philHealthNn = employeeN.getText();
                                String tinNn = tinN.getText();
                                String pagIbigNn = pagIbigN.getText();
                                String basicSs = basicS.getText();
                                String passWw = passW.getText();
                                
                                try{
                                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/motorhphdb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "admin");
                                        String query = "INSERT INTO motorhphdb.allemployees (`EmployeeNumber`, `LastName`, `FirstName`, `BirthDay`, `SSSNo`, `PhilHealthNo`, `TINNo`, `PagIbigNo`, `BasicSalary`, `Password`) VALUES ('"+employeeNn+"', '"+lastNn+"', '"+firstNn+"', '"+birthDd+"', '"+sssNn+"', '"+philHealthNn+"', '"+tinNn+"', '"+pagIbigNn+"', '"+basicSs+"', '"+passWw+"')";
                                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                                        preparedStatement.execute();
                                }catch(Exception e){
                                        e.printStackTrace(System.err);
                                }                                
                                
                                addFrame.dispose();
                        }
                });
                      
               
                
                
                
                
                
                
                addFrame.setLayout(null);
                addFrame.setVisible(true);
        }
        
        
}
