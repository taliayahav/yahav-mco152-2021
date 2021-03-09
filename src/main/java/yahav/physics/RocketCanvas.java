package yahav.physics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
Draws the rocket to the canvas
 */
public class RocketCanvas extends Canvas {
    /*
    Draws the path of the rocket starting form time=0 to the rocket's flight time with 1 second intervals.
     */
    public void draw(Rocket rocket){
        GraphicsContext context  = getGraphicsContext2D();

        context.setFill(Color.VIOLET);
        context.fillRect(0, 0, getWidth(), getHeight());
        context.setFill(Color.BLUE);
        context.translate(0,getHeight());
        context.setStroke(Color.BLUE);
        context.setLineWidth(2);
        context.beginPath();
        context.moveTo(rocket.getX(3),rocket.getY(3));


        for(double time = 0; time<rocket.getFlightTime(); time+=0.5){
            double x = rocket.getX(time);
            double y = rocket.getY(time);
            context.fillOval(x, -y, 10, 10);
            context.lineTo(x,-y);
        }
        context.stroke();
        context.translate(0, -getHeight());
    }
}
