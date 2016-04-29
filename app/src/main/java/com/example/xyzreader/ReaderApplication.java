

package com.example.xyzreader;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


public class ReaderApplication extends Application {

    private RefWatcher refWatcher;

    public static ReaderApplication get(Context context) {
        return (ReaderApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    public RefWatcher getRefWatcher() {
        return refWatcher;
    }
}
