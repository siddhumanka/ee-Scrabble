package com.ee.scrabble;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user-2 on 4/9/16.
 */
public class ScrabbleTest {

    Scrabble scrabbleInstance1  = Scrabble.getInstance();;
    Scrabble scrabbleInstance2 = Scrabble.getInstance();
    Scrabble scrabbleInstance3 = null;
    @Before
    public void setUp(){
    }

    @Test
    public void itShouldRequestWordsForAllThreePlayers(){
        System.out.println("Character for player 1 if 12 characters are requested : ");
        System.out.println(new String(scrabbleInstance1.requestCharactersToFormAWord(12)));
        System.out.println("Character for player 2 if 20 characters are requested : ");
        System.out.println(new String(scrabbleInstance2.requestCharactersToFormAWord(20)));
        System.out.println("Character for player 3 if 10 characters are requested : ");
        scrabbleInstance3 = Scrabble.getInstance();
        System.out.println(new String(scrabbleInstance3.requestCharactersToFormAWord(10)));

    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionIfCharactersInBoxAreNotSufficient(){
        System.out.println("Character for player 1 if 30 characters are requested again: ");
        System.out.println(new String(scrabbleInstance1.requestCharactersToFormAWord(30)));

    }
    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionIfBoxDoesNotHaveThatManyCharacters(){
        System.out.println("Character for player 1 if 90 characters are requested: ");
        System.out.println(new String(scrabbleInstance1.requestCharactersToFormAWord(90)));

    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionIfBoxIsEmpty(){
        System.out.println("Character for player 1 if 90 characters are requested: ");
        System.out.println(new String(scrabbleInstance1.requestCharactersToFormAWord(49)));
        scrabbleInstance2.requestCharactersToFormAWord(1);

    }

}