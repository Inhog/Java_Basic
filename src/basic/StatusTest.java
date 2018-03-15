package basic;

import java.util.Calendar;

public class StatusTest {

	public static void main(String[] args) {
		String id = "731212-1034567";
		char gender = id.charAt(7);
		String nai =id.substring(0, 2);
		int age =0;
		if(gender == '1' || gender == '3' || gender == '9')
			System.out.println("남자");
		else if(gender == '2' ||gender == '4' ||gender == '0')
			System.out.println("여자");
		else
			System.out.println("사람이 아님");
		char local = id.charAt(8);
		
		Calendar c= Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		switch(gender) {
		case '0': case '9':
			age = year-(1800+Integer.parseInt(nai))+1;
			break;
		case '1':case '2':
			age = year-(1900+Integer.parseInt(nai))+1;
			break;
		case '3':case '4':
			age = year-(2000+Integer.parseInt(nai))+1;
			break;
		default:
			break;
		}
		
		switch(local) {
		case '0':
		System.out.println("서울");
		break;
		case '1':
			System.out.println("인천/부산");
			break;
		case '2':
			System.out.println("경기");
			break;
		case '9':
		System.out.println("제주");
		break;
		default:
			break;
		}
		

		
		
		System.out.println("나이 : " + age);
	}
}
	