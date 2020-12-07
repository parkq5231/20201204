package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExample5 {
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

		Stream<EmployeeVO> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());

		// 1.salary>10000인 사원
		System.out.println("salary>10000인 사원.");// 실행되야할 return 구문이 1개라면 구문생략가능

		list.stream().filter(t -> t.getSalary() > 10000).forEach(s -> s.showEmpInfo());
		// 2. 부서번호가 50번인 사원들의 급여 합계(평균)
		System.out.println("부서번호가 50인 사원.");// sql 구문은 저것만 가져오고 나머지 구문은 java에 따라야하는듯
		// list.stream().filter(t -> t.getDeptId() == 50).forEach(s -> s.showEmpInfo());
		double avg = list.stream().filter(t -> t.getDeptId() == 50)//
				.mapToInt(a -> a.getSalary())//
				.average().getAsDouble();

		// 소수점자리 2번째까지 나오게 하기 위한 문장
		DecimalFormat dcm = new DecimalFormat("00.##");
		System.out.println(dcm.format(avg));
		//

		System.out.println(avg);
		// 3.급여가 5000~10000인 사원
		System.out.println("급여가 5000~10000인 사원.");
		list.stream().filter(t -> t.getSalary() > 5000 && t.getSalary() < 10000)//
				.forEach(s -> s.showEmpInfo());

	}// end of main
}// end of class
