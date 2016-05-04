package com.yiptv.sam.flightinfoapp.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiptv.sam.flightinfoapp.R;

/**
 * Created by Sam on 5/1/16.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder  {

    ImageView airlineImageView;
    TextView airlineTextView;
    ImageButton favSelectedButton;
    ImageButton favNotSelectedButton;


    public CustomViewHolder(View itemView) {
        super(itemView);
        airlineImageView = (ImageView) itemView.findViewById(R.id.airlineLogoImageView);
        airlineTextView = (TextView) itemView.findViewById(R.id.airlineNemeTextView);
        favSelectedButton = (ImageButton) itemView.findViewById(R.id.favSelectedButton);
        favNotSelectedButton = (ImageButton) itemView.findViewById(R.id.favNotSelectedButton);
    }


    public void bind(final ImageButton imageButton, final AdapterView.OnItemClickListener listener){

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void onClick(View.OnClickListener v) {

        /*
        int position = getAdapterPosition();
        DBTools dbTools = new DBTools(v.getContext(),"favorites.db",null,1);

        switch (v.getId()){

            case R.id.favNotSelectedButton:

                //dbTools.insertIntoFavorites();

                break;
            case R.id.favSelectedButton:

                break;
        } */

    }
}
