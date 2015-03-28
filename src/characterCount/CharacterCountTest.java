package characterCount;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by derric on 3/28/15.
 */
public class CharacterCountTest {
    @Test
    public void testMostFrequentCharacterPass() {
        Character expected = 'l'; //assign expected character
        Character actual = CharacterCount.getMostFrequentCharacter("Hello World");//call the function to return the most frequent character

//        assertTrue(actual==expected);
        assertSame(expected,actual);
    }

    @Test
    public void testMostFrequentCharacterFail() {
        Character unexpected = 'e';//assign unexpected character
        Character actual = CharacterCount.getMostFrequentCharacter("Hello World");//call the function to return the most frequent character

//        assertFalse(actual == expected);
        assertNotSame(unexpected,actual);
    }
}
