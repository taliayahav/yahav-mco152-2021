package yahav.physics;

public class Rocket {
    private final double velocity;
    private final double angle;

    public Rocket(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = angle;
    }

    public double getX(double time) {
        double xVelocity = Math.cos(Math.toRadians(angle)) * velocity;
        double x = xVelocity * time;
        return x;
    }

    /**
     *
     * @param time
     * @return
     */
    public double getY(double time){
        final double GRAVITY = 9.8;
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        double y = yVelocity * time - 0.5 * GRAVITY * time *time;
        return y;
    }
    public double TimeToLand(){
        final double GRAVITY = 9.8;
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        double time = yVelocity/(0.5*GRAVITY);
        return time;
    }
}

