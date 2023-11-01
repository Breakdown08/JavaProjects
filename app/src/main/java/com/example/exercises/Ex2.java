package com.example.exercises;

public class Ex2 extends Exercise
{
    Ex2()
    {
        title = "Второе задание";
        hasArguments = true;
        argumentsHint = "Введите два целых числа start и end через запятую";
    }

    @Override
    public void RunTask()
    {
        Integer start = Integer.parseInt(MainActivity.Instance.inputArguments[0]);
        Integer end = Integer.parseInt(MainActivity.Instance.inputArguments[1]);
        int first;
        int second;
        int third;
        boolean hasNumbers = false;
        for (Integer i = start; i <= end; i++)
        {
            if (i / 100 >= 1 && i / 100 <= 9)
            {
                first = i / 100;
                second = i / 10 % 10;
                third = i % 10;
                if (first + second + third == 9 && i % 5 == 0)
                {
                    hasNumbers = true;
                    MainActivity.Instance.PrintText(i.toString() + " ");
                }
            }
        }
        if (!hasNumbers)
        {
            MainActivity.Instance.PrintText("Нет трёхзначных чисел сумма цифр которых равна 9 и делится на 5");
        }
    }
}
