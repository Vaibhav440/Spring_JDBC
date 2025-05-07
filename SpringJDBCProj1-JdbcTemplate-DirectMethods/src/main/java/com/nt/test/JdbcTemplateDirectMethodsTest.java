//JdbcTemplateDirectMethodsTest.java (Client App)
package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IEmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		//create IOC container 
		ClassPathXmlApplicationContext ctx=
				  new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Service class obj
		IEmployeeMgmtService service=ctx.getBean("empService",IEmployeeMgmtService.class);
		//invoke the b.method
		  int count=service.showEmployeesCount();
		  System.out.println("employees count:"+count);
		  System.out.println("__________________________");
		  Map<String,Object> map=service.fetchEmployeesByNo(7499);
		  System.out.println("7499 employee details are ::"+map);
		  
		  System.out.println("________________________");
		  List<Map<String,Object>> list= service.fetchEmpsByDesgs("CLERK", "MANAGER");
		  list.forEach(m->{
			   System.out.println(m);
		  });
		  
		  System.out.println("________________________");
		  
		  System.out.println("7477 emp salary::"+service.fetchEmpSalaryByNo(7499));
		  
			/*  System.out.println("______________________");
			  String msg=service.registerEmployee("ramesh","MANAGER",56789.0f);
			  System.out.println(msg);*/
		  
			/*String  msg1=service.hikeEmployeeSalaryByDesg(15.0f, "CLERK11");
			System.out.println(msg1);
			*/
		  
		  String msg3=service.fireEmployeesBySalaryRanage(90000.0, 100000.0);
		  System.out.println(msg3);
		  
		  // close the IOC container
		  ctx.close();

	}

}
