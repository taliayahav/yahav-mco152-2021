package yahav.physics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    @FXML
    RocketCanvas rocketCanvas;

    @FXML public void calculateRocket(ActionEvent actionEvent) {
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);
        timeToLand.setText(String.valueOf(rocket.getFlightTime()));
        xField.setText(String.format("%.2f", rocket.getX(seconds)));
        yField.setText(String.format("%.2f", (rocket.getY(seconds))));

        rocketCanvas.draw(rocket);

    }
}
