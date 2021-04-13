package com.example.myfirstapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myfirstapplication.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_main, container, false);

        Button button = root.findViewById(R.id.button);
        TextView textView = root.findViewById(R.id.textView);
        textView.setText("Lieber Chef, bitte genehmigen Sie den Urlaub!");


        View viewById = root.findViewById(R.id.imageView);

        button.setOnClickListener(v -> {
            textView.setText("Urlaub ist genehmigt");
            viewById.setScaleX(0);
            viewById.animate().scaleX(1.0f).setDuration(2000);

        });

        root.findViewById(R.id.imageView).animate().scaleX(1.0f).setDuration(2000);

        return root;
    }
}