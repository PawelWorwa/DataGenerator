package com.data.generator.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoremIpsumTest {
    private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet.";
    private static final int NR_OF_WORDS = 10;
    private static final int NR_OF_PARAGRAPHS = 5;
    private static final int MIN_WORDS_PER_PARAGRAPHS = 15;
    private static final int MAX_WORDS_PER_PARAGRAPHS = 30;

    private LoremIpsum lorem = new LoremIpsum();

    @Test
    void testDefaultSentence() {
        Assertions.assertEquals(LOREM_IPSUM, lorem.defaultSentence(),
                "Default message is different that expected!");
    }

    @Test
    void testCreateWords() {
        String createdWords = lorem.createWords(NR_OF_WORDS);
        verifyIfSentenceContainsDefaultValue(createdWords);

        Assertions.assertEquals(NR_OF_WORDS, createdWords.split(" ").length,
                "Created Lorem Ipsum message has wrong number of words!");
    }

    @Test
    void testCreateParagraphs() {
        String createdWords = lorem.createParagraphs(NR_OF_PARAGRAPHS, MIN_WORDS_PER_PARAGRAPHS, MAX_WORDS_PER_PARAGRAPHS);
        verifyIfSentenceContainsDefaultValue(createdWords);

        String[] lines = createdWords.split(System.lineSeparator());
        Assertions.assertEquals(NR_OF_PARAGRAPHS, lines.length - NR_OF_PARAGRAPHS + 1,
                "Created Lorem Ipsum message number of paragraphs is different that expected! ");

        for (String paragraph : lines) {
            if (!paragraph.isEmpty()) {
                String[] words = paragraph.split(" ");
                Assertions.assertTrue(words.length >= MIN_WORDS_PER_PARAGRAPHS,
                        "Created Lorem Ipsum message in paragraph has less words that expected!");

                Assertions.assertTrue(words.length <= MAX_WORDS_PER_PARAGRAPHS,
                        "Created Lorem Ipsum message in paragraph has more words that expected!");
            }
        }
    }

    private void verifyIfSentenceContainsDefaultValue(String sentence) {
        Assertions.assertTrue(sentence.contains(LOREM_IPSUM),
                "Created Lorem Ipsum message doesn't contains default 'Lorem Ipsum...' sentence!");
    }
}