package com.mts.cow.nikolay.lifeofacow.data;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.mts.cow.nikolay.lifeofacow.models.CowTTX;
import com.mts.cow.nikolay.lifeofacow.models.Cows;

import java.util.List;

public class CowWithParams {


    @Embedded
    public Cows cows;

    @Relation(parentColumn = "cowNumber", entityColumn = "cowNumber_id")
    public List<CowTTX> cowParams;



}
