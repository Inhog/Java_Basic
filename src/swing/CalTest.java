package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*		이 클래스는 단순이 2개의 값만 읽어들여 하나의 연산자만 계산가능하게 만들어졌음.
 * 		값을 입력받는 방식을 StringButffer라던지 동적으로 활용할 수 있는 객체를 쓴다면 더 깔끔해지지않을까 싶음.
 * 		연산자는 Tokenizer? 로 구분하여 스위치문으로 연산을 수행할 수 있도록 만들면 좋을것같음.
 * 		지금 만든 이 방식은 너무 노가다고 단순하게 짜여져 있다.
 * 
 * 		(수정) 연산자의 우선순위 상관없이(괄호가 없다는 변명) 입력받은 순서대로 연산을 수행하여 몇개든지 입력받을 수 있다.
 */


public class CalTest {
	// 1. 멤버변수선언
	JFrame f = new JFrame();
	JButton[] b = new JButton[10];
	JButton bPlus;
	JButton bMinus;
	JButton bEqual;
	JButton bDivide;
	JButton bMul;
	JTextField tf = new JTextField();
	JTextField tf2 = new JTextField();
	double value1,value2,sol =0;
	double[] mulValue = new double[100];
	String Equation = new String("");
	int count=0;
	int check =98765432;
	
	// 2. 객체생성
	CalTest(){
		for(int i=0;i<10;i++){
			b[i] = new JButton();
			b[i].setText(""+i);
		}
		bPlus = new JButton("+");
		bMinus = new JButton("-");
		bEqual = new JButton("=");
		bDivide = new JButton("/");
		bMul = new JButton("*");
		tf.setText(Equation);
		tf.setEditable(false);
		tf2.setEditable(false);
	}
	
