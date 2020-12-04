package streams;

import java.util.List;

public class EmpServiceImpl implements EmpService {// 데이터 접근 및 처리

	EmpDAO dao = new EmpDAO();

	@Override
	public List getEmpList() {
		return dao.getEmpList();
	}

	@Override
	public EmployeeVO getSellect(int empId) {
		return dao.getSellect(empId);
	}


}// end of class