package api.model;

public class UserAddress extends Entity {
	
	private User user_id;
	private String city;
	private String street;
	private String number;
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public UserAddress() {
		super();
	}
	
	public UserAddress(int id, User user_id, String city, String street, String number) {
		super(id);
		this.user_id = user_id;
		this.city = city;
		this.street = street;
		this.number = number;
	}
	

}
