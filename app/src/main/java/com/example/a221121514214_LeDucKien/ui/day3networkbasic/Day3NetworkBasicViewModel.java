package com.example.a221121514214_LeDucKien.ui.day3networkbasic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Day3NetworkBasicViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public Day3NetworkBasicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Day3_Network_Basic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}