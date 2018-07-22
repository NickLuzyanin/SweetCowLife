package com.mts.cow.nikolay.lifeofacow.screen.animalList;

import com.mts.cow.nikolay.lifeofacow.common.BasePresenter;
import com.mts.cow.nikolay.lifeofacow.common.BaseView;
import com.mts.cow.nikolay.lifeofacow.data.Cows;

import java.util.List;

public interface ListofCowContract {

    interface View extends BaseView<Presenter> {

        void showCowPassport();

        void showSuccessfullySavedMessage();

        void showCowsFromLocalDB(List<Cows> cows);

        void showLoadingTasksError();

    }

    interface Presenter extends BasePresenter<View> {

        void result(int requestCode, int resultCode);
        void loadCowList();
        void addNewCowPassport();



    }



}
