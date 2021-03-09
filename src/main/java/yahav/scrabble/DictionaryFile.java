package yahav.scrabble;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryFile {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public DictionaryFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            wordsToDefinitions.put(
                    scanner.next(), // key
                    scanner.nextLine().trim() // value
            );
        }
    }

    public boolean contains(String word) {
        return wordsToDefinitions.containsKey(word.toUpperCase());
    }

    public String getDefinition(String word) {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size() {
        return wordsToDefinitions.size();
    }

}

//public class DictionaryFile {
//    private final ArrayList<String> allFirstWords = new ArrayList<>();
//
//    /**
//     * opens given file and reads through it, only searching the first word of every line.
//     * @param file accepts the file to be searched through
//     * @throws FileNotFoundException
//     */
//
//    public DictionaryFile(String file) throws FileNotFoundException {
//        File newFile = new File(file);
//        Scanner inputFile = new Scanner(newFile);
//        while (inputFile.hasNext()) {
//            String line = inputFile.nextLine();
//            String firstWord = line.split(" ")[0];
//            allFirstWords.add(firstWord);
//        }
//        inputFile.close();
//        Collections.sort(allFirstWords);
//    }
//
//    /**
//     * Tests if the word from command line exists in the text of the file
//     * @param word accepts word to be searched
//     * @return true if word exists
//     */
//    public boolean getWord(String word) {
//        String[] dictArray = allFirstWords.toArray(new String[0]);
//        return Arrays.binarySearch(dictArray, word.toUpperCase()) > 0;
//    }
//}
