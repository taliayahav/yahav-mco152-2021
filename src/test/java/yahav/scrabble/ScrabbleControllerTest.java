package yahav.scrabble;

import org.junit.Test;

import java.util.ArrayList;

public class ScrabbleControllerTest {
    @Test
    public void initialize(){
        //given
        ScrabbleController controller = new ScrabbleController();
        controller.letterLabels = new ArrayList<>();

        //when
        controller.initialize();

        //then

    }
}