	// 3. 화면 구성 및 띄우기
	void addLayout(){
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(5,3));
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(2,1));
		for(int i=1;i<10;i++){
			pSouth.add(b[i]);
		}
		pSouth.add(bPlus);
		pSouth.add(b[0]);
		pSouth.add(bEqual);
		pSouth.add(bMinus);
		pSouth.add(bMul);
		pSouth.add(bDivide);
		pNorth.add(tf);
		pNorth.add(tf2);
		
		f.setLayout(new BorderLayout());
		f.add(pSouth,BorderLayout.CENTER);
		f.add(pNorth,BorderLayout.NORTH);
		
		f.setSize(500, 400);
		f.setVisible(true);
		
	}
	
	// 4. 이벤트 등록
	
	void eventProc(){
		MyBtn bHdlr = new MyBtn();
		for(int i=0;i<10;i++){
			b[i].addActionListener(bHdlr);
		}
		bPlus.addActionListener(bHdlr);
		bMinus.addActionListener(bHdlr);
		bDivide.addActionListener(bHdlr);
		bMul.addActionListener(bHdlr);
		bEqual.addActionListener(bHdlr);
		
		MyWin winHdlr = new MyWin();
		f.addWindowListener(winHdlr);
	} // end of eventProc()
	
	class MyBtn implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent ev){
			JButton evt = (JButton)ev.getSource();
			if(evt == bPlus){
				if(value1 == 0){
					tf.setText(Equation);
				}else{
					if(count >= 1 ){
						Equation = change(Equation,'+');
						tf.setText(Equation);
						value1 = equal(check);
						//value1 = add(value1,value2);
						tf2.setText(""+value1);
						value2 = 0;
						check =0;
					}else{
						Equation = change(Equation,'+');
						tf.setText(Equation);
						tf2.setText(""+value1);
						count++;
						check = 0;
					}
				}
			}else if(evt == b[0]){
				if(count ==0){
					value1 = value1*10;
					Equation = change(Equation,'0');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10;
					Equation = change(Equation,'0');
					tf.setText(Equation);
				}
			}else if(evt == b[1]){
				if(count ==0){
					value1 = value1*10+1;
					Equation = change(Equation,'1');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+1;
					Equation = change(Equation,'1');
					tf.setText(Equation);
				}
			}else if(evt == b[2]){
				if(count ==0){
					value1 = value1*10+2;
					Equation = change(Equation,'2');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+2;
					Equation = change(Equation,'2');
					tf.setText(Equation);
				}
			}else if(evt == b[3]){
				if(count ==0){
					value1 = value1*10+3;
					Equation = change(Equation,'3');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+3;
					Equation = change(Equation,'3');
					tf.setText(Equation);
				}
			}else if(evt == b[4]){
				if(count ==0){
					value1 = value1*10+4;
					Equation = change(Equation,'4');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+4;
					Equation = change(Equation,'4');
					tf.setText(Equation);
				}
			}else if(evt == b[5]){
				if(count ==0){
					value1 = value1*10+5;
					Equation = change(Equation,'5');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+5;
					Equation = change(Equation,'5');
					tf.setText(Equation);
				}
			}else if(evt == b[6]){
				if(count ==0){
					value1 = value1*10+6;
					Equation = change(Equation,'6');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+6;
					Equation = change(Equation,'6');
					tf.setText(Equation);
				}
			}else if(evt == b[7]){
				if(count ==0){
					value1 = value1*10+7;
					Equation = change(Equation,'7');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+7;
					Equation = change(Equation,'7');
					tf.setText(Equation);
				}
			}else if(evt == b[8]){
				if(count ==0){
					value1 = value1*10+8;
					Equation = change(Equation,'8');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+8;
					Equation = change(Equation,'8');
					tf.setText(Equation);
				}
			}else if(evt == b[9]){
				if(count ==0){
					value1 = value1*10+9;
					Equation = change(Equation,'9');
					tf.setText(Equation);
				}
				else{
					value2 = value2 *10+9;
					Equation = change(Equation,'9');
					tf.setText(Equation);
				}
			}else if(evt == bMinus){
				if(value1 == 0){
					tf.setText(Equation);
				}else{
					if(count >= 1 ){
						Equation = change(Equation,'-');
						tf.setText(Equation);
						value1 = equal(check);
						tf2.setText(""+value1);
						value2 = 0;
						check = 1;
					}else{
						Equation = change(Equation,'-');
						tf.setText(Equation);
						tf2.setText(""+value1);
						count++;
						check = 1;
					}
				}
			}else if(evt == bMul){
				if(value1 == 0){
					tf.setText(Equation);
				}else{
					if(count >= 1 ){
						mulValue[count]=0;
						mulValue[count]=value1;
						Equation = change(Equation,'*');
						tf.setText(Equation);
						value1 = equal(check);
						value2 =0;
						tf2.setText(""+value1);
						check = 2;
					}else{
						Equation = change(Equation,'*');
						tf.setText(Equation);
						tf2.setText(""+value1);
						count++;
						check = 2;
					}
				}
			}else if(evt == bDivide){
				if(value1 == 0){
					tf.setText(Equation);
				}else{
					if(count >= 1 ){	
						Equation = change(Equation,'/');
						tf.setText(Equation);
						value1 = equal(check);
						tf2.setText(""+value1);
						value2 = 0;
						check = 3;
					}else{
						Equation = change(Equation,'/');
						tf.setText(Equation);
						tf2.setText(""+value1);
						count++;
						check = 3;
					}
				}
			}else if(evt == bEqual){
				tf.setText("");
				tf2.setText(""+equal(check));
			}else{
				System.exit(0);
			}
		}// end of actionPerformed()
		double add(double value1, double value2){
			double sum = value1+value2;
			return sum;
		}
		
		double mul(double value1,double value2){
			double mul = value1*value2;
			return mul;
		}
		
		double equal(int check){
			if(check ==0){
				sol = add(value1,value2);
			}else if(check == 1){
				sol = value1-value2;
			}else if(check == 2){
				sol = value1*value2;
			}else if(check == 3){
				sol = value1/value2;
			}else{
				sol =0;
			}
			return sol;
		}
	}// end of ActionListener{}
	
	class MyWin extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(null,"진짜로???????????????????");	
			if( result == JOptionPane.OK_OPTION){
				System.exit(0);
			}else{
				f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		} // end of windowClosing()
	} // end of WindowAdapter{}
	
	
	
	String change(String Equation,char ch){
		String temp = new String();
		temp = Equation + ch; 
		return temp;
	}// 현재 사용중인 식 보여주는 함수.
	
	public static void main(String[] args) {
		CalTest cal = new CalTest();
		cal.addLayout();
		cal.eventProc();
	}
}
