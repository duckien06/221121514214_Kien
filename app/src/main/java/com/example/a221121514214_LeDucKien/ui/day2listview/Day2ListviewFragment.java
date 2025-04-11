package com.example.a221121514214_LeDucKien.ui.day2listview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.adapter.ContactAdapter_1;
import com.example.a221121514214_LeDucKien.model.ContactModel_Advenced;

import java.util.ArrayList;
import java.util.List;

public class Day2ListviewFragment extends Fragment {

    private Day2ListviewViewModel mViewModel;
    private ListView lvContact;
    private List<ContactModel_Advenced> listContacts = new ArrayList<>();


    public static Day2ListviewFragment newInstance() {
        return new Day2ListviewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day2_listview, container, false);

        // Gọi đúng hàm init
        initData();

        // Ánh xạ ListView từ layout
        lvContact = view.findViewById(R.id.lvContact);

        // Truyền getActivity() thay vì Fragment cho adapter
        ContactAdapter_1 adapter = new ContactAdapter_1(getActivity(), listContacts);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemView, int position, long id) {
                ContactModel_Advenced contactModel1 = listContacts.get(position);
                Toast.makeText(getActivity(), contactModel1.getName1(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
    private void initData(){
        listContacts.add(new ContactModel_Advenced("Đức Kiên", "0515485525", R.drawable.hinh_0));
        listContacts.add(new ContactModel_Advenced("Quốc Doanh", "052522519", R.drawable.hinh_1));
        listContacts.add(new ContactModel_Advenced("Văn Cường", "0252288588", R.drawable.hinh_2));
        listContacts.add(new ContactModel_Advenced("Quỳnh Châu", "085858586", R.drawable.hinh_3));
        listContacts.add(new ContactModel_Advenced("Thái Bảo", "0255252858", R.drawable.hinh_4));
        listContacts.add(new ContactModel_Advenced("Thanh Mỹ", "02525252858", R.drawable.hinh_5));
        listContacts.add(new ContactModel_Advenced("Hoàng Sang", "0825252522858", R.drawable.hinh_6));
        listContacts.add(new ContactModel_Advenced("Khánh Duy", "0525252585", R.drawable.hinh_7));
    }


}