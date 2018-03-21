package collection;

import java.util.*;

public class ArrayListEx2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("rabbit");
		list.add("tiger");
		list.add("lion");
		list.add("dragon");
		list.add("rabbit");
		list.add("rabbit");
		list.add("rabbit");
		
		System.out.println(list);
//		ArrayList 자체에 toString이 오버라이딩 되어있어 반복문을 돌리지 않아도 확인 가능하다.
		
		list.add(3, "rock");
//		3번인덱스(4번째)에 해당 element가 삽입되면서 ArrayList의 크기가 하나 증가한다.
		System.out.println(list);
		
		list.set(3, "aa");
//		set메서드는 추가하는게 아니라 바꿔주는 개념이다.
		System.out.println(list);
		
		list.remove("aa");
//		해당 객체 삭제하고 크기 하나 줄임.
		System.out.println(list);
		
		Collections.sort(list);
//		기본적으로 정렬 제공.(무슨 정렬일까나)
		System.out.println(list);
	}

}
