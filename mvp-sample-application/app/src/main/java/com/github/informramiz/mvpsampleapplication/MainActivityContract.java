package com.github.informramiz.mvpsampleapplication;

import com.github.informramiz.mvplibrary.base.BaseView;
import com.github.informramiz.mvplibrary.base.IPresenter;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public class MainActivityContract {
    public interface Presenter extends IPresenter<View> {
        void onFabClicked();
    }

    public interface View extends BaseView {
        void showFabMessage();
    }
}
