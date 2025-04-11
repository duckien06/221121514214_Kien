package com.example.a221121514214_LeDucKien.ui.day3networkweather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Day3NetworkWeatherViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public Day3NetworkWeatherViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Day3_Network_Weather fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}