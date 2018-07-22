package com.mts.cow.nikolay.lifeofacow.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class CowsRepository implements CowsDataSource {


    private final CowsDataSource mCowsLocalDataSource;









    @Inject
    CowsRepository(@Local CowsDataSource tasksLocalDataSource) {
        mCowsLocalDataSource = tasksLocalDataSource;

    }

    @Override
    public void getCows(@NonNull LoadCowsCallback callback) {

        checkNotNull(callback);

        mCowsLocalDataSource.getCows(new LoadCowsCallback() {

            @Override
            public void onCowsLoaded(List<Cows> cows) {

                callback.onCowsLoaded(new ArrayList<>(cows));

            }

            @Override
            public void onDataNotAvailable() {

                callback.onDataNotAvailable();

            }
        });

    }

    @Override
    public void getCow(@NonNull String CowId, @NonNull GetTaskCallback callback) {

    }

    @Override
    public void saveCow(@NonNull Cows cow) {

        checkNotNull(cow);
        mCowsLocalDataSource.saveCow(cow);




    }






    @Override
    public void refreshCows() {

    }

    @Override
    public void deleteAllCows() {

    }

    @Override
    public void deleteCow(@NonNull String CowId) {

    }
}
