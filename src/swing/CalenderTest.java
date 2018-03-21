package swing;

/*	
 *	CalandarTest.java 파일을 활용하여 잘못된 부분을 수정하였다.
 * 	ActionListener 부분은 거의 완전 가져다 사용함.
 * 	다른 부분은 클래스에서 인터페이스를 구현하지 않았다는 점.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class CalenderTest {
	// 1. 멤버변수선언
	Calendar cal = Calendar.getInstance();
	int[] year_a = new int[3000];
	int[] month_a = new int[13];
	JFrame f = new JFrame();
	JButton btn;
	JLabel la,laY,laM,laD;
	JComboBox cbY;
	JComboBox cbM;
	JComboBox cbD;
	int year = cal.get(cal.YEAR);
	int month =  cal.get(cal.MONTH)+1;
	int day = cal.get(cal.DATE);
	int[] lastDays = {31,28,31,30,31,30,
			31,31,30,31,30,31};
	
	// 2. 객체 생성
	CalenderTest(){
		btn = new JButton("띠용");
		la = new JLabel();
		laY = new JLabel("년");
		laM = new JLabel("월");
		laD = new JLabel("일");
		
		cbY = new JComboBox();
		for(int i=1;i<year_a.length;i++)
			cbY.addItem(i);
		cbM = new JComboBox();
		for(int i=1;i<month_a.length;i++){
			cbM.addItem(i);
		}
		cbD = new JComboBox();
		cbY.setSelectedItem(year);
		cbM.setSelectedItem(month);
		setDay();
		cbD.setSelectedItem(day);
		
	}
	
	// 3. 화면 구성 및 띄우기
	void addLayout(){
		JPanel pCenter = new JPanel();
		
		pCenter.add(cbY);
		pCenter.add(laY);
		pCenter.add(cbM);
		pCenter.add(laM);
		pCenter.add(cbD);
		pCenter.add(laD);
		pCenter.add(btn);
		pCenter.add(la);
		
		f.setLayout(new BorderLayout());
		f.add(pCenter,BorderLayout.CENTER);
		f.setSize(600, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	// 4. 이벤트 등록
	void eventProc(){
		MyBtn BtnHdlr = new MyBtn();
		MyCombox CmHdlr = new MyCombox();
		btn.addActionListener(BtnHdlr);
		cbY.addActionListener(CmHdlr);
		cbM.addActionListener(CmHdlr);
	}	
	
	void setDay(){
		// 선택한 월값을 얻어오기
		cbD.removeAllItems();
		// 월 or 년도가 바뀌었을때 마다 추가하게 된다면 일수가 쭉 늘어나는 상황이 생길 수 있음.
		// 그래서 setDay() 메서드를 호출할때마다 기존 ComboBox의 내용을 싹 지우고 다시 추가한다.
		for(int i=1;i<=lastDays[getMonth()-1];i++){
			cbD.addItem(i);
		}
	}
	
	int getMonth(){

		return (int)cbM.getSelectedItem();
	}
	
	public String getDayName(int i){
		String dayName = new String();
		switch(i){
		case 1:
			dayName = "일요일";
			break;
		case 2:
			dayName = "월요일";
			break;
		case 3:
			dayName = "화요일";
			break;
		case 4:
			dayName = "수요일";
			break;
		case 5:
			dayName = "목요일";
			break;
		case 6:
			dayName = "금요일";
			break;
		case 7:
			dayName = "토요일";
			break;
		}
		return dayName;
	}
	
	class MyCombox implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if(source == cbY || source == cbM){
				setDay();
			}
		}
		
	}
	
	class MyBtn implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent ev){
			Object source = ev.getSource();
			if(source == btn){
			cal.set((int)cbY.getSelectedItem(),
					(int)cbM.getSelectedItem()-1,
					(int)cbD.getSelectedItem());
			la.setText(getDayName(cal.get(cal.DAY_OF_WEEK)));
			}
		}
	}
			
	
	public static void main(String[] args) {
		CalenderTest calender = new CalenderTest();
		calender.addLayout();
		calender.eventProc();
	}
}
