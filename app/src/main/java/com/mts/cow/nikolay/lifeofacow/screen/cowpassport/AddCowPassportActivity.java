package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, AddCowPassportActivity.class);
        activity.startActivity(intent);
    }


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
