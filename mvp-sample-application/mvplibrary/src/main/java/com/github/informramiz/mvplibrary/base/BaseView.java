package com.github.informramiz.mvplibrary.base;

import android.support.annotation.StringRes;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public interface BaseView extends IPresenter.View {
    void setLoadingIndicator(boolean visible);
    void showMessage(String message);
    void showMessage(@StringRes int messageResId);
}
