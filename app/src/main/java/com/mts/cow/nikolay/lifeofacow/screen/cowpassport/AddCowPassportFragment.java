package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import dagger.android.support.DaggerFragment;
import im.dacer.androidcharts.LineView;

public class AddCowPassportFragment extends DaggerFragment implements AddCowPassportContract.View {


    public static final String ARGUMENT_EDIT_COW_ID = "EDIT_COW_ID";


    private AutoCompleteTextView cowNumberAutoCompleteText;
    private AutoCompleteTextView cowBreedAutoCompleteText;
    private AutoCompleteTextView cowSuitAutoCompleteText;
    private AutoCompleteTextView cowBirthDayAutoCompleteText;
    private AutoCompleteTextView cowMotherAutoCompleteText;
    private AutoCompleteTextView cowFatherAutoCompleteText;

    private int randomint = 9;




    ProgressBar progressBar;

    @Inject
    AddCowPassportContract.Presenter mPresenter;


    @Inject
    public AddCowPassportFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);

    }

    @Override
    public void onPause() {
        mPresenter.dropView();
        super.onPause();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        /*CowTTX Cowttx = new CowTTX();
        Cowttx.setMilk_yield("100");
        Cowttx.setFat_content("25");
        Cowttx.setWeight("800");

        List<CowTTX> cowttx = new ArrayList<CowTTX>();
        cowttx.add(Cowttx);*/



        FloatingActionButton fab = getActivity().findViewById(R.id.fab_edit_cow_pass);
        fab.setImageResource(R.drawable.ic_done);
        fab.setOnClickListener(v -> {
                mPresenter.saveCow(cowNumberAutoCompleteText.getText().toString(),
                                    cowBreedAutoCompleteText.getText().toString(),
                        cowSuitAutoCompleteText.getText().toString(),
                        cowBirthDayAutoCompleteText.getText().toString(),
                        cowMotherAutoCompleteText.getText().toString(),
                        cowFatherAutoCompleteText.getText().toString(),false);
        });

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.addcow_pas_frag, container, false);

       cowNumberAutoCompleteText =root.findViewById(R.id.input_cow_number);
       cowBreedAutoCompleteText =root.findViewById(R.id.input_breed);
       cowSuitAutoCompleteText=root.findViewById(R.id.input_suit);
       cowBirthDayAutoCompleteText=root.findViewById(R.id.input_birthday);
       cowMotherAutoCompleteText=root.findViewById(R.id.input_mother);
       cowFatherAutoCompleteText=root.findViewById(R.id.input_father);

        final LineView lineView = (LineView) root.findViewById(R.id.line_view);

        initLineView(lineView);

        randomSet(lineView);


        setHasOptionsMenu(true);
        setRetainInstance(true);
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
    public void showCowGraph(List<Integer> cowParams) {




    }

    @Override
    public void showCowsList() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void showWait() {

    }

    @Override
    public void removeWait() {

    }
}
