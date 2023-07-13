package com.di.hilt.classes;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(ActivityComponent.class)
public class DatabaseModule {

    @ActivityScoped
    @Provides
    public Database getDatabase(){
        return new Database();
    }
}
