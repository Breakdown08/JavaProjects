package com.example.exercises;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Ex3_1 extends Exercise
{
    Button button;
    Ex3_1()
    {
        title = "Третье задание 1 часть";
        hasArguments = true;
        argumentsHint = "Введите centerX,centerY,pointX,pointY через запятую";
    }

    public static class Circle {
        private final double PI = 3.14;

        private final double centerX;
        private final double centerY;
        private double pointX;
        private double pointY;

        private double radius;
        private double length;
        private double area;

        public Circle(double centerX, double centerY, double pointX, double pointY) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.pointX = pointX;
            this.pointY = pointY;
            setFields();
        }

        public void resize(double newPointX, double newPointY) {
            this.pointX = newPointX;
            this.pointY = newPointY;
            setFields();
        }

        @Override
        public String toString() {
            return "Circle {" +
                    "centerX=" + centerX +
                    ", centerY=" + centerY +
                    ", pointX=" + pointX +
                    ", pointY=" + pointY +
                    ", radius=" + radius +
                    ", length=" + length +
                    ", area=" + area +
                    '}';
        }

        private void calculateRadius() {
            radius = Math.sqrt(Math.pow((centerX - pointX), 2) + Math.pow((centerY - pointY), 2));
        }

        private void calculateArea() {
            length = 2 * PI * radius;
        }

        private void calculateLength() {
            area = PI * Math.pow(radius, 2);
        }

        private void setFields() {
            calculateRadius();
            calculateLength();
            calculateArea();
        }
    }

    @Override
    public void RunTask()
    {
        float centerX = Float.parseFloat(MainActivity.Instance.inputArguments[0]);
        float centerY = Float.parseFloat(MainActivity.Instance.inputArguments[1]);
        float pointX = Float.parseFloat(MainActivity.Instance.inputArguments[2]);
        float pointY = Float.parseFloat(MainActivity.Instance.inputArguments[3]);

        Circle circle = new Circle(centerX, centerY, pointX, pointY);
        MainActivity.Instance.PrintText(circle.toString());
        circle.resize(7, 5);
        MainActivity.Instance.PrintText(circle.toString());
    }
}

