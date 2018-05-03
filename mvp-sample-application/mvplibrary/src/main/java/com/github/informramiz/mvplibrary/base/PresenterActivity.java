package com.github.informramiz.mvplibrary.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ramiz Raja on 03/05/2018.
 */
public abstract class PresenterActivity<P extends IPresenter<V>, V extends IPresenter.View> extends AppCompatActivity {
    private PresenterManager<P> mPresenterManager = new PresenterManager<>();

    /**
     * Returns the view associate with this presenter connection
     * @return view associated
     */
    abstract protected V getPresenterView();
    abstract protected P onCreatePresenter();

    /**
     * Returns presenter
     * @return IPresenter if it was created
     */
    @Nullable
    protected P getPresenter() {
        return mPresenterManager.getHostPresenter();
    }

    protected void addLifeCycleObserverToView() {
        getPresenterView().getLifecycle().addObserver(getPresenter());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        attachViewToPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detachViewFromPresenter();
        mPresenterManager.setHostPresenter(null);
    }

    private void attachViewToPresenter() {
        P presenter = getPresenter();
        if (presenter == null) {
            presenter = onCreatePresenter();
        }

        final V view = getPresenterView();
        if (view != null && presenter != null) {
            presenter.onAttachView(view);
            mPresenterManager.setHostPresenter(presenter);
            addLifeCycleObserverToView();
        } else if (presenter == null && view != null) {
            throw new IllegalStateException("You created a view, but did not provide a " +
                    "presenter for it.");
        } else if (presenter != null) {
            throw new IllegalStateException("You provided a presenter but did not create a view for it.");
        }
    }

    private void detachViewFromPresenter() {
        P presenter = getPresenter();
        if (presenter != null) {
            presenter.onDetachView();
        }
    }
}
