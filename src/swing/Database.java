package swing;
import java.sql.*;

// Create by Inho 2018. 4. 10. 오후 2:04:53

public class Database {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@70.12.115.62:1521:orcl";
	String user = "scott";
	String pw = "tiger";
	Connection con;
	
	public Database() throws Exception{
		// 1. 드라이버 로딩
			Class.forName(driver);
		// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pw);
	}
	
	public void insertData(InfoVO vo) throws SQLException{
		// 3. sql 자알 만들기
		String sql = "INSERT INTO info_tab "
				+ " VALUES(?,?,?,?,?,?)";
		// 4. sql 전송 객체 만들기
		PreparedStatement pst = con.prepareStatement(sql);
		//(2) 넘어온 데이터를 ?에 지정
		pst.setString(1, vo.getTel());
		pst.setString(2, vo.getName());
		pst.setString(3, vo.getId());
		pst.setString(4, vo.getGender());
		pst.setInt(5, vo.getAge());
		pst.setString(6, vo.getHome());
		// 5. sql 전송
		pst.executeQuery();
		// 6. 닫기
		pst.close();
	}
	public InfoVO selectByPk(String tel)throws Exception{
		InfoVO vo = new InfoVO();
		//3. SQL 문장 만들기
		String sql = "SELECT * FROM info_tab WHERE tel = '"+ tel + "'";
		//4. SQL 전송객체 얻어오기
		Statement st = con.createStatement();
		//5. SQL 전송 
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()){
			vo.setTel(rs.getString("TEL"));
			vo.setName(rs.getString("NAME"));
			vo.setId(rs.getString("JUMIN"));
			vo.setGender(rs.getString("GENDER"));
			vo.setAge(rs.getInt("AGE"));
			vo.setHome(rs.getString("HOME"));
		}
		//6. 닫기(Connection 제외)
		rs.close();
		st.close();
		return vo;
	}
	
	public void updateData(InfoVO vo) throws SQLException{
		// 3. sql 자알 만들기
		String sql = "UPDATE info_tab SET name = ?, JUMIN =?, GENDER =?, AGE = ?, HOME =?"
				+ " WHERE TEL = ?";
		// 4. sql 전송 객체 만들기
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, vo.getName());
		pst.setString(2, vo.getId());
		pst.setString(3, vo.getGender());
		pst.setInt(4, vo.getAge());
		pst.setString(5, vo.getHome());
		pst.setString(6, vo.getTel());

		// 5. sql 전송
		pst.executeQuery();
		// 6. 닫기
		pst.close();
	}
	
	public void deleteData(String tel)throws Exception{
		InfoVO vo = new InfoVO();
		//3. SQL 문장 만들기
		String sql = "DELETE FROM info_tab WHERE tel = '"+ tel + "'";
		//4. SQL 전송객체 얻어오기
		Statement st = con.createStatement();
		//5. SQL 전송 
		st.executeUpdate(sql);
		//6. 닫기(Connection 제외)
		st.close();
	}
	
}