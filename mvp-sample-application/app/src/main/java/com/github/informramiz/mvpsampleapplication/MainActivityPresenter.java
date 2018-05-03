package com.github.informramiz.mvpsampleapplication;

import android.content.Context;

import com.github.informramiz.mvplibrary.base.BasePresenter;
import com.github.informramiz.mvpsampleapplication.di.qualifiers.ApplicationContext;

import javax.inject.Inject;


/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public class MainActivityPresenter extends BasePresenter<MainActivityContract.View> implements MainActivityContract.Presenter {
    @ApplicationContext
    Context context;

    @Inject
    public MainActivityPresenter(@ApplicationContext Context context) {
        this.context = context;
    }

    @Override
    public void onFabClicked() {
        if (isViewActive()) {
            getView().showFabMessage();
        }
    }
}
