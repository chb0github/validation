package org.bongiorno.validation.test.cases.age;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.bongiorno.validation.constraints.age.Age;
import org.bongiorno.validation.test.cases.AbstractValidTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 */
public class TestValid extends AbstractValidTest {

	public static class CalendarBean extends AbstractBean<Calendar> {
		
		@Override
		@Age(20)
		public Calendar getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class LocalDateBean extends AbstractBean<LocalDate> {

		@Override
		@Age(20)
		public LocalDate getProperty() {
			return super.getProperty();
		}

	}
	
	public static class InstantBean extends AbstractBean<Instant> {
		
		@Override
		@Age(20)
		public Instant getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class DateBean extends AbstractBean<Date> {
		
		@Override
		@Age(20)
		public Date getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class LocalDateTimeBean extends AbstractBean<LocalDateTime> {
		
		@Override
		@Age(20)
		public LocalDateTime getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class OffsetDateTimeBean extends AbstractBean<OffsetDateTime> {
		
		@Override
		@Age(20)
		public OffsetDateTime getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class YearBean extends AbstractBean<Year> {
		
		@Override
		@Age(20)
		public Year getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class YearMonthBean extends AbstractBean<YearMonth> {
		
		@Override
		@Age(20)
		public YearMonth getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class ZonedDateTimeBean extends AbstractBean<ZonedDateTime> {
		
		@Override
		@Age(20)
		public ZonedDateTime getProperty() {
			return super.getProperty();
		}
		
	}

	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		
		return Arrays.asList(new Object[][] { 
				{ LocalDateBean.class, null },
				{ DateBean.class, null },
				{ CalendarBean.class, null },
				{ InstantBean.class, null },
				{ LocalDateTimeBean.class, null },
				{ OffsetDateTimeBean.class, null },
				{ YearBean.class, null },
				{ YearMonthBean.class, null },
				{ ZonedDateTimeBean.class, null },
				
				{ LocalDateBean.class, LocalDate.parse("1981-05-03") },
				{ DateBean.class, Date.from(Instant.parse("1981-05-02T10:15:30.00Z")) },
				{ CalendarBean.class, new Calendar.Builder().setDate(1981, 1, 5).build() },
				{ InstantBean.class, Instant.parse("1981-05-02T10:15:30.00Z") },
				{ LocalDateTimeBean.class, LocalDateTime.parse("1981-05-03T00:00:00") },
				{ OffsetDateTimeBean.class, OffsetDateTime.parse("1981-05-03T00:00:01+01:00") },
				{ YearBean.class, Year.parse("1981") },
				{ YearMonthBean.class, YearMonth.parse("1981-01") },
				{ ZonedDateTimeBean.class, ZonedDateTime.parse("1981-05-02T10:15:30+01:00") },
		});
	}

}

