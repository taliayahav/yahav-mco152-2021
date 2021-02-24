package yahav.physics;
import org.junit.Assert;
import org.junit.Test;


//new comment
public class RocketTest {
    @Test
    public void getX() {
        //given
        Rocket rocket = new Rocket(71, 35);

        //when
        double x = rocket.getX(3);

        //then
        Assert.assertEquals(174.47, x, 0.01);
    }

    @Test
    public void getY() {
        //given
        Rocket rocket = new Rocket(71, 35);

        //when
        double x = rocket.getY(3);

        //then
        Assert.assertEquals(78.07, x, 0.01);
    }

    @Test
    public void TimeToLand() {
        //given
        Rocket rocket = new Rocket(71, 35);

        //when
        double x = rocket.TimeToLand();

        //then
        Assert.assertEquals(8.31, x, 0.01);

    }
}
