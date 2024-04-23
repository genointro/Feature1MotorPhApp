
package com.mycompany.hw2motorph;

import java.util.ArrayList;
import java.util.Scanner;

public class WeekHours{
	
	Scanner input = new Scanner(System.in);
	ArrayList<Integer> dayList = new ArrayList<>();  //used in the loop to store time log in and out info.

	private int day;           //attributes
	private int wkHrs;
	private double gross;
	private int prHr;

	//constructor
	public WeekHours(int day, int wkHrs, double gross, int prHr){
		this.day = day;
		this.wkHrs = wkHrs;
		this.gross = gross;
		this.prHr = prHr;
	}

	//allows input of time in and out for the day, runs through a loop for 5 days equivalent.
	public int setWkHrs(){

		int day = 0;
		while(day<5){
			System.out.print("Enter Time IN HOUR of day "+(day+1)+": ");
			int hrIn = Integer.valueOf(input.nextLine());
			System.out.print("Enter Time IN MINUTE of day "+(day+1)+": ");
			int minIn = Integer.valueOf(input.nextLine());
				while(true){
					if(minIn>59){               //promtps user to re-enter correct amount of minutes.
						System.out.println("Please re-enter Correct Minutes: ");
						minIn = Integer.valueOf(input.nextLine());
					}else{
						break;
					}
				}
			System.out.print("Enter Time OUT HOUR of day "+(day+1)+": ");
			int hrOut = Integer.valueOf(input.nextLine());
			int sumHrs = hrOut-hrIn;
			if(hrIn==8&&minIn>10){    //deduction requirement for Time In beyond the 10min. grace period.
				sumHrs = hrOut-(hrIn+1);
			}
			dayList.add(sumHrs);
			day++;
		}

		return day;
	}

	//adds total hours of the stored in the array list tool, represents as total hours for the week.
	public int getWkHrs(){
		int wkHrs = 0;
		int i = 0;
		while(i<dayList.size()){
			System.out.println("Total Hours for "+"Day "+(i+1)+": "+dayList.get(i));
			wkHrs+=dayList.get(i);
			i++;
			
		}
		this.wkHrs = wkHrs;
		System.out.println("Total hours for the week: "+wkHrs);
		return wkHrs;
	}

	//asks for per hour rate input
	public int setPrHr(){
		System.out.print("Enter Per Hour Rate:");
		int prHr = Integer.valueOf(input.nextLine());
		this.prHr = prHr;
		return prHr;
	}

	//calculates gross salary for the week using the above attributes.
	public double getGrossWk(){
		double gross = wkHrs*prHr;
		this.gross = gross;
		return gross;
	}
}
