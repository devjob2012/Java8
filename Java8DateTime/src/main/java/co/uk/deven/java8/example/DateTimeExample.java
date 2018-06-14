package co.uk.deven.java8.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Local Date
 *
 */
public class DateTimeExample {
	public static void main(String[] args) {
		LocalDate.of(2016, 1, 31).plusMonths(1);

		LocalDate dtNow = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/dd/MM");
		LocalDate dt1 = LocalDate.parse("12/23/2018", formatter);
		System.out.println("Hello World!    " + dt1.format(newFormatter));
		System.out.println("" + dt1.until(dtNow));
		LocalTime time = LocalTime.now();
		System.out.println(" Local Time  " + time);

	}
}
