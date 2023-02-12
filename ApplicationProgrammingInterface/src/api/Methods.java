package api;

import java.util.Scanner;

public class Methods {

	public static Scanner scan;

	public static int numberInput(String message, int min, int max) {
		int number;
		while(true) {
			try {
				System.out.println(message);
				number = Integer.parseInt(scan.nextLine());
				if(number<min || number>max) {
					System.out.println("The number you entered must be between " + min + " and " + max + ".");
					continue;
				}
				return number;
				
			} catch(Exception e) {
				System.out.println("Please enter only a number!");
			}
		}
	}

	public static String stringInput(String message) {
		String s;
		System.out.println(message);
		s=scan.nextLine();
		return s; } }
