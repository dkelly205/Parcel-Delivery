import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CourierTest {

    Courier courier;
    Point pointA;
    Point pointB;
    Point pointC;
    Point pointD;

    @Before
    public void setUp()throws Exception{
        courier = new Courier(10, 0 , 0);
        pointA = new Point(1, 0);
        pointB = new Point(2, 1);
        pointC = new Point(4, 4);
        pointD = new Point(0,0);
    }

    @Test
    public void hasParcels(){
        assertEquals(10, courier.getParcels());
    }

    @Test
    public void hasAPositionX(){
        assertEquals(0, courier.getPositionX());
    }

    @Test
    public void hasAPositionY(){
        assertEquals(0, courier.getPositionY());
    }

    @Test
    public void canDropParcelsOff(){
        courier.drop(4);
        assertEquals(6, courier.getParcels());
    }

    @Test
    public void isNotComplete(){
        assertFalse(courier.isComplete());
    }

    @Test
    public void canComplete(){
        courier.drop(10);
        assertTrue(courier.isComplete());
    }

    @Test
    public void canMoveEast(){
        courier.move(pointA);
        assertEquals(1, courier.getPositionX());
    }

    @Test
    public void canMoveNorth(){
        courier.move(pointB);
        assertEquals(1, courier.getPositionY());
    }

    @Test
    public void canMoveWestAndSouth(){
        courier.move(pointC);
        courier.move(pointD);
        assertEquals(0, courier.getPositionX());
        assertEquals(0, courier.getPositionY());
    }

}
