package org.bongiorno.validation.test.cases.future;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Future;

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
		@Future
		public LocalDate getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class InstantBean extends AbstractBean<Instant> {
		
		@Override
		@Future
		public Instant getProperty() {
			return super.getProperty();
		}
		
	}

	public static class LocalDateTimeBean extends AbstractBean<LocalDateTime> {
		
		@Override
		@Future
		public LocalDateTime getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class OffsetDateTimeBean extends AbstractBean<OffsetDateTime> {
		
		@Override
		@Future
		public OffsetDateTime getProperty() {
			return super.getProperty();
		}
		
	}

	public static class YearBean extends AbstractBean<Year> {
		
		@Override
		@Future
		public Year getProperty() {
			return super.getProperty();
		}
		
	}
	
	public static class YearMonthBean extends AbstractBean<YearMonth> {
		
		@Override
		@Future
		public YearMonth getProperty() {
			return super.getProperty();
		}
		
	}

	public static class ZonedDateTimeBean extends AbstractBean<ZonedDateTime> {
		
		@Override
		@Future
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
		Violation[] violations = new Violation[]{new Violation(Future.class, "must be in the future")};
		return Arrays.asList(new Object[][] {
				{ LocalDateBean.class, LocalDate.now().minusDays(1), violations },
				{ LocalDateBean.class, LocalDate.now(), violations },
				{ InstantBean.class, Instant.now().minusSeconds(1), violations },
				{ LocalDateTimeBean.class, LocalDateTime.now().minusDays(1), violations },
				{ LocalDateTimeBean.class, LocalDateTime.now().minusSeconds(1), violations },
				{ OffsetDateTimeBean.class, OffsetDateTime.now().minusDays(1), violations },
				{ OffsetDateTimeBean.class, OffsetDateTime.now().minusSeconds(1), violations },
				{ YearBean.class, Year.now().minusYears(1), violations },
				{ YearBean.class, Year.now(), violations },
				{ YearMonthBean.class, YearMonth.now().minusMonths(1), violations },
				{ YearMonthBean.class, YearMonth.now(), violations },
				{ ZonedDateTimeBean.class, ZonedDateTime.now().minusDays(1), violations },
				{ ZonedDateTimeBean.class, ZonedDateTime.now().minusSeconds(10), violations },
		});
	}

}