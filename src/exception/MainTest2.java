package exception;

import java.util.Scanner;

public class MainTest2 {

	public static void main(String[] args) {
		Model m = new Model();
		try {
			m.method();
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("프로그램정상 종료");
	}
}

class Model{
	public void method() throws Exception{
		// 두 수 입력받아 첫번째 수를 두번째 수로 나누기
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째 수를 입력하시오.");
		int first = scanner.nextInt();
		System.out.println("두번째 수를 입력하시오.");
		int second = scanner.nextInt();
		if(second ==0){
			throw new MyException();
			// 예외클래스이기 때문에 throw로 예외를 발생시켜줘야 한다.
		}
		int result = first/second;
		System.out.println(result);
	}
}

class MyException extends Exception{
	public String getMessage(){
		return "두번째 수가 0이면 안됩니다!";
	}
}