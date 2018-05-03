package com.github.informramiz.mvplibrary.base;

/**
 * Right now this class is just a vessel to hold presenter but
 * idea is to extend this class in future to handle presenters persistance.
 *
 * Created by Ramiz Raja on 03/05/2018.
 */
public class PresenterManager<P extends IPresenter> {
    private P mHostPresenter;

    P getHostPresenter() {
        return mHostPresenter;
    }

    void setHostPresenter(P hostPresenter) {
        this.mHostPresenter = hostPresenter;
    }
}
