package com.mts.cow.nikolay.lifeofacow.screen.cowpassportdetails;

import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

import static com.mts.cow.nikolay.lifeofacow.screen.cowpassportdetails.CowDetailsActivity.EXTRA_COW_ID;


@Module
public abstract class CowDetailsModule {




        @FragmentScoped
        @ContributesAndroidInjector
        abstract CowDetailsFragment cowDetailsFragment();

        @ActivityScoped
        @Binds
        abstract CowDetailsContract.Presenter cowPresenter(CowDetailsPresenter presenter);

        @Provides
        @ActivityScoped
        static String provideCowId(CowDetailsActivity activity) {
            return activity.getIntent().getStringExtra(EXTRA_COW_ID);
        }

}
