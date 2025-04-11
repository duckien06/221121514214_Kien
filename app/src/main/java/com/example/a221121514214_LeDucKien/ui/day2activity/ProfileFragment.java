package com.example.a221121514214_LeDucKien.ui.day2activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a221121514214_LeDucKien.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename and change types of parameters
    private TextView tvUser;
    private Button btEdit;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        tvUser = rootView.findViewById(R.id.tvUserName);
        btEdit = rootView.findViewById(R.id.btEdit);

        if (getArguments() != null) {
            String userName = getArguments().getString("USER_NAME");
            tvUser.setText(userName);
        }
        btEdit.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btEdit) {
            onEdit();
        }
    }

    private void onEdit() {
        EditUserFragment editUserFragment = new EditUserFragment();
        Bundle args = new Bundle();
        args.putString("USER_NAME", tvUser.getText().toString());
        editUserFragment.setArguments(args);

        NavController navController = NavHostFragment.findNavController(this);

        if (navController.getCurrentDestination() != null) {
            navController.navigate(R.id.action_profileFragment_to_editUserFragment, args);
        } else {
            Toast.makeText(getContext(), "Navigation destination not found", Toast.LENGTH_SHORT).show();
        }
    }
}