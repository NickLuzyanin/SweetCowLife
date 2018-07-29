/*
 *
 * Copyright (c) $year Aleksandr Karpov <keyfour13@gmail.com>
 *
 */

package com.mts.cow.nikolay.lifeofacow.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;


import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.screen.animalList.ListofCowActivity;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
    }

    @Override
    public void onResume() {
        super.onResume();
        Observable.just(true)
                .subscribeOn(Schedulers.io())
                .delay(8, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(startActivityAction1(), Throwable::printStackTrace);
    }

    @NonNull
    private Action1<Boolean> startActivityAction1() {

        return usersExists -> {
            if (usersExists) {
                startActivity(new Intent(this, ListofCowActivity.class));

            } else {

            }
            this.finish();
        };
    }

}
