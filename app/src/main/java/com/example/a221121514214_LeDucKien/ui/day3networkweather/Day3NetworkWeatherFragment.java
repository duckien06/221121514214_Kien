package com.example.a221121514214_LeDucKien.ui.day3networkweather;

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
import android.widget.TextView;

import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.adapter.HourAdapter;
import com.example.a221121514214_LeDucKien.model.Weather;
import com.example.a221121514214_LeDucKien.network.APIManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Day3NetworkWeatherFragment extends Fragment {

    private Day3NetworkWeatherViewModel mViewModel;
    private TextView tvTem, tvStatus;
    private RecyclerView rvHour;

    public static Day3NetworkWeatherFragment newInstance() {
        return new Day3NetworkWeatherFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate layout
        View view = inflater.inflate(R.layout.fragment_day3_network_weather, container, false);

        // Khởi tạo View
        tvTem = view.findViewById(R.id.tvTem);
        tvStatus = view.findViewById(R.id.tvStatus);
        rvHour = view.findViewById(R.id.rvHour);

        // Thiết lập LayoutManager cho RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rvHour.setLayoutManager(layoutManager);

        // Gọi API
        getHours();

        return view;
    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        service.getHour().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Weather> listWeather = response.body();

                    if (!listWeather.isEmpty()) {
                        Log.d("WeatherData", "Received " + listWeather.size() + " items.");

                        // Truyền context cho adapter
                        HourAdapter hourAdapter = new HourAdapter(requireContext(), listWeather);
                        rvHour.setAdapter(hourAdapter);

                        // Gán dữ liệu đầu tiên
                        Weather weather = listWeather.get(0);
                        tvTem.setText(weather.getTemperature().getValue().intValue() + "°C");
                        tvStatus.setText(weather.getIconPhrase());
                    } else {
                        Log.e("API Error", "Weather list is empty");
                    }
                } else {
                    Log.e("API Error", "Failed to fetch weather data: response not successful or null");
                }
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                Log.e("API Failure", "Unable to retrieve data", t);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Day3NetworkWeatherViewModel.class);
        // TODO: Use the ViewModel
    }
}
