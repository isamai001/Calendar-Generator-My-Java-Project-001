import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CalendarGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user input for year and month
        System.out.print("Please Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Please Enter the month (1-12): ");
        int month = scanner.nextInt();
        
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        
        System.out.println("\n" + yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        LocalDate firstDay = yearMonth.atDay(1);
        int startDay = firstDay.getDayOfWeek().getValue() % 7;
        
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        
        LocalDate today = LocalDate.now();
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate currentDay = yearMonth.atDay(day);
            String dayStr = (currentDay.equals(today)) ? "[" + day + "]" : String.format("%2d ", day);
            System.out.printf(dayStr + " ");
            
            if ((startDay + day) % 7 == 0 || day == daysInMonth) {
                System.out.println();
            }
        }
        
        // Save to a file
        try (FileWriter writer = new FileWriter("calendar.txt")) {
            writer.write("\n" + yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + year + "\n");
            writer.write("Sun Mon Tue Wed Thu Fri Sat\n");
            
            for (int i = 0; i < startDay; i++) {
                writer.write("    ");
            }
            
            for (int day = 1; day <= daysInMonth; day++) {
                LocalDate currentDay = yearMonth.atDay(day);
                String dayStr = (currentDay.equals(today)) ? "[" + day + "]" : String.format("%2d ", day);
                writer.write(dayStr + " ");
                
                if ((startDay + day) % 7 == 0 || day == daysInMonth) {
                    writer.write("\n");
                }
            }
            
            writer.write("\nHolidays in Kenya:\n");
            writer.write("- January 1: New Year’s Day\n");
            writer.write("- June 1: Madaraka Day\n");
            writer.write("- October 10: Huduma Day\n");
            writer.write("- December 25: Christmas Day\n");
            writer.write("- December 26: Boxing Day\n");
            
            System.out.println("\nCalendar saved to calendar.txt");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
        
        scanner.close();
    }
}
