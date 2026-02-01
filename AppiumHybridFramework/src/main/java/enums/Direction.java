package enums;

public enum Direction {

	UP("up"),DOWN("down"),LEFT("left"), RIGHT("right");

	String direction;

	Direction(String direction) {
		this.direction = direction;
	}

	public String getDirectionValue() {
		return direction;
	}
}