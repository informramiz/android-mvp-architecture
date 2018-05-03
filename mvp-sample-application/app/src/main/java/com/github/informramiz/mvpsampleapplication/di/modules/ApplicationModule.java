package com.github.informramiz.mvpsampleapplication.di.modules;

import android.content.Context;

import com.github.informramiz.mvpsampleapplication.MyApplication;
import com.github.informramiz.mvpsampleapplication.di.qualifiers.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
@Module
public class ApplicationModule {
    private MyApplication mMyApplication;

    public ApplicationModule(MyApplication mMyApplication) {
        this.mMyApplication = mMyApplication;
    }

    @Provides
    @ApplicationContext
    Context provideApplicationContext() {
        return mMyApplication.getApplicationContext();
    }

    @Provides
    MyApplication provideMyApplication() {
        return mMyApplication;
    }
}
