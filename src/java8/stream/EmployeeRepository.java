package java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class EmployeeRepository {
	private List<Employee> empList = new ArrayList<>();
	private Map<Integer, Employee> empMap = new HashMap<>();
	
	public Function<Integer, Employee> findById = (id) -> getEmployeeById(id);
	
	
	public EmployeeRepository() {
		initEmpList();
	}
	
	private void initEmpList() {
		Employee e1 = new Employee(1, "Alibabu", 50000);
		Employee e2 = new Employee(2, "Muhammad", 60000);
		Employee e3 = new Employee(3, "Peter", 70000);
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empMap.put(e1.getId(), e1);
		empMap.put(e2.getId(), e2);
		empMap.put(e3.getId(), e3);
	}
	
	public Employee getEmployeeById(int id) {
		return empMap.get(id);
	}
	
	public List<Employee> getEmployeeList() {
		return empList;
	}
	
	
	
	
}
