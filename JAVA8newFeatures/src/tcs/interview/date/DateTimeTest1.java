package tcs.interview.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeTest1 {
	public static void main(String[] args) {
		LocalDate date22 = LocalDate.parse("2019-03-07");
		LocalDate date11 = LocalDate.of(2019,12,07);
		System.out.println("------------------------"+date22.getYear()+date11.getYear()+", "+date22.compareTo(date11)+", "+date11.compareTo(date22));


		
		LocalDate date = LocalDate.now();
		LocalDate yesterday = date.minusDays(1);
		LocalDate tomarrow = date.plusDays(1);
		System.out.println("TODAY:TMRW:YESTERDAY:===" + date + ":" + yesterday + ":" + tomarrow + ":");

		// CHECK LEAP YEARS
		LocalDate leapYear = LocalDate.of(2017, 02, 02);
		System.out.println("Leap year OBJECT before process" + leapYear);
		boolean res = leapYear.isLeapYear();
		System.out.println("Is l:" + res);

		// USIMG both DATeTIMe
		LocalDateTime ldt = leapYear.atTime(11, 50, 9);
		System.out.println("Time PLUS date:  " + ldt);

		// FORMATE/Converting DATE to String
		String s1 = leapYear.format(DateTimeFormatter.ISO_DATE);
		System.out.println("Noraml date:" + leapYear);
		System.out.println("Formated DTAE: String: " + s1);

		// PARSING: STRING TO DATE COVERTER
		String s2 = "2022-02-20";
		LocalDate ldt2 = LocalDate.parse(s2);
		System.out.println("String to DATE coversions: " + ldt2);

		// Time
		ZoneId zid1 = ZoneId.of("Asia/Tokyo");
		ZoneId zid2 = ZoneId.of("Asia/Kolkata");
		LocalTime lt = LocalTime.now(zid1);
		LocalTime lt2 = LocalTime.now(zid2);
		System.out.println("Time in TOKYO: " + lt);
		System.out.println("Time in India Kolkata: " + lt2);

		// CHRONO
		long hours = ChronoUnit.HOURS.between(lt, lt2);
		System.out.println("DIFF btw Tokoy and Kolkata" + hours);

		// REGULARA DATE FORMATTING IN STD WAYS
		LocalDateTime ld3 = LocalDateTime.now();
		System.out.println("before: Formatting: " + ld3);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String s3 = ld3.format(formatter);
		System.out.println("DATE TIME FORMATTER: " + s3);

	}
}
