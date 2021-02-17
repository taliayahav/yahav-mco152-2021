package yahav.scrabble;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class DictionaryFile {
    private final ArrayList<String> allFirstWords = new ArrayList<>();

    /**
     * opens given file and reads through it, only searching the first word of every line.
     * @param file accepts the file to be searched through
     * @throws FileNotFoundException
     */

    public DictionaryFile(String file) throws FileNotFoundException {
        File newFile = new File(file);
        Scanner inputFile = new Scanner(newFile);
        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            String firstWord = line.split(" ")[0];
            allFirstWords.add(firstWord);
        }
        inputFile.close();
    }

    /**
     * Tests if the word from command line exists in the text of the file
     * @param word accepts word to be searched
     * @return true if word exists
     */
    public boolean getWord(String word) {
        boolean retWord = false;
        for (String newWord : allFirstWords) {
            if (newWord.equalsIgnoreCase(word)) {
                retWord = true;
                break;
            }
        }
        return retWord;
    }
}
