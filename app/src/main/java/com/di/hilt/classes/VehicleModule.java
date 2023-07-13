package com.di.hilt.classes;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class VehicleModule {

    @Named("car")
    @Provides
    public Vehicle getCarVehicle(){
        return new Car();
    }

    @Named("bike")
    @Provides
    public Vehicle getBikeVehicle(){
        return new Bike();
    }
}
