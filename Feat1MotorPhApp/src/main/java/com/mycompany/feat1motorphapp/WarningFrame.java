
package com.mycompany.feat1motorphapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;	

public class WarningFrame{

	JFrame warningFrame;
	JLabel warningMessage;
	JButton ok;

	public WarningFrame(){

		warningFrame = new JFrame("Important Message");
		warningFrame.setSize(300, 200);
		
		warningMessage = new JLabel("Please enter Correct and Proper Value!!");
		warningMessage.setBounds(30, 20, 250, 30);
		warningFrame.add(warningMessage);

		ok = new JButton("OK");
		ok.setBounds(95, 80, 75, 25);
		warningFrame.add(ok);
		ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae){
				warningFrame.dispose();
			}
		});

		warningFrame.add(warningMessage);

		warningFrame.setLayout(null);
		warningFrame.setVisible(true);
		
	}
	
}


