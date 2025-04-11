package com.example.a221121514214_LeDucKien.ui.day2activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Day2ActivityViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private final MutableLiveData<String> mText;

    public Day2ActivityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Day2_Activity fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}