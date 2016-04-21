package com.my.examples.lecture4;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class DatabaseTest extends ApplicationTestCase<Application> {
	private DBHelper mDBHelper;
	public DatabaseTest() {
		super(Application.class);
	}

	@Override
	public void setUp() throws Exception {
		createApplication();
		mDBHelper = new DBHelper(getContext());
	}

	public void testSaveContat() throws Exception {
		DBHelper.AppContact contact = new DBHelper.AppContact("Bob");
		contact.setEmail("bob@my.com");
		contact.setPhone1("+78005555555");
		mDBHelper.addContact(contact);
		DBHelper.AppContact foundContact = mDBHelper.getContactByName("Bob");
		Assert.assertNotNull(foundContact);
		Assert.assertEquals(contact.getName(), foundContact.getName());
	}

	@Override
	public void tearDown() throws Exception {
		mDBHelper.drop();
	}
}