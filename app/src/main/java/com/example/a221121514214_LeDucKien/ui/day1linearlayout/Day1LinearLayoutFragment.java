package com.example.a221121514214_LeDucKien.ui.day1linearlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.a221121514214_LeDucKien.databinding.FragmentDay1LinearLayoutBinding;


public class Day1LinearLayoutFragment extends Fragment {

    private FragmentDay1LinearLayoutBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Day1LinearLayoutViewModel day1LayoutViewModel =
                new ViewModelProvider(this).get(Day1LinearLayoutViewModel.class);

        binding = FragmentDay1LinearLayoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}