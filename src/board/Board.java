package board;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import Players.Players;
import Rule.RuleStrategy;
import console.PlayersConsole;
import console.Subject;

public class Board implements Subject {

	private int size;
	private int[][] board;
	private Deque<Players> players = new ArrayDeque<>(); 
	private List<PlayersConsole> playersConsoleList = new ArrayList<>(); 
	private List<RuleStrategy> rules= new ArrayList<>();
	public boolean completedGame= false;
	
	public Board(int size) {
		this.size = size;
		board= new int[this.size][this.size];
		
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	
	public void addPlayer(Players player) {
		players.addFirst(player);
	}
	
	public void playAgain(Players player) {
		players.addFirst(player);
	}
	
	public Players fetchActivePlayer() {
		Players player = this.players.pollFirst();
		this.players.addLast(player);
		return player;
	}

	@Override
	public void addObserver(PlayersConsole playerConsole) {
		playersConsoleList.add(playerConsole);		
	}

	@Override
	public void removeObserver(PlayersConsole playerConsole) {
		playersConsoleList.remove(playerConsole);		
	}

	@Override
	public void notifyObservers(String msg) {
		
		for(PlayersConsole playerConsole : playersConsoleList) {
			playerConsole.displayMsg(msg);
		}
		
	}
	
	@Override
	public void notifyObserver(Players player, String msg) {
		
			player.getPlayerConsole().displayMsg(msg);
		
	}
	
	
	public boolean validateAction(int row, int col) {
		if(row<0 || row>=this.size) {
			return false;
		}
		if(col<0 || col>=this.size) {
			return false;
		}
		return true;
	}
	
	public boolean checkwin(Players player) {
		for(RuleStrategy rule : rules) {
			if(rule.checkRule(this.board, player)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkDraw(Players player) {
		for(int row =0; row<board.length; row++) {
			for(int col=0; col<board.length; col++) {
				if(board[row][col]==0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void addRule(RuleStrategy ruleStrategy) {
		rules.add(ruleStrategy);
	}
	
	
	public void diplayBoard() {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]==1) {
					System.out.print("0 ");
					
				}else if(board[i][j]==0){
					System.out.print("- ");
				}else {
					System.out.print("X ");
				}
			}
			System.out.println();

		}
	}
	
	
	
	
	
	
	

	

}
