package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;






public class AddCowPassportActivity extends DaggerAppCompatActivity {

    public static final int REQUEST_ADD_COW = 1;

    @Inject
    AddCowPassportContract.Presenter mAddCowPassportPresenter;

    @Inject
    AddCowPassportFragment mFragment;

    @Inject
    @Nullable
    String mCowId;

    private boolean mIsDataMissing = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcow_pas_act);


        AddCowPassportFragment addCowPassportFragment =
                (AddCowPassportFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrameCowPass);

        if (addCowPassportFragment == null) {
            addCowPassportFragment = mFragment;

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    addCowPassportFragment, R.id.contentFrameCowPass);
        }
        //restoreState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    boolean isDataMissing() {
        return mIsDataMissing;
    }









}
