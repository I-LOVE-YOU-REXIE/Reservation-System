package ReservationSystem;

public class CustomCalendar {
	
    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    // Method to get the number of days in a month
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: return 31;  // January
            case 2: return isLeapYear(year) ? 29 : 28;  // February
            case 3: return 31;  // March
            case 4: return 30;  // April
            case 5: return 31;  // May
            case 6: return 30;  // June
            case 7: return 31;  // July
            case 8: return 31;  // August
            case 9: return 30;  // September
            case 10: return 31; // October
            case 11: return 30; // November
            case 12: return 31; // December
            default: return 0;
        }
    }

    // Method to get the day of the week for the first day of a month
    // Zeller's Congruence Algorithm
    public static int getFirstDayOfMonth(int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int K = year % 100;
        int J = year / 100;
        int firstDay = (1 + (13 * (month + 1)) / 5 + K + (K / 4) + (J / 4) - (2 * J)) % 7;
        return (firstDay + 5) % 7 + 1; // Adjusting Zeller's output to our format (1 = Monday, 7 = Sunday)
    }
}
