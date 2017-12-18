package test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestParallel {
	@Test
	public void test(){
		Instant start = Instant.now();
		LongStream.rangeClosed(0, 10000000000L)
			.parallel()
			.reduce(0, Long::sum);

		Instant end = Instant.now();
		System.out.println("Time:"+Duration.between(start, end).toMillis());
	}
}
