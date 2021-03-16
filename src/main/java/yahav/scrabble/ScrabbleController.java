package yahav.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleController {

    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;
    @FXML
    Label pointsCheck;

    private LetterBag letterBag = new LetterBag();

    private DictionaryFile dictionary;

    private int count =0;

    public ScrabbleController() {
        try {
            dictionary = new DictionaryFile("dictionary.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        for (Label label : letterLabels) {
            label.setText(letterBag.nextLetter());
        }
    }

    public void onAnswerClicked(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
    }

    public void onSubmit(ActionEvent actionEvent) {

        StringBuilder result = new StringBuilder();
        for(Label letter : answerLabels){
            String answer = letter.getText();
            result.append(answer);
        }
        if (dictionary.contains(result.toString())) {
            if (result.length() == 2) {
                count += 1;
            } else if (result.length() == 3) {
                count += 3;
            } else if (result.length() == 4) {
                count += 5;
            } else if (result.length() == 5) {
                count += 7;
            } else if (result.length() == 6) {
                count += 11;
            } else if (result.length() == 7) {
                count += 13;
            }

            pointsCheck.setText(String.valueOf(count));
            else{
                pointsCheck.setText("word invalid");
            }
        }
    }

    public void onClear(ActionEvent actionEvent) {
        for(Label box : answerLabels){
            if(!box.getText().isEmpty()){ //to clear out the answer boxes, if they're not empty, empty them.
                box.setText("");
            }
        }
    }

    public void onLetterClicked(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        for(Label click : answerLabels){
            if(click.getText().equals("")){
                click.setText(label.getText());
                break;
            }
        }
    }
}
