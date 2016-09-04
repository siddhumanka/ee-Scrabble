package com.ee.scrabble;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by user-2 on 4/9/16.
 */

public class CharBox {
    private final int MAX_CHARS_IN_BOX = 50;
    private List<Character> boxOfchars;

    public CharBox() {
        populateWordChart();
    }

    private void populateWordChart() {
        this.boxOfchars = new LinkedList<>();
        addCharactersToWordChartRandomly();
    }

    private void addCharactersToWordChartRandomly() {
        Random randomObject = new Random();
        for (int boxIterator = 0; boxIterator < MAX_CHARS_IN_BOX; boxIterator++) {
                this.boxOfchars.add((char)(randomObject.nextInt(26) + 'a'));
        }
    }

    public char[] requestStreamOfCharacters(int numberOfCharacters) {
        if(numberOfCharacters>MAX_CHARS_IN_BOX){
            throw new IllegalArgumentException(" Not that many charcters in the box");
        }
        if(this.boxOfchars.size()<numberOfCharacters){
            throw new IllegalArgumentException("Not that many characters left please request for characters less than"+this.boxOfchars.size());
        }
        Random randomObject = new Random();
        char[] resultantCharArray = new char[numberOfCharacters];
        int flag = 0;
        while (flag < numberOfCharacters) {
            int randomNumber = randomObject.nextInt(this.boxOfchars.size()-1);
                resultantCharArray[flag] = this.boxOfchars.get(randomNumber);
                removeCharacterFromBox(randomNumber);
                flag++;
            }
        return resultantCharArray;
    }

    private void removeCharacterFromBox(int indexOfcharacter) {
        this.boxOfchars.remove(indexOfcharacter);
    }

    @Override
    public String toString() {
        return (this.boxOfchars).toString();
    }
}
