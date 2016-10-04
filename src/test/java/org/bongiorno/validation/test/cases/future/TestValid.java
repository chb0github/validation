package org.bongiorno.validation.test.cases.future;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Future;

import org.bongiorno.validation.test.cases.AbstractValidTest;
import org.bongiorno.validation.test.model.AbstractBean;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 */
public class TestValid extends AbstractValidTest {
	
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
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() {
		return Arrays.asList(new Object[][] {
				{ LocalDateBean.class, null },
				{ LocalDateBean.class, LocalDate.now().plusDays(1) },
				{ InstantBean.class, null },
				{ InstantBean.class, Instant.now().plus(Period.ofDays(1)) },
				{ LocalDateTimeBean.class, null },
				{ LocalDateTimeBean.class, LocalDateTime.now().plusDays(1) },
				{ OffsetDateTimeBean.class, null },
				{ OffsetDateTimeBean.class, OffsetDateTime.now().plusDays(1) },
				{ YearBean.class, null },
				{ YearBean.class, Year.now().plusYears(1) },
				{ YearMonthBean.class, null },
				{ YearMonthBean.class, YearMonth.now().plusMonths(1) },
				{ ZonedDateTimeBean.class, null },
				{ ZonedDateTimeBean.class, ZonedDateTime.now().plusDays(1) },
		});
	}

}