package com.example.exercises;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Ex3 extends Exercise
{
    Button button;
    Ex3()
    {
        title = "Третье задание";
        hasArguments = true;
        argumentsHint = "Введите a и b через запятую";
    }

    @Override
    public void RunTask()
    {
        float a = Float.parseFloat(MainActivity.Instance.inputArguments[0]);
        float b = Float.parseFloat(MainActivity.Instance.inputArguments[1]);
        MainActivity.Instance.PrintText(String.valueOf(a + b));
    }
}
