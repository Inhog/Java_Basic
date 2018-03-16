package oop;
// Create by Inho 2018. 3. 16. 오후 5:48:21
// 생성자 매개변수를 STring으로 받는걸로 수정중.
// 아직 수정해야함.
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력할 학생수를 입력하세요.");
		final int n = scanner.nextInt(); scanner.nextLine();
		String[] studentInfo = new String[n];
		Student[] student = new Student[n];
		Math_Point math_point = new Math_Point();
		Eng_Point eng_point = new Eng_Point();
		Kor_Point kor_point = new Kor_Point();
		int count=0;
		for(int i=0;i<n;i++){
			student[i]= new Student();
			
			System.out.printf("%d째 학생의 성적을 입력 ->",i+1);
			studentInfo[i] = scanner.nextLine();
			
			StringTokenizer st = new StringTokenizer(studentInfo[i]);		// tokenizer 활용
			String[] tokens12 = new String[st.countTokens()];			// tokenizer 활용해서 배열 크기 지정함.
			
			while(st.hasMoreTokens()){
				tokens12[count] = st.nextToken();
				count++;
			}
			count=0;
//			student[i].setValue(Integer.parseInt(tokens12[2])		// 점수들을 한번에 set해주는거
//					,Integer.parseInt(tokens12[3])
//					,Integer.parseInt(tokens12[4]));
			student[i].setValue(tokens12);
			
//			StringTokenizer st = new StringTokenizer(studentInfo[i]);		// tokenizer 활용
//			while(st.hasMoreTokens()){
//				tokens1[count] = st.nextToken();
//				count++;
//			}

//			String[] tokens = studentInfo[i].split(" ");		// split 활용
//			student[i].setValue(Integer.parseInt(tokens[2])
//			,Integer.parseInt(tokens[3])
//			,Integer.parseInt(tokens[4]));
			
			
/*		각 점수마다 set 해주는거 		
 * student[i].setKorean(Integer.parseInt(tokens[2])); 
 * student[i].setEnglish(Integer.parseInt(tokens[3]));  
 * student[i].setMath(Integer.parseInt(tokens[4]));  
 */ 
			
			math_point.addSum(student[i].getMath());
			eng_point.addSum(student[i].getEnglish());
			kor_point.addSum(student[i].getKorean());
		}
		
		for(int i=0;i<n;i++){
			System.out.printf("%d째 학생의",i+1);
			student[i].print();
		}
		
		math_point.print(n);
		eng_point.print(n);
		kor_point.print(n);
	}
}

class Student{
	private int korean;
	private int english;
	private int math;
	private int[] score;
	private String name,student_num;
	
	public Student(){}
	/*public Student(String student_num, String name, int...score){
		this.student_num = student_num;
		this.english = english;
		this.math = math;
		this.korean = korean;
		this.name = name;
	}*/
	public Student(String...token){
		score = new int[token.length-2];
		this.student_num = token[0];
		this.name = token[1];
		for(int i=2;i<token.length;i++){
			score[i-2] = Integer.parseInt(token[i]);
		}
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	/*public void setValue(int kor,int eng, int math){
		this.korean = kor;
		this.english = eng;
		this.math = math;
	}
	*/
	public void setValue(String[] token){
		for(int i=2;i<token.length;i++){
			score[i] = Integer.parseInt(token[i]);
		}
	}
	
	public int sum(){
		int sum=0;
		for(int i=2;i<score.length;i++){
			sum += score[i];
		}
		return sum;
	}
	public double sum_per(){
		return sum()/score.length;
	}
	public void print(){
		System.out.printf("총점 %4d 이고 평균은 %3f 입니다.\n",sum(),sum_per());
	}
}

class Point{
	int sum=0;
	public Point(){}
	public void addSum(int score){
		this.sum += score;
	}
	public int Sum(){
		return sum;
	}
	public double Sum_per(double per){
		return sum/per; 
	}
}

class Math_Point extends Point{
	public Math_Point(){
		super();
		}
	public void print(int per){
		System.out.println("수학과목 총점 " + super.Sum() + " 평균은 "+super.Sum_per(per)+" 입니다.");
	}
}
class Eng_Point extends Point{
	public Eng_Point(){
		super();
	}
	public void print(int per){
		System.out.println("영어과목 총점 " + super.Sum() + " 평균은 "+super.Sum_per(per)+" 입니다.");
	}
}
class Kor_Point extends Point{
	public Kor_Point(){
		super();
	}
	public void print(int per){
		System.out.println("국어과목 총점 " + super.Sum() + " 평균은 "+super.Sum_per(per)+" 입니다.");
	}
}