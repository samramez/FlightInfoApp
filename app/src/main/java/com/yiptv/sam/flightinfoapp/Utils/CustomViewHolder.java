package com.yiptv.sam.flightinfoapp.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiptv.sam.flightinfoapp.R;

/**
 * Created by Sam on 5/1/16.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {

    ImageView airlineImageView;
    TextView airlineTextView;


    public CustomViewHolder(View itemView) {
        super(itemView);
        airlineImageView = (ImageView) itemView.findViewById(R.id.airlineLogoImageView);
        airlineTextView = (TextView) itemView.findViewById(R.id.airlineNemeTextView);
    }
}
