package com.example.exercises;

import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.exercises.MainActivity;

import java.util.Arrays;
import java.util.Optional;

public class Ex1 extends Exercise
{
    Ex1()
    {
        title = "Первое задание";
        hasArguments = true;
        argumentsHint = "Введите целое число";
    }

    @Override
    public void RunTask()
    {
        Integer number = Integer.parseInt(MainActivity.Instance.inputArguments[0]);
        Optional<Integer> sumOfNumeralsAliquotThree;
        boolean containsEven;
        if (number.toString().length() < 4)
        {
            throw new IllegalArgumentException("Введённое число содержит меньше 4 знаков");
        }
        else if (number < 1)
        {
            throw new IllegalArgumentException("Введённое число не натуральное");
        }
        else
        {
            sumOfNumeralsAliquotThree = Arrays
                    .stream(number.toString().split(""))
                    .map(Integer::parseInt)
                    .filter(x -> x % 3 == 0)
                    .reduce(Integer::sum);
            containsEven = Arrays
                    .stream(number.toString().split(""))
                    .map(Integer::parseInt)
                    .anyMatch(x -> x % 2 == 0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            {
                if (sumOfNumeralsAliquotThree.isEmpty() || sumOfNumeralsAliquotThree.get() == 0)
                {
                    MainActivity.Instance.PrintText("Нет цифр в составе числа делящихся на 3");
                }
                else
                {
                    MainActivity.Instance.PrintText(sumOfNumeralsAliquotThree.get().toString());
                }
            }
            if (containsEven)
            {
                MainActivity.Instance.PrintText("Число содержит четные цифры");
            }
            else
            {
                MainActivity.Instance.PrintText("Число не содержит четные цифры");
            }
        }
    }
}