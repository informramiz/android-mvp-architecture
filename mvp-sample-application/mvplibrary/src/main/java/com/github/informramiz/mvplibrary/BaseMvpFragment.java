package com.github.informramiz.mvplibrary;

import android.content.Context;

import com.github.informramiz.mvplibrary.base.BasePresenter;
import com.github.informramiz.mvplibrary.base.BaseView;
import com.github.informramiz.mvplibrary.base.PresenterFragment;


/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public abstract class BaseMvpFragment<P extends BasePresenter<V>, V extends BaseView> extends PresenterFragment
    implements BaseView {

    private BaseMvpActivity mBaseMvpActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseMvpActivity) {
            this.mBaseMvpActivity = (BaseMvpActivity)context;
        } else {
            throw new IllegalArgumentException(context.getClass().getSimpleName() + " must be extend from BaseMvpActivity");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mBaseMvpActivity = null;
    }

    @Override
    protected V getPresenterView() {
        return (V) this;
    }

    @Override
    public void setLoadingIndicator(boolean visible) {
        mBaseMvpActivity.setLoadingIndicator(visible);
    }

    @Override
    public void showMessage(String message) {
        mBaseMvpActivity.showMessage(message);
    }

    @Override
    public void showMessage(int messageResId) {
        mBaseMvpActivity.showMessage(messageResId);
    }
}
