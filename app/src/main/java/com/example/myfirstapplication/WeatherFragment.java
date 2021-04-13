package com.example.myfirstapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {

    Executor executor = Executors.newSingleThreadExecutor();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_weather, container, false);

        // Inflate the layout for this fragment
        executor.execute(()-> {

            SystemClock.sleep(3000);
            String city = getArguments().getString("city");

            root.post(()->
            {

                TextView textView = root.findViewById(R.id.textView);
                textView.setText(city);

            });

        });






        return root;
    }
}