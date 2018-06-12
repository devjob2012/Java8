package co.uk.deven.java8.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Employee {
	private long id;
	private String name;
	private String dept;
	private int salary;
}
