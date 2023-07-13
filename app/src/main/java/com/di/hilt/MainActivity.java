package com.di.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.di.hilt.classes.Company;
import com.di.hilt.classes.Country;
import com.di.hilt.classes.Database;
import com.di.hilt.classes.Vehicle;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    Company company; //Using constructor

    @Inject
    Country country; //Using Modules and Provides

    @Named("bike")
    @Inject
    Vehicle vehicle; //Named() and Qualifier or create custom Qualifier.

    @Inject
    Database database; // Scoped

    @Inject
    Database database1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        company.start();


        country.initCountry();

        vehicle.startVehicle();


        database.initDB();
        System.out.println("============ Databse 1 ============= "+database+"===== Database 2 ===== "+database1);
        /*
        Rotate your screen and check again the reference value of database and database 1
        if you use @Singleton and SingletonComponent in DatabaseModule the reference will be same because
        Singleton is associated with Application whose instance will be retain till application is running
        but when you use @ActivityScoped and ActivityComponent the reference will be change because after
        activity destroyed it will create again instance and till activity remain single instance will be used.
         */
    }
}

/*
AndroidEntryPoint ->
This annotation is used on a java class which needs dependency and according to this activity hilt will create
ActivityComponent which will provide dependency either from constructor or from modules.
 */

/*
@InstallIn()
This annotations is used on Modules that which component will need this dependency from a module.
Like Country object needs from CountryModule so we annot CountryModule which InstallIn to tell hilt that
this class will give dependency to ActivityComponent.
 */

/*
Scope
if you need a instance only single for whole application you need to annot with @Singleton
Singleton is associated with SingletonComponent which is for application
if you need a scope till activity use @ActivityScoped with its ActivityComponent.
See in Database class and Database Module
just like this all classes like ViewModel , service they have their own scope and their component
Visit to hilt documentation for more understanding.
 */