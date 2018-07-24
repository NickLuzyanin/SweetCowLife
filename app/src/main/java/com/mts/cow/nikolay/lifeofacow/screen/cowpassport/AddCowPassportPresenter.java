package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mts.cow.nikolay.lifeofacow.data.Cows;
import com.mts.cow.nikolay.lifeofacow.data.CowsDataSource;
import com.mts.cow.nikolay.lifeofacow.data.CowsRepository;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import dagger.Lazy;
import im.dacer.androidcharts.LineView;


public class AddCowPassportPresenter implements AddCowPassportContract.Presenter, CowsDataSource.GetTaskCallback {

    private static final int randomint = 9;

    @NonNull
    private final CowsDataSource mCowsRepository;

    @Nullable
    private AddCowPassportContract.View mAddCowView;

    private Lazy<Boolean> mIsDataMissingLazy;

    @Nullable
    private String cityRequests;


    @Nullable
    private String mCowId;


    @Inject
    AddCowPassportPresenter(@Nullable String cowId, @NonNull CowsRepository tasksRepository,
                         Lazy<Boolean> shouldLoadDataFromRepo) {
        mCowId = cowId;
        mCowsRepository = tasksRepository;
        mIsDataMissingLazy = shouldLoadDataFromRepo;
    }


    @Override
    public void saveCow(String cowNumber, String cowBreed, String cowSuit,String birthDay,String mother,String father,boolean state) {
        if (isNewTask()) {
            createCow(cowNumber,cowBreed,cowSuit,birthDay,mother,father,state);
        } else {
           // updateCow(cowNumber, cowBreed, cowsuit, birthDay, mother, father);
        }


    }

    @Override
    public void saveCowParams(String cowNumber, String milkyielddate, String milkyield, String fat_content, String weight) {
        if (isNewTask()) {
            createCowParams(cowNumber,milkyielddate,milkyield,fat_content,weight);
        } else {
            // updateCow(cowNumber, cowBreed, cowsuit, birthDay, mother, father);
        }
    }



    private void createCowParams(String cowNumber, String milkyielddate, String milkyield, String fat_content, String weight) {
        CowTTX newCowParams = new CowTTX(cowNumber,milkyielddate,"2",true,fat_content,milkyield,weight);
        if (newCowParams.isEmpty()) {
            if (mAddCowView != null) {
                // mAddCowView.showEmptyTaskError();
            }
        } else {
            mCowsRepository.saveCowParams(newCowParams);

            if (mAddCowView != null) {
               // mAddCowView.showCowsList();
            }
        }




    }


    private void createCow(String cowNumber, String cowBreed, String cowSuit,String birthDay,String mother,String father,boolean state) {
       Cows newCow = new Cows(cowNumber,cowBreed, "1",state,cowSuit,birthDay,mother,father);
        if (newCow.isEmpty()) {
            if (mAddCowView != null) {
               // mAddCowView.showEmptyTaskError();
            }
        } else {
            mCowsRepository.saveCow(newCow);

            if (mAddCowView != null) {
                mAddCowView.showCowsList();
            }
        }
    }


    @Override
    public void loadCowParams() {

        mCowsRepository.getCowParams(new CowsDataSource.LoadCowParamsCallback() {

            @Override
            public void onCowsLoaded(List<CowTTX> cowParams) {
                if (mAddCowView != null) {
                    mAddCowView.showCowParamsfromLocalDB(cowParams);
                }
            }

            @Override
            public void onDataNotAvailable() {
                //mAddCowView.showLoadingCowsError();
            }
        });

    }




    private boolean isNewTask() {
        return mCowId == null;
    }



    @Override
    public void getCowGraphParams() {

    }

    @Override
    public void getStreetList() {

    }

    @Override
    public void initLineView(LineView lineView) {



        ArrayList<String> test = new ArrayList<String>();
        for (int i = 0; i < randomint; i++) {
            test.add(String.valueOf(i + 1));
        }
        lineView.setBottomTextList(test);
        lineView.setColorArray(new int[] {
                Color.parseColor("#F44336"), Color.parseColor("#9C27B0"),
                Color.parseColor("#2196F3"), Color.parseColor("#009688")
        });
        lineView.setDrawDotLine(true);
        lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);

    }

    @Override
    public void cowParamsSet(LineView lineView, List<CowTTX> cowParams) {



        ArrayList<Integer> cowDataParams = new ArrayList<>();
        for (int i = 0; i < cowParams.size(); i++) {
            cowDataParams.add(Integer.parseInt(cowParams.get(i).getMilkyield()));
        }

        ArrayList<Integer> dataList = new ArrayList<>();
        float random = (float) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataList.add((int) (Math.random() * random));
        }

        ArrayList<Integer> dataList2 = new ArrayList<>();
        random = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataList2.add((int) (Math.random() * random));
        }

        ArrayList<Integer> dataList3 = new ArrayList<>();
        random = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataList3.add((int) (Math.random() * random));
        }

        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
        dataLists.add(cowDataParams);
        //dataLists.add(dataList2);
        //dataLists.add(dataList3);

        lineView.setDataList(dataLists);

        ArrayList<Float> dataListF = new ArrayList<>();
        float randomF = (float) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataListF.add((float) (Math.random() * randomF));
        }

        ArrayList<Float> dataListF2 = new ArrayList<>();
        randomF = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataListF2.add((float) (Math.random() * randomF));
        }

        ArrayList<Float> dataListF3 = new ArrayList<>();
        randomF = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataListF3.add((float) (Math.random() * randomF));
        }

        ArrayList<ArrayList<Float>> dataListFs = new ArrayList<>();
        dataListFs.add(dataListF);
        //dataListFs.add(dataListF2);
        //dataListFs.add(dataListF3);





    }

    @Override
    public void takeView(AddCowPassportContract.View view) {
        mAddCowView = view;
    }

    @Override
    public void dropView() {

    }

    @Override
    public void onCowLoaded(Cows cow) {

    }

    @Override
    public void onDataNotAvailable() {

    }
}
