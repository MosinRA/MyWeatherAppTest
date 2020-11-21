package com.mosin.myweatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mosin.myweatherapp.modelDB.Cities;

import java.util.List;

public class CityRecyclerAdapter extends RecyclerView.Adapter<CityRecyclerAdapter.ViewHolder> {

    private Context context;
    private EducationSource dataSource;

    public CityRecyclerAdapter(EducationSource dataSource, Context context){
        this.dataSource = dataSource;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Заполняем данными записи на экране
        List<Cities> cities = dataSource.getCities();
        Cities city = cities.get(position);
        holder.cityName.setText(city.cityName);
        holder.cityTemp.setText(city.cityTemp);
    }

    @Override
    public int getItemCount() {
        return (int) dataSource.getCountCities();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cityName;
        private TextView cityTemp;
        private View cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            cityName = cardView.findViewById(R.id.textCityName);
            cityTemp = cardView.findViewById(R.id.textCityTemp);
        }
    }
}



