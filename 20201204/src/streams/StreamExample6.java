package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;

public class StreamExample6 {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>();
		try {
			String sql = "select * from emp1 order by salary";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();// 결과값이 rs에 담김

			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();// 인스턴스1개 선언
				emp.setEmployeeId(rs.getInt("employee_id"));// emp에 값을 담아줌
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDeptId(rs.getInt("department_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Stream<EmployeeVO> stream = list.stream();

		// 2. 부서번호가 50번인 사원들의 급여 합계(평균)
		System.out.println("부서번호가 40인 사원.");// sql 구문은 저것만 가져오고 나머지 구문은 java에 따라야하는듯
		// list.stream().filter(t -> t.getDeptId() == 50).forEach(s -> s.showEmpInfo());
		OptionalDouble avg = list.stream()//
				.filter(t -> t.getDeptId() == 50)//
				.mapToInt(a -> a.getSalary())//
				.average();
		System.out.println("평균: " + avg.orElse(0.0));

		avg.ifPresent(new DoubleConsumer() {
			@Override
			public void accept(double value) {
				System.out.println(avg.getAsDouble());
			}
		});

	}// end of main
}// end of class
