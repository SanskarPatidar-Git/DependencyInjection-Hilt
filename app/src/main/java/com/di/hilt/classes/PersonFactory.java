package com.di.hilt.classes;

import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface PersonFactory {
    Person create(String name , int age);
}
