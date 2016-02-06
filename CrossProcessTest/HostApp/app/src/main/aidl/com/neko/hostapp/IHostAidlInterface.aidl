// IHostAidlInterface.aidl
package com.neko.hostapp;
import com.neko.hostapp.HostEvent;
// Declare any non-default types here with import statements

interface IHostAidlInterface {

    int getProcessID();

    HostEvent generateEvent();

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
