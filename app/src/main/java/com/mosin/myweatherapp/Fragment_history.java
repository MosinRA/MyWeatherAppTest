package com.mosin.myweatherapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mosin.myweatherapp.dao.EducationDao;
import com.mosin.myweatherapp.modelDB.Cities;

import java.util.List;

public class Fragment_history extends Fragment {
    private CityRecyclerAdapter adapter;
    private EducationSource educationSource;
    String cityChoice;
    SharedPreferences sharedPreferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        initRecyclerView(view);
    }

    public void initRecyclerView(View view) {

        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        EducationDao educationDao = App
                .getInstance()
                .getEducationDao();
        educationSource = new EducationSource(educationDao);
        adapter = new CityRecyclerAdapter(educationSource, getActivity());
        recyclerView.setAdapter(adapter);
        //рабочий кликер, разбираюсь как подтянуть текст с конпки
        adapter.SetOnItemClickListener(new CityRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                position = recyclerView.getChildAdapterPosition(view);
                List<Cities> cities = educationSource.getCities();
                cityChoice = cities.get(position).cityName.toUpperCase();
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("cityName", cityChoice);
                editor.apply();
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new Fragment_main())
                        .commit();
            }
        });

    }
}
