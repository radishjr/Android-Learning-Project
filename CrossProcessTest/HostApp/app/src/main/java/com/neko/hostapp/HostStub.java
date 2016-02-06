package com.neko.hostapp;

import android.os.RemoteException;
import com.neko.hostapp.HostEvent;
/**
 * Created by neko on 2/5/2016.
 */
public class HostStub extends IHostAidlInterface.Stub {
    @Override
    public int getProcessID() throws RemoteException {
        return 0;
    }

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public HostEvent generateEvent() throws RemoteException {
        return new HostEvent();
    }
}
