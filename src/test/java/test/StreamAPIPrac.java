package test;

import cn.sinjinsong.java8.domain.Employee;
import cn.sinjinsong.java8.domain.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPIPrac {
	List<Employee> emps =  Arrays.asList(
			new Employee("111", 12, 3382.2, Status.Busy), 
			new Employee("222", 13, 44.2,Status.Free),
			new Employee("333", 14, 33482.2,Status.Busy), 
			new Employee("444", 15, 332282.2,Status.Free), 
			new Employee("555", 122, 338232.2,Status.Vacation),
			new Employee("666", 1221, 1.2,Status.Vacation));
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = list.stream().map((i) -> i*i).collect(Collectors.toList());
		System.out.println(list2);
		
	}
	
	@Test
	public void test2(){
		Optional<Integer> count = emps.stream().map((e) -> 1).reduce(Integer::sum);
		System.out.println(count.get());
	}
}
