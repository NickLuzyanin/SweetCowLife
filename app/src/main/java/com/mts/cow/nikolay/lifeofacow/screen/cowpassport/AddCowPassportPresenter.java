package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mts.cow.nikolay.lifeofacow.data.Cows;
import com.mts.cow.nikolay.lifeofacow.data.CowsDataSource;
import com.mts.cow.nikolay.lifeofacow.data.CowsRepository;

import javax.inject.Inject;

import dagger.Lazy;


public class AddCowPassportPresenter implements AddCowPassportContract.Presenter, CowsDataSource.GetTaskCallback {

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
    public void saveTask(String cowNumber, String cowBreed, String cowsuit, String birthDay, String mother, String father) {
        if (isNewTask()) {
            createCow(cowNumber, cowBreed, cowsuit, birthDay, mother, father);
        } else {
            updateCow(cowNumber, cowBreed, cowsuit, birthDay, mother, father);
        }


    }


    private void createCow(String cowNumber, String cowBreed, String cowsuit, String birthDay, String mother, String father) {
       Cows newTask = new Cows(cowNumber,cowBreed,cowsuit,birthDay,mother,father);
        if (newTask.isEmpty()) {
            if (mAddTaskView != null) {
                mAddTaskView.showEmptyTaskError();
            }
        } else {
            mTasksRepository.saveTask(newTask);

            if (mAddTaskView != null) {
                mAddTaskView.showTasksList();
            }
        }
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
