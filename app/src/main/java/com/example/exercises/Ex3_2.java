package com.example.exercises;

import android.widget.Button;

public class Ex3_2 extends Exercise
{
    Button button;
    Ex3_2()
    {
        title = "Третье задание 2 часть";
        hasArguments = true;
        argumentsHint = "Введите числитель и знаменатель через запятую";
    }

    public static class Fraction {
        private final int numerator;
        private final int denominator;
        private final double fractionInDec;
        private final String stringFraction;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            this.fractionInDec = (double) numerator / (double) denominator;
            this.stringFraction = numerator + "/" + denominator;
        }

        public String getFractionInDec() {
            return  "Дробь в десятичном формате: " + fractionInDec;
        }

        public String getStringFraction() {
            return  "Строковое представление дроби: " + stringFraction;
        }

        public String getPowFraction(double pow) {
            return "Результат возведения дроби в степень " + pow
                    + "\n" + "в десятичном виде: " + Math.pow(fractionInDec, pow)
                    + "\n" + "в дробном виде: " + (int) Math.pow(numerator, pow) + "/" + (int) Math.pow(denominator, pow);
        }


        @Override
        public String toString() {
            return "Fraction {" +
                    "numerator=" + numerator +
                    ", denominator=" + denominator +
                    ", fractionInDec=" + fractionInDec +
                    ", stringFraction='" + stringFraction + '\'' +
                    '}';
        }
    }

    @Override
    public void RunTask()
    {
        int numerator = Integer.parseInt(MainActivity.Instance.inputArguments[0]);
        int denominator = Integer.parseInt(MainActivity.Instance.inputArguments[1]);

        Fraction fraction = new Fraction(numerator, denominator);
        fraction.getFractionInDec();
        fraction.getPowFraction(2);
        MainActivity.Instance.PrintText(fraction.getFractionInDec());
        MainActivity.Instance.PrintText(fraction.getPowFraction(2));
    }
}

