package com.example.a221121514214_LeDucKien.ui.day1layout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Day1LayoutViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public Day1LayoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Day1_Layout fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
