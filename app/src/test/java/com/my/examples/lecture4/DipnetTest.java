package com.my.examples.lecture4;

import org.junit.Test;

import static org.junit.Assert.*;

public class DipnetTest {
	@Test
	public void selfTest() throws Exception {
		final String testPassword = "My super passwor"; //must be 16 bytes long
		final String testKey = "A super secrete password";

		final byte[] keyBytes = testKey.getBytes();
		final byte[] passBytes = testPassword.getBytes();

		Object key = Dipnet.makeKey(keyBytes);

		final byte[] encrypted = Dipnet.blockEncrypt(passBytes, 0, key);
		final byte[] decrypted = Dipnet.blockDecrypt(encrypted, 0, key);

		final String result = new String(decrypted);
		if (!result.equals(testPassword)) {
			throw new RuntimeException("Symmetric operation failed "+result);
		}
	}
}