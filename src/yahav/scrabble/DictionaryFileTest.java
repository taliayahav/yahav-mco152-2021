package yahav.scrabble;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class DictionaryFileTest {

    @Test
    public void getWord() throws FileNotFoundException {
        DictionaryFile readWord = new DictionaryFile("dictionary.txt");
        boolean x = readWord.getWord("AA");
        Assert.assertTrue(x);
        boolean y = readWord.getWord("Talia");
        Assert.assertFalse(false);
    }

}
