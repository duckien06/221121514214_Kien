package com.example.a221121514214_LeDucKien.ui.day2listview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Day2ListviewViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public Day2ListviewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Day2_ListView fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}