package com.ee.scrabble;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author : Sid
 * @version : 0.1
 * Created by user-2 on 4/9/16.
 */
public class Scrabble {
    private final int MAX_CHARS_IN_BOX = 50;
    private List<Character> requestedListOfCharacters;
    private List<Character> boxOfChars;

    private  Scrabble(){
        populateWordChart();
    }

    /**
     * @param numberOfCharacters : the number of characters asked by the player
     * @return : the instance of the game
     */

    public static Scrabble getInstance(int numberOfCharacters) {
        Scrabble instance = ScrabbleHelper.instance;
        instance.setRequestedListOfCharacters(numberOfCharacters);
        return instance;
    }

    /**
     * @return : List of requested number of charcters from the box
     */

    public List getMyListOfCharacters() {
        return requestedListOfCharacters;
    }

    /**
     *
     * @param numOfCharacters : Number of characters
     *
     */
    private void setRequestedListOfCharacters(int numOfCharacters) {
        this.requestedListOfCharacters = requestListOfCharacters(numOfCharacters);
    }


    private void populateWordChart() {
        this.boxOfChars = new LinkedList<>();
        addCharactersToBoxOfCharactersRandomly();
    }

    private void addCharactersToBoxOfCharactersRandomly() {
        Random randomObject = new Random();
        for (int boxIterator = 0; boxIterator < MAX_CHARS_IN_BOX; boxIterator++) {
            this.boxOfChars.add((char) (randomObject.nextInt(26) + 'a'));
        }
    }
    private List<Character> requestListOfCharacters(int numberOfCharacters) {
        if (numberOfCharacters > MAX_CHARS_IN_BOX) {
            throw new IllegalArgumentException(" Not that many charcters in the box");
        }
        if (numberOfCharacters > this.boxOfChars.size()) {
            throw new IllegalArgumentException("Not that many characters left please request for characters less than" + this.boxOfChars.size());
        }
        Random randomObject = new Random();
        List<Character> resultantList = new LinkedList<>();
        int index = 0;
        while (numberOfCharacters > index) {
            int randomNumber = randomObject.nextInt(this.boxOfChars.size() - 1);
            resultantList.add(this.boxOfChars.get(randomNumber));
            removeCharacterFromBox(randomNumber);
            index++;
        }
        return resultantList;
    }

    private void removeCharacterFromBox(int indexOfcharacter) {
        this.boxOfChars.remove(indexOfcharacter);
    }

    @Override
    public String toString() {
        return (this.boxOfChars).toString();
    }

    private static class ScrabbleHelper {
        private final static Scrabble instance = new Scrabble();

    }
}