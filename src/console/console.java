package console;

public class console implements PlayersConsole {

	private String name;
	private int id;

	public console(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}


	
	@Override
	public void displayMsg(String msg) {
		System.out.println(name + " console :  " + msg);
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
