package com.example.v_s.androidtutorialfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements ItemsFragment.Listener{

    private ViewGroup itemsListContainer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsListContainer = findViewById(R.id.view_items);
        if (savedInstanceState == null){
            if (isTablet()){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.view_items, new ItemsFragment())
                        .replace(R.id.view_container, DetailFragment.newInstance("N/A"))
                        .commit();
            }else {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.view_container, new ItemsFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onItem1Click(ItemsFragment fragment) {
        String name = "Item1";
        /*if (isTablet()){
            final DetailFragment detailFragment =
                    (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.view_container);
            detailFragment.setName(name);
        }else {*/
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.view_container, DetailFragment.newInstance(name))
                    .commit();
        //}
    }

    @Override
    public void onItem2Click(ItemsFragment fragment) {
        String name = "Item2";
        /*if (isTablet()){
            DetailFragment detailFragment =
                    (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.view_container);
            detailFragment.setName(name);
        }else {*/
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.view_container,DetailFragment.newInstance(name))
                    .commit();

        //}
    }

    private boolean isTablet(){
        return itemsListContainer != null;

    }

   /* public void onButtonClick(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.view_container, new DetailFragment())
                .commit();

    }*/
}
