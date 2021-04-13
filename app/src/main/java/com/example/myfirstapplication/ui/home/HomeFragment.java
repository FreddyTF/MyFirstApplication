package com.example.myfirstapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myfirstapplication.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //View root = inflater.inflate(R.layout.activity_photo, container, false);
        //return root;
        ConstraintLayout root = (ConstraintLayout) inflater.inflate(R.layout.activity_photo,container,false);

        Button button = root.findViewById(R.id.uploadbutton);


        button.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(root);
            //navController.navigate(R.id.navigation_dashboard);
            navController.navigate(R.id.action_navigation_home_to_navigation_dashboard);

        });

        return root;
    }
}

