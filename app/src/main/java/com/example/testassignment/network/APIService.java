package com.example.testassignment.network;

import com.example.testassignment.response.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/intern_test")
    Call<ApiResponse> fetchResponse();
}
