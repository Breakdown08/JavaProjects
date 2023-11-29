package com.example.exercises;

import android.widget.Button;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex4_2 extends Exercise
{
    Button button;
    Ex4_2()
    {
        title = "Четвертое задание 2 часть";
        hasArguments = true;
        argumentsHint = "Введите произвольный текст";
    }

    @Override
    public void Init()
    {
        MainActivity.Instance.argumentsSplitRegex = " ";
    }

    @Override
    public void RunTask()
    {
        String string = MainActivity.Instance.textInputEditText.getText().toString();
        String[] sArray1 = MainActivity.Instance.inputArguments;
        MainActivity.Instance.PrintText("Количество слов в тексте: " + sArray1.length);

        int lengthInShortestWord = Stream.of(sArray1)
                .max((x, y) -> y.length() - x.length())
                .get()
                .length();

        MainActivity.Instance.PrintText("Количество символов в самом коротком слове: " + lengthInShortestWord);

        List<String> lastCapitalize = Stream.of(sArray1)
                .map(x -> x.charAt(x.length() - 1))
                .map(Object::toString)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();

        int counter = 0;

        for (int i = 0; i < string.length(); i++) {
            try {
                Optional<Character> nextCharacter = Optional.of(string.charAt(i + 1));
                if (Character.toString(nextCharacter.get()).equals(" ")) {
                    result.append(lastCapitalize.get(counter));
                    counter++;
                } else {
                    result.append(string.charAt(i));
                }
            } catch (StringIndexOutOfBoundsException exception) {
                result.append(lastCapitalize.get(counter));
                break;
            }
        }

        MainActivity.Instance.PrintText("Текст с заменой последней буквы в каждом слове на заглавную: " + result);
    }
}

