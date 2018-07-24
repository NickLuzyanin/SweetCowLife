package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;



import com.mts.cow.nikolay.lifeofacow.common.BasePresenter;
import com.mts.cow.nikolay.lifeofacow.common.BaseView;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;


import java.util.ArrayList;
import java.util.List;

import im.dacer.androidcharts.LineView;

public interface AddCowPassportContract {


    interface View extends BaseView<Presenter> {

        void showCowGraph(List<Integer> cowParams);
        void showCowsList();

        void showCowParamsfromLocalDB(List<CowTTX> cowParams);

        void setTitle(String title);

        void setDescription(String description);



        boolean isActive();

        void showWait();

        void removeWait();
    }

    interface Presenter extends BasePresenter<View> {

        void saveCow(String cowNumber, String cowBreed, String cowSuit,String birthDay,String mother,String father,boolean state);
        void saveCowParams (String cowNumber, String milkyielddate, String milkyield,String fat_content, String weight);
        void loadCowParams();
        void getCowGraphParams();
        void getStreetList();

        void initLineView(LineView lineView);
        void cowParamsSet(LineView lineView, List<CowTTX> cowParams);



    }


}
