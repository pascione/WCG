package paolo.wcg.carsexercise;

public class Coordinates {

	private int maxX;
	private int maxY;
	private Point point;
	private Direction direction;

	public Point getPoint() {
		return point;
	}

	public Direction getDirection() {
		return direction;
	}

	public Coordinates(Point point, Direction direction, int maxX, int maxY) {
		this.point = point;
		this.direction = direction;
		this.maxX = maxX - 1;
		this.maxY = maxY - 1;
	}

	public void move(Direction directionV) {
		switch (direction) {
		case NORTH:
			point.setY((point.getY() + 1) % maxY);
			break;
		case EAST:
			point.setX((point.getX() + 1) % maxX);
			break;
		case SOUTH:
			point.setY((point.getY() - 1) % maxY);
			break;
		case WEST:
			point.setX((point.getX() - 1) % maxX);
			break;
		}
	}

	private void changeDirection(Direction directionValue, int directionStep) {
		int directions = Direction.values().length;
		int index = (directions + directionValue.ordinal() + directionStep) % directions;
		direction = Direction.values()[index];
	}

	public void turnLeft() {
		changeDirection(direction, -1);
	}

	public void turnRight() {
		changeDirection(direction, 1);
	}

	public void moveForward() {
		move(direction);
	}
}
