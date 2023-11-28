package com.example.exercises;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exercises.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static MainActivity Instance;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Spinner spinner;
    Button runButton;
    Button applyInputButton;
    TextInputEditText textInputEditText;
    TextView textView;
    ArrayAdapter<String> adapter;
    List<String> spinnerItemsList;
    ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    Map<String, Exercise> map = new HashMap<>();
    String[] inputArguments;
    String argumentsSplitRegexDefault = ",";
    String argumentsSplitRegex = argumentsSplitRegexDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Instance = this;
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        spinner = (Spinner) findViewById(R.id.spinner);
        textInputEditText = (TextInputEditText) findViewById(R.id.inputText);
        textView = (TextView) findViewById(R.id.textView);
        spinnerItemsList = new ArrayList<String>();
        runButton = (Button) findViewById(R.id.runButton);
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                map.get(spinner.getSelectedItem().toString()).Run();
            }
        });
        applyInputButton = (Button) findViewById(R.id.applyInputButton);
        applyInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                inputArguments = textInputEditText.getText().toString().split(argumentsSplitRegex);
                try {
                    map.get(spinner.getSelectedItem().toString()).RunTask();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                spinner.setVisibility(View.VISIBLE);
                runButton.setVisibility(View.VISIBLE);
                textInputEditText.setVisibility(View.INVISIBLE);
                applyInputButton.setVisibility(View.INVISIBLE);
            }
        });

        SetExercisesList();
        SetSpinnerItems();
        textInputEditText.setVisibility(View.INVISIBLE);
        applyInputButton.setVisibility(View.INVISIBLE);
    }

    private void SetSpinnerItems() {
        for (Exercise exercise : exercises) {
            spinnerItemsList.add(exercise.title);
            map.put(exercise.title, exercise);
        }
        adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, spinnerItemsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void PrintText(String data) {
        textView.append("\n" + data);
    }

    private void SetExercisesList() {
        exercises.add(new Ex1());
        exercises.add(new Ex2());
        exercises.add(new Ex3_1());
        exercises.add(new Ex3_2());
        exercises.add(new Ex4_1());
        //exercises.add(new Ex4_2());
        exercises.add(new Ex4_3());
    }

    public void ActivateUserInput(String hint)
    {
        textInputEditText.setHint(hint);
        spinner.setVisibility(View.INVISIBLE);
        runButton.setVisibility(View.INVISIBLE);
        textInputEditText.setVisibility(View.VISIBLE);
        applyInputButton.setVisibility(View.VISIBLE);
    }
}