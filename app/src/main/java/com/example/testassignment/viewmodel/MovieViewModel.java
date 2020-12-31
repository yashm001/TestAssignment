package com.example.testassignment.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testassignment.network.APIService;
import com.example.testassignment.network.RetroInstance;
import com.example.testassignment.response.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<ApiResponse> moviesList;

    public MovieViewModel(){
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<ApiResponse> getMoviesListObserver() {
        return moviesList;

    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<ApiResponse> call = apiService.fetchResponse();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                moviesList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                moviesList.postValue(null);
            }
        });
    }
}
