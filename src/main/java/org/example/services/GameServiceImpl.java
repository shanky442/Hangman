package org.example.services;

import org.example.models.HangmanModel;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameServiceImpl implements GameService {

    private static boolean verifyWordContents(String sourceWord, String guessedChar) {
        if (sourceWord.contains(guessedChar)) {
            return true;
        }
        return false;
    }

    private static String maskWord(String sourceWord, String unmaskedWord) {
        int length = sourceWord.length();
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < length; i++) {
            masked = masked.append("*");
        }
        return masked.toString();
    }

    @Override
    public void hangman() {

        HangmanModel model = new HangmanModel();
        String sourceWord = selectRandomWord(model);
        int noOfAttempts = model.getAttempts();
        String unmaskedWord = "";
        String maskedWord = maskWord(sourceWord, unmaskedWord);
        Scanner scan = new Scanner(System.in);
        String partialUnmasked = "";
        for (int attempt = 0; attempt < noOfAttempts; attempt++) {
            System.out.println("Guess a character from the word..attempt no. " + (attempt + 1));
            String guessedChar = scan.next();
            boolean searchResult = verifyWordContents(sourceWord, guessedChar);
            if (searchResult) {
                partialUnmasked = unmaskSelectedChar(partialUnmasked, sourceWord, guessedChar);
            } else {
                if (partialUnmasked.equals("")) {
                    partialUnmasked = maskedWord;
                }
            }
            System.out.println(partialUnmasked);
        }
        if(partialUnmasked.equalsIgnoreCase(sourceWord)){
            System.out.println("Congrats!! you have guessed the word!!!!");
        } else {
            System.out.println("Sorry!! Better luck next time");
        }
    }

    public String unmaskSelectedChar(String partialUnmasked, String sourceWord, String guessedChar) {
        char[] sourceWordArray = sourceWord.toCharArray();
        String resultantString = "";

        for (char c : sourceWordArray) {
            if (guessedChar.charAt(0) == c) {
                resultantString += c;
            } else {
                resultantString += '*';
            }
        }
        if (partialUnmasked != "" && !partialUnmasked.equals(resultantString)) {
            resultantString = calculateResultant(partialUnmasked, resultantString);
        }
        return resultantString;
    }

    private String calculateResultant(String partialUnmasked, String resultantString) {
        char[] partialUnmaskedArray = partialUnmasked.toCharArray();
        char[] resultantStringArray = resultantString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partialUnmasked.length(); i++) {
            if (partialUnmaskedArray[i] != '*') {
                sb.append(partialUnmaskedArray[i]);
            } else {
                sb.append(resultantStringArray[i]);
            }
        }
        return sb.toString();
    }

    public String selectRandomWord(HangmanModel hangmanModel) {
        List<String> listOfWords = hangmanModel.getListOfWords();
        Random randomInt = new Random();
        int i = randomInt.nextInt(listOfWords.size());
        System.out.println(listOfWords.get(i));
        return listOfWords.get(i);
    }
}
