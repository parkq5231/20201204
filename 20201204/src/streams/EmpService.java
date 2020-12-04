package streams;

import java.util.List;

public interface EmpService {
	public List getEmpList();// 리스트 조회
	
	public EmployeeVO getSellect(int empId);
	
}