//IEmployeeDAO.java
package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
      public int getEmpsCount();
      public  Map<String,Object>  getEmployeeByNo(int no);
      public  List<Map<String,Object>>  getEmployeesByDesg(String desg1,String desg2);
      public  double    getEmpSalaryByEmpno(int no);
      public   int   insertEmployee(String name,String desg, double salary);
      public   int    updateEmployeeSalaryByDesg(double percentage,String desg);
      public   int   deleteEmployeesBySalaryRange(double startSalary,double endSalary);
      
}
