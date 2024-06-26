package ReservationSystem;

public class ReservationManagement {
	
	
	//Reservation Management: The resort staff must be able to search for available accommodations
	//based on their desired check-in and check-out dates and preferred accommodation type. They
	//should be able to view details of available options and select one for reservation.
	
	private static final int maxAccommodation = 30; 
	private Accommodation[] accommodations;
	private int accommdationCount;
	
	public ReservationManagement() {
		accommodations = new Accommodation[maxAccommodation];
		accommdationCount = 0;
	}
	
	public void addAccommodation(Accommodation accommodation) {
		if(accommdationCount < maxAccommodation) {
			accommodations[accommdationCount++] = accommodation;
		}else {
			System.out.println("Accommodation list is full.");
		}
	}
	
	//search for available accom
	public Accommodation[] searchAvailableAccommodations(int checkInMonth, int checkInDay, int chekOutMonth, int checkOutday, String type) {
		Accommodation[] availableAccommodations = new Accommodation[accommdationCount];
		int count = 0;
		for(int i = 0; i < accommdationCount; i++) {
			Accommodation accommodation = accommodations[i];
			if(accommodation.getType().equals(type) && accommodation.isAvailableForDateRange(checkInMonth, checkInDay, chekOutMonth, checkOutday)) {
				availableAccommodations[count++] = accommodation;
			}
		}
		return trimArray(availableAccommodations, count);
		
	}
	
    public void printAvailableAccommodations(Accommodation[] availableAccommodations) {
        for (Accommodation accommodation : availableAccommodations) {
            System.out.println("Type: " + accommodation.getType());
            System.out.println("Price per Night: $" + accommodation.getPricePerNight());
            System.out.println("Amenities: " + String.join(", ", accommodation.getAmenities()));
            System.out.println();
        }
    }
	
	
	//to trim the array
	private Accommodation[] trimArray(Accommodation[] array, int size) {
		Accommodation[] trimmedArray = new Accommodation[size];
		for(int i = 0; i < size; i++) {
			trimmedArray[i] = array[i];
		}
		
		return trimmedArray;
	}

}
