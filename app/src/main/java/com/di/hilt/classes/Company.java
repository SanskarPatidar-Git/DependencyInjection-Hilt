package com.di.hilt.classes;

import javax.inject.Inject;

public class Company {

    @Inject
    public Company(){

    }
    public void start(){
        System.out.println("========== COMPANY STARTED ======== ");
    }
}
