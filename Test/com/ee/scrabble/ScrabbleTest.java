package com.ee.scrabble;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user-2 on 4/9/16.
 */
public class ScrabbleTest {

    Scrabble player1 = Scrabble.getInstance(10);
    Scrabble player2 = Scrabble.getInstance(13);
    Scrabble player3 = Scrabble.getInstance(23);

    @Before
    public void setUp(){
    }

    @Test
    public void itShouldRequestWordsForAllThreePlayers(){
        System.out.println(player1.getMyListOfCharacters().toString());
        System.out.println(player1.getMyListOfCharacters().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionIfBoxDoesNotHaveThatManyCharacters(){
        player1 = Scrabble.getInstance(95);

    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowAnExceptionIfBoxIsEmpty(){
        System.out.println("If box is Empty ");
        player1 = Scrabble.getInstance(45);
        player1 = Scrabble.getInstance(5);

    }

    @Test
    public void isSingleton() throws Exception {
        assertEquals(System.identityHashCode(player2), System.identityHashCode(player1));
        assertEquals(System.identityHashCode(player3), System.identityHashCode(player1));
    }
}