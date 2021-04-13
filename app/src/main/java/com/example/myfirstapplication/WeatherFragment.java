package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
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

            //SystemClock.sleep(1000);
            String city = getArguments().getString("city");


            try {
                URLConnection urlConnection = new URL("http://10.0.2.2:8080").openConnection();
                try (InputStream inputStream = urlConnection.getInputStream()) {
                    //String result = IOUtils.toString(inputStream, "UTF-8");

                    Map<String, Object> fromJson = new Gson().fromJson(
                            new InputStreamReader(inputStream, "UTF-8"),
                            new TypeToken<HashMap<String, Object>>() {
                            }.getType()
                    );
                    Object temperature = fromJson.get("temperature");
                    root.post(()->
                    {

                        TextView textView = root.findViewById(R.id.textView);
                        textView.setText(temperature.toString());

                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
                root.post(()->
                {

                    TextView textView = root.findViewById(R.id.textView);
                    textView.setText(e.getClass().getSimpleName() + ": " + e.getMessage());

                });
            }



        });






        return root;
    }
}