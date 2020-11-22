package com.mosin.myweatherapp;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mosin.myweatherapp.dao.EducationDao;
import com.mosin.myweatherapp.modelDB.Cities;

import java.util.LinkedList;

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
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                long id = recyclerView.getChildAdapterPosition(view);
//                cityChoice = educationSource.getCityById(id);
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
