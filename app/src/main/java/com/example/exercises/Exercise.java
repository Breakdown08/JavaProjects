package com.example.exercises;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class Exercise {
    String title;
    String argumentsHint;
    Boolean hasArguments;
    public void RunTask() throws IOException { }
    public void Init() { }
    public void Run()
    {
        MainActivity.Instance.argumentsSplitRegex = MainActivity.Instance.argumentsSplitRegexDefault;
        Init();
        MainActivity.Instance.textView.setText("");
        if (hasArguments)
        {
            MainActivity.Instance.ActivateUserInput(argumentsHint);
        }
        else
        {
            try {
                RunTask();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
