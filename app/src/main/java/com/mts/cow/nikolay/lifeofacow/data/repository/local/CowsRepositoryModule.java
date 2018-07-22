package com.mts.cow.nikolay.lifeofacow.data.repository.local;


import android.app.Application;
import android.arch.persistence.room.Room;

import com.mts.cow.nikolay.lifeofacow.data.CowsDataSource;
import com.mts.cow.nikolay.lifeofacow.data.Local;
import com.mts.cow.nikolay.lifeofacow.utils.AppExecutors;
import com.mts.cow.nikolay.lifeofacow.utils.DiskIOThreadExecutor;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class CowsRepositoryModule {


    private static final int THREAD_COUNT = 3;

    @Singleton
    @Binds
    @Local
    abstract CowsDataSource provideTasksLocalDataSource(CowsLocalDataSource dataSource);



    @Singleton
    @Provides
    static CowDatabase provideDb(Application context) {
        return Room.databaseBuilder(context.getApplicationContext(), CowDatabase.class, "Cow_MTS.db")
                .build();
    }

    @Singleton
    @Provides
    static CowsDao provideTasksDao(CowDatabase db) {
        return db.cowsDao();
    }

    @Singleton
    @Provides
    static AppExecutors provideAppExecutors() {
        return new AppExecutors(new DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                new AppExecutors.MainThreadExecutor());
    }



}
