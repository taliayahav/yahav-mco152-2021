package yahav.scrabble;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DictionaryFile {

    private final Map<String, String> wordsToDefinitions = new HashMap<>();

    public DictionaryFile() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            int index = line.indexOf(" ");
            String word = index == -1 ? line : line.substring(0, index);
            String definition = index > -1 ? line.substring(index + 1) : null;
            wordsToDefinitions.put(word, definition);
        }
    }

    public boolean contains(String word) {
        if(word!=null)
        return wordsToDefinitions.containsKey(word.toUpperCase());
        else return false;
    }

    public String getDefinition(String word) {
        String definition = wordsToDefinitions.get(word.toUpperCase());
        return definition == null ? "" : definition;
    }

    public int size() {
        return wordsToDefinitions.size();
    }
}
