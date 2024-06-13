package ReservationSystem;

public class Reservation {

	private String guestName;
	private int checkInMonth;
	private int checkInDay;
	private int checkOutMonth;
	private int checkOutDay;
	private Accommodation accommodation;

	public Reservation(String guestName, int checkInMonth, int checkInDay, int checkOutMonth, int checkOutDay,
			Accommodation accommodation) {
		setGuestName(guestName);
		setCheckInMonth(checkInMonth);
		setCheckInDay(checkInDay);
		setCheckOutMonth(checkOutMonth);
		setCheckOutDay(checkOutDay);
		setAccommodation(accommodation);
	}

	public void confirmReservation() {

	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getCheckInMonth() {
		return checkInMonth;
	}

	public void setCheckInMonth(int checkInMonth) {
		this.checkInMonth = checkInMonth;
	}

	public int getCheckInDay() {
		return checkInDay;
	}

	public void setCheckInDay(int checkInDay) {
		this.checkInDay = checkInDay;
	}

	public int getCheckOutMonth() {
		return checkOutMonth;
	}

	public void setCheckOutMonth(int checkOutMonth) {
		this.checkOutMonth = checkOutMonth;
	}

	public int getCheckOutDay() {
		return checkOutDay;
	}

	public void setCheckOutDay(int checkOutDay) {
		this.checkOutDay = checkOutDay;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

}
