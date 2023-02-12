package api.process;

import java.util.ArrayList;
import java.util.List;

import api.Methods;
import api.Start;
import api.model.UserAddress;
import api.model.User;

public class UsersAddress {

	private static List<UserAddress> usersAddress;
	private Start start;

	public List<UserAddress> getUseraddress() {
		return usersAddress;
	}

	public void setUseraddress(List<UserAddress> useraddress) {
		this.usersAddress = useraddress;

	}

	public UsersAddress(Start start) {
		super();
		this.start = start;
		usersAddress = new ArrayList<>();
	}

	public static void addressRegistration(User u) {
		UserAddress ua = new UserAddress();
		ua.setUser_id(u);
		ua.setCity(Methods.stringInput("Enter your city: "));
		ua.setStreet(Methods.stringInput("Enter your street address: "));
		ua.setNumber(Methods.stringInput("Enter your number: "));
		usersAddress.add(ua);
	}

	public static UserAddress getUserAddress(int id) {
	    for (UserAddress ua : usersAddress) {
	        if (ua.getUser_id().getId() == id) {
	            return ua;
	        }
	    }
	    return null;
	}

	public static void addressUpdate(User user) {
		UserAddress ua = new UserAddress();
		ua.setUser_id(user);
		ua.setCity(Methods.stringInput("Enter your city: "));
		ua.setStreet(Methods.stringInput("Enter your street address: "));
		ua.setNumber(Methods.stringInput("Enter your number: "));
	}

} 

