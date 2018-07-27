package com.mts.cow.nikolay.lifeofacow.data.repository.local;

import android.support.annotation.NonNull;

import com.mts.cow.nikolay.lifeofacow.models.Cows;
import com.mts.cow.nikolay.lifeofacow.data.CowsDataSource;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;
import com.mts.cow.nikolay.lifeofacow.utils.AppExecutors;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.google.common.base.Preconditions.checkNotNull;


@Singleton
public class CowsLocalDataSource implements CowsDataSource {

    private final CowsDao mCowsDao;

    private final AppExecutors mAppExecutors;


    @Inject
    public CowsLocalDataSource(@NonNull AppExecutors executors, @NonNull CowsDao tasksDao) {
        mCowsDao = tasksDao;
        mAppExecutors = executors;
    }



    @Override
    public void getCows(@NonNull LoadCowsCallback callback) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Cows> tasks = mCowsDao.getCows();
                mAppExecutors.mainThread().execute(() -> {
                    if (tasks.isEmpty()) {
                        // This will be called if the table is new or just empty.
                        callback.onDataNotAvailable();
                    } else {
                        callback.onCowsLoaded(tasks);
                    }
                });
            }
        };

        mAppExecutors.diskIO().execute(runnable);

    }

    @Override
    public void getCowParams(@NonNull LoadCowParamsCallback callback) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<CowTTX> tasks = mCowsDao.getCowsTTX();
                mAppExecutors.mainThread().execute(() -> {
                    if (tasks.isEmpty()) {
                        // This will be called if the table is new or just empty.
                        callback.onDataNotAvailable();
                    } else {
                        callback.onCowsLoaded(tasks);
                    }
                });
            }
        };

        mAppExecutors.diskIO().execute(runnable);

    }


    @Override
    public void getCow(@NonNull String CowId, @NonNull GetTaskCallback callback) {

    }

    @Override
    public void saveCow(@NonNull Cows cow) {

        checkNotNull(cow);
        Runnable saveRunnable = () -> mCowsDao.insertCows(cow);
        mAppExecutors.diskIO().execute(saveRunnable);

    }

    @Override
    public void saveCowParams(@NonNull CowTTX cowParams) {

        checkNotNull(cowParams);
        Runnable saveRunnable = () -> mCowsDao.insertCowsTTX(cowParams);
        mAppExecutors.diskIO().execute(saveRunnable);

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
