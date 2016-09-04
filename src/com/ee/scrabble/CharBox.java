package com.ee.scrabble;

import java.util.Random;

/**
 * Created by user-2 on 4/9/16.
 */

public class CharBox {
    private char[][] charsInWordChart;

    public CharBox() {
        populateWordChart();
    }

    private void populateWordChart() {
        this.charsInWordChart = new char[50][50];
        addCharactersToWordChartRandomly();
    }

    private void addCharactersToWordChartRandomly() {
        Random randomObject = new Random();
        for (int rowIterator = 0; rowIterator < this.charsInWordChart.length; rowIterator++) {
            for (int columnIterator = 0; columnIterator < this.charsInWordChart[rowIterator].length; columnIterator++) {
                this.charsInWordChart[rowIterator][columnIterator] = (char) (randomObject.nextInt(26) + 'a');
            }
        }
    }

    public char[] requestStreamOfCharacters(int numberOfCharacters) {
        Random randomObject = new Random();
        char[] resultantCharArray = new char[numberOfCharacters];
        int flag = 0;
        while (flag < numberOfCharacters) {
            int randomRowNumber = randomObject.nextInt(50);
            int randomColumnNumber = randomObject.nextInt(50);
            if (isCharacterAtThisPositionAvailable(randomRowNumber, randomColumnNumber)) {
                resultantCharArray[flag] = this.charsInWordChart[randomRowNumber][randomColumnNumber];
                makePlaceVacant(randomRowNumber, randomColumnNumber);
                flag++;
            }
        }
        return resultantCharArray;
    }

    private void makePlaceVacant(int rowNumber, int columnNumber) {
        this.charsInWordChart[rowNumber][columnNumber] = '\u0000';
    }

    private boolean isCharacterAtThisPositionAvailable(int rowNumber, int columnNumber) {
        if (this.charsInWordChart[rowNumber][columnNumber] != '\u0000') {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String stringToReturn = "";
        for (int rowIterator=0;rowIterator<this.charsInWordChart.length;rowIterator++){
            for (int colIterator =0;colIterator<this.charsInWordChart[rowIterator].length;colIterator++ ){
                stringToReturn += this.charsInWordChart[rowIterator][colIterator]+" ";
            }
            stringToReturn+="\n";
        }
        return stringToReturn;
    }
}
