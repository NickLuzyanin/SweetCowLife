package com.mts.cow.nikolay.lifeofacow.data;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "cows")
public final class Cows {



    @NonNull
    @ColumnInfo(name = "entryid")
    private final String mId;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "cowNumber")
    private final String mCowNumber;

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


    @ColumnInfo(name = "completed")
    private final boolean mCompleted;

    /**
     * Use this constructor to create a new active Task.
     *
     * @param cowNumber       title of the task
     * @param breed description of the task
     */
    @Ignore
    public Cows(@Nullable String cowNumber, @Nullable String breed,@Nullable String suit, @Nullable String birthDay,@Nullable String mother,@Nullable String father) {
        this(cowNumber, breed, UUID.randomUUID().toString(), false,suit,birthDay,mother,father);
    }

    /**
     * Use this constructor to create an active Task if the Task already has an id (copy of another
     * Task).
     *
     * @param cowNumber       title of the task
     * @param breed description of the task
     * @param id          id of the task
     */
    @Ignore
    public Cows(@Nullable String cowNumber, @Nullable String breed, @NonNull String id,@Nullable String suit, @Nullable String birthDay,@Nullable String mother,@Nullable String father) {
        this(cowNumber, breed, id, false,suit,birthDay,mother,father);
    }

    /**
     * Use this constructor to create a new completed Task.
     *
     * @param cowNumber       title of the task
     * @param breed description of the task
     * @param completed   true if the task is completed, false if it's active
     */
    @Ignore
    public Cows(@Nullable String cowNumber, @Nullable String breed, boolean completed,@Nullable String suit, @Nullable String birthDay,@Nullable String mother,@Nullable String father) {
        this(cowNumber, breed, UUID.randomUUID().toString(), completed,suit,birthDay,mother,father);
    }

    /**
     * Use this constructor to specify a completed Task if the Task already has an id (copy of
     * another Task).
     *
     * @param cowNumber       title of the task
     * @param breed description of the task
     * @param id          id of the task
     * @param completed   true if the task is completed, false if it's active
     */
    public Cows(@Nullable String cowNumber, @Nullable String breed,
                @NonNull String id, boolean completed,@Nullable String suit, @Nullable String birthDay,@Nullable String mother,@Nullable String father) {
        mId = UUID.randomUUID().toString();
        mCowNumber = cowNumber;
        mBreed = breed;
        mCompleted = completed;
        mSuit = suit;
        mBirthDay = birthDay;
        mMother = mother;
        mFather = father;
    }

    @NonNull
    public String getId() {
        return mId;
    }

    @Nullable
    public String getCowNumber() {
        return mCowNumber;
    }

    @Nullable
    public String getTitleForList() {
        if (!Strings.isNullOrEmpty(mCowNumber)) {
            return mCowNumber;
        } else {
            return mBreed;
        }
    }

    @Nullable
    public String getBreed() {
        return mBreed;
    }

    @Nullable
    public String getSuit() {
        return mSuit;
    }

    @Nullable
    public String getBirthDay() {
        return mBirthDay;
    }

    @Nullable
    public String getMother() {
        return mMother;
    }

    @Nullable
    public String getFather() {
        return mFather;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public boolean isActive() {
        return !mCompleted;
    }

    public boolean isEmpty() {
        return Strings.isNullOrEmpty(mCowNumber) &&
                Strings.isNullOrEmpty(mBreed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cows cow = (Cows) o;
        return Objects.equal(mId, cow.mId) &&
                Objects.equal(mCowNumber, cow.mCowNumber) &&
                Objects.equal(mBreed, cow.mBreed);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mCowNumber, mBreed);
    }

    /*@Override
    public String toString() {
        return "Task with title " + mCowNumber;
    }*/






}
