package yahav.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;

public class DictionaryController {
    @FXML
    javafx.scene.control.TextField wordSearchField;
    @FXML
    TextField ifFoundWordField;

    public void dictionarySearch(ActionEvent actionEvent) throws IOException {
        DictionaryFile dictionaryFile = new DictionaryFile();
        String str = wordSearchField.getText();
        dictionaryFile.contains(str);
        if(dictionaryFile.contains(str)){
            ifFoundWordField.setText("exists");
        }
        else{
            ifFoundWordField.setText("does not exist");
        }

    }
}
