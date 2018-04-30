package alist.array;

import java.util.Scanner;


// Create by Inho 2018. 4. 26. 

public class Practice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrList<String> s = new ArrList<String>();
		for(int i=0;i<10;i++){
			// 값 입력받음.
			String value = scanner.nextLine();
			if(i==0){// 맨처음은 그냥 입력
				s.insertLast(String.valueOf(value.charAt(0)));
				continue;
			}
			boolean flag = false;
			// 돌면서 찾음.
			for(int j=0;j<i;j++){
				if(value.charAt(0) < s.peek(j).charAt(0)){
//					System.out.print(value.charAt(0)+" ");
//					System.out.println(s.peek(j).charAt(0));
					s.insert(value, j);
					flag = true;
					break;
				}
			}
			if(flag == false){ // 맨마지막으면 마지막자리에 넣음.
				s.insertLast(value);
			}
		}
		boolean flag = false;
		int mid = s.getSize()/2;// 중간위치 찾음.
		int count=1;
		while(!flag){	// 찾을때까지 반복
			if(s.peek(mid).equals("P")){
				flag =true;
				System.out.println(count);
			}else if(s.peek(mid).charAt(0) <'P'){
				mid = (s.getSize()+mid)/2;
				count++;
			}else{
				mid = mid/2;
				count++;
			}
		}
		System.out.println(s.peek(s.getSize()/2));
		s.print();
	}
}
