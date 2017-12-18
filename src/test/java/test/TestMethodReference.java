package test;

import cn.sinjinsong.java8.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethodReference {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		Consumer<String> c1 = (x) -> System.out.println(x);
		Consumer<String> c2 = System.out::println;
		c2.accept("ssss");
	}
	
	@Test
	public void test2(){
		Comparator<Integer> com = Integer::compare;
		
	}
	
	@Test
	public void test3(){
		BiPredicate<String, String> bp = String::equals;
		
	}
	
	@Test
	public void test4(){
		Supplier<Employee> sup1 = () -> new Employee();
		Supplier<Employee> sup2 = Employee::new ;
		
		System.out.println(sup2.get());
		
		Function<String,Employee> sup3 = Employee::new;
		System.out.println(sup3.apply("123").getName());
	}

}
