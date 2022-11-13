package com.example.musadkhan.newsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class HomeFragment extends Fragment {

    LinearLayout buisness,health,entertainment,science,sport,technology;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false);


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buisness = (LinearLayout) getView().findViewById(R.id.buisness);
        health = (LinearLayout) getView().findViewById(R.id.health);
        entertainment = (LinearLayout) getView().findViewById(R.id.entertainment);
        science = (LinearLayout) getView().findViewById(R.id.science);
        sport = (LinearLayout) getView() .findViewById(R.id.sport);
        technology = (LinearLayout) getView().findViewById(R.id.technology);




        buisness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CategoryListActivity.class);
                intent.putExtra("category","business");
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CategoryListActivity.class);
                intent.putExtra("category","health");
                startActivity(intent);
            }
        });

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CategoryListActivity.class);
                intent.putExtra("category","entertainment");
                startActivity(intent);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CategoryListActivity.class);
                intent.putExtra("category","science");
                startActivity(intent);
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CategoryListActivity.class);
                intent.putExtra("category","sports");
                startActivity(intent);
            }
        });

        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CategoryListActivity.class);
                intent.putExtra("category","technology");
                startActivity(intent);
            }
        });


    }





}