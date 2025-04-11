package com.example.a221121514214_LeDucKien.ui.day3networkrecyclerview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Day3NetworkRecyclerViewViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<String> mText;

    public Day3NetworkRecyclerViewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Day3_Network_RecyclerView fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}