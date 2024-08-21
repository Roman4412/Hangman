import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class WordSupplier {
    private static final String PATH = "resources\\word_base.txt";
    private List<String> wordsBase;

    public WordSupplier() {
    }

    void initBase() {
        try (Stream<String> lines = Files.lines(Path.of(PATH))) {
            wordsBase = lines.distinct()
                    .filter(a -> a.length() > 4)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    public Word initWord() {
        Random random = new Random();
        return new Word(wordsBase.get(random.nextInt(wordsBase.size())));
    }
}

