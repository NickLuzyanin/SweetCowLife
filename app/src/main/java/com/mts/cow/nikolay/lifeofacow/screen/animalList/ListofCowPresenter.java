package com.mts.cow.nikolay.lifeofacow.screen.animalList;


import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;

import javax.annotation.Nullable;
import javax.inject.Inject;

@ActivityScoped
public class ListofCowPresenter implements ListofCowContract.Presenter {



    @Nullable
    private ListofCowContract.View mCowListView;

    @Inject
    ListofCowPresenter() {

    }





    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadCowList() {

    }

    @Override
    public void addNewCowPassport() {

        if (mCowListView != null) {
            mCowListView.showCowPassport();
        }
    }

    @Override
    public void takeView(ListofCowContract.View view) {
        this.mCowListView = view;

    }

    @Override
    public void dropView() {

    }
}
