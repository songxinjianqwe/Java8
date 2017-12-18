package test;

import cn.sinjinsong.java8.domain.Trader;
import cn.sinjinsong.java8.domain.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class TestStreamAPI {
	List<Transaction> transactions = null;
	
	@Before
	public void before(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}
	
	@Test
	public void test1(){
		transactions
			.stream()
			.filter((trans) -> trans.getYear() == 2011)
			.sorted((t1,t2) -> Integer.compare(t1.getValue(),t2.getValue()) )
			.forEach(System.out::println);
	}
	
	@Test
	public void test2(){
		transactions
			.stream()
			.map((trans) -> trans.getTrader().getCity())
			.distinct()
			.forEach(System.out::println);
	}
	
	@Test
	public void test3(){
		transactions
			.stream()
			.map(Transaction::getTrader)
			.filter((trader) -> trader.getCity().equals("Cambridge"))
			.sorted((t1,t2) -> t1.getName().compareTo(t2.getName()))
			.forEach(System.out::println);
	}
	
	@Test
	public void test4(){
		transactions
			.stream()
			.map((trans) -> trans.getTrader().getName())
			.sorted()
			.forEach(System.out::println);
	}
	
	@Test
	public void test5(){
		boolean b = transactions
			.stream()
			.anyMatch((trans) -> trans.getTrader().getCity().equals("Milan"));
		System.out.println(b);
	}
	@Test void test6(){
		Integer sum = transactions
			.stream()
			.filter((trans) -> trans.getTrader().getCity().equals("Cambridge"))
			.collect(Collectors.summingInt(Transaction::getValue));
		System.out.println(sum);
	}
	
	@Test
	public void test7(){
		Optional<Integer> max = transactions
			.stream()
			.map(Transaction::getValue)
			.collect(Collectors.maxBy((v1,v2) -> Integer.compare(v1,v2)));
		System.out.println(max.get());
	}
	
	@Test
	public void test8(){
		Optional<Transaction> maxTrans = transactions
					.stream()
					.max((t1,t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		System.out.println(maxTrans.get());
	}
}
