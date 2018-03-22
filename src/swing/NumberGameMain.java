package swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class  NumberGameMain
{
	public static void main(String[] args) 
	{
		// 1. 화면 구성
		NumberGameFrame gameFrm = new NumberGameFrame();

		// 2. 랜덤 문자 지정하기
		gameFrm.initChar();

		// 3. 버튼에 문자 보여주기
		gameFrm.showAnswer();
	}
}

class NumberGameFrame extends JFrame implements ActionListener
{
	
	// 이미지 버튼을 넣을 패널
	JPanel panel = new JPanel();
	
	// 맞춘 짝 갯수, 틀린 횟수를 넣을 패널
	JPanel scorepanel = new JPanel();
	
	// 경고 표시 패널
	JPanel cautionpanel = new JPanel();
	
	// 1. 화면 구성
	int getsu = 4;
	JButton la[][] = new JButton[getsu][getsu];
	
	// 게임에 활용될 이미지
	ImageIcon[] Icon = new ImageIcon[(getsu*getsu/2)];
	
		
	// 맞춘 짝 갯수, 틀린 횟수 
	JLabel L_clear = new JLabel("맞춘 횟수");
	JLabel L_fail = new JLabel("틀린 횟수");
	JTextField clear = new JTextField();
	JTextField fail = new JTextField();
	JTextField caution = new JTextField("열번 틀리면 게임 종료!");
	int clear_cnt =0;
	int fail_cnt=0;

	// 2. 버튼에 지정할 문자변수 선언
	int [][] answers = new int[getsu][getsu];

	// 5. 첫번째 선택된 버튼을 저장할 변수와 위치 변수 
	JButton firstClick = null;
	int firstRow, firstCol;

