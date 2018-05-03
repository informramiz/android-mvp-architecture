package com.github.informramiz.mvpsampleapplication;

import android.app.Application;

import com.github.informramiz.mvpsampleapplication.di.components.ApplicationComponent;
import com.github.informramiz.mvpsampleapplication.di.components.DaggerApplicationComponent;
import com.github.informramiz.mvpsampleapplication.di.modules.ApplicationModule;


/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public class MyApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
