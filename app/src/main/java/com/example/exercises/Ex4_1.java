package com.example.exercises;

import android.widget.Button;

import java.util.Comparator;
import java.util.stream.Stream;

public class Ex4_1 extends Exercise
{
    Button button;
    Ex4_1()
    {
        title = "Четвертое задание 1 часть";
        hasArguments = true;
        argumentsHint = "Введите 3 числа через запятую";
    }

    @Override
    public void RunTask()
    {
        String s1 = MainActivity.Instance.inputArguments[0];
        String s2 = MainActivity.Instance.inputArguments[1];
        String s3 = MainActivity.Instance.inputArguments[2];

        String[] sArray1 = s1.split("");
        String[] sArray2 = s2.split("");
        String[] sArray3 = s3.split("");

        int maxS1 = Stream.of(sArray1).map(Integer::parseInt).sorted().max(Comparator.comparingInt(x -> x)).get();
        int maxS2 = Stream.of(sArray2).map(Integer::parseInt).sorted().max(Comparator.comparingInt(x -> x)).get();
        int maxS3 = Stream.of(sArray3).map(Integer::parseInt).sorted().max(Comparator.comparingInt(x -> x)).get();

        MainActivity.Instance.PrintText("Наибольшая цифра в числе " + s1 + ": " + maxS1);
        MainActivity.Instance.PrintText("Наибольшая цифра в числе " + s2 + ": " + maxS2);
        MainActivity.Instance.PrintText("Наибольшая цифра в числе " + s3 + ": " + maxS3);
    }
}

