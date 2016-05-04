package com.yiptv.sam.flightinfoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView airlineLogoImage;
    private TextView airlineNameTextView;
    private TextView airlineWebsiteTextView;
    private TextView airlinePhoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();



        airlineLogoImage = (ImageView) findViewById(R.id.airlineLogoImage);
        Picasso.with(this)
                .load("https://www.kayak.com/" + intent.getStringExtra("image") )
                .into(airlineLogoImage);

        airlineNameTextView = (TextView) findViewById(R.id.airlineNameTextView);
        airlineNameTextView.setText( intent.getStringExtra("name") );


        airlineWebsiteTextView = (TextView) findViewById(R.id.airlineWebsiteTextView);
        airlineWebsiteTextView.setText( "http://" + intent.getStringExtra("website"));
        airlineWebsiteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(airlineWebsiteTextView.getText().toString()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        airlinePhoneTextView = (TextView) findViewById(R.id.airlinePhoneTextView);
        airlinePhoneTextView.setText( intent.getStringExtra("phone"));
        airlinePhoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + airlinePhoneTextView.getText().toString()));
                startActivity(intent);
            }
        });




    }
}
