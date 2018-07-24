package com.mts.cow.nikolay.lifeofacow.data.repository.local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.mts.cow.nikolay.lifeofacow.data.Cows;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;

@Database(entities = {Cows.class, CowTTX.class}, version = 1)
public abstract class CowDatabase extends RoomDatabase {

        public abstract CowsDao cowsDao();

}
