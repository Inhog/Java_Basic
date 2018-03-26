package thread.basic.ex;

import java.io.IOException;

public class ProcessTest {

	public static void main(String[] args) {
		try{
		Runtime rt = Runtime.getRuntime();
		//경로 입력
		rt.exec("C:\\Program Files\\Internet Explorer\\iexplore.exe");
		System.out.println("프로세스 실행");
		}catch(IOException ex){
			System.out.println("실행 실패:"+ex.getMessage());
		}
	}

}
