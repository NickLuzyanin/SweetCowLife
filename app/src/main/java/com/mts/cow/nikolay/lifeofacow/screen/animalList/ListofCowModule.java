package com.mts.cow.nikolay.lifeofacow.screen.animalList;

import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ListofCowModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ListofCowFragment CowFragment();

    @ActivityScoped
    @Binds
    abstract ListofCowContract.Presenter mainPresenter(ListofCowPresenter presenter);

}