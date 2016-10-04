package org.bongiorno.validation.test.cases.age;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.bongiorno.validation.constraints.age.Age;
import org.bongiorno.validation.test.cases.AbstractViolationTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
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

	public <T>TestViolation(Class<AbstractBean<T>> beanType, T property,
			Violation[] violations) {
		super(beanType, property, violations);
	}
	
	@Parameters
	static public List<Object[]> beans() {
		Violation violation = new Violation(Age.class, "The Age must be at least 20 years.");
		Violation[] violations = new Violation[]{ violation };
		Violation[] pastViolations = new Violation[]{ violation, new Violation(Past.class, "must be in the past") };
		LocalDate yesterday = LocalDate.now().minusDays(1);
		Date yesterdayDate = Date.from(Instant.from(yesterday.atStartOfDay(ZoneId.systemDefault())));
		return Arrays.asList(new Object[][] {
				{ LocalDateBean.class,  yesterday, violations },
				{ DateBean.class,     yesterdayDate, violations },
				{ CalendarBean.class, new Calendar.Builder().setInstant(yesterdayDate).build(), violations },
				{ LocalDateBean.class,  LocalDate.now().plusYears(5), pastViolations },
				{ TestValid.InstantBean.class, yesterdayDate.toInstant(), violations },
				{ LocalDateTimeBean.class, yesterday.atStartOfDay(), violations },
				{ OffsetDateTimeBean.class, yesterday.atTime(OffsetTime.MIN), violations },
				{ YearBean.class, Year.now().minusYears(1), violations },
				{ YearMonthBean.class, YearMonth.now().minusYears(1), violations },
				{ ZonedDateTimeBean.class, ZonedDateTime.now().minusMonths(1), violations },
		});
	}

}
