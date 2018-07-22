package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import dagger.android.support.DaggerFragment;

public class AddCowPassportFragment extends DaggerFragment implements AddCowPassportContract.View {


    public static final String ARGUMENT_EDIT_COW_ID = "EDIT_COW_ID";


    private AutoCompleteTextView cowNumberAutoCompleteText;
    private AutoCompleteTextView cowBreedAutoCompleteText;
    private AutoCompleteTextView cowSuitAutoCompleteText;
    private AutoCompleteTextView cowBirthDayAutoCompleteText;
    private AutoCompleteTextView cowMotherAutoCompleteText;
    private AutoCompleteTextView cowFatherAutoCompleteText;




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
                        cowBreedAutoCompleteText.getText().toString(),false);
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



        setHasOptionsMenu(true);
        setRetainInstance(true);
        return root;
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
