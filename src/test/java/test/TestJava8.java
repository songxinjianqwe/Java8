package test;

import cn.sinjinsong.java8.domain.Employee;
import cn.sinjinsong.java8.service.MyPredicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestJava8 {

	@Test
	public void test() {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};

		Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);
	}

	@Test
	public void test2() {
		List<Employee> emps = Arrays.asList(new Employee("111", 12, 3382.2), new Employee("222", 13, 44.2),
				new Employee("333", 14, 33482.2), new Employee("444", 15, 332282.2), new Employee("555", 122, 338232.2),
				new Employee("666", 1221, 1.2));
		List<Employee> result = filterEmps(emps,(e) -> e.getSalary() > 10000);
		System.out.println(result);
		result = filterEmps(emps, (e) -> e.getAge() > 30);
		System.out.println(result);
		System.out.println();
		emps.stream().filter((e) -> e.getAge() > 30).forEach(System.out::println);
	}
	
	

	public List<Employee> filterEmps(List<Employee> list,MyPredicate<Employee> pre) {
		List<Employee> emps = new ArrayList<Employee>();
		for (Employee employee : list) {
			if(pre.isValid(employee)){
				emps.add(employee);
			}
		}
		return emps;
	}


}
