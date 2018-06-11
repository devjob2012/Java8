package co.uk.dev.java8.examples.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import co.uk.dev.java8.examples.model.Employee;

public class LambdaExample {

	public static void main(String[] args) {
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

		List<Employee> lsEmployees = new ArrayList<>();

		lsEmployees.add(emp1);
		lsEmployees.add(emp2);
		lsEmployees.add(emp3);
		lsEmployees.add(emp4);

		LambdaExample lex = new LambdaExample();
		lex.compare(lsEmployees);
		System.out.println(lsEmployees);
	}

	private void compare(List<Employee> lsEmployees) {
		Collections.sort(lsEmployees, (e1, e2) -> e1.getSalary() - e2.getSalary());
	}
}
