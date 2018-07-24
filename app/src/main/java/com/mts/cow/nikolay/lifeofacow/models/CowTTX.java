package com.mts.cow.nikolay.lifeofacow.models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import java.util.UUID;


@Entity(tableName = "cows_params")
public final class CowTTX {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "entryid")
    private final String mId;


    @NonNull
    @ColumnInfo(name = "cowNumber_id")
    private final String mCowNumber_id;

    @Nullable
    @ColumnInfo(name = "date_milkyield")
    private final String mDate_milkyield;

    @Nullable
    @ColumnInfo(name = "milkyield")
    private final String mMilkyield;



    @Nullable
    @ColumnInfo(name = "fat_content")
    private final String mFat_content;

    @Nullable
    @ColumnInfo(name = "weight")
    private final String mWeight;


    @ColumnInfo(name = "completed")
    private final boolean mCompleted;


    public CowTTX(@Nullable String cowNumber_id,
                @Nullable String date_milkyield,
                @NonNull String id,
                boolean completed,
                @Nullable String fat_content,
                @Nullable String weight,@Nullable String milkyield) {
        mId = UUID.randomUUID().toString();
        mCowNumber_id = cowNumber_id;
        mDate_milkyield = date_milkyield;
        mCompleted = completed;
        mFat_content = fat_content;
        mWeight = weight;
        mMilkyield = milkyield;


    }

    @NonNull
    public String getId() {
        return mId;
    }

    @Nullable
    public String getCowNumber_id() {
        return mCowNumber_id;
    }



    @Nullable
    public String getDate_milkyield() {
        return mDate_milkyield;
    }

    @Nullable
    public String getMilkyield() {
        return mMilkyield;
    }

    @Nullable
    public String getFat_content() {
        return mFat_content;
    }

    @Nullable
    public String getWeight() {
        return mWeight;
    }


    public boolean isCompleted() {
        return mCompleted;
    }

    public boolean isActive() {
        return !mCompleted;
    }

    public boolean isEmpty() {
        return Strings.isNullOrEmpty(mCowNumber_id) &&
                Strings.isNullOrEmpty(mDate_milkyield);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cows cow = (Cows) o;
        return Objects.equal(mId, cow.mId) &&
                Objects.equal(mCowNumber, cow.mCowNumber) &&
                Objects.equal(mBreed, cow.mBreed);
    }*/

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mCowNumber_id, mDate_milkyield);
    }

    /*@Override
    public String toString() {
        return "Task with title " + mCowNumber;
    }*/



}



