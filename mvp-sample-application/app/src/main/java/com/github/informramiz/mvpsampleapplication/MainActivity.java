package com.github.informramiz.mvpsampleapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.github.informramiz.mvplibrary.BaseMvpActivity;
import com.github.informramiz.mvplibrary.base.IPresenter;

import javax.inject.Inject;

import dagger.Lazy;

public class MainActivity extends MyBaseActivity<MainActivityContract.Presenter, MainActivityContract.View> implements MainActivityContract.View {

    @Inject
    Lazy<MainActivityContract.Presenter> presenterLazy;

    FloatingActionButton mFab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getActivityComponent().inject(this);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onFabClicked();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected MainActivityContract.Presenter onCreatePresenter() {
        return presenterLazy.get();
    }

    @Override
    public void showFabMessage() {
        Snackbar.make(mFab, "Presenter invoked successfully", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
