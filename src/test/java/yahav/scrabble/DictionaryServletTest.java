package yahav.scrabble;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class DictionaryServletTest {
    @Test
    public void DictionaryServletTest() throws IOException {

        // given
        DictionaryServlet dictionaryServlet = new DictionaryServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        PrintWriter out = mock(PrintWriter.class);
        doReturn(out).when(response).getWriter();
        doReturn("word").when(request).getParameter("word");

        // when
        dictionaryServlet.doGet(request, response);

        // then
        verify(out).println(anyString());
    }
}
