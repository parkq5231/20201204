package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

//salary >= 10000인 사원의 사원번호,이름 메일 급여 출력
//50번 부서의 급여 합계 (평균) 구하기
//salary BETWEEN 5000 AND 10000인 사원번호,이름,메일,급여 출력
//mapping이 중요
//
//public class StreamExample4 {
//
//	public static void main(String[] args) {
//
//		Scanner scn = new Scanner(System.in);
//		EmpService service = new EmpServiceImpl();
//
//		List<EmployeeVO> list = service.getEmpList();
//		for (Object vo : list) {
//			EmployeeVO emp = (EmployeeVO) vo;
//			emp.showEmpInfo();
//		}
// Stream<EmployeeVO> strStream = Arrays.stream(list);

//	}// end of main
//}// end of class