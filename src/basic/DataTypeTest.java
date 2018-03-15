package basic;

public class DataTypeTest {

	public static void main(String[] args) {
		
		char ch = 'A';
		if( ch == 'A')
			System.out.println("같다.");
		else System.out.println("다르다.");
		char result = add(ch);
		System.out.println("결과: "+ result);
		
		String str = "만나서반갑소";
//		// String str = new String("~~~");		이게 오리지널널널널널
//		if( str == "만나서반갑소") System.out.println("같다");
//		else System.out.println("다르다.");
		String resultStr = add(str);
		System.out.println("결과: " + resultStr);
	}
	static char add(char ch){
		ch += 'B';
		return ch;
	}
	static String add(String str){
		str += " 허허";
		return str;
	}
}
