/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(AndroidJUnit4.class)
public class TestServiceTest {

	@ClassRule
	public static ServiceTestRule mServiceRule = new ServiceTestRule();
	private static ITestService mTestService;

	class Callback extends ICallback.Stub {
		final CountDownLatch mLatch;
		String mString;

		public Callback(CountDownLatch latch) {
			mLatch = latch;
		}
		@Override
		public void onNewString(String data) throws RemoteException {
			mString = data;
			mLatch.countDown();
		}

		public String getString() {
			return mString;
		}
	}

	@BeforeClass
	public static void init() throws TimeoutException {
		Intent startIntent = new Intent(InstrumentationRegistry.getTargetContext(), TestService.class);
		IBinder binder = mServiceRule.bindService(startIntent);
		mTestService = ITestService.Stub.asInterface(binder);
	}

	@Test
	public void testSync() throws TimeoutException, RemoteException {
		Assert.assertEquals(mTestService.getString(), "Hello from Service!");
	}

	@Test
	public void testAsync() throws TimeoutException, RemoteException, InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		Callback callback = new Callback(latch);
		mTestService.bindActivity(callback);
		mTestService.getStringAsync();

		latch.await(3, TimeUnit.SECONDS);

		Assert.assertEquals(callback.getString(), "Hello from Service!");
	}
}
