/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labwork3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameAndElements implements ActionListener{

	JFrame frame;              //Attributes
	
	JLabel ms1;
	JLabel ms2;
	JLabel ta;

	JTextField ms1in;
	JTextField ms2in;
	JTextField taIn;
	
	JLabel ms1max;
	JLabel ms2max;
	JLabel taMax;
	JLabel total;
	
	JLabel ms1total;
	JLabel ms2total;
	JLabel taTotal;
	JLabel overAllGrade;

	JButton calculateG;

	public FrameAndElements(){              //Constructor
		
		frame = new JFrame("Milestone Calculator"); //frame name and size
		frame.setSize(700, 300);
		
		ms1 = new JLabel("Milestone 1");        //column 1
		ms2 = new JLabel("Milestone 2");
		ta = new JLabel("Terminal Assesment");
		ms1.setBounds(50, 25, 100, 30);
		ms2.setBounds(50, 75, 130, 30);
		ta.setBounds(50, 125, 160, 30);
		frame.add(ms1);
		frame.add(ms2);
		frame.add(ta);

		ms1in = new JTextField();            //collumn 2
		ms2in = new JTextField();
		taIn = new JTextField();
		ms1in.setBounds(190, 25, 90, 30);
		ms2in.setBounds(190, 75, 90, 30);
		taIn.setBounds(190, 125, 90, 30);
		frame.add(ms1in);
		frame.add(ms2in);
		frame.add(taIn);

		ms1max = new JLabel("%  25 (max points)");  //collumn 3
		ms2max = new JLabel("%  40 (max points)");
		taMax = new JLabel("%  35 (max points)");
		total = new JLabel("TOTAL");
		ms1max.setBounds(280, 25, 120, 30);
		ms2max.setBounds(280, 75, 120, 30);
		taMax.setBounds(280, 125, 120, 30);
		total.setBounds(280, 175, 120, 30);
		frame.add(ms1max);
		frame.add(ms2max);
		frame.add(taMax);
		frame.add(total);

		ms1total = new JLabel();                   //collumn 4, displays after pressing calculate.
		ms2total = new JLabel();
		taTotal = new JLabel();
		overAllGrade = new JLabel();
		ms1total.setBounds(410, 25, 100, 30);
		ms2total.setBounds(410, 75, 100, 30);
		taTotal.setBounds(410, 125, 100, 30);
		overAllGrade.setBounds(410, 175, 100, 30);
		frame.add(ms1total);
		frame.add(ms2total);
		frame.add(taTotal);
		frame.add(overAllGrade);
		
		calculateG = new JButton("Calculate");        //button with actionListener
		calculateG.setBounds(190, 175, 90, 30);
		frame.add(calculateG);
		calculateG.addActionListener(this);

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	public void actionPerformed(ActionEvent e){             //actionListener Method

		int a = Integer.parseInt(ms1in.getText());      //performs calculations
		int b = Integer.parseInt(ms2in.getText());      //promtps incorrect value, and equates to zero
		int c = Integer.parseInt(taIn.getText());

		if(a<0||a>100){
			ms1total.setText("Incorrect Value!");
			a = 0;
		}else{
			ms1total.setText((a*25)/100+"%");
		}
		if(b<0||b>100){
			ms2total.setText("Incorrect Value!");
			b = 0;
		}else{
			ms2total.setText((b*40)/100+"%");
		}
		if(c<0||c>100){
			taTotal.setText("Incorrect Value!");
			c = 0;
		}else{
			taTotal.setText((c*35)/100+"%");
		}
		overAllGrade.setText(((a*25)/100)+((b*40)/100)+((c*35)/100)+"%");

	}
 
}
