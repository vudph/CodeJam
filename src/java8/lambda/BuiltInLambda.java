package java8.lambda;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.stream.Employee;
import java8.stream.EmployeeRepository;

public class BuiltInLambda {
	private Predicate<Employee> salaryGreater100 = emp -> emp.getSalary() > 50000;
	private BiPredicate<Employee, Double> salaryGreater = (emp, s) -> emp.getSalary() > s;
	private EmployeeRepository empRepo = new EmployeeRepository();
	private List<Employee> empList;
	
	public BuiltInLambda() {
		empList = empRepo.getEmployeeList();
	}
	
	public List<Employee> getEmployeesBySalary(double salary) {
		return empList.stream().filter(emp -> salaryGreater.test(emp, salary)).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		BuiltInLambda l = new BuiltInLambda();
		List<Employee> e = l.getEmployeesBySalary(60000);
		
		System.out.println();
	}
}
