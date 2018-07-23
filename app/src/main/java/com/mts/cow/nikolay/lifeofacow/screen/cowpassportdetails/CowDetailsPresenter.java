package com.mts.cow.nikolay.lifeofacow.screen.cowpassportdetails;


import com.mts.cow.nikolay.lifeofacow.data.Cows;
import com.mts.cow.nikolay.lifeofacow.data.CowsDataSource;
import com.mts.cow.nikolay.lifeofacow.data.CowsRepository;
import com.mts.cow.nikolay.lifeofacow.screen.animalList.ListofCowContract;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class CowDetailsPresenter implements  CowDetailsContract.Presenter {


    private final CowsRepository mCowsRepository;

    @Nullable
    private CowDetailsContract.View mCowListView;

    @Inject
    CowDetailsPresenter(CowsRepository cowsRepository) {
        mCowsRepository = cowsRepository;
    }


    @Override
    public void loadCowList() {
        mCowsRepository.getCows(new CowsDataSource.LoadCowsCallback() {
            @Override
            public void onCowsLoaded(List<Cows> cows) {
                if (mCowListView != null) {
                    mCowListView.showCowsDetailsFromLocalDB(cows);
                }

            }

            @Override
            public void onDataNotAvailable() {
                mCowListView.showLoadingCowsError();
            }
        });
    }

    @Override
    public void editNewCowPassport() {

    }

    @Override
    public void takeView(CowDetailsContract.View cowDetailsFragment) {

        mCowListView = cowDetailsFragment;

    }

    @Override
    public void dropView() {
        mCowListView = null;
    }
}
