package com.example.monitor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.util.Log;

import com.example.monitor.databinding.ActivityMainBinding;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));
        EqAdapter adapter = new EqAdapter();
        binding.eqRecycler.setAdapter(adapter);

        viewModel.getEqList().observe(this, eqList->{

            adapter.submitList(eqList);

        });

        viewModel.getEarthquakes();

    }
}

