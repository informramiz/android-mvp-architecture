package com.github.informramiz.mvpsampleapplication.di.components;

import com.github.informramiz.mvpsampleapplication.MyApplication;
import com.github.informramiz.mvpsampleapplication.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
