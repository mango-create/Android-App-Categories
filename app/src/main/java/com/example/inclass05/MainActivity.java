//Matthew Mango and Ray Townsend
//InClass05

package com.example.inclass05;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IAppCategories, IAppsList {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.parentContainer, new AppCategories())
                .commit();
    }

    @Override
    public void onCatClick(String appName) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parentContainer, AppsList.newInstance(appName))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onAppClick(DataServices.App app) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parentContainer, AppDetails.newInstance(app))
                .addToBackStack(null)
                .commit();
    }
}