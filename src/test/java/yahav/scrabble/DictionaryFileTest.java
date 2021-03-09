package yahav.scrabble;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class DictionaryFileTest {

    @Test
    public void contains_true() throws FileNotFoundException {
        // given
        DictionaryFile dictionary = new DictionaryFile("dictionary.txt");

        // when

        // then
        assertTrue(dictionary.contains("pineapple"));
    }
    @Test
    public void contains_false() throws FileNotFoundException {
        // given
        DictionaryFile dictionary = new DictionaryFile("dictionary.txt");

        // when

        // then
        assertFalse(dictionary.contains("asdfasdfasff=d"));
    }

    @Test
    public void size() throws FileNotFoundException {
        // given
        DictionaryFile dictionary = new DictionaryFile("dictionary.txt");

        // when

        // then
        assertEquals(167964, dictionary.size());
    }

    @Test
    public void getDefinition() throws FileNotFoundException {
        // given
        DictionaryFile dictionary = new DictionaryFile("dictionary.txt");

        // when

        // then
        assertEquals("<pinecone=n> [n]", dictionary.getDefinition("pinecones"));
    }

}