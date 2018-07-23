package com.mts.cow.nikolay.lifeofacow.screen.cowpassportdetails;

import com.mts.cow.nikolay.lifeofacow.common.BasePresenter;
import com.mts.cow.nikolay.lifeofacow.common.BaseView;

public interface CowDetailsContract {


    interface View extends BaseView<Presenter> {



        boolean isActive();
    }

    interface Presenter extends BasePresenter<View> {



        void takeView(CowDetailsContract.View taskDetailFragment);

        void dropView();
    }


}
