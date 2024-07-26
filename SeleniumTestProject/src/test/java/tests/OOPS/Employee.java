package tests.OOPS;

public class Employee {
	
	String name;
	int age;
	double salary;
	String location;

	
	public Employee(String name, int age, int salary, String location){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.location = location;
	}

	public String getEmployee() {
		return this.name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public void raiseSalary(String name) {
		this.salary = salary * 2;
	}
	
}
