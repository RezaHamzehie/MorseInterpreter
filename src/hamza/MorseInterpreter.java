package hamza;


import acm.program.ConsoleProgram;

import java.util.ArrayList;

/**
 * File: MorseInterpreter.java
 * ----------------------------
 * interprets the morse code to string and vice versa.
 * coded by: RezaHamzehie
 * github: @RezaHamzehie
 * email: rezahamzehie@gmail.com
 */
public class MorseInterpreter extends ConsoleProgram {
    //all needed fields
    private ArrayList<Letter> letterBoard;
    private String[] morseCodes = {".-", "-...", "-.-.", "-..",
            ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};

    /**
     * the main entry point method into the program
     *
     * @param args passed initial strings
     */
    public static void main(String[] args) {

        //initialization of the class
        new MorseInterpreter().start(args);
    }

    /**
     * the main entry point method for the acm package
     */
    public void run() {

        setUpTheLetterBoard();
        println("This program interprets the Morse codes to letter and vice versa." +
                "\nenter 1 for English to Morse." +
                "\nenter 2 for Morse to English.");

        int choice = readInt("choice : ");

        if (choice == 1) {
            englishToMorse();
        } else if (choice == 2) {
            morseToEnglish();
        }
    }

    /**
     * converts Morse codes to English letters
     */
    private void morseToEnglish() {
        println("Enter the Morse code: " +
                "\none space \" \" to indicate the end of a letter," +
                "\ntwo spaces \"  \" to indicate the end of a word.");
        String morse = readLine("Enter: ");

        char[] morseChars = morse.toCharArray();
        String morseCode = "";
        String englishText = "";

        for (int i = 0; i < morseChars.length; i++) {

            //ending indication
            if (morseChars[i] == ' ') {

                //adding newly created letter
                englishText = englishText.concat(String.valueOf(translateMorseToEnglish(morseCode)));

                //clearing the morse letter
                morseCode = "";

            } else {
                morseCode = morseCode.concat(String.valueOf(morseChars[i]));
            }

            if (i == morseChars.length - 1) {
                //adding newly created letter
                englishText = englishText.concat(String.valueOf(translateMorseToEnglish(morseCode)));

                //clearing the morse letter
                morseCode = "";
            }
        }

        //printing the English text
        println(englishText);
    }

    /**
     * translates the morse codes into english letters
     *
     * @param morseCode the passed morse letter to translate
     * @return the translated english letter
     */
    private char translateMorseToEnglish(String morseCode) {

        for (Letter letter : this.letterBoard) {
            if (letter.getMorse().equals(morseCode)) {
                return letter.getEnglishLetter();
            }
        }
        return ' ';
    }

    /**
     * translate English letters to morse codes.
     */
    private void englishToMorse() {

        String englishText = readLine("Enter the English text: ");
        char[] englishChars = englishText.toCharArray();
        String morseCode = "";

        for (int i = 0; i < englishChars.length; i++) {
            morseCode = morseCode.concat(translateEnglishToMorse(englishChars[i]));
            morseCode = morseCode.concat(" ");
        }
        println("morse code:\n" + morseCode);
    }

    /**
     * translates English letters to morse code.
     *
     * @param englishChar the passed english chars to translate.
     * @return the morse code result
     */
    private String translateEnglishToMorse(char englishChar) {

        for (Letter letter : this.letterBoard) {
            if (letter.getEnglishLetter() == englishChar) {
                return letter.getMorse();
            }
        }
        return "\n";
    }


    /**
     * sets up the letter board
     */
    private void setUpTheLetterBoard() {

        //all locals
        letterBoard = new ArrayList<>();
        int counter = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            Letter letter = new Letter(morseCodes[counter], ch);
            letterBoard.add(letter);
            counter++;
        }
    }


}
