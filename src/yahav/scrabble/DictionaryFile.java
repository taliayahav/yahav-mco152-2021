package yahav.scrabble;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
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
        Collections.sort(allFirstWords);
        System.out.println(allFirstWords);
    }

    /**
     * Tests if the word from command line exists in the text of the file
     * @param word accepts word to be searched
     * @return true if word exists
     */
    public boolean getWord(String word) {
        String[] dictArray = allFirstWords.toArray(new String[0]);
        return Arrays.binarySearch(dictArray, word.toUpperCase()) > 0;
    }
}
