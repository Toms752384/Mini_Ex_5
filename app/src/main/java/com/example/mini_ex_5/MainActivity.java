package com.example.mini_ex_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import com.example.Mini_Ex_5.R;
import com.example.Mini_Ex_5.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 private SampleViewModel viewModel;

 @Override
 protected void onCreate(@Nullable Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);

 viewModel = new ViewModelProvider(this).get(SampleViewModel.class);

 viewModel.getFoo().observe(this, new Observer<String>() {
 @Override
 public void onChanged(@Nullable final String foo) {
 getSupportActionBar().setTitle(foo);
 }
 });

 FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
 btnAdd.setOnClickListener(view -> {
 String currentDateTime = DateFormat.getDateTimeInstance().format(new Date());
 viewModel.getFoo().setValue(currentDateTime);
 });
 }
 }
