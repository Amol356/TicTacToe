package board;

public enum Symbols {
    CIRCLE(1),
	CROSS(2);
	
	private int id;

	public int getId() {
		return id;
	}

	Symbols(int id) {
		this.id = id;
	}
	
}
