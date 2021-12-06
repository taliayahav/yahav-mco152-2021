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

    public ScrabbleController(LetterBag letterBag,
                              DictionaryFile dictionary) {
        this.letterBag = letterBag;
        this.dictionary = dictionary;
        try {
            dictionary = new DictionaryFile("src/main/resources/dictionary.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        for (Label label : letterLabels) {
            label.setText(letterBag.nextLetter()); //put a random letter from letter bag into each letter box
        }
    }

    public void onAnswerClicked(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource();
        for(Label clicked: letterLabels){ //if the user wants to return the letter back to the letter label boxes
            if(clicked.getText().equals("")){
                clicked.setText(label.getText()); //set an empty box to whatever letter the user clicked to be returned
                label.setText(""); //clear out the answer box clicked
                break;
            }
        }
    }

    public void onSubmit(ActionEvent actionEvent) {
        StringBuilder result = new StringBuilder();
        for(Label letter : answerLabels)
        {
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
        }
        else{
            pointsCheck.setText("word invalid");
        }
        for(Label refresh : letterLabels){
            if(refresh.getText().equals(""))
            {
                refresh.setText(letterBag.nextLetter());
            }
        }
    }

    public void onClear(ActionEvent actionEvent) {
        for(Label box : answerLabels){
                if (!box.getText().isEmpty()) { //to clear out the answer boxes check if empty
                    for(Label swipe : letterLabels) { //to send the letters back to the label
                        if(swipe.getText().equals("")) {
                            swipe.setText(box.getText()); //set the empty letter label to the letter from answer label
                            break;
                        }
                    }
                    box.setText(""); // empty the answer label.
                }
        }
    }

    public void onLetterClicked(MouseEvent mouseEvent) {
        Label label = (Label) mouseEvent.getSource(); //object that allows access to whatever input is in the label
        for(Label click : answerLabels){ //each individual box in the answer boxes
            if(click.getText().equals("")){ //check if that box is empty,
                click.setText(label.getText()); //if it is, set it to whatever letter was clicked on from letter label
                label.setText(""); //once the letter is used, clear its box from the 'garbage' letter
                break;
            }
        }
    }
}
