package exception;

public class MainTest {

	public static void main(String[] args) {
		try{
			int result = 3/0;
			//예외가 발생할 구문
			for(int i=0;i<4;i++){
				System.out.println(args[i]);
			}
			System.out.println("배열 정상처리");
			return; //-> 앞에서 종료시켜도 finally구문은 무조건 실행된다.
		}catch(ArrayIndexOutOfBoundsException ex){
			// 예외가 발생한 후에 처리
			System.out.println("예외발생 :" + ex.getMessage());
			ex.printStackTrace();
		}catch(Exception ex){
			System.out.println("그 외 예외발생:" + ex.getMessage());
		}finally{
			// 예외에 관계없이 '무조건' 수행하는 구문
			System.out.println("예외에 관계없이 무조건 수행하는 구문");
		}
		
		System.out.println("프로그램 정상 종료");
	}
}
