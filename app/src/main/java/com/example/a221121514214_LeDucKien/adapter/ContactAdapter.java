package com.example.a221121514214_LeDucKien.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.model.ContactModel;
import com.example.a221121514214_LeDucKien.network.IOnChildItemClick;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContactModel> listContact;
    private IOnChildItemClick iOnChildItemClick;

    public ContactAdapter(Context mContext, List<ContactModel> listContact){
        this.mContext = mContext;
        this.listContact = listContact;
    }

    public void registerChildItemClick(IOnChildItemClick iOnChildItemClick){
        this.iOnChildItemClick = iOnChildItemClick;
    }

    public void unRegisterChildItemClick(){
        this.iOnChildItemClick = null;
    }


    @Override
    public int getCount() {
        return listContact.size();
    }


    @Override
    public ContactModel  getItem(int position){
        return listContact.get(position);
    }


    @Override
    public long getItemId(int position){
        return 0;
    }


    @Override
    public View getView(final int position, View converView, ViewGroup viewGroup){

        View rowView = converView;


        if (rowView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_contact, null);
            // configure view holder
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) rowView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) rowView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) rowView.findViewById(R.id.ivAvatar);
            holder.btCall = (ImageView) rowView.findViewById(R.id.btCall);
            holder.btEdit = (ImageView) rowView.findViewById(R.id.btEdit);
            rowView.setTag(holder);

        }


        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.tvName.setText(listContact.get(position).getName());
        holder.tvPhone.setText(listContact.get(position).getPhone());
        holder.ivAvatar.setImageResource(listContact.get(position).getImage());

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(position);
            }
        });

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnChildItemClick.onItemChildClick(position);
            }
        });

        return rowView;
    }

    private void onCall(int position){
        ContactModel contact = listContact.get(position);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact.getPhone()));
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        mContext.startActivity(intent);
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        ImageView btCall;
        ImageView btEdit;
    }
}


