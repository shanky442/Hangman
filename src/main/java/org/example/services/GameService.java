package org.example.services;

import org.example.models.HangmanModel;

public interface GameService {

    void hangman();

    String selectRandomWord(HangmanModel hangmanModel);

    String unmaskSelectedChar(String partialUnmasked, String sourceWord, String guessedChar);
}
