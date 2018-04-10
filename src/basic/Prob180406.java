package basic;

import java.util.Scanner;

public class Prob180406 {

	public static void main(String[] args) {
		//Scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
		// Int형 변수 입력받고
		int n= scanner.nextInt();
		int type= scanner.nextInt();
		// 줄바꿈
		scanner.nextLine();
		switch(type){
		case 1:
			one(n);
			break;
		case 2:
			two(n);
			break;
		case 3:
			three(n);
			break;
		}
	}
	
	static void one(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<i+1;j++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void two(int n){
		for(int i=0;i<n;i++){
			for(int j=n;j>i;j--){
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void three(int n){
		// 출력할 배열의 사이즈 변수
		int size = (n*2)-1;
		// 배열 선언
		char[][] arr = new char[size][size];
		// 2차원 배열을 모두 돌면서 조건에 맞는 문자로 초기화
		// i는 높이
		for(int i=0;i<=n;i++){
			// j 는 arr[].length 까지.
			for(int j =0;j<size;j++){
				// 위에서 부터 1,3,5,7,....에 대한 조건식
				if(arr.length/2+i >j && arr.length/2-i <j)
					// 조건이 성립하면 *
					arr[i][j] = '*';
				else
					// 안하면 ' ' 공백
					arr[i][j] = ' ';
				// 초기화 해주고 바로 출력
				System.out.print(arr[i][j]);
			}
			// 줄바꿈
			System.out.println("");
		}
	}
}
