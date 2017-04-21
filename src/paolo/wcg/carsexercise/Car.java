package paolo.wcg.carsexercise;

import java.util.ArrayList;
import java.util.List;

public class Car {

	private Coordinates coordinates;
	private List<Point> listMovements;

	public List<Point> getListMovements() {
		return listMovements;
	}

	public Car(Coordinates coordinates) {
		this.coordinates = coordinates;
		listMovements = new ArrayList<Point>();
		listMovements.add(new Point(coordinates.getPoint().getX(), coordinates.getPoint().getY()));
	}

	public void receiveCommand(String commands) throws Exception {
		for (char command : commands.toCharArray()) {
			executeCommand(command);
		}
	}

	private void executeCommand(char command) throws Exception {
		switch (Character.toUpperCase(command)) {
		case 'F':
			coordinates.moveForward();
			listMovements.add(new Point(coordinates.getPoint().getX(), coordinates.getPoint().getY()));
			break;
		case 'L':
			coordinates.turnLeft();
			break;
		case 'R':
			coordinates.turnRight();
			break;
		default:
			throw new Exception("Command " + command + " unknown.");
		}

	}
}
