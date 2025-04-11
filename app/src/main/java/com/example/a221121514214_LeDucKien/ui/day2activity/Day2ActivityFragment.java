package com.example.a221121514214_LeDucKien.ui.day2activity;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.databinding.FragmentDay1LinearLayoutBinding;
import com.example.a221121514214_LeDucKien.databinding.FragmentDay2ActivityBinding;

public class Day2ActivityFragment extends Fragment implements View.OnClickListener {

    private FragmentDay2ActivityBinding binding;
    private Day2ActivityViewModel mViewModel;

    public static Day2ActivityFragment newInstance() {
        return new Day2ActivityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentDay2ActivityBinding.inflate(inflater, container, false);


        EditText edUser = binding.edUser;
        EditText edPassword = binding.edPassword;
        Button btLogin = binding.btLogin;

        btLogin.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btLogin) {
            onLogin();
        }
    }

    private void onLogin() {
        EditText edUser = binding.edUser;
        EditText edPassword = binding.edPassword;

        if (edUser.getText().toString().isEmpty() || edPassword.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Bạn chưa nhập user hoặc password", Toast.LENGTH_SHORT).show();
        } else {
            ProfileFragment profileFragment = new ProfileFragment();
            Bundle args = new Bundle();
            args.putString("USER_NAME", edUser.getText().toString());
            profileFragment.setArguments(args);


            NavController navController = NavHostFragment.findNavController(this);


            if (navController.getCurrentDestination() != null) {

                navController.navigate(R.id.action_day2ActivityFragment_to_profileFragment, args);
            } else {
                Toast.makeText(getContext(), "Navigation destination not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}