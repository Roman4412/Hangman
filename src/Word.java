public class Word {
    private final String word;
    private String wordMask;

    public Word(String word) {
        this.word = word;
        this.wordMask = hideLetters(word);
    }

    private String hideLetters(String word) {
        return "_".repeat(word.length());
    }

    public void showLetter(char letter) {
        char[] maskChars = wordMask.toCharArray();
        for (int i = 0; i < this.word.length(); i++) {
            if (letter == word.charAt(i)) {
                maskChars[i] = letter;
            }
        }
        this.wordMask = String.valueOf(maskChars);
    }

    public String getWord() {
        return word;
    }

    public String getMask() {
        return wordMask;
    }
}
