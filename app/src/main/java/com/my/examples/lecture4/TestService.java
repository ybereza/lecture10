/**
 * Copyright Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class TestService extends Service {
	private class TestServiceProxy extends ITestService.Stub {
		private ICallback mActivityCallbak;

		@Override
		public String getString() throws RemoteException {
			return sayHello();
		}

		@Override
		public void bindActivity(IBinder callback) throws RemoteException {
			mActivityCallbak = ICallback.Stub.asInterface(callback);
		}

		@Override
		public void getStringAsync() {
			sendString("Async callback from service to activity");
		}

		public void sendString(String data) {
			if (mActivityCallbak != null) {
				try {
					mActivityCallbak.onNewString(data);
				}
				catch (RemoteException e) {

				}
			}
		}
	}

	private TestServiceProxy mServiceProxy = new TestServiceProxy();

	@Override
	public IBinder onBind(Intent intent) {
		return mServiceProxy;
	}

	public String sayHello() {
		return "Hello from Service!";
	}
}
