package com.example.myfirstapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapplication.R;

public class NotificationsFragment extends Fragment {

    RecyclerView recyclerView;
    String[] strings = {"Stuttgart", "Esslingen", "Ludwigsburg", "Freiburg", "Rom", "New York", "Bremen", "Malterdigen", "Monaco", "Sindelfingen"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAdapter(strings));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        return recyclerView;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private String[] dataSource;

        public MyAdapter(String[] dataArgs) {
            dataSource = dataArgs;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(dataSource[position]);
        }

        @Override
        public int getItemCount() {
            return dataSource.length;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
            textView.setOnClickListener(v -> {
                        int itemPosition = getAdapterPosition();
                        System.out.println(itemPosition);
                        NavController navController = Navigation.findNavController(textView);
                        navController.navigate(R.id.action_navigation_notifications_to_weatherFragment);
                    }
            );
        }
    }

}