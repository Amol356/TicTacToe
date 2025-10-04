package Players;

import board.Board;
import board.Symbols;
import console.PlayersConsole;

public class StandardPlayer implements Players {

	private String name;
	private int id;
	private Symbols playerSymbol;
	private PlayersConsole playerConsole;
	

	public StandardPlayer(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public void setPlayerSymbol(int id) {
		if(id==1) {
			playerSymbol = Symbols.CIRCLE;
		}else {
			playerSymbol = Symbols.CROSS;

		}
	}
	
	public PlayersConsole getPlayerConsole() {
		return playerConsole;
	}

	public void setPlayerConsole(PlayersConsole playerConsole) {
		this.playerConsole = playerConsole;
	}
	
	public void setSymbol(Symbols symbol) {
		this.playerSymbol= symbol;
	}
	
	public int getSymbol() {
		return this.playerSymbol.getId();
	}
	
	public void markCell(Board board, int row, int col) {
		int[][] boardMatrix = board.getBoard();
		boardMatrix[row][col] = this.playerSymbol.getId(); 
	}
	
	public int getCell(Board board, int row, int col) {
		int[][] boardMatrix = board.getBoard();
		return boardMatrix[row][col];
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
