package collection;

import java.util.*;


/*		Object[] -> Vector	/  ArrayList
 * 		Vector는 Object배열 이라고 생각하면 편하다.
 * 		갯수를 정확하게 모를땐 Vector / ArrayList
 * 		갯수를 정확하게 알면 배열을 쓰는게 메모리관점에서 이득이다.
 */
public class ArrayListEx1 {

	public static void main(String[] args) {
//		Object[] data = dataSet();
//		Vector data = dataSet();
		ArrayList data = dataSet();
		
		// 출력
//		for(int i=0;i<data.length;i++){
//		System.out.println(data[i].toString());
//		}
//		for(int i=0;i<data.size();i++){
//			System.out.println(data.get(i).toString());
//		}
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).toString());
		}
	}
	
//	static Object[] dataSet(){
//	static Vector dataSet(){
	static ArrayList dataSet(){
		String name = "홍길순";
		int age = 25;
		double height = 170.99;
		
		/*
		Object[] data = new Object[3];
		data[0]= name;
		data[1] = new Integer(age);
		data[2] = new Double(height);*/
		
		/*Vector data = new Vector();
		data.add(name);
		data.add(new Integer(age));
		data.add(new Double(height));*/
		
		ArrayList data = new ArrayList();
		data.add(name);
		data.add(new Integer(age));
		data.add(new Double(height));
		return data;
	}
}
