package co.uk.dev.java8.examples.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private String name;
    private String dept;
    private int salary;
}
