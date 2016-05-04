package com.yiptv.sam.flightinfoapp;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button airlinesButton;
    private Button favoritesButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        airlinesButton = (Button) findViewById(R.id.airlinesButton);
        favoritesButton = (Button) findViewById(R.id.favoritesButton);

        showAirlinesFragment();


        if(!isNetworkAvailable()){
            Toast.makeText(this,"Please connect to Internet and Try again",Toast.LENGTH_LONG).show();
        }

    }

    private void showAirlinesFragment() {

        AirlinesFragment airlinesFragment = new AirlinesFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,airlinesFragment)
                .commit();

    }

    private void showFavoriteFragment(){

        FavoritesFragment favoriteFragment = new FavoritesFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,favoriteFragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onClick(View view) {

        switch(view.getId()) {

            case R.id.airlinesButton:
                showAirlinesFragment();
                airlinesButton.setClickable(false);
                favoritesButton.setClickable(true);
                break;
            case R.id.favoritesButton:
                showFavoriteFragment();
                airlinesButton.setClickable(true);
                favoritesButton.setClickable(false);
                break;
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
