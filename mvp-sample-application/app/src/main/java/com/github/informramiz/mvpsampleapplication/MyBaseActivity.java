package com.github.informramiz.mvpsampleapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.informramiz.mvplibrary.BaseMvpActivity;
import com.github.informramiz.mvplibrary.base.BaseView;
import com.github.informramiz.mvplibrary.base.IPresenter;
import com.github.informramiz.mvpsampleapplication.di.components.ActivityComponent;
import com.github.informramiz.mvpsampleapplication.di.components.DaggerActivityComponent;
import com.github.informramiz.mvpsampleapplication.di.modules.ActivityModule;


/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public abstract class MyBaseActivity<P extends IPresenter<V>, V extends BaseView> extends BaseMvpActivity<P, V> {

    private ActivityComponent mActivityComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((MyApplication) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }
}
