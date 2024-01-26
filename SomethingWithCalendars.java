package de.unistuttgart.iste.sqa.pse.sheet12.homework.cleancode;

import static java.lang.Integer.parseInt;

import java.util.Calendar;
import java.util.Scanner;

public class SomethingWithCalendars {

	static String[] weekDays = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	/**
	 * Reads the given date and sets the given values for the calendar fields Year. Month, Day
	 * requires calendar, date and separator to be initialized
	 * requires date to be in the right format and a known separator to be used
	 * ensures that the correct date has been set
	 * @param calendar, the calendar used
	 * @param date, the given date
	 * @param separator, the separator used
	 */
	static void setCalendarDate(final Calendar calendar, final String date, final String separator) {
		final String[] splitDate = date.split(separator);
		final int year = parseInt(splitDate[0]);
		final int month = parseInt(splitDate[1]) - 1;
		final int day = parseInt(splitDate[2]);
		calendar.set(year, month, day);
	}

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a date (YYYY-MM-DD)");
		final String userInput = scanner.nextLine();
		final Calendar cal = Calendar.getInstance();

		if (userInput.contains("-")) {
			setCalendarDate(cal, userInput, "-");
		} else if (userInput.contains("/")) {
			setCalendarDate(cal, userInput, "/");
		} else if (userInput.contains(".")) {
			setCalendarDate(cal, userInput, "\\.");
		} else {
			throw new IllegalArgumentException("Wrong format");
		}

		final int weekdayAsInteger = cal.get(Calendar.DAY_OF_WEEK);
		final String weekday = weekDays[weekdayAsInteger - 1];
		System.out.print(weekday);
	}
}
