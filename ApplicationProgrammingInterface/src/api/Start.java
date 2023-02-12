package api;

import java.util.Scanner;

import api.process.Users;
import api.process.UsersAddress;

public class Start {
	
	private Users users;
	private UsersAddress usersAddress;
	
	public Start() {
		
		Methods.scan = new Scanner(System.in);
		users = new Users(this);
		usersAddress = new UsersAddress(this);
		menuPaths();
		
	}
	
	public void menuPaths() {
		System.out.println("");
		System.out.println("--------------OPTIONS-------------");
		System.out.println("1. User registration");
		System.out.println("2. User information");
		System.out.println("3. Update user data");
		System.out.println("4. Search user by first name,last name,city and/or address");
		System.out.println("5. Exit program");
		optionSelection();
	}

	private void optionSelection() {
		System.out.println("----------------------------------");
		switch(Methods.numberInput("Choose one of the listed options: ",1,5)) {
			
		case 1: 
			users.register();
			break;
		case 2:
			users.information();
		case 3:
			users.update();
			break;
		case 4:
			users.searchBy();
			break;
		case 5:
			System.out.println("----------------------------------");
			System.out.println("Goodbye!");
			System.out.println("----------------------------------");
		}
		
	}

	public static void main(String[] args) {
		
		new Start();
		
		
	}

}

