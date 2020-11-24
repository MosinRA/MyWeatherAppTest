package com.mosin.myweatherapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mosin.myweatherapp.modelDB.Cities;

import java.util.Collections;
import java.util.List;

public class CityRecyclerAdapter extends RecyclerView.Adapter<CityRecyclerAdapter.ViewHolder> {

    private Activity activity;
    private EducationSource dataSource;
    private OnItemClickListener itemClickListener;
    private long menuPosition;

    public CityRecyclerAdapter(EducationSource dataSource, Activity activity) {
        this.dataSource = dataSource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Заполняем данными записи на экране
        List<Cities> cities = dataSource.getCities();
        Collections.reverse(cities);
        Cities city = cities.get(position);
        holder.cityName.setText(city.cityName);
        holder.dateText.setText(city.date);
        holder.cityTemp.setText(city.cityTemp);

        // Тут определяем, какой пункт меню был нажат
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(view, getItemCount());
                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (int) dataSource.getCountCities();
    }


    public void SetOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cityName, dateText, cityTemp;
        private View cardView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            cityName = cardView.findViewById(R.id.textCityName);
            dateText = cardView.findViewById(R.id.textDate);
            cityTemp = cardView.findViewById(R.id.textCityTemp);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(view, getAdapterPosition());

                    }
                }
            });
        }
        public TextView getTextView() {
            return cityName;
        }
    }
}



