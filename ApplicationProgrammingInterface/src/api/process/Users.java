package api.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import api.Methods;
import api.Start;
import api.model.User;
import api.model.UserAddress;

public class Users {

	private List<User> users;
	private List<UserAddress> usersAddress;
	private Start start;
	private static int latestId = 0;

	public List<UserAddress> getUsersAddress() {
		return usersAddress;
	}

	public void setUsersAddress(List<UserAddress> usersAddress) {
		this.usersAddress = usersAddress;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Users(Start start) {
		super();
		this.start = start;
		users = new ArrayList<>();
		usersAddress = new ArrayList<>();
	}

	public Users(Start start, List<User> users) {
		super();
		this.start = start;
		this.users = users;

	}

	public void register() {
		users.add(newRegistration());
		start.menuPaths();
	}

	private static User newRegistration() {
		User u = new User();
		u.setId(latestId++); // auto increment
		u.setFirstName(Methods.stringInput("Enter your name: "));
		u.setLastName(Methods.stringInput("Enter your last name: "));
		u.setEmail(Methods.stringInput("Enter your email: "));
		u.setUsername(Methods.stringInput("Enter your username: "));
		u.setPassword(Methods.stringInput("Enter your password: "));
		UsersAddress.addressRegistration(u);
		return u;
	}

	public void information() {
		System.out.println("");
		System.out.println("----------------------------------");
		int id = Methods.numberInput("Enter the user id: ", 0, Integer.MAX_VALUE);
		System.out.println("----------------------------------");
		System.err.println("User information: ");
		System.out.println("");
		User user = getUser(id);
		if (user == null) {
			System.out.println("User not found.");
		} else {
			System.out.println("First name: " + user.getFirstName());
			System.out.println("Last name: " + user.getLastName());
			UserAddress address = UsersAddress.getUserAddress(id);
			if (address != null) {
				System.out.println("City: " + address.getCity());
				System.out.println("Street: " + address.getStreet());
				System.out.println("Number: " + address.getNumber());
			} else {
				System.out.println("Address information not found.");
			}
		}
		System.out.println("----------------------------------");
		start.menuPaths();
	}

	private User getUser(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	public void update() {
		System.out.println("");
		System.out.println("----------------------------------");
		System.err.println("User information: ");
		System.out.println("");
		int rb = 1;
		for (User u : users) {
			System.out.println(rb++ + ". " + u);
		}
		System.out.println("");
		int id = Methods.numberInput("Enter the user id: ", 0, Integer.MAX_VALUE);
		User user = users.get(id);
		if (user == null) {
			System.out.println("User not found.");
		} else {
			user.setId(Methods.numberInput("Enter the id: ", 0, Integer.MAX_VALUE));
			user.setFirstName(Methods.stringInput("Enter the name: "));
			user.setLastName(Methods.stringInput("Enter the last name: "));
			user.setEmail(Methods.stringInput("Enter the email: "));
			user.setUsername(Methods.stringInput("Enter the username: "));
			user.setPassword(Methods.stringInput("Enter the password: "));
			UsersAddress.addressUpdate(user);
		}
		System.out.println("----------------------------------");
		start.menuPaths();
	}

	public void searchBy() {
		System.out.println("----------------------------------");
		System.out.println("Do you want to search by: ");
		System.out.println("1. name ");
		System.out.println("2. surname ");
		System.out.println("3. or address? ");
		System.out.println("----------------------------------");

		int option = Methods.numberInput("Choose one of options: ", 1, 3);
		User user = null;

		switch (option) {
		case 1:
			System.out.println("----------------------------------");
			user = searchName(Methods.stringInput("Enter the name: "));
			System.out.println("----------------------------------");
			break;
		case 2:
			System.out.println("----------------------------------");
			user = searchSurname(Methods.stringInput("Enter the last name: "));
			System.out.println("----------------------------------");
			break;
		case 3:
			System.out.println("----------------------------------");
			user = searchAddress(Methods.stringInput("Enter the street name: "));
			System.out.println("----------------------------------");
			break;
		}

		if (user == null) {
			System.out.println("User not found!");
		} else {
			System.out.println("User found: " + user.getFirstName() + " " + user.getLastName());
			System.out.println("----------------------------------");
		}
		start.menuPaths();
		
	}

	private User searchAddress(String street) {
		for (UserAddress ua : usersAddress) {
			if (ua.getStreet().equals(street)) {
				String number = Methods.stringInput("Enter the address number: ");
				if (ua.getNumber().equals(number)) {
					return ua.getUser_id();
				}
			}
		}
		return null;
	}

	private User searchSurname(String surname) {
		for (User u : users) {
			if (u.getLastName().equals(surname)) {
				return u;
			}
		}
		return null;
	}

	private User searchName(String name) {
		for (User u : users) {
			if (u.getFirstName().equals(name)) {
				return u;
			}
		}
		return null;
	}

}
