package collection;

import java.util.*;

public class StackQueueTest {

	public static void main(String[] args) {
		
		Stack<String> s = new Stack<String>();
		s.push("이효리");
		s.push("이상순");
		s.push("사미자");
		// Stack에 데이터가 없을 때까지 데이터 꺼내기
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
		
		Queue q = new LinkedList();
		q.offer("가");
		q.offer("나");
		q.offer("라");
		q.offer("다");
		// 데이터가 없을때까지 데이터 꺼내기
		while(!q.isEmpty()){
			System.out.println(q.poll());
		}
	}
}