	/***********************************************
	 1. 화면 구성
	*/
	NumberGameFrame()
	{
		
		setLayout(new BorderLayout());
		scorepanel.setLayout(new GridLayout());
		// getsu,getsu GridLayout으로 프레임 구성
		panel.setLayout(new GridLayout( getsu, getsu ));
		clear.setText("0");
		fail.setText("0");
		caution.setEditable(false);
		clear.setEditable(false);
		fail.setEditable(false);
		
		cautionpanel.add(caution);
		scorepanel.add(L_clear);
		scorepanel.add(clear);
		scorepanel.add(L_fail);
		scorepanel.add(fail);
		// 모든 버튼 돌아가면서 
		for( int row = 0; row < getsu ; row++)
		{
			for( int col=0; col < getsu; col++ ) 
			{
				// 버튼 생성하고 버튼 추가
				la[row][col] = new JButton( );
				panel.add( la[row][col] );			
				
				// 각각의 버튼에 이벤트 등록
				la[row][col].addActionListener(this);		
				
				// answers 배열 초기화
				answers[row][col] = 0;
			}
		}
		add(cautionpanel,BorderLayout.SOUTH);
		add(scorepanel,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		setSize( 500,700 );
		setVisible( true );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	/***********************************************
	 2. 문자 지정
	*/
	void initChar()
	{
		for(int i=0;i<(getsu*getsu)/2;i++){
			Icon[i] = new ImageIcon("..\\JavaBasic\\src\\swing\\img\\"+(i+1)+".JPG");
		}
		// 지역변수를 사용할땐 반드시 초기화
		int alpha = 0;
		COMEBACK:
		for(int i=0;i<getsu*getsu;){
			// 문자를 선택
			if(i%2 == 0){
				// 임의의 알파벳을 구해서 출력
				alpha = (int)(Math.random()*getsu*getsu/2)+1;
				//System.out.println(alpha);
				//중복 처리 해야함.
				for(int r=0;r<getsu;r++){
					for(int c=0;c<getsu;c++){
						// 다 돌면서 앞서 넣은 문자가 있다면 위로 올라간다.
						if(answers[r][c] == alpha)	continue COMEBACK;
					}
				}
			}
			// 위치를 선택
			boolean flag = false;
			do{
				// 0,1,2,3 중 하나 나옴
				int row = (int)(Math.random()*getsu);
				int col = (int)(Math.random()*getsu);
				if(answers[row][col] == 0){
					answers[row][col] = alpha;
					flag = true;
					i++;
				}
			}while(!flag);
		}
	}

	/***********************************************
	 3. 지정된 문자를 버튼에 보여주기
	*/
	void showAnswer()
	{
		for(int row=0;row<getsu;row++){
			for(int col =0;col<getsu;col++){
//				String 형으로 형변환하는 메서드 String.valueOf
//				la[row][col].setText(String.valueOf(answers[row][col]));
//				 이미지로바꾸자
				la[row][col].setIcon(insertImage(answers[row][col]));
			}
		}
		
		try {
			// 밀리초
			Thread.sleep(2000);
		} catch (InterruptedException e) {	}
		
		for(int row=0;row<getsu;row++){
			for(int col =0;col<getsu;col++){
				la[row][col].setIcon(null);
			}
		}
	}
	
	/***********************************************
	  4. 이벤트 처리
	*/
	
	public void actionPerformed( ActionEvent ev )
	{
		// JButton형 변수 선언 하고 다운캐스팅으로 이벤트발생한 소스 알아내기.
		JButton evtBtn = (JButton)ev.getSource();
		// 마찬가지로 버튼 다 돌면서
		for( int i=0; i< getsu; i++ )
		{
			for( int j=0; j < getsu; j++ )
			{
				// 해당 위치의 버튼에서 이벤트가 발생했다면
				if( evtBtn == la[i][j] )
				{
					// 첫번쨰 선택한 버튼
					if(firstClick == null)
					{
						firstClick = evtBtn;
						firstRow = i;
						firstCol = j;
						// 컴퓨터 색상 : R(red) G(green) B(blue)
						firstClick.setIcon(insertImage(answers[i][j]));
					}else
					{	//두번째 선택한 버튼
						if(answers[firstRow][firstCol] == answers[i][j])
						{
							if(!(firstRow==i && firstCol ==j))
							{
								// 정답인 경우
								clear_cnt++;
								clear.setText(String.valueOf(clear_cnt));
								firstClick.setIcon(insertImage(answers[firstRow][firstCol]));								
								firstClick.setEnabled(false);
								evtBtn.setIcon(insertImage(answers[i][j]));
								evtBtn.setEnabled(false);
								firstClick = null;
								// 맞춘 갯수가 총 이미지 짝의 갯수와 맞다면
								if(clear_cnt == getsu*getsu/2){
									JOptionPane.showMessageDialog(null,"모두 맞추셨습니다. 축하합니다.");
								}
							}
						}else
						{	
							// 틀린횟수 카운트
							fail_cnt++;
							// 틀린횟수 표시
							fail.setText(String.valueOf(fail_cnt));
							// 10번 이상 틀리면 게임종료
							if(fail_cnt >=10){
								JOptionPane.showMessageDialog(null,"10번 이상 틀렸습니다 게임종료.");
								System.exit(0);
							}
							// 틀리면 이미지 안보이기.
							evtBtn.setIcon(null);
							firstClick.setIcon(null);
//							firstClick.setBackground(null);
							// 다시 첫번째 클릭으로
							firstClick = null;
						}
					}
				}
			}
		}
	}
	/***********************************************
	  5. 버튼 이미지 삽입 처리.
	*/
	ImageIcon insertImage(int answers){
		ImageIcon image = new ImageIcon(); 
				switch(answers){
				case 1:
					image = Icon[0];
					break;
				case 2:
					image =Icon[1];
					break;
				case 3:
					image =Icon[2];		
					break;
				case 4:
					image =Icon[3];		
					break;
				case 5:
					image =Icon[4];
					break;
				case 6:
					image =Icon[5];
					break;
				case 7:
					image =Icon[6];
					break;
				case 8:
					image =Icon[7];
					break;
				}
				return image;
			}
}