package com.yiptv.sam.flightinfoapp.Api;

import com.yiptv.sam.flightinfoapp.Model.AirlineInfo;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Sam on 5/1/16.
 */
public interface FlightApi {

    /**
     * The following api calls are based on this link:
     * https://www.kayak.com/h/mobileapis/directory/
     */

    @GET("airlines")
    Call<List<AirlineInfo>> getAirlineInfo();

}


