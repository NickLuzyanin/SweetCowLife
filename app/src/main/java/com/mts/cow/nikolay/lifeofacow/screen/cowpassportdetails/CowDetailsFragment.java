package com.mts.cow.nikolay.lifeofacow.screen.cowpassportdetails;

import com.mts.cow.nikolay.lifeofacow.di.ActivityScoped;

import dagger.android.support.DaggerFragment;


@ActivityScoped
public class CowDetailsFragment extends DaggerFragment implements CowDetailsContract.View {










    @Override
    public boolean isActive() {
        return false;
    }
}
