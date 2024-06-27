
package com.mycompany.feat1motorphapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.sql.*;
        
public class Login {
    
        JFrame loginFrame;
        
        JLabel user;
        JLabel pass;
        
        JTextField userTextField;
        JPasswordField passTextField;
        
        JButton logIn;
        JButton adminLogIn;
        
        //drop down for selecting HR/admin and Employee
        
        public Login(){
               
                loginFrame = new JFrame("Login");
                loginFrame.setSize(600, 300);
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                user = new JLabel("Employee ID Number/Admin Username:");
                user.setBounds(180, 25, 225, 30);
                loginFrame.add(user);
                userTextField = new JTextField();
                userTextField.setBounds(180, 50, 250, 30);
                loginFrame.add(userTextField);
                                
                pass = new JLabel("Password:");
                pass.setBounds(180, 90, 100, 30);
                loginFrame.add(pass);
                passTextField = new JPasswordField();
                passTextField.setBounds(180, 115, 250, 30);
                loginFrame.add(passTextField);
                
                logIn = new JButton("Employee Login");
                logIn.setBounds(180, 180, 125, 30);
                loginFrame.add(logIn);
                logIn.addActionListener(new ActionListener(){
                   
                        public void actionPerformed(ActionEvent ae){
                                
                                String userName = userTextField.getText();
                                String password = passTextField.getText();
                                String un = null;
                                String p = null;
                                
                                try{
                                        
                                        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/motorhphdb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "admin");
                                        System.out.println("Database Connected");
                                        Statement statement = connection.createStatement();                                        
                                        ResultSet resultSet = statement.executeQuery("SELECT * FROM allemployees WHERE EmployeeNumber= '"+userName+"' and Password= '"+password+"'");
                                        
                                        while(resultSet.next()){
                                                
                                                un = resultSet.getString("EmployeeNumber");
                                                p = resultSet.getString("Password");                                                                                        
                                        }
                                        
                                        if(userName.equals(un)&&password.equals(p)){
                                                new EmployeeInfo();
                                            
                                        }else{
                                                new WarningFrame();
                                                      
                                        }
                                  //      new EmployeeInfo();
                                       
                                }catch(SQLException sqlException){
                                    
                                        sqlException.printStackTrace();
                                }
                                        
                        }
                });
                
                adminLogIn = new JButton("Admin Login");
                adminLogIn.setBounds(305, 180, 125, 30);
                loginFrame.add(adminLogIn);
                adminLogIn.addActionListener(new ActionListener(){ 
                
                        public void actionPerformed(ActionEvent ae){
                            
                                String un = null;
                                String p = null;
                                
                                try{
                                        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/motorhphdb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "admin");
                                        System.out.print("Database Connected");
                                        Statement statement = connection.createStatement();
                                        ResultSet resultSet = statement.executeQuery("SELECT * FROM login WHERE UserName='"+userTextField.getText()+"' and Password='"+passTextField.getText()+"'");
                                        
                                        while(resultSet.next()){
                                                un = resultSet.getString("UserName");
                                                p = resultSet.getString("Password");
                                        }
                                        
                                        if(userTextField.getText().equals(un)&&passTextField.getText().equals(p)){
                                                new AllEmployees();
                                        }else{
                                                new WarningFrame();
                                        }
                                }catch(SQLException sqlException){
                                        sqlException.printStackTrace();
                                }
                        }
                });
                                                
                loginFrame.setLayout(null);
                loginFrame.setVisible(true);
        }
        
        
    
}
