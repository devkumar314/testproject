package JavaProject;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.DateUtils;


public class DateTests {
	
	DateUtils dateUtils;
	
	@BeforeClass
	public void init() {
		dateUtils = new DateUtils();
	}
	
	@Test
	public void dateDifference() throws ParseException {
		
		String startDate = "01/08/2020";
		String endDate = "07/12/2024";
		
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		
		Date sDate = sdf.parse(startDate);
		Date eDate = sdf.parse(endDate);
		
		//Calculate time difference in milliseconds
        long difference_In_Time = eDate.getTime() - sDate.getTime();
        
		//Calculate time difference in days
		long diff_in_days = TimeUnit.DAYS.toDays(difference_In_Time);
		
		
		System.out.println(
				TimeUnit.MILLISECONDS.toDays(difference_In_Time)/365
                + " years, "
                + TimeUnit.DAYS.toDays(difference_In_Time)
                + " days, "
                + TimeUnit.HOURS.toDays(difference_In_Time)
                + " hours, "
                + TimeUnit.MINUTES.toDays(difference_In_Time)
                + " minutes, "
                + TimeUnit.SECONDS.toDays(difference_In_Time)
                + " seconds");
		
		
	}
	
	@Test
	public void dateDifferenceCalendar() throws ParseException {
		
		String startDate = "01/08/2020";
		String endDate = "07/12/2024";
		
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		
		Date sDate = sdf.parse(startDate);
		Date eDate = sdf.parse(endDate);
		
		Calendar cal1 = Calendar.getInstance();
		Date strDateTime = cal1.getTime();
		
		int year = cal1.get(strDateTime.getYear());
		int month = cal1.get(strDateTime.getMonth()); // Note: Returns zero-based month
		int dayOfMonth = cal1.get(Calendar.DAY_OF_MONTH);
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		int millisecond = cal1.get(Calendar.MILLISECOND);
		
		//Calculate time difference in milliseconds
        long difference_In_Time = eDate.getTime() - sDate.getTime();
        
		//Calculate time difference in days
		long diff_in_days = TimeUnit.DAYS.toDays(difference_In_Time);
		
		
		System.out.println(
				TimeUnit.MILLISECONDS.toDays(difference_In_Time)/365
                + " years, "
                + TimeUnit.DAYS.toDays(difference_In_Time)
                + " days, "
                + TimeUnit.HOURS.toDays(difference_In_Time)
                + " hours, "
                + TimeUnit.MINUTES.toDays(difference_In_Time)
                + " minutes, "
                + TimeUnit.SECONDS.toDays(difference_In_Time)
                + " seconds");
		
		
	}
}
