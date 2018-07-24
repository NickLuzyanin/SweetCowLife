package com.mts.cow.nikolay.lifeofacow.screen.cowpassportdetails;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.data.Cows;
import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import im.dacer.androidcharts.LineView;


@ActivityScoped
public class CowDetailsFragment extends DaggerFragment implements CowDetailsContract.View {




    @NonNull
    private static final String ARGUMENT_COW_ID = "COW_ID";

    @NonNull
    private static final int REQUEST_COW_TASK = 1;
    /*@Inject
    String CowId;*/


    @Inject
    CowDetailsContract.Presenter mPresenter;


    private TextView cowNumberText;
    private TextView cowBreedText;
    private TextView cowSuitText;
    private TextView cowBirthDayText;
    private TextView cowMotherText;
    private TextView cowFatherText;

    private int randomint = 9;


    @Inject
    public CowDetailsFragment() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        mPresenter.loadCowList();
    }

    @Override
    public void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cowdetail_frag, container, false);
        setHasOptionsMenu(true);


        cowNumberText =root.findViewById(R.id.cow_number_details);
        cowBreedText =root.findViewById(R.id.breed_details);
        cowSuitText =root.findViewById(R.id.suit_details);
        cowBirthDayText =root.findViewById(R.id.birthday_details);
        cowMotherText =root.findViewById(R.id.mother_details);
        cowFatherText =root.findViewById(R.id.father_details);






        // Set up floating action button
        FloatingActionButton fab = getActivity().findViewById(R.id.fab_edit_cow);

        //fab.setOnClickListener(v -> mPresenter.editNewCowPassport());

        return root;
    }


    private void initLineView(LineView lineView) {


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

    private void randomSet(LineView lineView) {
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
        dataLists.add(dataList);
        dataLists.add(dataList2);
        dataLists.add(dataList3);

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


    }


    @Override
    public void showCowsDetailsFromLocalDB(List<Cows> cows) {
        cowNumberText.setText(cows.get(0).getCowNumber());
        cowBreedText.setText(cows.get(0).getBreed());
        cowSuitText.setText(cows.get(0).getSuit());
        cowBirthDayText.setText(cows.get(0).getBirthDay());
        cowMotherText.setText(cows.get(0).getMother());
        cowFatherText.setText(cows.get(0).getFather());
    }

    @Override
    public void showLoadingCowsError() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
