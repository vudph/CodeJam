package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.stream.Employee;
import java8.stream.EmployeeRepository;

/*

- Supplier<T> is used to generate objects/results when no input/parameter is required

 */
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
		
		int array[] = new int[]{1,2,3,4};

		int sum = Arrays.stream(array).reduce(0, (n1, n2) -> n1 + n2);
		System.out.println(sum);
		OptionalInt min = Arrays.stream(array).min();
		System.out.println(min.getAsInt());
		List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
		 
        Optional<Integer> minNumber = list.stream().min((i, j) -> i.compareTo(j));
		System.out.println(minNumber);
	}
}
