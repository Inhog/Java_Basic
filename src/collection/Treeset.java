package collection;

import java.util.*;
public class Treeset {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		set.add("박보검");
		set.add("공유");
		set.add("소지섭");
		set.add("강다니엘");
		set.add("김수현");
		set.add("김태호");
		set.add("유재석");
		
		System.out.println(set);
		System.out.println(set.subSet("가", "사"));
		System.out.println(set.headSet("박"));
		System.out.println(set.tailSet("박"));
	}

}
