import enums.GallowsStates;
import enums.GameMessages;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Game {
    private static final int FAILS_LIMIT = 5;
    private static final Scanner SCANNER = new Scanner(System.in);
    private final WordSupplier wordSupplier = new WordSupplier();
    private Word word;
    private Set<Character> usedLetters;

    public Game() {

    }
    public void startGame() {
        wordSupplier.initBase();
        GameMessages.print(GameMessages.START_INFO);
        while (true) {
            String input = SCANNER.nextLine().trim().toLowerCase();
            if (!isCorrectAnswer(input)) {
                continue;
            }
            if (!isStartNewRound(input)) {
                return;
            } else {
                startRound();
            }
            GameMessages.print(GameMessages.TRY_AGAIN);
        }
    }

    public void startRound() {
        word = wordSupplier.initWord();
        GameMessages.print(GameMessages.INIT_WORD, word.getMask().length());
        usedLetters = new HashSet<>();
        int fails = 0;
        do {
            String input = SCANNER.nextLine().toLowerCase().trim();
            if (!isCorrectLetter(input)) {
                continue;
            }
            Character letter = input.charAt(0);
            usedLetters.add(letter);
            if (word.getWord().contains(String.valueOf(letter))) {
                word.showLetter(letter);
                GameMessages.print(GameMessages.RIGHT_LETTER, word.getMask());
            } else {
                fails++;
                GameMessages.print(GameMessages.WRONG_LETTER, FAILS_LIMIT-fails);
                GallowsStates.printState(fails);
            }
        }
        while (isRoundContinues(fails));
    }

    private boolean isRoundContinues(int fails) {
        if (!word.getMask().contains("_")) {
            GameMessages.print(GameMessages.WIN, word.getWord().toUpperCase());
            return false;
        } else if (fails >= FAILS_LIMIT) {
            GameMessages.print(GameMessages.LOSE);
            System.out.println(word.getWord());
            return false;
        }
        return true;
    }

    private boolean isStartNewRound(String input) {
        return input.equals("y");
    }

    private boolean isCorrectLetter(String input) {
        if (input.isEmpty()) {
            GameMessages.print(GameMessages.EMPTY_INPUT);
            return false;
        }
        if (input.length() > 1) {
            GameMessages.print(GameMessages.MANY_LETTERS);
            return false;
        }
        if (usedLetters.contains(input.charAt(0))) {
            GameMessages.print(GameMessages.WAS_ENTERED);
            return false;
        }
        return true;
    }

    private boolean isCorrectAnswer(String input) {
        if (input.isBlank()) {
            GameMessages.print(GameMessages.EMPTY_INPUT);
            return false;
        }
        if (input.length() > 1) {
            GameMessages.print(GameMessages.MANY_LETTERS);
            return false;
        }
        if (!(input.equals("y") || input.equals("n"))) {
            GameMessages.print(GameMessages.INVALID_LETTER);
            return false;
        }
        return true;
    }
}
