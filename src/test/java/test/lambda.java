package test;

import cn.sinjinsong.java8.domain.Employee;
import cn.sinjinsong.java8.service.MyCalc;
import cn.sinjinsong.java8.service.MyFun;
import cn.sinjinsong.java8.service.MySample;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lambda {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		new Thread(
				() -> System.out.println("heheda")
				).start();
	}
	
	@Test
	public void test2() {
		tttt222(new Employee("1231", 12, 2333.22),(e) -> System.out.println(e));
	}
	
	public void tttt222(Employee emp,MySample<Employee> sample){
		sample.test(emp);
	}
	
	@Test
	public void test3(){
		Comparator<Integer> comparator = (x,y)->{
			System.out.println("heheeh");
			return Integer.compare(x, y);
		};
		System.out.println(comparator.compare(12, 33));
	}
	
	@Test
	public void test4(){
		List<Employee> emps = Arrays.asList(new Employee("222", 12, 3382.2), new Employee("111", 12, 44.2),
				new Employee("333", 14, 33482.2), new Employee("444", 15, 332282.2), new Employee("555", 122, 338232.2),
				new Employee("666", 1221, 1.2));
		Collections.sort(emps, (x,y) -> {
			return x.getAge() - y.getAge() == 0 ? x.getName().compareTo(y.getName()):x.getAge() - y.getAge();
		});
		System.out.println(emps);
	}
	
	@Test
	public void test5(){
		ttttt("wsdad",(x) -> x.toUpperCase());
	}
	public void ttttt(String str, MyFun func){
		System.out.println(func.getValue(str));
	}
	
	
	@Test
	public void test6(){
		ttttttt(111,222,(x,y)->x*y);
		ttttttt(111,222,(x,y)->x+y);
	}
	
	public void ttttttt(long l1,long l2,MyCalc<Long,Long> calcator){
		System.out.println(calcator.calc(l1, l2));
	}
}	


