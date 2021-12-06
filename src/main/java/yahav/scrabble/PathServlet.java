package yahav.scrabble;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PathServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)throws IOException{
        PrintWriter out = response.getWriter();
    }
    //when user types in code, return definition or if it doesn't exist
}
