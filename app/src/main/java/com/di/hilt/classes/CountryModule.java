package com.di.hilt.classes;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class CountryModule {

    @Provides
    public Country getCountry(){
        return new Country();
    }
}
