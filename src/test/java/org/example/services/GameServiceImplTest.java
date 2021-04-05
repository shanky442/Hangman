package org.example.services;

import org.example.models.HangmanModel;
import org.junit.Assert;
import org.junit.Test;

public class GameServiceImplTest {

    GameService gameService = new GameServiceImpl();

    @Test
    public void selectRandomWordTest() {
        HangmanModel model = new HangmanModel();
        String randomWord = gameService.selectRandomWord(model);
        Assert.assertTrue(model.getListOfWords().contains(randomWord));
    }

    @Test
    public void unmaskSelectedCharTest() {
        String result = gameService.unmaskSelectedChar("c**c***", "cricket", "r");
        Assert.assertEquals(result, "cr*c***");
    }
}
