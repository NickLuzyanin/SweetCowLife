package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;


import android.app.Activity;
import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.annotation.Nullable;


import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.content.res.AppCompatResources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;
import com.mts.cow.nikolay.lifeofacow.utils.ActivityUtils;


import java.util.List;

import javax.inject.Inject;


import dagger.android.support.DaggerFragment;
import im.dacer.androidcharts.LineView;

public class AddCowPassportFragment extends DaggerFragment implements AddCowPassportContract.View{


    public static final String ARGUMENT_EDIT_COW_ID = "EDIT_COW_ID";

    private static final int REQUEST_COW_PARAMS = 1;


    private AutoCompleteTextView cowNumberAutoCompleteText;
    private AutoCompleteTextView cowBreedAutoCompleteText;
    private AutoCompleteTextView cowSuitAutoCompleteText;
    private AutoCompleteTextView cowBirthDayAutoCompleteText;
    private AutoCompleteTextView cowMotherAutoCompleteText;
    private AutoCompleteTextView cowFatherAutoCompleteText;
    private Button savePassport;
    private  LineView lineView;
    ArrayAdapter<String> adapter;



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
        cowBreedAutoCompleteText.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable cityRequest) {

                if (cityRequest.toString().length()>= 4){

                    adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.cow_breed_array));
                    cowBreedAutoCompleteText.setAdapter(adapter);

                }


            }
        });


        cowSuitAutoCompleteText.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable cityRequest) {

                if (cityRequest.toString().length()>= 4){

                    adapter = new ArrayAdapter<String>(getContext(),R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.cow_suit_array));
                    cowSuitAutoCompleteText.setAdapter(adapter);

                }


            }
        });




    }

    @Override
    public void onPause() {
        mPresenter.dropView();
        super.onPause();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);






        FloatingActionButton fab = getActivity().findViewById(R.id.fab_edit_cow_pass);
        fab.setImageResource(R.drawable.ic_add_graph);
        fab.setOnClickListener(v -> {
            ActivityUtils.showDialogFragment(new AddCowMilkYieldFragment(),getFragmentManager(),this,REQUEST_COW_PARAMS);
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

        String[] cowParams = data.getStringArrayExtra(AddCowMilkYieldFragment.TAG_COW_PARAMS_SELECTED);

        mPresenter.saveCowParams("2345",cowParams[0],cowParams[1],cowParams[2],cowParams[3]);
        mPresenter.loadCowParams();


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.addcow_pas_frag, container, false);

        lineView = (LineView) root.findViewById(R.id.line_view_main);


       cowNumberAutoCompleteText =root.findViewById(R.id.input_cow_number);
       cowBreedAutoCompleteText =root.findViewById(R.id.input_breed);
       cowSuitAutoCompleteText=root.findViewById(R.id.input_suit);
       cowBirthDayAutoCompleteText=root.findViewById(R.id.input_birthday);
       cowMotherAutoCompleteText=root.findViewById(R.id.input_mother);
       cowFatherAutoCompleteText=root.findViewById(R.id.input_father);
       savePassport=root.findViewById(R.id.save_pass_button);
       savePassport.setOnClickListener(v ->
               mPresenter.saveCow(cowNumberAutoCompleteText.getText().toString(),
                   cowBreedAutoCompleteText.getText().toString(),
                   cowSuitAutoCompleteText.getText().toString(),
                   cowBirthDayAutoCompleteText.getText().toString(),
                   cowMotherAutoCompleteText.getText().toString(),
                   cowFatherAutoCompleteText.getText().toString(),false));






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
    public void showCowParamsfromLocalDB(List<CowTTX> cowParams) {
        mPresenter.initLineView(lineView);
        mPresenter.cowParamsSet(lineView,cowParams);




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
