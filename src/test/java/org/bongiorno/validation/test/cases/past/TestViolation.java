package org.bongiorno.validation.test.cases.past;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Past;

import org.bongiorno.validation.test.model.AbstractBean;
import org.bongiorno.validation.test.model.Violation;
import org.junit.runners.Parameterized.Parameters;

import org.bongiorno.validation.test.cases.AbstractViolationTest;

/**
 *
 */
public class TestViolation extends AbstractViolationTest {
	
	public static class LocalDateBean extends AbstractBean<LocalDate> {
		
		@Override
		@Past
		public LocalDate getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class InstantBean extends AbstractBean<Instant> {
		
		@Override
		@Past
		public Instant getProperty() {
			return super.getProperty();
		}
		
	}

	public static class LocalDateTimeBean extends AbstractBean<LocalDateTime> {
		
		@Override
		@Past
		public LocalDateTime getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class OffsetDateTimeBean extends AbstractBean<OffsetDateTime> {
		
		@Override
		@Past
		public OffsetDateTime getProperty() {
			return super.getProperty();
		}
		
	}

	public static class YearBean extends AbstractBean<Year> {
		
		@Override
		@Past
		public Year getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class YearMonthBean extends AbstractBean<YearMonth> {
		
		@Override
		@Past
		public YearMonth getProperty() {
			return super.getProperty();
		}
		
	}

	public static class ZonedDateTimeBean extends AbstractBean<ZonedDateTime> {
		
		@Override
		@Past
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
		Violation[] violations = new Violation[]{new Violation(Past.class, "must be in the past")};
		return Arrays.asList(new Object[][] {
				{ LocalDateBean.class, LocalDate.now().plusDays(1), violations },
				{ LocalDateBean.class, LocalDate.now(), violations },
				{ InstantBean.class, Instant.now().plusSeconds(1), violations },
				{ LocalDateTimeBean.class, LocalDateTime.now().plusDays(1), violations },
				{ LocalDateTimeBean.class, LocalDateTime.now().plusSeconds(1), violations },
				{ OffsetDateTimeBean.class, OffsetDateTime.now().plusDays(1), violations },
				{ OffsetDateTimeBean.class, OffsetDateTime.now().plusSeconds(1), violations },
				{ YearBean.class, Year.now().plusYears(1), violations },
				{ YearBean.class, Year.now(), violations },
				{ YearMonthBean.class, YearMonth.now().plusMonths(1), violations },
				{ YearMonthBean.class, YearMonth.now(), violations },
				{ ZonedDateTimeBean.class, ZonedDateTime.now().plusDays(1), violations },
				{ ZonedDateTimeBean.class, ZonedDateTime.now().plusSeconds(10), violations },
		});
	}

}