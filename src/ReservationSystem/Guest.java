package ReservationSystem;

public class Guest {

	private String name;
	private String gender;
	private String phone;
	private int age;
	private int numberOfGuest;

	Guest(String name, String gender, String phone, int age, int numberOfGuest) {
		setName(name);
		setGender(gender);
		setPhone(phone);
		setAge(age);
		setNumberOfGuest(numberOfGuest);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfGuest() {
		return numberOfGuest;
	}

	public void setNumberOfGuest(int numberOfGuest) {
		this.numberOfGuest = numberOfGuest;
	}
}
