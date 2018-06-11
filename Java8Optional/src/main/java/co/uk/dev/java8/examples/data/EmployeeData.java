package co.uk.dev.java8.examples.data;

import java.util.ArrayList;
import java.util.List;

import co.uk.dev.java8.examples.model.Employee;

public class EmployeeData {
	public static List<Employee> getEmployees() {
		List<Employee> lsEmployee = new ArrayList<>();
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		Employee emp4 = new Employee();

		emp1.setDept("1");
		emp1.setName("James");
		emp1.setSalary(1000);

		emp2.setDept("2");
		emp2.setName("Kate");
		emp2.setSalary(1200);

		emp3.setDept("3");
		emp3.setName("Adam");
		emp3.setSalary(1500);

		emp4.setDept("4");
		emp4.setName("Pickle");
		emp4.setSalary(800);
		lsEmployee.add(emp1);
		lsEmployee.add(emp2);
		lsEmployee.add(emp3);
		lsEmployee.add(emp4);

		return lsEmployee;
	}
}
