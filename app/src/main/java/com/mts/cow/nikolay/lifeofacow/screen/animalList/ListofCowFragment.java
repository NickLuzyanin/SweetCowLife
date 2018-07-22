package com.mts.cow.nikolay.lifeofacow.screen.animalList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.data.Cows;
import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;
import com.mts.cow.nikolay.lifeofacow.screen.cowpassport.AddCowPassportActivity;


import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


@ActivityScoped
public class ListofCowFragment extends DaggerFragment implements ListofCowContract.View {

    @Inject
    ListofCowContract.Presenter mPresenter;


    private View mNoTasksView;
    private ImageView mNoCowIcon;
    private TextView mNoCowMainView;
    private TextView mNoTaskAddView;
    private LinearLayout mTasksView;
    private TextView mFilteringLabelView;


    private TextView firstParamFromDB;
    private TextView secondParamsFromDB;



    @Inject
    public ListofCowFragment() {
        // Requires empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        mPresenter.loadCowList();
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

        firstParamFromDB = root.findViewById(R.id.cow_title);
        secondParamsFromDB = root.findViewById(R.id.cow_description);








        mNoCowIcon = (ImageView) root.findViewById(R.id.noCowsIcon);
        mNoCowMainView = (TextView) root.findViewById(R.id.noCowsMain);

        // Set up floating action button
        FloatingActionButton fab = getActivity().findViewById(R.id.fab_add_cow_pass);

        fab.setImageResource(R.drawable.ic_addpass);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addNewCowPassport();
            }
        });

        // Set up progress indicator
        final ScrollChildSwipeRefreshLayout swipeRefreshLayout =
                root.findViewById(R.id.refresh_layout);



        setHasOptionsMenu(true);

        return root;
    }










    @Override
    public void showCowPassport() {
        Intent intent = new Intent(getContext(),AddCowPassportActivity.class);
        startActivityForResult(intent, AddCowPassportActivity.REQUEST_ADD_COW);
    }

    @Override
    public void showSuccessfullySavedMessage() {
        showMessage(getString(R.string.successfully_saved_cow));
    }

    @Override
    public void showCowsFromLocalDB(List<Cows> cows) {

            firstParamFromDB.setText(cows.get(0).getTitle());
            secondParamsFromDB.setText(cows.get(0).getDescription());

    }

    private void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingTasksError() {
        showMessage(getString(R.string.loading_tasks_error));
    }







}
