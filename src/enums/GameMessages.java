package enums;

public enum GameMessages {
    START_INFO("Привет!\n"
            + "Я хочу сыграть с тобой в игру.\n"
            + "Я загадаю слово. Тебе всего лишь нужно его отгадать.\n"
            + "Отгадывать можно только по 1 букве\n"
            + "Если допустишь больше 5 ошибок - тебя повесят\n"),
    TRY_AGAIN("Еще каточку?\n"),
    WIN("Ты отгадал слово %s !!!\n"),
    LOSE("Посмотрите-ка, кто это там висит?)))\n"),
    EMPTY_INPUT("Тут же пусто 0_0\n"),
    MANY_LETTERS("Нужно ввести только одну букву!\n"),
    WAS_ENTERED("Ты уже вводил это!!!\n"),
    INVALID_LETTER("Введен неподходящий символ\n"),
    RIGHT_LETTER("Буква угадана верно! %s\n"),
    WRONG_LETTER("Буква угадана неверно!\n" +
            "Ошибок осталось: %d\n"),
    INIT_WORD("Я загадал слово из %d букв \n");

    private final String text;

    GameMessages(String text) {
        this.text = text;
    }
    public static void print(GameMessages message) {
        System.out.println(message.text);
    }

    public static void print(GameMessages message, int value) {
        System.out.printf(message.text, value);
    }

    public static void print(GameMessages message, String value) {
        System.out.printf(message.text, value);
    }
}
