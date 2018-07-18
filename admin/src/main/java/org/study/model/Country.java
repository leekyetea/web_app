package org.study.model;

public enum Country {
	Korea,
	USA,
	UK,
	Misc;
	
	public static Country getCountry(String str) {
		if (str.equals("Korea")) {
			return Country.Korea;
		} else if (str.equals("USA")) {
			return Country.USA;
		} else if (str.equals("UK")) {
			return Country.UK;
		} else {
			return Country.Misc;
		}
	}
}
