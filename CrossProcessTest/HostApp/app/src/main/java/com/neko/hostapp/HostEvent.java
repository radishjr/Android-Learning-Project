package com.neko.hostapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by neko on 2/5/2016.
 */
public class HostEvent implements Parcelable {

    public HostEvent(){

    }

    public HostEvent(Parcel parcel){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<HostEvent> CREATOR = new Parcelable.ClassLoaderCreator<HostEvent>(){
        @Override
        public HostEvent createFromParcel(Parcel source, ClassLoader loader) {
            return new HostEvent(source);
        }

        @Override
        public HostEvent createFromParcel(Parcel source) {
            return new HostEvent(source);
        }

        @Override
        public HostEvent[] newArray(int size) {
            return new HostEvent[0];
        }
    };
}
