package yahav.scrabble;
import java.io.*;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        DictionaryFile readWord = new DictionaryFile("dictionary.txt");
        System.out.println(readWord.getWord("hi"));

    }
}
