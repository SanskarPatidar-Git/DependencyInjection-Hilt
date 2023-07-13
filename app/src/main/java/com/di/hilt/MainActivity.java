package com.di.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.di.hilt.classes.Company;
import com.di.hilt.classes.Country;
import com.di.hilt.classes.Database;
import com.di.hilt.classes.Person;
import com.di.hilt.classes.PersonFactory;
import com.di.hilt.classes.Vehicle;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.components.ActivityComponent;

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

    private Person person; // Need object with some values

    @Inject
    PersonFactory personFactory;

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


        /*
        Factory implementation for getting instance at runtime while passing parameter.
        Just like dagger we need to create a factory.
         */
        person = personFactory.create("Hey,I am Hilt",12);
        person.displayPersonData();
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


/*
Factory
While creating instance we need to pass some parameters to its constructor we need to define a factory

1. A class whose instance is need to be created while passing parameter is annoted to its constructor with
   @AssistedInject and the value in its constructor which will be passed at runtime will be annoted with @Assisted
   this will tell dagger that to create a instance of this class need a values which will be provided at runtime

2. Create a interface basically a Factory which will contain a method create which takes a parameter which will
   passed to constructor of class and return the instance if that class.
   the interface will be annoted with @AssistedFactory.

3. Instead of field injection to that class of which we need instance we are injecting field injection to the
   object of the Factory interface which will provide an instance of a class and passing the arguments to create
   method of interface.

   If we need a instance of that class whose object takes some parameter through constructor we don't need to
   define module for that class because module does not provide the object of class with @AssistedInject.

   -> in our project Person class need some parameter for creating its instance so we uses a factory interface
      PersonFactory to create a instance at runtime with values.
 */