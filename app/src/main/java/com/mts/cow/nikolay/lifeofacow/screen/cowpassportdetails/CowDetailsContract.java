package com.mts.cow.nikolay.lifeofacow.screen.cowpassportdetails;

import com.mts.cow.nikolay.lifeofacow.common.BasePresenter;
import com.mts.cow.nikolay.lifeofacow.common.BaseView;
import com.mts.cow.nikolay.lifeofacow.models.Cows;

import java.util.List;

public interface CowDetailsContract {


    interface View extends BaseView<Presenter> {

        void showCowsDetailsFromLocalDB(List<Cows> cows);

        void showLoadingCowsError();

        boolean isActive();
    }

    interface Presenter extends BasePresenter<View> {

        void loadCowList();

        void editNewCowPassport();

        void takeView(CowDetailsContract.View cowDetailsFragment);

        void dropView();
    }


}
