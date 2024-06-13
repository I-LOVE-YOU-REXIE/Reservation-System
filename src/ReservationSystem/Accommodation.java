package ReservationSystem;

public class Accommodation {
	
	private String type; //room, suite, villa
	private String[] amenities;
	private int numAmenities;
	private int pricePerNight;
	private boolean[][] calendarAvailability; //to represent availability for a year
	
	public Accommodation() {
		this.amenities = new String[5]; //5 amenities 
		this.numAmenities = 0;
		this.calendarAvailability = new boolean[12][31]; //12 months, and maximum of 31 days
		initializeCalendarAvailabilty();
	}
	
	//constructr with parameters
	public Accommodation(String type, String[] amenities, int pricePerNight) {
		this.type = type;
		this.amenities = new String[5];
		this.numAmenities = Math.min(amenities.length, 5);
		for(int i = 0; i < this.numAmenities; i++) {
			this.amenities[i] = amenities[i];
		}
		
		this.pricePerNight = pricePerNight;
		this.calendarAvailability = new boolean[12][31];
//		//copy the contents of the first availablity calendar to subarray
//		for(int i = 0; i < 12; i++) {
//			for(int j = 0; j < 31; j++) {
//				this.calendarAvailability[i][j] = calendarAvailability[i][j];
//			}
//		}	
		initializeCalendarAvailabilty();
	}
	
	//this method sets all the dates available initially
	private void initializeCalendarAvailabilty() {
		for(int i = 0;  i < 12; i++) {
			for(int j = 0; j < 31; j++) {
				this.calendarAvailability[i][j] = true;
			}
		}
	}
	
	//getter and setter for type
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	//getter and setter for amenities
	public String[] getAmenities() {
		String[] amenitiesCopy  = new String[5];
		//System.arraycopy(amenities, 0, amenitiesCopy, 0, numAmenities);
		for(int i= 0; i < numAmenities; i ++) {
			amenitiesCopy[i] = this.amenities[i];
		}
		return amenitiesCopy;
	}
	
	public void setAmenities(String[] amenities) {
		this.amenities = new String[5];
		this.numAmenities = Math.min(amenities.length, 5);
		for(int i = 0; i < numAmenities; i++) {
			this.amenities[i] = amenities[i];
		}
	}
	
	//getter and setter for price per night
	public int getPricePerNight() {
		return pricePerNight;
	}
	
	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	// Method to print amenities
	public void printAmenities() {
	    String[] amenitiesList = getAmenities();
	    System.out.print("Amenities: ");
	    for (String amenity : amenitiesList) {
	        if (amenity != null) {
	            System.out.print(amenity + " ");
	        }
	    }
	    System.out.println(); // Move to the next line after printing all amenities
	}
	
	//getter and setter for calender avaliability
	public boolean[][] getCalendarAvailability() {
		boolean[][] calendarCopy = new boolean[12][31];
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 31; j++) {
				calendarCopy[i][j] = this.calendarAvailability[i][j];
			}
		}
		return calendarCopy;
	}
	
	public void setCalendarAvailability(boolean[][] calendarAvailability) {
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 31; j++) {
				this.calendarAvailability[i][j] = calendarAvailability[i][j];
			}
		}
	}
	
	//method to add amenity
	//if the number of amenities is less than 5, add the amenity
	public void addAmenity(String amenity) {
		if(numAmenities < 5) {
			this.amenities[numAmenities++] = amenity;
		}
	}
	
	//to set availabitlity for a specific date
	//no non-negativity for motnh and day, and month and days cannot exceded to 12 and 31 respectively
	public boolean setAvailability(int month, int day, boolean isAvailable) {
		if(month >= 1 && month <= 12 && day >= 1 && day <= 31) {
			this.calendarAvailability[month - 1][day - 1] = isAvailable;
		}
		return false;
	}
	
	/* 
	 * check if the specific date is available, return the date if available
	 * return false otherwise
	 * 
	 */
	public boolean isAvailable(int month, int day) {
		if(month >=1 && month <= 12 && day >= 1 && day <= 31) {
			return this.calendarAvailability[month - 1][day - 1];
		}
		
		return false;
	}
	
	//to check availability
	public boolean isAvailableForDateRange(int checkoutMonth, int checkInDay, int checkOutMonth, int checkOutDay) {
		for(int month = 1; month <= checkOutMonth-1; month++) {
			int startDay = (month == checkoutMonth)? checkInDay - 1 : 0;
			int endDay = (month == checkOutMonth - 1)? checkOutDay - 1: CustomCalendar.getDaysInMonth(month+1, 2024) - 1;
			for(int day = startDay; day <= endDay; day++) {
				if(!calendarAvailability[month][day]) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*
	 * this method 
	 * 
	 */
	public void displayAvailability(int year, int month) {
		
		initializeCalendarAvailabilty();
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		System.out.println("Availibility for " + months[month - 1] + " " + year);
		
		System.out.println("\nMon Tue Wed Thu Fri Sat Sun");
		int firstDay = CustomCalendar.getFirstDayOfMonth(month, year);
		int daysInMonth = CustomCalendar.getDaysInMonth(month, year);
		
		for(int i = 1; i < firstDay; i++) {
			System.out.print("  ");
		}
		
		for(int day = 1; day <= daysInMonth; day++) {
			if(isAvailable(month, day)) {
				System.out.printf("%3d ", day);
			}else {
				System.err.print(" x ");
			}
			
			//checks for the end of the week
			if((day + firstDay - 1) % 7 == 0){
				System.out.println();
			}			
		}	
		System.out.println();
	}	

}
