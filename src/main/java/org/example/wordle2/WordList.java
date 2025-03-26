package org.example.wordle2;

import java.util.List;
import java.util.Random;


public class WordList {
    private static final List<String> WORDS = List.of("apple", "grape", "table", "chair",
            "world", "brick", "light", "spice", "dream", "flame");

    public static String getRandom() {

        Random random = new Random();
        return WORDS.get(random.nextInt(WORDS.size()));
    }
}
