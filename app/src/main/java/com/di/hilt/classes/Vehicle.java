package com.di.hilt.classes;

import javax.inject.Named;

public interface Vehicle {
    void startVehicle();
}

class Car implements Vehicle {


    @Override
    public void startVehicle() {
        System.out.println("======== Car vehicle started ============");
    }
}

class Bike implements Vehicle{


    @Override
    public void startVehicle() {
        System.out.println("======== Bike vehicle started ============");
    }
}

