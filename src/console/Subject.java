package console;

import Players.Players;

public interface Subject {

	public void addObserver(PlayersConsole playerConsole);
	public void removeObserver(PlayersConsole playerConsole);
	public void notifyObserver(Players player,String msg);
	public void notifyObservers(String msg);

}
