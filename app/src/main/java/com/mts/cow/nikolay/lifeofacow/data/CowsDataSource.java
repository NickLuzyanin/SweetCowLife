package com.mts.cow.nikolay.lifeofacow.data;

import android.support.annotation.NonNull;

import java.util.List;

public interface CowsDataSource {

    interface LoadCowsCallback {

        void onCowsLoaded(List<Cows> cows);



        void onDataNotAvailable();
    }

    interface GetTaskCallback {

        void onCowLoaded(Cows cow);

        void onDataNotAvailable();
    }

    void getCows(@NonNull LoadCowsCallback callback);

    void getCow(@NonNull String CowId, @NonNull GetTaskCallback callback);

    void saveCow(@NonNull Cows cow);


    void refreshCows();

    void deleteAllCows();

    void deleteCow(@NonNull String CowId);



}
