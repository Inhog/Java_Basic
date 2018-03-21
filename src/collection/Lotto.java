package collection;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		while(set.size()<6){
			set.add((int)(Math.random()*45+1));
		}
		// Colloections.sort 활용 정렬
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
//		Collections.sort() 의 매개변수는 list만 가능하기 때문에 ArrayList 혹은 LinkedList를 새로 만든 후 에 정렬해야한다.
		System.out.println(list.toString());
		System.out.println(set.toString());
		
	}

}
