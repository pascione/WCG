package paolo.wcg.carsexercise;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CarTest {

	private Car car;

	@Test
	public void testForward() {
		try {
			Point p = new Point(5, 5);
			Coordinates coordinates = new Coordinates(p, Direction.NORTH, 15, 15);
			car = new Car(coordinates);
			car.receiveCommand("FFRFF");
			List<Point> movements = car.getListMovements();
			assertEquals(5, movements.get(1).getX());
			assertEquals(6, movements.get(1).getY());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testTurnLeft() {
		try {
			Point p = new Point(5, 5);
			Coordinates coordinates = new Coordinates(p, Direction.NORTH, 15, 15);
			car = new Car(coordinates);
			car.receiveCommand("LF");
			List<Point> movements = car.getListMovements();
			assertEquals(4, movements.get(1).getX());
			assertEquals(5, movements.get(1).getY());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testTurnRight() {
		try {
			Point p = new Point(5, 5);
			Coordinates coordinates = new Coordinates(p, Direction.NORTH, 15, 15);
			car = new Car(coordinates);
			car.receiveCommand("RF");
			List<Point> movements = car.getListMovements();
			assertEquals(6, movements.get(1).getX());
			assertEquals(5, movements.get(1).getY());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPath1() {
		try {
			Point p = new Point(5, 5);
			Coordinates coordinates = new Coordinates(p, Direction.NORTH, 15, 15);
			car = new Car(coordinates);
			car.receiveCommand("RFLFRFLF");
			List<Point> movements = car.getListMovements();
			assertEquals(7, movements.get(movements.size() - 1).getX());
			assertEquals(7, movements.get(movements.size() - 1).getY());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPath2() {
		try {
			Point p = new Point(6, 6);
			Coordinates coordinates = new Coordinates(p, Direction.NORTH, 15, 15);
			car = new Car(coordinates);
			car.receiveCommand("FFLFFLFFLFF");
			List<Point> movements = car.getListMovements();
			assertEquals(6, movements.get(movements.size() - 1).getX());
			assertEquals(6, movements.get(movements.size() - 1).getY());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPath3() {
		try {
			Point p = new Point(5, 5);
			Coordinates coordinates = new Coordinates(p, Direction.NORTH, 15, 15);
			car = new Car(coordinates);
			car.receiveCommand("FLFLFFRFFF");
			List<Point> movements = car.getListMovements();
			assertEquals(1, movements.get(movements.size() - 1).getX());
			assertEquals(4, movements.get(movements.size() - 1).getY());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
