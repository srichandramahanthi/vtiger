package genericlibraries;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class JavaUtility {
	/**
	 * this class contains reusable methods related to java operations
	 * @param args
	 */
	public int generateRandomNum(int limit)
	{
		Random random=new Random();
		return random.nextInt(limit);
	}
	/**
	 * this method returns current time
	 * @return
	 */
	public String getCurrentTime()
	{
		Date data=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		return sdf.format(data);
	}
	/**
	 * this method is used to convert string type month to integer
	 * @param month
	 * @return
	 */
	public int convertMonthToInt(String month)
	{
		return DateTimeFormatter
				.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(month)
				.get(ChronoField.MONTH_OF_YEAR);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
