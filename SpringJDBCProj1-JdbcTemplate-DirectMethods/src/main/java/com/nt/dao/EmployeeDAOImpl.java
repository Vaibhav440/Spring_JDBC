//EmployeeDAOImpl.java (DAOImpl class)
package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private  static  final String  GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final  String  GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?)";
	private static final String  GET_EMP_SAL_BY_EMPNO="SELECT SAL FROM EMP WHERE EMPNO=?";
	private  static final  String  EMP_INSERT_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(ENO_SEQ.NEXTVAL,?,?,?)";
	private  static final  String  EMP_UPDATE_QUERY="UPDATE EMP SET SAL=SAL+SAL*? WHERE JOB=?";
	private  static final  String   EMP_DELETE_QUERY="DELETE FROM EMP WHERE SAL>=? AND SAL<=?";
	
	
	@Autowired
	private JdbcTemplate jt;

	public int getEmpsCount() {
		int count=jt.queryForObject(GET_EMPS_COUNT,Integer.class);
		return count;
	}

	public Map<String, Object> getEmployeeByNo(int no) {
		Map<String,Object> map=jt.queryForMap(GET_EMP_BY_NO,no);
		return map;
	}

	public List<Map<String, Object>> getEmployeesByDesg(String desg1,String desg2) {
	   List<Map<String,Object>> list=jt.queryForList(GET_EMPS_BY_DESG,desg1,desg2);
	   return list;
		
	}
	
	
	public double getEmpSalaryByEmpno(int no) {
		  double salary=jt.queryForObject(GET_EMP_SAL_BY_EMPNO,Double.class, no);
		  return salary;
		
	}
	
	public int insertEmployee(String name, String desg, double salary) {
		int count=jt.update(EMP_INSERT_QUERY, name,desg,salary);
		return count;
	}

	public int updateEmployeeSalaryByDesg(double percentage, String desg) {
		  double percentValue=percentage/100.0;
		int count=jt.update(EMP_UPDATE_QUERY,percentValue ,desg);
		return count;
	}

	public int deleteEmployeesBySalaryRange(double startSalary, double endSalary) {
		int  count=jt.update(EMP_DELETE_QUERY,startSalary,endSalary);
		return count;
	}

}
