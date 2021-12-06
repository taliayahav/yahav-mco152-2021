package yahav.scrabble;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Dictionary;

public class DictionaryServlet extends HttpServlet {
    private final DictionaryFile dictionaryFile;

    public DictionaryServlet() throws FileNotFoundException {
        dictionaryFile = new DictionaryFile("src/main/resources/dictionary.txt");
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
        String defineWord = request.getParameter("defineWord");
        String answer;
        if (dictionaryFile.contains(defineWord)){
            answer = dictionaryFile.getDefinition(defineWord);
        }
        else{
            answer = "This word doesn't exist";
        }
        out.print(answer);
    }
    //when user types in code, return definition or if it doesn't exist
}
