package com.example.a221121514214_LeDucKien.ui.day2listviewadvanced;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.adapter.ContactAdapter;
import com.example.a221121514214_LeDucKien.model.ContactModel;
import com.example.a221121514214_LeDucKien.network.IOnChildItemClick;

import java.util.ArrayList;
import java.util.List;

public class Day2ListviewAdvancedFragment extends Fragment implements IOnChildItemClick {

    private Day2ListviewAdvancedViewModel mViewModel;
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private TextView tvName;
    private ImageView ivUser;

    public static Day2ListviewAdvancedFragment newInstance() {
        return new Day2ListviewAdvancedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day2_listview_advanced, container, false);

        initView(view); // Truyền view vào
        initData();

        mAdapter = new ContactAdapter(getContext(), listContact);
        mAdapter.registerChildItemClick(new IOnChildItemClick() {
            @Override
            public void onItemChildClick(int position) {
                ContactModel model = listContact.get(position);
                tvName.setText(model.getName());
                ivUser.setImageResource(model.getImage());
            }
        });

        lvContact.setAdapter(mAdapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel model = listContact.get(position);
                Toast.makeText(getContext(), model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void initView (View view) {
        lvContact = view.findViewById(R.id.lvContact);
        tvName = view.findViewById(R.id.tvName);
        ivUser = view.findViewById(R.id.ivUser);
    }

    private void initData() {
        listContact.add(new ContactModel("Đức Kiên", "0515485525", R.drawable.hinh_0));
        listContact.add(new ContactModel("Quốc Doanh", "052522519", R.drawable.hinh_1));
        listContact.add(new ContactModel("Văn Cường", "0252288588", R.drawable.hinh_2));
        listContact.add(new ContactModel("Quỳnh Châu", "085858586", R.drawable.hinh_3));
        listContact.add(new ContactModel("Thái Bảo", "0255252858", R.drawable.hinh_4));
        listContact.add(new ContactModel("Thanh Mỹ", "02525252858", R.drawable.hinh_5));
        listContact.add(new ContactModel("Hoàng Sang", "0825252522858", R.drawable.hinh_6));
        listContact.add(new ContactModel("Khánh Duy", "0525252585", R.drawable.hinh_7));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel model = listContact.get(position);
        tvName.setText(model.getName());
        ivUser.setImageResource(model.getImage());

    }

}