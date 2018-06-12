package co.uk.deven.java8.example.data;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.github.javafaker.service.RandomService;

import co.uk.deven.java8.example.model.Employee;

public class EmployeeData {
	final Faker faker = new Faker();
	final RandomService randomService = new RandomService();

	public void populateEmployeeData() {

		faker.company();
	}

	public static void main(String[] args) {
		EmployeeData empData = new EmployeeData();
		empData.getEmployeeData().forEach(System.out::println);

	}

	public List<Employee> getEmployeeData() {

		List<Employee> lsEmployee = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Employee emp = new Employee();
			emp.setId(i);
			emp.setName(faker.name().firstName());
			emp.setSalary(randomService.nextInt(i + 100) * 100);
			emp.setDept(faker.commerce().department());
			lsEmployee.add(emp);
		}
		return lsEmployee;
	}
}
