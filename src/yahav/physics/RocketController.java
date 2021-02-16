package yahav.physics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RocketController {
    @FXML
    TextField velocityField;
    @FXML
    TextField angleField;
    @FXML
    TextField secondsField;
    @FXML
    Button calculateButton;
    @FXML
    TextField timeToLand;
    @FXML
    TextField xField;
    @FXML
    TextField yField;

    @FXML public void calculateRocket(ActionEvent actionEvent) {
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);
        rocket.TimeToLand();
        timeToLand.setText(String.valueOf(rocket.TimeToLand()));
        rocket.getX(seconds);
        xField.setText(String.valueOf(rocket.getX(seconds)));
        rocket.getY(seconds);
        yField.setText(String.valueOf(rocket.getY(seconds)));

    }



}
