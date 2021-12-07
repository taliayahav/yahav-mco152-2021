package yahav.scrabble;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class DictionaryFileTest {

    @Test
    public void contains_true() throws IOException {
        // given
        DictionaryFile dictionary = new DictionaryFile();

        // when

        // then
        assertTrue(dictionary.contains("pineapple"));
    }
    @Test
    public void contains_false() throws IOException {
        // given
        DictionaryFile dictionary = new DictionaryFile();

        // when

        // then
        assertFalse(dictionary.contains("asdfasdfasff=d"));
    }

    @Test
    public void size() throws IOException {
        // given
        DictionaryFile dictionary = new DictionaryFile();

        // when

        // then
        assertEquals(167964, dictionary.size());
    }

    @Test
    public void getDefinition() throws IOException {
        // given
        DictionaryFile dictionary = new DictionaryFile();

        // when

        // then
        assertEquals("<pinecone=n> [n]", dictionary.getDefinition("pinecones"));
    }

}