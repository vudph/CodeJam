package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
https://stackify.com/streams-guide-java-8/

- forEach() loops over the stream elements, calling the supplied function on each element.
- map() produces a new stream after applying a function to each element of the original stream. The new stream could be different type
- collect() gets stuff out of the stream once we are done with all the processing
- filter() produces a new stream that contains elements of the original stream that pass a given test (specified by a Predicate)
- findFirst() returns an Optional for the first entry in the stream; the Optional can be empty
- toArray() gets an array out of the stream


 */
public class StreamOperations {
	private List<Employee> empList;
	private EmployeeRepository empRepo = new EmployeeRepository();
	
	public StreamOperations() {
		empList = empRepo.getEmployeeList();
	}
	
	protected void incrementSalary(double increment) {
		empList.stream().forEach(emp -> incrementSalaryByEmployee(emp, increment));
	}
	
	protected void incrementSalaryParallel(double increment) {
		empList.parallelStream().forEach(emp -> incrementSalaryByEmployee(emp, increment));
	}
	
	private void incrementSalaryByEmployee(Employee emp, double increment) {
		emp.salaryIncrement(increment);
	}
	
	protected List<Employee> getEmployeesByIds(Integer ids[]) {
//		 return Stream.of(ids).map(empRepo::getEmployeeById).collect(Collectors.toList());
		return Stream.of(ids).map(id -> empRepo.findById.apply(id)).collect(Collectors.toList());
	}
	
	protected List<Employee> collectEmployees() {
		List<Employee> list = empList.stream().collect(Collectors.toList());
		list.get(0).salaryIncrement(10000);
		list.add(new Employee(4, "Vu", 100000));
		return list;
	}
	
	protected List<Employee> getEmployeesBySalary(double salary) {
		Predicate<Double> sal = s -> s > salary; 
		List<Employee> l = empList.stream().filter(e -> e != null).filter(e -> sal.test(e.getSalary())).collect(Collectors.toList());
		return l;
	}
	
	protected void flatMap() {
		List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"), Arrays.asList("Mark", "Zuckerberg"));

		List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		StreamOperations streamOper = new StreamOperations();
		long t1, t2;
		t1 = System.currentTimeMillis();   
		streamOper.incrementSalary(100.0);
		t2 = System.currentTimeMillis();
        System.out.println("Sequential Stream Time Taken?= " + (t2-t1) + "\n");
 
        t1 = System.currentTimeMillis();
		streamOper.incrementSalaryParallel(200.0);
		t2 = System.currentTimeMillis();
		System.out.println("Parallel Stream Time Taken?= " + (t2-t1));
		
		List<Employee> l0 = streamOper.getEmployeesByIds(new Integer[]{2, 3});
		
		List<Employee> l1 = streamOper.collectEmployees();
		
		List<Employee> l2 = streamOper.getEmployeesBySalary(70000);
		
		streamOper.flatMap();
		
		System.out.println();
	}
}
