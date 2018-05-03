package com.github.informramiz.mvplibrary.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.Nullable;

import com.github.informramiz.mvplibrary.common.LogUtils;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public abstract class BasePresenter<V extends BaseView> implements IPresenter<V> {
    @Nullable
    private V mView;

    @Override
    public void onAttachView(V view) {
        LogUtils.d(getClass().getSimpleName(), "onAttachView");
        this.mView = view;
    }

    @Override
    public void onDetachView() {
        LogUtils.d(getClass().getSimpleName(), "onDetachView");
        this.mView = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroy() {
        LogUtils.d(getClass().getSimpleName(), "onDestroy");
    }

    @Nullable
    public V getView() {
        return mView;
    }

    public void setView(@Nullable V view) {
        this.mView = mView;
    }

    protected boolean isViewActive() {
        return getView() != null && getView().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }
}
