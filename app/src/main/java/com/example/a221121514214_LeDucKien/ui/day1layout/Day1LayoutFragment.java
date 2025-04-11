package com.example.a221121514214_LeDucKien.ui.day1layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.a221121514214_LeDucKien.databinding.FragmentDay1LayoutBinding;


public class Day1LayoutFragment extends Fragment {

    private FragmentDay1LayoutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Day1LayoutViewModel day1LayoutViewModel =
                new ViewModelProvider(this).get(Day1LayoutViewModel.class);

        binding = FragmentDay1LayoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}