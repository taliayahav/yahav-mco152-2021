package yahav.scrabble;
import java.io.*;

public class readFile {

    public static void main(String[] args) throws IOException {
        dictionaryFile readWord = new dictionaryFile("/Users/taliayahav/Downloads/dictionary.txt");
        System.out.println(readWord.getWord("hi"));
    }
}
