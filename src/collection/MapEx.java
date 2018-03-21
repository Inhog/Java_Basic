package collection;

import java.util.*;
public class MapEx {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("javassem", "1111");
		map.put("javababo", "9999");
		map.put("kimjava", "1111");
//		key값은 중복되면 안된다.
		map.put("kimjava", "1234");
		
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		while(!flag){
			System.out.println("아이디 :");
			String id = scanner.nextLine();
			System.out.println("비밀번호 : ");
			String pw = scanner.nextLine();
			
			// 1-1 입력받은 id 가 있다면
			if(map.containsKey(id)){
				// 2.1 그 해당하는 id값의 value를 얻어와서 입력한 비밀번호가 같다면
				if((pw.equals(map.get(id)))){
					// 	로그인 성공 출력
					System.out.println("로그인 성공");
				}else{
					// 2-2 틀리면 다시 입력받을 수 있도록
					System.out.println("다시 입력해 주십시오.");
					continue;
				}
			}else{
				// 1-2 입력받은 id는 존재하지 않음.
				System.out.println("존재하지 않는 아이디입니다.");
				continue;
			}
			
		}
	}

}
