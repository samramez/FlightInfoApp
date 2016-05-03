package com.yiptv.sam.flightinfoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yiptv.sam.flightinfoapp.Model.AirlineInfo;
import com.yiptv.sam.flightinfoapp.Service.AirlineInfoService;
import com.yiptv.sam.flightinfoapp.Utils.AirlineRecyclerAdapter;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;

/**
 * Created by Sam on 5/1/16.
 */
public class AirlinesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private AirlineRecyclerAdapter mAdapter;
    private AirlineInfoService mAirlineInfoService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_airlines, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.airlineRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mAirlineInfoService = new AirlineInfoService();
        //mRecyclerView.setAdapter(new AirlineRecyclerAdapter(view.getContext(),null));
        getAirlineInfo();
    }

    private void getAirlineInfo(){

        try {
            mAirlineInfoService.getFlightInfo(new Callback<List<AirlineInfo>>() {
                @Override
                public void onResponse(Response<List<AirlineInfo>> response) {

                    //Log.e("###########",response.errorBody().toString());
                    List<AirlineInfo> airlineInfo = response.body();
                    mAdapter = new AirlineRecyclerAdapter(getActivity(),airlineInfo);
                    mRecyclerView.setAdapter(mAdapter);
                    Toast.makeText(getActivity(),"Success" , Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Throwable t) {

                    Toast.makeText(getActivity(),"Failure" , Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
