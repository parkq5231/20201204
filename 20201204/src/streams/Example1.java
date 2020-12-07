package streams;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

public class Example1 {
	public static void main(String[] args) {
		Connection conn = DAO.getConnection();
		List<EmployeeVO> list = new ArrayList<>();

		try {
			String sql = "Select * from employees";
			PreparedStatement ppst = conn.prepareStatement(sql);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDeptId(rs.getInt("department_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("사운");
		Stream<EmployeeVO> stream = list.stream();
		stream.forEach(s -> s.showEmpInfo());
		list.stream().filter(t -> t.getSalary() > 5000).forEach(s -> s.showEmpInfo());

		System.out.println("부서번호가 50인 사원 평균급여.");
		OptionalDouble avg = list.stream().filter(t -> t.getDeptId() == 50)//
				.mapToInt(t -> t.getSalary()).average();
		System.out.println(avg.orElse(0.0));
		avg.ifPresent((value) -> System.out.println("급여요" + avg.getAsDouble()));

		System.out.println("급여5000~8000사이");
		list.stream().filter(t -> t.getSalary() > 5000 && t.getSalary() < 8000).forEach(s -> s.showEmpInfo());

	}// end of main
}// end of class
