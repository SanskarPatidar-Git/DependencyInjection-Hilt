package com.di.hilt.classes;

import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;

public class Person {

    private String name;
    private int age;

    @AssistedInject
    public Person(@Assisted String name ,@Assisted int age){
        this.name = name;
        this.age = age;
    }

    public void displayPersonData(){
        System.out.println("===== Teacher ===== name - "+name+"  ==== age - "+age);
    }
}

