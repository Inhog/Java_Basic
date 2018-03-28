package io.xml;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class InfoTest implements ActionListener{

	JFrame frame;
	JTextField tf_name, tf_id, tf_tel, tf_age, tf_gender, tf_home ;
	JButton b_add, b_show, b_search, b_delete, b_cancel, b_exit;
	JTextArea ta;	
	JScrollPane sp;


	public InfoTest() {

		frame		= new JFrame("DBTest");


		tf_name	= new JTextField(15);
		tf_id		= new JTextField(15);
		tf_tel		= new JTextField(15);
		tf_age		= new JTextField(15);
		tf_gender	= new JTextField(15);
		tf_home		= new JTextField(15);

		b_add		= new JButton("Add", new ImageIcon("img/add.gif"));
		b_add.setVerticalTextPosition(SwingConstants.BOTTOM);
		b_add.setHorizontalTextPosition(SwingConstants.CENTER);		
		b_add.setBorder(new BevelBorder(BevelBorder.RAISED));
		b_add.setToolTipText("추가");


		b_show		= new JButton("Show");
		b_search	= new JButton("Modify");
		b_delete	= new JButton("Delete");
		b_cancel	= new JButton("Cancel");
		b_exit		= new JButton("Exit");
		ta			= new JTextArea(20, 50);
		sp 			= new JScrollPane(ta);


	}

	void setup(){

		JPanel p_center  = new JPanel();
		JPanel p_west	 = new JPanel();
		JPanel p_south 	 = new JPanel();

		// west영역 붙이기
		// 화면출력만 하는 라벨 생성 및 붙이기 

		/************************
		 * 이미지 라벨 
		 */
		JLabel ll_name = new JLabel("Name", new ImageIcon("img/cute/1.gif"),JLabel.CENTER);		
		JLabel ll_id   = new JLabel("ID",   new ImageIcon("img/cute/2.gif"),SwingConstants.CENTER);
		JLabel ll_tel  = new JLabel("Tel",  new ImageIcon("img/cute/3.gif"),SwingConstants.CENTER);
		JLabel ll_sex  = new JLabel("Sex",  new ImageIcon("img/cute/4.gif"),SwingConstants.CENTER);
		JLabel ll_age  = new JLabel("Age",  new ImageIcon("img/cute/5.gif"),SwingConstants.CENTER);
		JLabel ll_home = new JLabel("Home", new ImageIcon("img/cute/6.gif"),SwingConstants.CENTER);


		p_west.setLayout( new GridLayout(6,2));
		p_west.add( ll_name);
		p_west.add( tf_name );
		p_west.add( ll_id);
		p_west.add( tf_id );
		p_west.add( ll_tel);
		p_west.add( tf_tel );
		p_west.add( ll_sex);
		p_west.add( tf_gender );
		p_west.add( ll_age);
		p_west.add( tf_age );
		p_west.add( ll_home);
		p_west.add( tf_home );


		// center 영역
		p_center.setLayout(new BorderLayout());
		p_center.add("Center", sp );

		// south 영역
		p_south.setLayout( new GridLayout(1,6));
		p_south.add( b_add );
		p_south.add( b_show );
		p_south.add( b_search );
		p_south.add( b_delete );
		p_south.add( b_cancel );
		p_south.add( b_exit );

		frame.getContentPane().setLayout( new BorderLayout() );
		frame.getContentPane().add("West", p_west );
		frame.getContentPane().add("Center", p_center );
		frame.getContentPane().add("South", p_south );

		frame.pack();
		frame.setTitle("InfoTest");
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void eventProc(){


		// 버튼 이벤트 등록
		b_add.addActionListener( this );
		b_show.addActionListener( this );
		b_search.addActionListener( this );
		b_delete.addActionListener( this );
		b_cancel.addActionListener( this );
		b_exit.addActionListener( this );

		tf_name.addActionListener(this);

	}

	public void actionPerformed( ActionEvent ev ){

		Object evt = ev.getSource();
		if( evt== b_add ){
			saveData();
		}	else if( evt == b_show ){
			readData();
		} 	else if( evt == tf_name ){
			search();
		}	else if( evt == b_delete ){
			removeData();
		}
	}

	void removeData(){
		File f = new File("info.xml");
		try {
			DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docFac.newDocumentBuilder();
			Document doc = docBuild.parse(f);		// file -> 메모리구조(트리구조)변경
			
			NodeList personList = doc.getElementsByTagName("person");	// 태그 이름이 여러개일 수 있으니  알아서 list로 저장하게한다.
			ta.setText("");
			
			for (int i = 0; i < personList.getLength(); i++) {
				Node temp = personList.item(i);
				NodeList childlist = temp.getChildNodes();
				
				for(int j =0;j<childlist.getLength();j++){
					Node node = childlist.item(j);
					
					if(node.getNodeName().equals("name")){
						temp.getParentNode().removeChild(temp);
						Transformer transformer = TransformerFactory.newInstance().newTransformer();
		                Result output = new StreamResult(new File("info.xml"));
		                Source input = new DOMSource(doc);
		                transformer.transform(input, output);
					}
				}
			}
		} catch (Exception e) {
			ta.setText("읽기실패: " + e.getMessage());
		}

	}
	void search(){
//		찾을때 <info>랑 <person> 을 찾아 접근하게끔 바꾸면 계속 가능할 듯
		File f = new File("info.xml");
		try {
			DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docFac.newDocumentBuilder();
			Document doc = docBuild.parse(f);		// file -> 메모리구조(트리구조)변경
			
			NodeList personList = doc.getElementsByTagName("person");	// 태그 이름이 여러개일 수 있으니  알아서 list로 저장하게한다.
			ta.setText("");
			
			for (int i = 0; i < personList.getLength(); i++) {
				Node temp = personList.item(i);
				NodeList childlist = temp.getChildNodes();
				
				for(int j =0;j<childlist.getLength();j++){
					Node node = childlist.item(j);
					
					if(node.getNodeName().equals("name")){
						String searchName =tf_name.getText();
						
						if(searchName.equals(node.getTextContent())){
							tf_id.setText(node.getNextSibling().getTextContent());
							tf_tel.setText(node.getNextSibling().getTextContent());
							tf_age.setText(node.getNextSibling().getTextContent());
							tf_gender.setText(node.getNextSibling().getTextContent());
							tf_home.setText(node.getNextSibling().getTextContent());
						}
					}
				}
			}
		} catch (Exception e) {
			ta.setText("읽기실패: " + e.getMessage());
		}
		
	}
	
	void readData(){
		File f = new File("info.xml");
		try {
//			이 부분은 당췌 알수가 없다.
			DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docFac.newDocumentBuilder();
			Document doc = docBuild.parse(f);		// file -> 메모리구조(트리구조)변경
			
//			ta.setText(doc.getDocumentElement().getNodeName());
			NodeList personList = doc.getElementsByTagName("person");	// 태그 이름이 여러개일 수 있으니  알아서 list로 저장하게한다.
//			ta.setText("인원수 : " + personList.getLength());
			ta.setText("");
			
			// 나눌 수 있는 태그로 나누고 나눈만큼 각 Node의 내용들을 읽어서 TextArea에 출력한다.
			for (int i = 0; i < personList.getLength(); i++) {
				Node temp = personList.item(i);
//				태그를 노드라고 생각하면 된다?
//				person 태그에 해당하는 노드들을 얻어오고
				NodeList childlist = temp.getChildNodes();
//				해당 person 마다 자식노드들을 Nodelist에 담는다.
				for(int j =0;j<childlist.getLength();j++){
					Node node = childlist.item(j);
					ta.append(node.getTextContent() + "\t");
				}
				ta.append("\n");
			}
		} catch (Exception e) {
			ta.setText("읽기실패: " + e.getMessage());
		}
		
	}
	
	void saveData(){
		try{
			File f = new File("info.xml");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			long pos = raf.length() - new String("</info>").length();
//			long pos = raf.length() -7;	// </info>
			
			
			if(pos < 0){	// 처음 데이터를 저장할때
				String tag = "<info>" + makeTags() + "</info>";
				raf.write(tag.getBytes());	//string -> byte[]
			}else{		//이미 데이터가 있는경우
				raf.seek(pos);
				String tag = makeTags() + "</info>";
				raf.write(tag.getBytes());
			}
			
			raf.close();
			
			//clear textarea.
			clearTextFields();
			
		}catch(Exception ex){
			ta.setText("save Failure : " + ex.getMessage());
		}
	}

	String makeTags(){
		StringBuffer sb = new StringBuffer();
		sb.append("<person>");
		sb.append("<name>" + tf_name.getText()+"</name>");
		sb.append("<id>" + tf_id.getText()+"</id>");
		sb.append("<tel>" + tf_tel.getText()+"</tel>");
		sb.append("<gender>" + tf_gender.getText()+"</gender>");
		sb.append("<age>" + tf_age.getText()+"</age>");
		sb.append("<home>" + tf_home.getText()+"</home>");
		sb.append("</person>");
		return sb.toString();
	}

	void clearTextFields(){
		tf_tel.setText("");
		tf_name.setText("");
		tf_id.setText("");
		tf_age.setText("");
		tf_home.setText("");
		tf_gender.setText("");
	}
	public static void main(String args[]) {		
		InfoTest mainFrame = new InfoTest();
		mainFrame.setup();
		mainFrame.eventProc();
	}
}
