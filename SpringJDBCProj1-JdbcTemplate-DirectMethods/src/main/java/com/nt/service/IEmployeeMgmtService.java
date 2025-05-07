//IEmployeeMgmtService.java (service Interface)
package com.nt.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMgmtService {
      public  int  showEmployeesCount();
      public  Map<String,Object>  fetchEmployeesByNo(int no);
      public   List<Map<String,Object>> fetchEmpsByDesgs(String desg1,String desg2);
      public   double    fetchEmpSalaryByNo(int no);
      public   String   registerEmployee(String ename,String desg, double salary);
      public   String    hikeEmployeeSalaryByDesg(double percentage,String desg);
      public   String  fireEmployeesBySalaryRanage(double start,double end);
      
}
