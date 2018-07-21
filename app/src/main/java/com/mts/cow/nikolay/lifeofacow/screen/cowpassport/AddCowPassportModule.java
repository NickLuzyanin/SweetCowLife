package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;


import android.support.annotation.Nullable;

import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AddCowPassportModule {


    @Provides
    @ActivityScoped
    @Nullable
    static String provideTaskId(AddCowPassportActivity activity) {
        return activity.getIntent().getStringExtra(AddCowPassportFragment.ARGUMENT_EDIT_COW_ID);
    }

    @Provides
    @ActivityScoped
    static boolean provideStatusDataMissing(AddCowPassportActivity activity) {
        return activity.isDataMissing();
    }

    @FragmentScoped
    @ContributesAndroidInjector
    abstract AddCowPassportFragment addCowPassportFragment();

    @ActivityScoped
    @Binds
    abstract AddCowPassportContract.Presenter cowPresenter(AddCowPassportPresenter presenter);




}
