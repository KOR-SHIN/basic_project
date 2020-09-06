package project;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IDaoImpl implements IDao {

	private String url = "jdbc:oracle:thin:@Ip:PortNumber/SID";
	private String id = "yourId";
	private String pw = "yourPw";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	@Override
	public String logIn(Map<String, String> params) {
		
		String mem_id = params.get("mem_id");
		String mem_pass = params.get("mem_pass");
		
		Connection con = null;
		Statement state = null;
		ResultSet rs = null;
		
		String login_id = null;
		
		try{
			
			//1. 
			Class.forName(driver);
			
			//2.
			con = DriverManager.getConnection(url, id, pw);
			
			//3.
			state = con.createStatement();
			String sql = "SELECT MEM_ID "
						+"FROM 	 THEATER_MEMBER "
						+"WHERE  MEM_ID = '" + mem_id + "'"
						+"AND    MEM_PASS = '" + mem_pass + "'"
						+"AND    MEM_DELETE = 0";
			
			//4.
			rs = state.executeQuery(sql);
			
			while(rs.next()) {
				login_id = rs.getString("MEM_ID");
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("로딩실패");
		} catch(SQLException e) {
			System.out.println("접속실패");
		} finally {
			
			try{
				if(rs != null) {
					//객체가 생성되지 않았다면 close()를 할 필요가 없다.
					rs.close();
				}
				
				if(state != null) {
					state.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("자원반환 실패");
			}
		}
		
		return login_id;
	}

	@Override
	public List<MemberVO> readAllMember() {
		// TODO Auto-generated method stub
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			//1. Driver loading
			Class.forName(driver);
			
			//2. DB connection
			con = DriverManager.getConnection(url, id, pw);
			
			//3. query
			st = con.createStatement();
			String sql = "SELECT * "
					+ "	  FROM THEATER_MEMBER";
			
			//4. result
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setMem_add1(rs.getString("mem_add1"));
				member.setMem_add2(rs.getString("mem_add2"));
				memberList.add(member);
				
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩실패");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 접속실패");
		} finally {
			
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(st != null) {
					st.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("자원반납 실패");
			}
		}
		
		return memberList;
	}

	@Override
	public MemberVO readMemInfo(String login_id) {
		
		MemberVO member = new MemberVO();
		
		Connection con = null;
		Statement state = null;
		ResultSet rs = null;
		
		try{
			//1. driver loading
			Class.forName(driver);
		
			//2. DB connection
			con = DriverManager.getConnection(url, id, pw);
			
			//3. query
			state = con.createStatement();
			String sql = "SELECT *"
					+ "	  FROM   THEATER_MEMBER"
					+ "   WHERE  MEM_ID = '" + login_id + "'";
		
			rs = state.executeQuery(sql);
			MemberVO memeber = new MemberVO();

			while(rs.next()) {
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_regno1(rs.getString("mem_regno1"));
				member.setMem_regno2(rs.getString("mem_regno2"));
				member.setMem_add1(rs.getString("mem_add1"));
				member.setMem_add2(rs.getString("mem_add2"));
				member.setMem_hp(rs.getString("mem_hp"));
				member.setMem_mail(rs.getString("mem_mail"));
				member.setMem_job(rs.getString("mem_job"));
				member.setMem_mileage(rs.getString("mem_mileage"));
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");
		} catch(SQLException e) {
			System.out.println("데이터베이스 접속 실패");
		} finally {
			try {
				if(rs != null) {
					con.close();
				}
				
				if(state != null) {
					state.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				System.out.println("자원반납 실패");
			}
		}
		//2. DB connection
		
		
		return member;
	}

	@Override
	public boolean createMember(MemberVO newMember) {

		Connection con = null;
		Statement stmt = null;
		
		try {
			
			// loading
			Class.forName(driver);
			
			// DB connection
			con = DriverManager.getConnection(url, id, pw);
			
			// query
			stmt = con.createStatement();
			
			String sql = "INSERT INTO THEATER_MEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1, "
													+ "MEM_REGNO2, MEM_ADD1, MEM_ADD2, MEM_HP, "
													+ "MEM_MAIL, MEM_JOB) "
													+ "VALUES ('" + newMember.getMem_id() + "', '" + newMember.getMem_pass()
														 + "', '" + newMember.getMem_name() + "', '" + newMember.getMem_regno1()
														 + "', '" + newMember.getMem_regno2() + "', '" + newMember.getMem_add1()
														 + "', '" + newMember.getMem_add2() + "', '" + newMember.getMem_hp()
														 + "', '" + newMember.getMem_mail() + "', '" + newMember.getMem_job() + "')";

			int result = stmt.executeUpdate(sql);
			System.out.println("System Log : [Update : " + result + " column]");

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩실패");
			return false;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 접속실패");
			return false;
		} finally {
			
			try {
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("자원반납 실패");
			}
		}
		return true;
	}

	@Override
	public boolean updateMemHp(Map<String, String> info) {
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
			String new_hp = info.get("new_hp");
			String mem_id = info.get("mem_id");
			
			stmt = con.createStatement();
			String sql = "UPDATE THEATER_MEMBER "
					+	 "   SET MEM_HP = '" + new_hp + "'"
					+    " WHERE MEM_ID = '" + mem_id + "'";
			
			int result = stmt.executeUpdate(sql);
			System.out.println("System Log : [Update : " + result + " column]");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩실패");
			return false;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 접속실패");
			return false;
			
		} finally {
			
			try {
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("자원반납 실패");
			}
		}
		
		return true;
	}

	@Override
	public boolean checkDupId(String mem_id) {
	
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean ret = false;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
			stmt = con.createStatement();
			String sql = "SELECT MEM_ID "
					   + "  FROM THEATER_MEMBER "
					   + " WHERE MEM_ID = '" + mem_id + "'";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString("mem_id").equals(mem_id)) {
					ret = true;
				}
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩실패");
			return false;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 접속실패");
			return false;
			
		} finally {
			
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("자원반납 실패");
			}
		}
		
		return ret;
	}

	@Override
	public boolean updateMemAdd(Map<String, String> info) {
		
		Connection con = null;
		Statement stmt = null;
		
		String new_add1 = info.get("new_add1");
		String new_add2 = info.get("new_add2");
		String mem_id = info.get("mem_id");
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
			stmt = con.createStatement();
			String sql = "UPDATE THEATER_MEMBER "
					   + "   SET MEM_ADD1 = '" + new_add1 + "',"  
					   + "       MEM_ADD2 = '" + new_add2 + "'"
					   + " WHERE MEM_ID = '" + mem_id + "'";
			
			int result = stmt.executeUpdate(sql);
			System.out.println("System Log : [Update : " + result + " column]");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩실패");
			return false;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 접속실패");
			return false;
			
		} finally {
			
			try {
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("자원반납 실패");
			}
		}
		return true;
	}

	@Override
	public boolean updateMemMail(Map<String, String> info) {
		Connection con = null;
		Statement stmt = null;
		
		String new_mail = info.get("new_mail");
		String mem_id = info.get("mem_id");
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
			stmt = con.createStatement();
			String sql = "UPDATE THEATER_MEMBER "
					   + "   SET MEM_MAIL = '" + new_mail + "'"  
					   + " WHERE MEM_ID = '" + mem_id + "'";
			
			int result = stmt.executeUpdate(sql);
			System.out.println("System Log : [Update : " + result + " column]");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩실패");
			return false;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 접속실패");
			return false;
			
		} finally {
			
			try {
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("자원반납 실패");
			}
		}
		return true;
	}

	@Override
	public boolean deleteMember(String mem_id) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
			stmt = con.createStatement();
			String sql = "UPDATE THEATER_MEMBER "
					   + "   SET MEM_DELETE = CASE WHEN MEM_DELETE = 0 THEN 1 "
					   + "                    ELSE 1 END "
					   + " WHERE MEM_ID = '" + mem_id +"'";
			
			int result = stmt.executeUpdate(sql);
			System.out.println("System Log : [Update : " + result + " column]");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩실패");
			return false;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 접속실패");
			return false;
			
		} finally {
			
			try {
				
				if(stmt != null) {
					stmt.close();
				}
				
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("자원반납 실패");
			}
		}
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

