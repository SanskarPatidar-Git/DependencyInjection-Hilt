package com.di.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.di.hilt.classes.Company;
import com.di.hilt.classes.Country;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    Company company;

    @Inject
    Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        company.start();
        country.initCountry();
    }
}