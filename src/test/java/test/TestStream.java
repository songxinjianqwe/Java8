package test;

import cn.sinjinsong.java8.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class TestStream {
	List<Employee> emps =  Arrays.asList(new Employee("111", 12, 3382.2), new Employee("222", 13, 44.2),
			new Employee("333", 14, 33482.2), new Employee("444", 15, 332282.2), new Employee("555", 122, 338232.2),
			new Employee("666", 1221, 1.2));
	@Test
	public void test() {
		// 1. Collection 提供了两个方法 stream() 与 parallelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream(); // 获取一个顺序流
		Stream<String> parallelStream = list.parallelStream(); // 获取一个并行流

		// 2. 通过 Arrays 中的 stream() 获取一个数组流
		Integer[] nums = new Integer[10];
		Stream<Integer> stream1 = Arrays.stream(nums);

		// 3. 通过 Stream 类中静态方法 of()
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

		// 4. 创建无限流
		// 迭代
		Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
		stream3.forEach(System.out::println);

		// 生成
		Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
		stream4.forEach(System.out::println);
	}
	
	@Test
	public void test2(){
		emps.stream()
			.filter((e) -> e.getAge() > 20)
			.limit(1)
			.forEach(System.out::println);
		
	}
	
	@Test
	public void test3(){
		List<String> strs = Arrays.asList("aaa","bbb","ccc","ddd");
		strs.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
	}
	
	@Test
	public void test4(){
		emps.stream().map(Employee::getName).forEach(System.out::println);
	}
	
	@Test
	public void test5(){
		List<String> strs = Arrays.asList("ddd","ccc","aaa","bbb");
		strs.stream().sorted().forEach(System.out::println);
	}
	
	@Test
	public void test6(){
		emps.stream().sorted((e1,e2) -> e1.getAge() - e2.getAge()).forEach(System.out::println);
	}
}
