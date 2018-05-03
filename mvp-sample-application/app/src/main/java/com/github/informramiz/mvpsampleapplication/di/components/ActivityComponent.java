package com.github.informramiz.mvpsampleapplication.di.components;

import com.github.informramiz.mvpsampleapplication.MainActivity;
import com.github.informramiz.mvpsampleapplication.di.modules.ActivityModule;
import com.github.informramiz.mvpsampleapplication.di.scopes.PerActivity;

import dagger.Component;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
