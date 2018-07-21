package com.mts.cow.nikolay.lifeofacow.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mts.cow.nikolay.lifeofacow.models.CowTTX;

import java.util.ArrayList;

@Entity(tableName = "cows")
public class Cows {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "cowid")
    private final String mId;

    @Nullable
    @ColumnInfo(name = "breed")
    private final String mBreed;

    @Nullable
    @ColumnInfo(name = "suit")
    private final String mSuit;

    @Nullable
    @ColumnInfo(name = "birthDay")
    private final String mBirthDay;

    @Nullable
    @ColumnInfo(name = "mother")
    private final String mMother;

    @Nullable
    @ColumnInfo(name = "father")
    private final String mFather;

    @Nullable
    @ColumnInfo(name = "cowttx")
    private final ArrayList<CowTTX> cowTTX;












    public Cows(@Nullable String cowid, @Nullable String breed, @Nullable String suit, @Nullable String birthDay, @Nullable String mother, @Nullable String father, @Nullable ArrayList<CowTTX> cowttx) {
        mId = cowid;
        mBreed  = breed;
        mSuit = suit;
        mBirthDay = birthDay;
        mMother = mother;
        mFather = father;
        cowTTX = cowttx;
    }





    @NonNull
    public String getmId() {
        return mId;
    }

    @Nullable
    public String getmBreed() {
        return mBreed;
    }

    @Nullable
    public String getmSuit() {
        return mSuit;
    }

    @Nullable
    public String getmBirthDay() {
        return mBirthDay;
    }

    @Nullable
    public String getmMother() {
        return mMother;
    }

    @Nullable
    public String getmFather() {
        return mFather;
    }

    @Nullable
    public ArrayList<CowTTX> getCowTTX() {
        return cowTTX;
    }
}
