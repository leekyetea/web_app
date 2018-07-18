package org.study.misc;

import org.junit.Test;
import org.study.model.Country;

public class DateTest {

	@Test
	public void testSqltoUtilDate() {
		java.util.Date utilDate = new java.util.Date("1999/11/11");
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		System.out.println(sqlDate);
		
		Country c = Country.Korea;
		
		System.out.println(c.name());
	}
}
