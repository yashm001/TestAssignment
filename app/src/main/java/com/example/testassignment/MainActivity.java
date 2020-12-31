package com.example.testassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.testassignment.adapter.Type1Adapter;
import com.example.testassignment.adapter.Type2Adapter;
import com.example.testassignment.model.TypeB;
import com.example.testassignment.response.ApiResponse;
import com.example.testassignment.viewmodel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Type1Adapter adapter1, adapter3 , adapter4;
    private Type2Adapter adapter2;
    private MovieViewModel viewModel;

    private NestedScrollView nestedScrollView;
    private ProgressBar progressBar;

    List<TypeB> movies1, movies2, movies3, movies4;

    private RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView3 = findViewById(R.id.recyclerView3);
        recyclerView4 = findViewById(R.id.recyclerView4);

        nestedScrollView = findViewById(R.id.nestedScrollView);
        progressBar = findViewById(R.id.progressBar);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);
        recyclerView4.setLayoutManager(layoutManager4);






        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                for(int i=0 ; i< apiResponse.getResponse().size(); i++) {
                    Log.d("TAG",Integer.toString(i));

                    if(apiResponse.getResponse().get(i).getType().equals("type1")) {
                        if (apiResponse.getResponse().get(i).getTitle().equals("category1")) {
                            movies1 = apiResponse.getResponse().get(i).getItems();
                            Log.d("TAG2",Integer.toString(movies1.size()));

                        } else if(apiResponse.getResponse().get(i).getTitle().equals("category3")){
                            movies3 = apiResponse.getResponse().get(i).getItems();
                            Log.d("TAG21",Integer.toString(movies3.size()));

                        } else {
                            movies4 = apiResponse.getResponse().get(i).getItems();
                        }

                    } else{
                        if(apiResponse.getResponse().get(i).getTitle().equals("category2")){
                            movies2 = apiResponse.getResponse().get(i).getItems();
                        }
                    }

                }



                adapter1 = new Type1Adapter(MainActivity.this,movies1);
                adapter2 = new Type2Adapter(MainActivity.this, movies2);
                adapter4 = new Type1Adapter(MainActivity.this,movies4);
                adapter3 = new Type1Adapter(MainActivity.this,movies3);

                recyclerView1.setAdapter(adapter1);
                recyclerView2.setAdapter(adapter2);
                recyclerView4.setAdapter(adapter4);
                recyclerView3.setAdapter(adapter3);

                progressBar.setVisibility(View.GONE);
                nestedScrollView.setVisibility(View.VISIBLE);


            }
        });
        viewModel.makeApiCall();






    }
}