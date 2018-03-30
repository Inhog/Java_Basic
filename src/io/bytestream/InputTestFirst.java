package io.bytestream;

/*
	======================================================
	InputStream을 구현한 FileInputStream을 이용한 예
	======================================================
	
	@ int read()
		` 한 바이트를 읽고 이를 0-255사이의 값을 리턴하지만4byte의 int 형으로 리턴
		` 리턴되는 값은 0-255 부호없는 바이트이지만 형변환 과정에서 -128 ~127의 부호 있는 바이트가 된다
		
		
		` 데이타를 읽어들이기 전까지 기다리므로 다른 부분을 실행할 수가 없다
			-> 쓰레드 적용 필요
			
		` 더이상 읽을 바이트가 없으면 -1 리턴
		
		
		
		[ 참고 ]
			int i =  b >= 0 ? b : 256 + b;
*/

import java.io.FileInputStream;
import java.io.IOException;

public class InputTestFirst
{
	public static void main( String args[] ) 
	{
		try
		{
			FileInputStream fis = new FileInputStream("a.txt");
			
			int data = 0;
			char charData = ' ';
			int charOrder = 0;
//			**easyway to escape the while-loop**
//			while(true){
//				data = fis.read();
//				if( data == -1) break;
//				System.out.print(data);
//			}
			
			do{
				//int형 데이터 10개에 대해서 int로 받고
				if(charOrder <10){
					data = fis.read();
					System.out.print(data);
				}
				//뒤의 알파벳은 char형으로 받기
				else if(charOrder >= 10) {
					charData = (char)fis.read();
					System.out.print(charData);
				}
				charOrder++;
				
			}while((int)charOrder != -1);
			
			fis.close();
		}catch( Exception ex ){
			System.out.println("파일전송실패 :" + ex.toString() );
		}
	}	
}

/*
	======================================
		결과 출력
	======================================

	` 숫자만 나오는데, 우선 열개만 읽어서 숫자 자체로 출력하고
	나머지는 읽어서 (char) 형변환 하면 문자로 출력될 것이
*/