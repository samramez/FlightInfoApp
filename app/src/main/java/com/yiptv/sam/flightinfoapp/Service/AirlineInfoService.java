package com.yiptv.sam.flightinfoapp.Service;


import com.yiptv.sam.flightinfoapp.Api.FlightApi;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Sam on 5/1/16.
 */
public class AirlineInfoService {

    private FlightApi flightApi;

    private static final String BASE_URL = "http://www.kayak.com/h/mobileapis/directory";


    public AirlineInfoService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flightApi = retrofit.create(FlightApi.class);

    }

    public void getFlightInfo(Callback callback){
        flightApi.getAirlineInfo().enqueue(callback);
    }


}
