package com.example.a221121514214_LeDucKien.ui.day1linearlayout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Day1LinearLayoutViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public Day1LinearLayoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Day1_LinearLayout fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
