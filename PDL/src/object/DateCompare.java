package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DateCompare implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		
		try {
			Date date1 = formatter.parse(o1);
			Date date2 = formatter.parse(o2);	
			return date1.compareTo(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

