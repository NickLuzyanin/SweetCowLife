package com.mts.cow.nikolay.lifeofacow.screen.animalList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.screen.cowpassport.AddCowPassportActivity;


import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


@ActivityScoped
public class ListofCowFragment extends DaggerFragment implements ListofCowContract.View {

    @Inject
    ListofCowContract.Presenter mPresenter;

    //private TasksAdapter mListAdapter;
    private View mNoTasksView;
    private ImageView mNoCowIcon;
    private TextView mNoTaskMainView;
    private TextView mNoTaskAddView;
    private LinearLayout mTasksView;
    private TextView mFilteringLabelView;



    @Inject
    public ListofCowFragment() {
        // Requires empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode, resultCode);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cowlist_frag, container, false);

        // Set up  no tasks view

        mNoCowIcon = (ImageView) root.findViewById(R.id.noCowsIcon);
        mNoTaskMainView = (TextView) root.findViewById(R.id.noCowsMain);

        // Set up floating action button
        FloatingActionButton fab = getActivity().findViewById(R.id.fab_add_cow_pass);

        fab.setImageResource(R.drawable.ic_addpass);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addNewCowPassport();
            }
        });





        return root;
    }










    @Override
    public void showCowPassport() {
        Intent intent = new Intent(getContext(),AddCowPassportActivity.class);
        startActivityForResult(intent, AddCowPassportActivity.REQUEST_ADD_COW);
    }



}
