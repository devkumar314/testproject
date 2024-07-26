package tests.OOPS;

public class oopsTest {

	
	public static void main(String[] args) {
		
		Employee employee1 = new Employee("Devender", 40, 10000, "Noida");
		
		Employee employee2 = new Employee("Amit", 35, 40000, "US");
		
		employee1.raiseSalary("Devender");
		
		System.out.println("Salary of the employee: "+ employee1.getEmployee() + " is : " + employee1.getSalary());
		System.out.println("Salary of the employee: "+ employee2.getEmployee() + " is : " + employee2.getSalary());
	}
}
