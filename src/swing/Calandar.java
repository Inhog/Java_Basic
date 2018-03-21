package swing;
import java.util.Calendar;
public class Calandar {
	
	public String getdayName(Calendar c){
		int dayNum = c.get(c.DAY_OF_WEEK);
		String dayName = new String();
		switch(dayNum){
		case 1:
			dayName = "일요일";
			break;
		case 2:
			dayName = "월요일";
			break;
		case 3:
			dayName = "화요일";
			break;
		case 4:
			dayName = "수요일";
			break;
		case 5:
			dayName = "목요일";
			break;
		case 6:
			dayName = "금요일";
			break;
		case 7:
			dayName = "토요일";
			break;
		}
		return dayName;
	}
	
}
