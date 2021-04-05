package org.example.models;

import java.util.Arrays;
import java.util.List;

public class HangmanModel {
    private final List<String> listOfWords = Arrays.asList("test","world","hello","cricket","java");
    private final int attempts = 3;

    public List<String> getListOfWords() {
        return listOfWords;
    }

    public int getAttempts() {
        return attempts;
    }
}
