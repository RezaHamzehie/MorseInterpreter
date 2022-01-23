package hamza;

/**
 * works as a bridge in the program between Morse code and english letters
 */
public class Letter {
    //all fields
    private String morse;
    private char letter;

    /**
     * constructor for the class
     * @param morse the morse code
     * @param letter the english letter
     */
    public Letter(String morse, char letter) {
        this.morse = morse;
        this.letter = letter;
    }

    /**
     * gives back the English letter for an incoming code
     * @return an English letter
     */
    public char getEnglishLetter() {
        return letter;
    }

    /**
     * givens back a Morse code
     * @return a morse code
     */
    public String getMorse() {
        return morse;
    }
}
