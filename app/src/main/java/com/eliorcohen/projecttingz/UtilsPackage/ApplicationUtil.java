package com.eliorcohen.projecttingz.UtilsPackage;

import android.app.Application;

public class ApplicationUtil extends Application {

    private static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
    }

    public static Application getApplication() {
        return mApplication;
    }

}
