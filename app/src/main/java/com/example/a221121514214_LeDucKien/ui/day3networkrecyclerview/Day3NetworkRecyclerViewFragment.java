package com.example.a221121514214_LeDucKien.ui.day3networkrecyclerview;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.adapter.NewsAdapter;
import com.example.a221121514214_LeDucKien.model.Item;
import com.example.a221121514214_LeDucKien.network.APIManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Day3NetworkRecyclerViewFragment extends Fragment {

    private Day3NetworkRecyclerViewViewModel mViewModel;
    RecyclerView rvListNews;
    List<Item> listData;
    NewsAdapter adapter;
    public static Day3NetworkRecyclerViewFragment newInstance() {
        return new Day3NetworkRecyclerViewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day3_network_recycler_view, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        rvListNews = view.findViewById(R.id.rvListNews);
        rvListNews.setLayoutManager(layoutManager);

        getListData();

        return view;
    }

    private void getListData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIManager service = retrofit.create(APIManager.class);
        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listData = response.body();
                    adapter = new NewsAdapter(getActivity(), listData);
                    rvListNews.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Lỗi API!", Toast.LENGTH_SHORT).show();
                }

                Log.e("API_RESPONSE", "Kết nối API: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(getActivity(), "Lỗi kết nối API", Toast.LENGTH_SHORT).show();
            }

        });
    }


}