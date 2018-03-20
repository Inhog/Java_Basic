package swing;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Calendar;
// InfoTest에서 class MyFocus extends FocusAdapter{ 내부의 focusLost(FocusEvent e)
// 메서드를 완성하기위해 클래스를 생성함.
// 생성자의 매개변수로 String을 받아 그 안에있는 값으로 데이터를 처리한다.
public class Status {
	String id = new String();
	Status(){}
	Status(String str){
		this.id = str;
	}
	
	public String getGender(){
		String strgender = new String();
		try{
		char gender = id.charAt(7);
		if(gender == '1' || gender == '3' || gender == '9')
			strgender = "남자";
		else if(gender == '2' ||gender == '4' ||gender == '0')
			strgender ="여자";
		else
			strgender = "사람이 아님";
		}catch(Exception e){
			strgender = "입력오류";
		}
		return strgender;
	}
	
	public int getAge(){
		int age =0;
		Calendar c= Calendar.getInstance();
		String nai =id.substring(0, 2);
		int year = c.get(Calendar.YEAR);
		char gender = id.charAt(7);
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
		return age;
	}
	
	public String getHome(){
		char local = id.charAt(8);
		String Home = new String();
		switch(local) {
		case '0':
			Home = "서울";
			break;
		case '1':
			Home = "인천/부산";
			break;
		case '2':
			Home = "경기";
			break;
		case '9':
			Home = "제주";
			break;
		default:
			break;
		}
		return Home;
	}
}
