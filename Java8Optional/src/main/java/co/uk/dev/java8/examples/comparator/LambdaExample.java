package co.uk.dev.java8.examples.comparator;

import java.util.Collections;
import java.util.List;

import co.uk.dev.java8.examples.data.EmployeeData;
import co.uk.dev.java8.examples.model.Employee;

public class LambdaExample {

	public static void main(String[] args) {

		List<Employee> lsEmployees = EmployeeData.getEmployees();

		LambdaExample lex = new LambdaExample();
		Collections.shuffle(lsEmployees);
		lex.compare(lsEmployees);
		lsEmployees.forEach((t) -> System.out.println(t));
	}

	private void compare(List<Employee> lsEmployees) {
		Collections.sort(lsEmployees, (e1, e2) -> e1.getSalary() - e2.getSalary());
	}
}
