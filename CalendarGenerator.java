import java.util.Scanner;

public class CalendarGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store the number of days in each month
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December"};
        String[] weekDays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        // User input for month
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        // User input for the year
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        // Adjust February for leap years
        if (month == 2 && isLeapYear(year)) {
            daysInMonth[1] = 29;  // Leap year adjustment
        }

        // Validate month input
        if (month < 1 || month > 12) {
            System.out.println("Invalid month! Please enter a value between 1 and 12.");
            System.exit(0);
        }

        // Get the first day of the month
        int startDay = getStartDay(year, month);

        // Print the month name and headers
        System.out.println("\n " + monthNames[month - 1] + " " + year);
        for (String day : weekDays) {
            System.out.printf("%4s", day);
        }
        System.out.println("\n---------------------------");

        // Print leading spaces for the first row
        for (int i = 0; i < startDay; i++) {
            System.out.printf("%4s", " ");
        }

        // Print calendar days
        for (int day = 1; day <= daysInMonth[month - 1]; day++) {
            System.out.printf("%4d", day);
            if ((day + startDay) % 7 == 0) { // New line at the end of each week
                System.out.println();
            }
        }

        System.out.println(); // Move to the next line for better formatting
        scanner.close();
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to calculate the starting day of the month
    private static int getStartDay(int year, int month) {
        int totalDays = 0;

        // Calculate total days from year 1900 to the given year
        for (int i = 1900; i < year; i++) {
            totalDays += (isLeapYear(i)) ? 366 : 365;
        }

        // Days in each month (adjusted for leap years)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Add days for each month in the current year before the selected month
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        // Start day of January 1, 1900 was Monday (index 1)
        return (totalDays + 1) % 7;
    }
}
