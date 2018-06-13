package co.uk.deven.java8.example;

import java.time.LocalDate;

/**
 * Local Date
 *
 */
public class DateTimeExample {
	public static void main( String[] args )
    {
    	LocalDate.of(2016, 1, 31).plusMonths(1);

        System.out.println( "Hello World!" );
    }
}
