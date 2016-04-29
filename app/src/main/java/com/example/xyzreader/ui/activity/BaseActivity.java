

package com.example.xyzreader.ui.activity;

import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import com.example.xyzreader.ReaderApplication;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;

/**
 * Base class for all activities.
 * Binds views and watches memory leaks
 *
 * @see ButterKnife
 * @see RefWatcher
 */
public abstract class BaseActivity extends AppCompatActivity {

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ReaderApplication.get(this).getRefWatcher().watch(this);
    }

    @CallSuper
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

}
