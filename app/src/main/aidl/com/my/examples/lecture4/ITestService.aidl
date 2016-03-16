// ITestService.aidl
package com.my.examples.lecture4;


interface ITestService {
    String getString();
    oneway void getStringAsync();
    void bindActivity(IBinder callback);
}
