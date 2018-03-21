package swing;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;

import swing.CalenderTest.MyBtn;
// 이건 강사님이 하신거
// 뒤에거는 많이 수정이 필요함 만약 같은부분이 있다면 여기서 배낀거임
public class CalandarTest implements ActionListener{
	// 여기가 아주 킬링파트다.
	Calendar cal = Calendar.getInstance();
//	Calendar 클래스
	Calandar cal_dayName = new Calandar();
//	요일 계산을 깔끔하게 하기위해 만든 클래스
	JFrame f;
	JLabel la,laY,laM,laD;
	JComboBox cbY,cbM,cbD;
	JButton btn;
	int year = cal.get(cal.YEAR);
	int month =  cal.get(cal.MONTH)+1;
	int day = cal.get(cal.DATE);
	JPanel pCenter = new JPanel();
	
	
	Integer[] strY = new Integer[150];
	Integer[] strM = new Integer[12];
	
	int[] lastDays = {31,28,31,30,31,30,
			31,31,30,31,30,31};
	
	CalandarTest(){
		f = new JFrame("나의 달력");
		btn = new JButton("ㅇㅇ");
		la = new JLabel("요일");
		laY = new JLabel("년");
		laM = new JLabel("월");
		laD = new JLabel("일");
		for(int i=0;i<12;i++){
			strM[i] = i+1;
		}
		
		for(int i=0;i<150;i++){
			strY[i] = 1870+i;
		}
		// 올해년도에서 +-5년 출력
		
		cbY = new JComboBox(strY);
		cbM = new JComboBox(strM);
		cbY.setSelectedItem(year);
		cbM.setSelectedItem(month);
		
		cbD = new JComboBox(setDay2());
		
		cbD.setSelectedItem(day);
		la.setText(cal_dayName.getdayName(cal));
	}
	
	void addLayout(){
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Calandar d = new Calandar();
		Object evt = e.getSource();
//		ActionEvent가 발생한 객체를 Object로 받아서
		if(evt == cbM || evt == cbY){
//		해당 객체가 ComboBox객체라면
//			cbD.removeAllItems();
			cbD = new JComboBox(setDay2());
			pCenter.remove(4);
			pCenter.add(cbD,4);
//			f.setLayout(new BorderLayout());
//			f.add(pCenter,BorderLayout.CENTER);
//			f.setSize(600, 200);
			f.setVisible(true);
			
//			Mr.clap 형의 가설 
//			패널에 더해주는 개념이아니라, 객체의 인스턴스를 가리키는 개념으로 해석해서
//			패널을 setVisible로 프레임위에 띄워주고
//			이후에 변경된 사항(패널이 가리키는 인스턴스를 바꿔준다?)을 다시 setVisible로 띄워준다면
//			다시 생성하여 프레임위에 띄우는 것이 가능하더라..
			
//			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else if(evt == btn){
//		해당 객체가 버튼이면
			cal.set((int)cbY.getSelectedItem(),
					(int)cbM.getSelectedItem()-1,
//			Calendar 클래스의 월(1월은 0, 2월은 1)
//			따라서 해당 월 값에 -1 을 해줘야 한다.
					(int)cbD.getSelectedItem());
			la.setText(d.getdayName(cal));
		}
	}
	
	void eventProc(){
		cbY.addActionListener(this);
		cbM.addActionListener(this);
		btn.addActionListener(this);
//		와 이걸 몰랐네....
	}
	
	void setDay(){
		// 윤년 구해서
		int year_s = (Integer)cbY.getSelectedItem();
//		Object 형으로 반환하기 때문에 Integer로 형변환 해준다.
		
		if(year_s%4 == 0 && year_s%100!=0 || year_s%400 ==0){
			lastDays[1] = 29;
		}else{
			lastDays[1] = 28;
		}
		
		// 선택한 월값을 얻어오기
		int month = cbM.getSelectedIndex();
		cbD.removeAllItems();
		for(int i=1; i<=lastDays[month];i++){
			cbD.addItem(i);
		}
	}
	Integer[] setDay2(){
		// 윤년 구해서
		
		int year_s = (Integer)cbY.getSelectedItem();
//		Object 형으로 반환하기 때문에 Integer로 형변환 해준다.
		
		if(year_s%4 == 0 && year_s%100!=0 || year_s%400 ==0){
			lastDays[1] = 29;
		}else{
			lastDays[1] = 28;
		}
		
		// 선택한 월값을 얻어오기
		int month = cbM.getSelectedIndex();
		Integer[] strD = new Integer[lastDays[month]];
		for(int i=0; i<lastDays[month];i++){
			strD[i] =i+1;
		}
		return strD;
	}

	public static void main(String[] args) {
		CalandarTest calandar = new CalandarTest();
		calandar.addLayout();
		calandar.eventProc();
	}
}
