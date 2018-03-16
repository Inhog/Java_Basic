package util;

import java.util.StringTokenizer;

public class STringTokenizerTest {

	public static void main(String[] args) {
		String str = "독,도는 대,한민,국의 아름,,다운섬이다.";
		StringTokenizer st = new StringTokenizer(str,",");
		//StringTokenizer st = new StringTokenizer(str);
		// 구분자는 default로 공백으로 설정한다.
		while(st.hasMoreTokens()){
		System.out.println(st.nextToken());
		}
		
		System.out.println("======================");
		String[] tokens = str.split(",");
		for(int i=0;i<tokens.length;i++){
			System.out.println(tokens[i]);
		}
		
		// 위, 아래의차이가 살짝 있다.
	}

}
