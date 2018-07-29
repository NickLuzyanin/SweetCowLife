package com.mts.cow.nikolay.lifeofacow.data;

import android.support.annotation.NonNull;

import com.mts.cow.nikolay.lifeofacow.models.CowTTX;
import com.mts.cow.nikolay.lifeofacow.models.Cows;

import java.util.List;

public interface CowsDataSource {

    interface LoadCowsCallback {

        void onCowsLoaded(List<Cows> cows);



        void onDataNotAvailable();
    }

    interface LoadCowParamsCallback {

        void onCowsLoaded(List<CowTTX> cowParams);



        void onDataNotAvailable();
    }

    interface GetTaskCallback {

        void onCowLoaded(Cows cow);

        void onDataNotAvailable();
    }

    void getCows(@NonNull LoadCowsCallback callback);
    void getCowParams(@NonNull LoadCowParamsCallback callback);

    void getCow(@NonNull String CowId, @NonNull GetTaskCallback callback);

    void saveCow(@NonNull Cows cow);
    void saveCowParams(@NonNull CowTTX cowParams);



    void refreshCows();

    void deleteAllCows();

    void deleteCow(@NonNull String CowId);



}
