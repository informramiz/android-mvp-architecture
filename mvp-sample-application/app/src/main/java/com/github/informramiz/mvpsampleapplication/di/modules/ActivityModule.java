package com.github.informramiz.mvpsampleapplication.di.modules;

import android.app.Activity;
import android.content.Context;

import com.github.informramiz.mvpsampleapplication.MainActivityContract;
import com.github.informramiz.mvpsampleapplication.MainActivityPresenter;
import com.github.informramiz.mvpsampleapplication.di.qualifiers.ApplicationContext;
import com.github.informramiz.mvpsampleapplication.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ApplicationContext
    public Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    MainActivityContract.Presenter provideMainActivityPresenter(MainActivityPresenter mainActivityPresenter) {
        return mainActivityPresenter;
    }
}
