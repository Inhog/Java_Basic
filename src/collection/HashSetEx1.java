package collection;

import java.util.*;

public class HashSetEx1 {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();	
		// set은 순서를 저장하지 않기 때문에 중복저장이 안됨.
		set.add("개");
		set.add("고양이");
		set.add("기린");
		set.add("고양이");
		
		System.out.println(set);
	}

}
