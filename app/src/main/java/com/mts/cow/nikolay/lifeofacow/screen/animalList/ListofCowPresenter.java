package com.mts.cow.nikolay.lifeofacow.screen.animalList;


import android.app.Activity;

import com.mts.cow.nikolay.lifeofacow.models.Cows;
import com.mts.cow.nikolay.lifeofacow.data.CowsDataSource;
import com.mts.cow.nikolay.lifeofacow.data.CowsRepository;
import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.screen.cowpassport.AddCowPassportActivity;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

@ActivityScoped
public class ListofCowPresenter implements ListofCowContract.Presenter {

    private final CowsRepository mCowsRepository;

    @Nullable
    private ListofCowContract.View mCowListView;

    @Inject
    ListofCowPresenter(CowsRepository cowsRepository) {
        mCowsRepository = cowsRepository;
    }



    @Override
    public void result(int requestCode, int resultCode) {


            if (AddCowPassportActivity.REQUEST_ADD_COW == requestCode&& Activity.RESULT_OK == resultCode) {
                if (mCowListView != null) {
                    mCowListView.showSuccessfullySavedMessage();
                }
            }



    }

    @Override
    public void loadCowList() {

        mCowsRepository.getCows(new CowsDataSource.LoadCowsCallback() {
            @Override
            public void onCowsLoaded(List<Cows> cows) {
                if (mCowListView != null) {
                    mCowListView.showCowsFromLocalDB(cows);
                }

            }

            @Override
            public void onDataNotAvailable() {
                mCowListView.showLoadingCowsError();
            }
        });

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
