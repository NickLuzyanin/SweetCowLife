package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;



import com.mts.cow.nikolay.lifeofacow.common.BasePresenter;
import com.mts.cow.nikolay.lifeofacow.common.BaseView;


import java.util.List;

public interface AddCowPassportContract {


    interface View extends BaseView<Presenter> {

        void showCowGraph(List<Integer> cowParams);

        void setTitle(String title);

        void setDescription(String description);

        boolean isActive();

        void showWait();

        void removeWait();
    }

    interface Presenter extends BasePresenter<View> {

        void saveTask(String CowNumber, String CowBreed,String Cowsuit, String birthDay, String mother, String father);
        void getCowGraphParams();
        void getStreetList();



    }


}
