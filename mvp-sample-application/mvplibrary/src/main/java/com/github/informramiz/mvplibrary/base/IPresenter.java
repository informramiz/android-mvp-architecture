package com.github.informramiz.mvplibrary.base;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public interface IPresenter<V extends IPresenter.View> extends LifecycleObserver {
    /**
     * View in MVP architecture
     */
    interface View extends LifecycleOwner {

    }

    /**
     * Called to attach view to presenter
     * @param view view to attach to presenter
     */
    void onAttachView(V view);

    /**
     * Called to detach view from presenter
     */
    void onDetachView();
}
