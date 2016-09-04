package com.ee.scrabble;

/**
 * Created by user-2 on 4/9/16.
 */
public class Scrabble {
    private static Scrabble instanceOfThisClass ;
    private CharBox charBox = null;


    private  Scrabble(){
       charBox = getAlphabetsForGame();
    }

    private CharBox getAlphabetsForGame() {
        return new CharBox();
    }

    public synchronized static Scrabble getInstance() {
        if(instanceOfThisClass ==null){
            instanceOfThisClass = new Scrabble();
        }
        return instanceOfThisClass;
    }

    public synchronized char[] requestCharactersToFormAWord(int numberOfcharacters){
        return this.charBox.requestStreamOfCharacters(numberOfcharacters);
    }

}
