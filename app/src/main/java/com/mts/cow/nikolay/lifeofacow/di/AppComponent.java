package com.mts.cow.nikolay.lifeofacow.di;


import android.app.Application;


import com.mts.cow.nikolay.lifeofacow.AppDelegate;
import com.mts.cow.nikolay.lifeofacow.data.repository.local.CowsRepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {CowsRepositoryModule.class,
       // NetModule.class,
                        ApplicationModule.class,
                        ActivityBindingModule.class,
                        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<AppDelegate> {

    //TasksRepository getTasksRepository();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);




        AppComponent build();
    }
}
