package com.mts.cow.nikolay.lifeofacow.screen.animalList;

import com.mts.cow.nikolay.lifeofacow.common.BasePresenter;
import com.mts.cow.nikolay.lifeofacow.common.BaseView;

public interface ListofCowContract {

    interface View extends BaseView<Presenter> {

        void showCowPassport();

    }

    interface Presenter extends BasePresenter<View> {

        void result(int requestCode, int resultCode);
        void loadCowList();
        void addNewCowPassport();


    }



}
