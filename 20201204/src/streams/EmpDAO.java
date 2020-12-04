package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {// 데이터 처리 기능을 넣을 것
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;

	// 전체조회
	public List getEmpList() {
		conn = DAO.getConnection();
		sql = "select* from emp1 order by 1";
		List list = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				// first_name이라는 문자열 값을 rs에서 찾아 그 값을 vo의setFirstName에 넣어주겠단 소린가
				list.add(vo);// 위 두줄 입력한 값이 여기에 담김
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 1번 조건 조회(salary 10000이상)
	public EmployeeVO getSellect(int empId) {
		conn = DAO.getConnection();
		sql = "SELECT * FROM emp1 WHERE salary =10000";
		EmployeeVO vo = new EmployeeVO();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				vo.setEmail(rs.getString("email"));
				vo.setSalary(rs.getInt("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;

	}

}// end of class