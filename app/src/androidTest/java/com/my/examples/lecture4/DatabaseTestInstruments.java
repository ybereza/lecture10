/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DatabaseTestInstruments extends InstrumentationTestCase {
	private DBHelper mDBHelper;
	private Context mContext;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		injectInstrumentation(InstrumentationRegistry.getInstrumentation());

		do {
			if ((mContext = getInstrumentation().getTargetContext()) != null) {
				break;
			}
			Thread.sleep(50);
		} while (true);

		mDBHelper = new DBHelper(mContext);
	}

	@Test
	public void testSaveContat() throws Exception {
		DBHelper.AppContact contact = new DBHelper.AppContact("Bob");
		contact.setEmail("bob@my.com");
		contact.setPhone1("+78005555555");
		mDBHelper.addContact(contact);
		DBHelper.AppContact foundContact = mDBHelper.getContactByName("Bob");
		Assert.assertNotNull(foundContact);
		Assert.assertEquals(contact.getName(), foundContact.getName());
	}

	@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		mDBHelper.drop();
	}
}