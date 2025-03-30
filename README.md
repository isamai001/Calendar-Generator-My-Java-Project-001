Calendar Generator

Description

The Calendar Generator is a simple Java program that allows users to generate a calendar for a specific month and year. It displays the calendar in the console and also saves it to a text file (calendar.txt).

Features

Displays a formatted calendar for any month and year.

Highlights the current day if the selected month includes today's date.

Saves the calendar to a text file.

Includes a list of public holidays in Kenya.

How to Use

1. Run the Program

Compile and run the Java file using the following commands:

javac CalendarGenerator.java
java CalendarGenerator

2. Enter the Required Details

The program will prompt you to enter:

Year (e.g., 2025)

Month (e.g., 3 for March)

3. View the Calendar

The calendar will be displayed in the terminal.

A text file (calendar.txt) will be created with the calendar details.

Example Output

Enter year: 2025
Enter month (1-12): 3

March 2025
Sun Mon Tue Wed Thu Fri Sat
                        1
 2   3   4   5   6   7   8
 9  10  11  12  13  14  15
16  17  18  19  20  21  22
23  24  25  26  27  28  29
30  31

Calendar saved to calendar.txt

File Output (calendar.txt)

March 2025
Sun Mon Tue Wed Thu Fri Sat
                        1
 2   3   4   5   6   7   8
 9  10  11  12  13  14  15
16  17  18  19  20  21  22
23  24  25  26  27  28  29
30  31

Holidays in Kenya:
- January 1: New Year’s Day
- June 1: Madaraka Day
- October 10: Huduma Day
- December 25: Christmas Day
- December 26: Boxing Day

Technologies Used

Java (Core Java)

Java Time API (for date handling)

Scanner (for user input)

FileWriter (for saving output to a file)

Future Improvements

Add more public holidays dynamically based on the selected country.

Support different date formats.

Allow users to generate full-year calendars.

Author

Developed by Isaya Maindi

License

This project is open-source and available under the MIT License.



