package com.example.exercises;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercise {
    String title;
    String argumentsHint;
    Boolean hasArguments;
    public void RunTask() { }

    public void Run()
    {
        MainActivity.Instance.textView.setText("");
        if (hasArguments)
        {
            MainActivity.Instance.ActivateUserInput(argumentsHint);
        }
        else
        {
            RunTask();
        }
    }
}
