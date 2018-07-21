package com.mts.cow.nikolay.lifeofacow.data;

import android.support.annotation.NonNull;

public class CowsRepository implements CowsDataSource {


    private final CowsDataSource mCowsLocalDataSource;




    @Override
    public void getCows(@NonNull LoadTasksCallback callback) {

    }

    @Override
    public void getCow(@NonNull String CowId, @NonNull GetTaskCallback callback) {

    }

    @Override
    public void saveCow(@NonNull Cows cow) {

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
