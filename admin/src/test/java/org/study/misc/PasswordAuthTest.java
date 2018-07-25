package org.study.misc;

import org.junit.Assert;
import org.junit.Test;
import org.study.sec.PasswordAuthentication;



public class PasswordAuthTest {

	@Test
	public void testHash() {
		PasswordAuthentication passAuth = new PasswordAuthentication();
		String passwd = "1234";

		for (int i = 0; i < 5; i++) {
			String passwdToken = passAuth.hash(passwd.toCharArray());

			System.out.println(passwd + ": " + passwdToken);
		}
	}
	
	@Test 
	public void testAuthentication() {
		PasswordAuthentication passAuth = new PasswordAuthentication();
		String passwd = "1234";
		String passwdToken = passAuth.hash(passwd.toCharArray());
		
		Assert.assertFalse(passAuth.authenticate(new char[]{'a', 'b'}, passwdToken));
		
	}
}
