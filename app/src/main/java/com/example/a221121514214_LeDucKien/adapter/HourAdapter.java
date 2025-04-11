package com.example.a221121514214_LeDucKien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a221121514214_LeDucKien.R;
import com.example.a221121514214_LeDucKien.model.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HourAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Weather> listWeather;

    public HourAdapter(Context context, List<Weather> listWeather) {
        this.context = context;
        this.listWeather = listWeather;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_hour, parent, false);
        HourHolder holder = new HourHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HourHolder vh = (HourHolder) holder;
        Weather weather = listWeather.get(position);
        vh.tvTime.setText(convertTime(weather.getDateTime()));
        vh.tvTem.setText(weather.getTemperature().getValue() + "");

        String url;
        if (weather.getWeatherIcon() < 10) {
            url = "https://developer.accuweather.com/sites/default/files/0" + weather.getWeatherIcon() + "-s.png";
        } else {
            url = "https://developer.accuweather.com/sites/default/files/" + weather.getWeatherIcon() + "-s.png";
        }

        Glide.with(context).load(url).into(vh.icon);
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    public static class HourHolder extends RecyclerView.ViewHolder {
        private TextView tvTime;
        private ImageView icon;
        private TextView tvTem;

        public HourHolder(View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            icon = itemView.findViewById(R.id.icon);
            tvTem = itemView.findViewById(R.id.tvTem);
        }
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat informart = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.ENGLISH);
        Date date = null;
        try {
            date = informart.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            SimpleDateFormat outformat = new SimpleDateFormat("ha", Locale.ENGLISH);
            return outformat.format(date);
        } else {
            return "";
        }
    }

}
