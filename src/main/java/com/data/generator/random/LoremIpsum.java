package com.data.generator.random;

import com.data.generator.ResourceList;

public class LoremIpsum {
    private static final String WORDS_LIST_FILE = "loremIpsumWords.txt";
    private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet.";
    private static final int MIN_WORDS_IN_SENTENCE = 7;
    private static final int MAX_WORDS_IN_SENTENCE = 15;
    private static final int COMMA_CHANCE = 25;
    private static final int MAX_VALUE = 100;

    private static final ResourceList LOREM_IPSUM_WORDS_LIST = new ResourceList(WORDS_LIST_FILE);

    private final Number number = new Number();

    public String defaultSentence() {
        return LOREM_IPSUM;
    }

    public String createWords(long words) {
        StringBuilder builder = new StringBuilder();
        builder.append(handleLoremIpsumSentence(words));

        long wordsLeft = words - numberOfWordsInDefaultSentence();
        while (wordsLeft > 0) {
            long wordsInSentence = number.randomNumber(MIN_WORDS_IN_SENTENCE, MAX_WORDS_IN_SENTENCE);
            if (wordsInSentence > wordsLeft) {
                wordsInSentence = wordsLeft;
            }

            builder.append(sentenceCreator(wordsInSentence));
            wordsLeft -= wordsInSentence;
        }

        return builder.toString();
    }

    public String createParagraphs(int paragraphs, int minWordsPerParagraph, int maxWordsPerParagraph) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= paragraphs; i++) {
            builder.append(
                    createWords(number.randomNumber(minWordsPerParagraph, maxWordsPerParagraph)));

            if (i != paragraphs) {
                builder.append(System.lineSeparator());
                builder.append(System.lineSeparator());
            }
        }

        return builder.toString();
    }

    private String handleLoremIpsumSentence(long words) {
        if (words >= numberOfWordsInDefaultSentence()) {
            return LOREM_IPSUM;
        }

        StringBuilder builder = new StringBuilder();
        String[] loremIpsumWords = LOREM_IPSUM.split(" ");
        for (int i = 0; i < words; i++) {
            builder.append(loremIpsumWords[i]);
            if (i != words - 1) {
                builder.append(" ");
            }
        }

        builder.append(".");

        return builder.toString();
    }

    private boolean isComma() {
        return number.randomNumber(MAX_VALUE) < COMMA_CHANCE;
    }

    private String sentenceCreator(long words) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= words; i++) {
            builder.append(" ");
            String word = getRandomWord();
            if (i == 1) {
                word = capitalizeFirstLetter(word);
            }

            builder.append(word);
            if (isComma() && i != words) {
                builder.append(",");
            }
        }
        builder.append(".");

        return builder.toString();
    }

    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private String getRandomWord() {
        return LOREM_IPSUM_WORDS_LIST.randomResource();
    }

    private int numberOfWordsInDefaultSentence() {
        return LOREM_IPSUM.split(" ").length;
    }
}