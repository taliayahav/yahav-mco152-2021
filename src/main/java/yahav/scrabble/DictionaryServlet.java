package yahav.scrabble;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Dictionary;

public class DictionaryServlet extends HttpServlet {
    private final DictionaryFile dictionaryFile;
    //private final DictionaryService dict;

    public DictionaryServlet() throws IOException {
        dictionaryFile = new DictionaryFile();
        //dict = service.dictionary();
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws IOException{
            PrintWriter out = response.getWriter();
            String word = request.getParameter("word");
            String answer;
            if (dictionaryFile.contains(word)) {
                answer = dictionaryFile.getDefinition(word);
            } else {
                answer = "This word doesn't exist";
            }
            out.println(answer);
    }
    //when user types in code, return definition or if it doesn't exist
}
