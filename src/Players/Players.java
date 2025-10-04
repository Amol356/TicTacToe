package Players;

import board.Board;
import board.Symbols;
import console.PlayersConsole;

public interface Players {
	public PlayersConsole getPlayerConsole();
	public void setPlayerConsole(PlayersConsole playerConsole);
	public void setPlayerSymbol(int id);
	public String getName();

	public int getId();
	public void markCell(Board board, int row, int col);
	
	public int getCell(Board board, int row, int col);
	
	public int getSymbol();
}
