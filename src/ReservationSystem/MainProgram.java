package ReservationSystem;

import java.util.Scanner;

public class MainProgram {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		accommodationListing();
		// searchAvailableAccomodation();

	}

	// user registration
	public static void userRegistration() {
		System.out.print("Name: ");
		String name = scan.next();

		System.out.println("Age: ");
		int age = scan.nextInt();

		System.out.println("Gender: ");
		String gender = scan.next();

		System.out.println("Contact Number: ");
		String phone = scan.next();

		System.out.println("Number Of Guest: ");
		int numberOfGuest = scan.nextInt();

		Guest guest = new Guest(name, gender, phone, age, numberOfGuest);

		System.out.println("Guest Registered Successfully!");
		// also display the registered guest

	}

	// display available accommodation
	public static void accommodationListing() {

		Accommodation room = new Accommodation();
		room.setType("Room");
		room.setPricePerNight(450);
		room.addAmenity("Mini Fridge");
		room.addAmenity("Internet");
		room.addAmenity("Pet Friendly");
		// room.setCalendarAvailability(null);

		// display
		System.out.println(room.getType());
		System.out.println("Price per night: " + room.getPricePerNight());
		room.printAmenities();
		System.out.println();

//		for(int i = 1; i < 12; i++) {
//			room.displayAvailability(2024, i);
//		}

		Accommodation suite = new Accommodation();
		suite.setType("Suite");
		suite.setPricePerNight(650);
		suite.addAmenity("Air Conditioning");
		suite.addAmenity("Mini Fridge");
		suite.addAmenity("Internet");
		suite.addAmenity("Pet Friendly");

		System.out.println(suite.getType());
		System.out.println("Price per night: " + suite.getPricePerNight());
		suite.printAmenities();
		System.out.println();

		Accommodation villa = new Accommodation();
		villa.setType("Villa");
		villa.setPricePerNight(850);
		villa.addAmenity("Air Conditioning");
		villa.addAmenity("Mini Fridge");
		villa.addAmenity("Jacuzzi");
		villa.addAmenity("Internet");
		villa.addAmenity("Pet Friendly");

		System.out.println(villa.getType());
		System.out.println("Price per night: " + villa.getPricePerNight());
		villa.printAmenities();
		System.out.println();

	}

	public static void searchAvailableAccomodation() {
		System.out.println("Chek-in date: ");
		System.out.print("Month(1-12): ");
		int month = scan.nextInt();

		System.out.print("Day(1-31): ");
		int day = scan.nextInt();

	}

}
