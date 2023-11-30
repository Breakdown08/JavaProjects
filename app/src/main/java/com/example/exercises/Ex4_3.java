package com.example.exercises;

import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex4_3 extends Exercise
{
    /*Button button;
    Ex4_3()
    {
        title = "Четвертое задание 3 часть";
        hasArguments = false;
        argumentsHint = "";
    }

    public String readFromFile(String fileName)
    {
        File path = MainActivity.Instance.getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public void swapFirstLastWords(File file) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        String[] sentences = content.toString().split("\\.\\s*");

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i].trim();
            if (!sentence.isEmpty()) {
                String[] words = sentence.split("\\s+");
                if (words.length >= 2) {
                    String firstWord = words[0];
                    words[0] = words[words.length - 1];
                    words[words.length - 1] = firstWord;

                    sentences[i] = String.join(" ", words);
                }
            }
        }
        String result = String.join(". ", sentences);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath()))) {
            writer.write(result);
        }
        MainActivity.Instance.PrintText("Текст в файле с заменой первого и последнего слов в предложении: \n" + result);
    }

    @Override
    public void RunTask() throws IOException {
        File file = new File("file.txt");
        swapFirstLastWords(file);
    }*/
}

