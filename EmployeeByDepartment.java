/**
 * 
 */
package com.basic.collection_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 */
public class EmployeeByDepartment {
	public static void main(String[] args) {
		List<Employee> emp=Arrays.asList(new Employee("pooja","cs",20000),new Employee("Anagha","ENTC",30000),
				new Employee("priya","cs",40000),new Employee("rekha","ENTC",40000));
		
		//===========================Group employees by department=======================================
		
		Map<String,List<Employee>> depart=emp.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(depart);
		
		//==========================Highest salary per department===========================================
		
		Map<String, Optional<Employee>> Salary=emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary)))); 
		
		Salary.forEach((dep, employee) ->
        System.out.println(dep + " -> " +
           employee.get().getSalary()));
		
		//===================Find the employee with highest salary in each department=============================
		Map<String, Optional<Employee>> salary=emp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.minBy(Comparator.comparing(Employee::getSalary))));
		
		salary.forEach((dep, employee) ->
        System.out.println(dep + " -> " +
                employee.get().getName() + " -> " +
                employee.get().getSalary()));
	
	}

}
