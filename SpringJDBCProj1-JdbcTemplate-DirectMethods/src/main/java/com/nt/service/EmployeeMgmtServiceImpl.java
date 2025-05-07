// EmployeeMgmtServiceImpl.java  (ServiceImpl class)
package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO empDAO;

	
	public int showEmployeesCount() {
		//use dao
		int count=empDAO.getEmpsCount();
		return count;
	}

	public Map<String, Object> fetchEmployeesByNo(int no) {
		 //use DAO
		return  empDAO.getEmployeeByNo(no);
		
	}
	

	public List<Map<String, Object>> fetchEmpsByDesgs(String desg1, String desg2) {
		return  empDAO.getEmployeesByDesg(desg1, desg2);
	
	}

	public double fetchEmpSalaryByNo(int no) {
	  return  empDAO.getEmpSalaryByEmpno(no);
	}
	
	public String registerEmployee(String ename, String desg,double salary) {
		int count=empDAO.insertEmployee(ename, desg, salary);
		return  count==0?"Employee not registered":"Employee registered";
	}
	
	  public   String    hikeEmployeeSalaryByDesg(double percentage,String desg) {
		  int count=empDAO.updateEmployeeSalaryByDesg(percentage, desg);
		  return  count==0?"Employees not found fro salary updation": count+" no.of Employees Salary is hiked";
	  }
	  
	  
	public String fireEmployeesBySalaryRanage(double start, double end) {
		int count=empDAO.deleteEmployeesBySalaryRange(start, end);
		  return  count==0?"Employees not found for deletion": count+" no.of Employees  are found and deletion";
			 	
	}

}
