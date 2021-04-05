package org.example;

import org.example.services.GameService;
import org.example.services.GameServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
        GameService gService = new GameServiceImpl();
        gService.hangman();
    }
}
