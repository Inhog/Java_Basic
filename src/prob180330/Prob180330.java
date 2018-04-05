package prob180330;

import java.util.Scanner;

public class Prob180330 {
	public static void main(String[] args) {
		prob3();
	}
	public static void prob1() {
		/**
		 * 문제 1)1~ N까지의숫자를 다음처럼 출력하라
		 * 1 2 3 4 5
		 * 6 7 8 9 10
		 * 11 12 13 14 15
		 */
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int count =1;
		for(int i=0;i<N/5+1;i++){
			int count_n =0;
			for(int j=count;j<=N&&count_n<5;j++){
				System.out.print(j+" ");
				count++;
				count_n++;
			}
			System.out.print("\n");
		}
	}
	
	public static void prob2(){
		/**문제2) 두 개의 실수를 입력받아 
		 * 모두 4.0 이상이면 "A",
		 *  모두 3.0 이상이면 "B",
		 *   아니면 "C" 라고 
		 *   출력하는프로그램을 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		double first = scanner.nextDouble();
		double second = scanner.nextDouble();
		scanner.nextLine();
		if(first > 4.0 && second >4.0){
			System.out.println("A");
		}else if(first > 3.0 && second >3.0){
			System.out.println("B");
		}else{
			System.out.println("C");
		}
	}
	public static void prob3(){
		/**문제3) 10개의 정수를 입력받아
		 *  입력받은 수들 중 짝수의 개수와 
		 *  홀수의 개수를 각각 구하여
		 *   출력하는 프로그램을 작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		int[] input = new int[10];
		int odd=0,even=0;
		for(int i=0;i<input.length;i++){
			input[i] = scanner.nextInt();
		}
		scanner.nextLine();
		
		for(int i=0;i<input.length;i++){
			if(input[i]!=0){
				if((input[i]%2) == 0){
					even++;
				}else{
					odd++;
				}
			}
		}
		System.out.println("짝수 : " + even);
		System.out.println("홀수 : " + odd);
	}
	
	
	public static void prob4(){
		/**문제4) 행과 열의 수를 입력받아
		 *  다음과 같이 출력하는 프로그램을작성하시오.
		 */
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		scanner.nextLine();
		int col_count =1;
		int row_count =1;
		for(int j=1;j<=row;j++){
			for(int i=1;i<=col;i++){
				System.out.print(row_count *i+" ");
			}
			System.out.print("\n");
			row_count++;
		}
	}
	
	public static void prob5(){
		/**문제 5) 정수 20 개를 입력받아서
		 *  그 합과 평균을 출력하되 0 이 입력되면 
		 *  20개 입력이 끝나지 않았더라도
		 *   그 때까지 입력된합과 평균을 
		 *   출력하는 프로그램을 작성하시오. 
		 */
		Scanner scanner = new Scanner(System.in);
		int[] input = new int[20];
		int sum=0,avg=0;
		for(int i=0;i<input.length;i++){
			input[i] = scanner.nextInt();
			if(input[i] == 0){
				break;
			}
			sum += input[i];
			avg = sum/(i+1);
		}
		System.out.print(sum + " "+ avg);
	}
}
