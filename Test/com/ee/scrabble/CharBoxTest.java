package com.ee.scrabble;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user-2 on 4/9/16.
 */
public class CharBoxTest {

    CharBox charBox = null;
    @Before
    public void setUp() throws Exception {
        charBox = new CharBox();
    }

    @Test
    public void itShouldPrintNumberOfRandomCharactersRequested() throws Exception {
        System.out.println(charBox);
        char[] resultCharacters =charBox.requestStreamOfCharacters(9);
        System.out.println(new String(resultCharacters));
        System.out.println(charBox);
    }

    @Test
    public void itShouldPrintAllTheCharactersInsideTheBox() throws Exception {
        System.out.println(charBox);
    }


}