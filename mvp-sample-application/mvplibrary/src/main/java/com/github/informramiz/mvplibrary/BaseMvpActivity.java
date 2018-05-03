package com.github.informramiz.mvplibrary;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.github.informramiz.mvplibrary.base.BasePresenter;
import com.github.informramiz.mvplibrary.base.BaseView;
import com.github.informramiz.mvplibrary.base.IPresenter;
import com.github.informramiz.mvplibrary.base.PresenterActivity;


/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public abstract class BaseMvpActivity<P extends IPresenter<V>, V extends BaseView> extends PresenterActivity<P, V> implements BaseView {

    private ProgressDialog mProgressDialog;

    @Override
    protected V getPresenterView() {
        return (V) this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(getString(R.string.loading));
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            mProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    @Override
    public void setLoadingIndicator(boolean visible) {
        if (visible && !mProgressDialog.isShowing()) {
            try {
                mProgressDialog.show();
            } catch (Exception ignored) {

            }
        } else {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(int messageResId) {
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show();
    }
}
