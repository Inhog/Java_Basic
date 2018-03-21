package collection;

import java.util.*;

public class ArrayListEx3 {

	public static void main(String[] args) {
		// ArrayList<Student> -> 제네릭?
		ArrayList<Student> list = dataSet();
		// 출력
//		System.out.println(list);
//		이렇게하면 안나옴 단순값이 아니라서.
		
	/*	for(int i=0;i<list.size();i++){
			Student s = (Student)list.get(i);
//			(Student) <- 캐스팅연산자? 클래스 끼리는 상속관계에서만 사용가능하다.
			System.out.println(s);
//			이렇게 하면 s.toString()이 자동으로 호출된다.
//			그래서 Student클래스 내부에서 toString 메서드를 오버라이딩하여 원하는 정보를 출력시킨다.
		}오리지널 for문?*/
//		
		
//		for(Student s : list){
//			System.out.println(s);
//		}
//		하나하나 형변환하는 코드가 줄어든다.
//		향상된 포문을 사용할때는 제네릭스가 필수다.
		
		
		// 표준 출력 방식 ( Collection 전체적인 표준)
		// Enumeration -> Iterator
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
//			Student s = (Student)it.next();
//			제네릭스를 사용하지 않으면 계속 형변환을 해야한다.
			Student s = it.next();
			System.out.println(s);
		}
	}
	
	static ArrayList<Student> dataSet(){
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("송혜교",25));
		list.add(new Student("아이유",22));
		list.add(new Student("아이유2",23));
		
		return list;
	}

}
