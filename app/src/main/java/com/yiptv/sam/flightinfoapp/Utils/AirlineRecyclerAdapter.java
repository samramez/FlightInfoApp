package com.yiptv.sam.flightinfoapp.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.yiptv.sam.flightinfoapp.Model.AirlineInfo;
import com.yiptv.sam.flightinfoapp.R;

import java.util.List;

/**
 * Created by Sam on 5/1/16.
 */
public class AirlineRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<AirlineInfo> mAirlineInfoList;
    private Context mContext;

    public AirlineRecyclerAdapter(Context mContext, List<AirlineInfo> airlineInfo) {
        this.mContext = mContext;
        this.mAirlineInfoList = airlineInfo;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_airline_recyclerview,null);
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        AirlineInfo airlineInfo = mAirlineInfoList.get(position);

        Picasso.with(mContext)
        .load("https://www.kayak.com/" + airlineInfo.getLogoURL() )
        .into(holder.airlineImageView);

        holder.airlineTextView.setText(airlineInfo.getName());



    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
