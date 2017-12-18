package test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TestTimeAndDateAPI {
	@Test
	public void test() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
	}
	
	@Test
	public void test2(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
		LocalDate ld = LocalDate.parse("2016-12-20", dtf);
		System.out.println(ld);
	}
	
	@Test
	public void test3(){
		LocalDate ld = LocalDate.of(2016, 12, 22);
		System.out.println(ld);
	}
	
	@Test
	public void test4(){
		LocalDate ld = LocalDate.of(2016, Month.JULY, 21);
		LocalDate ld2  = ld.plusMonths(2);
		System.out.println(ld2);
	}
	
	@Test
	public void test5(){
		LocalDateTime ldt = LocalDateTime.of(2018, 11, 12, 12, 22, 02);
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
	}
	
	//时间戳
	//Instant :Unix 元年 1970年1月1日 00:00:00
	//默认为UTC时间，比北京时间慢8个小时 
	@Test
	public void test6(){
		Instant now = Instant.now();
		System.out.println(now);//格林尼治时间
		OffsetDateTime time  = now.atOffset(ZoneOffset.ofHours(8));
		System.out.println(time);//北京时间
		
		
		System.out.println(now.toEpochMilli());//转为毫秒
		
		//毫秒转为Instant对象
		Instant now2 = Instant.ofEpochMilli(1487730030936L);
		System.out.println(now2);
	}
	
	//日期、时间 间隔
	//Period 日期间隔
	//Duration 时间间隔
	@Test
	public void test7() throws InterruptedException{
		Instant n1 = Instant.now();
		Thread.sleep(1000);
		Instant n2 = Instant.now();
		Duration dur = Duration.between(n1, n2);
		System.out.println(dur.toMillis());
		System.out.println(dur.getSeconds());
		System.out.println(dur);
		
		System.out.println();
		
		LocalTime t1 = LocalTime.of(20, 12, 22);
		LocalTime t2 = LocalTime.of(23, 11,22);
		Duration dur2 = Duration.between(t1, t2);
		System.out.println(dur2.toMillis());
		System.out.println(dur2);
		
		
		System.out.println();
		
		LocalDate ld1 = LocalDate.of(2015, 12, 12);
		LocalDate ld2 = LocalDate.of(2017, 2, 22);
		Period per = Period.between(ld1, ld2);
		System.out.println(per.getYears());
		System.out.println(per.getMonths());
		System.out.println(per.getDays());
		System.out.println(per.toTotalMonths());//一共差了14个月，算上年份
		System.out.println(per);
		
	}
	
	
	@Test
	public void test8(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = ldt.withMonth(12).withDayOfMonth(26);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.MONDAY));//下一个周一
		System.out.println(ldt3);
		//TemporalAdjuster是一个函数式接口
		//自定义一个校正器
		//获取下一个工作日
		LocalDateTime ld4 = ldt.with((t) -> {
			LocalDateTime ld = (LocalDateTime)t;
			DayOfWeek week = ld.getDayOfWeek();
			if(week == DayOfWeek.FRIDAY){
				return ld.plusDays(3);
			}else if(week == DayOfWeek.SATURDAY){
				return ld.plusDays(2);
			}else{
				return ld.plusDays(1);
			}
		});
		System.out.println(ld4);
		
	}
	
	@Test
	public void test9(){
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String str = ldt.format(dtf);
		System.out.println(str);
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String str2 = ldt.format(dtf2);
		System.out.println(str2);
		
		
		LocalDateTime ldt2 = LocalDateTime.parse(str2, dtf2);
		System.out.println(ldt2);
	}
	//ZonedDate ZonedDateTime ZonedDate
	@Test
	public void test10(){
		System.out.println(ZoneId.getAvailableZoneIds());
		LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(ldt1);
		
		LocalDateTime ldt2 = LocalDateTime.now();
		ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
		System.out.println(zdt);
		System.out.println(zdt.getZone());
	}
	
	
	
}
