package com;

import java.util.Scanner;

import Players.Players;
import Players.StandardPlayer;
import Rule.HorizontalRule;
import Rule.RuleStrategy;
import Rule.VerticalRule;
import Rule.DiagonalRule;
import board.Board;
import console.PlayersConsole;

public class TicTacToeMain {

	Board board;

	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		initGame(scanner);
		playGame(scanner);
		scanner.close();
	}

	public void initGame(Scanner scanner) {
		System.out.print("please enter size of the board ");
		int boardSize = scanner.nextInt();
		this.board = new Board(boardSize);

		// Adding rule strategy
		RuleStrategy horizontal = new HorizontalRule();
		RuleStrategy verticle = new VerticalRule();
		RuleStrategy diagonal = new DiagonalRule();

		this.board.addRule(horizontal);
		this.board.addRule(verticle);
		this.board.addRule(diagonal);

		System.out.print("please enter number of players ");
		int playerSize = scanner.nextInt();
		int id = 1;
		scanner.nextLine();

		for (int i = 0; i < playerSize; i++) {
			System.out.print("please enter player " + id + " name : ");
			String name = scanner.nextLine();
			Players player = new StandardPlayer(name, id);
			player.setPlayerSymbol(id);
			this.board.addPlayer(player);

			PlayersConsole console = new console.console(name, id);
			this.board.addObserver(console);
			player.setPlayerConsole(console);
			id++;
		}
	}

	public void playGame(Scanner scanner) {
		boolean isGameFinished = this.board.completedGame;

		while (!isGameFinished) {
			Players player = this.board.fetchActivePlayer();
			this.board.notifyObserver(player,"please enter your next action");

			String action = scanner.nextLine();
			String[] rowcol = action.split(" ");
			int row = Integer.parseInt(rowcol[0]);
			int col = Integer.parseInt(rowcol[1]);

			if (this.board.validateAction(row, col)) {
				player.markCell(this.board, row, col);
				this.board.diplayBoard();
				if (this.board.checkwin(player)) {
					this.board.notifyObservers("player " + player.getName() + " has won the game.");
					this.board.completedGame = true;
					isGameFinished = true;
				} else if (this.board.checkDraw(player)) {
					this.board.notifyObservers("Game is draw.");
					this.board.completedGame = true;
					isGameFinished = true;
				}
			} else {
				this.board.notifyObserver(player, player.getName() + " please enter valid action");
				this.board.playAgain(player);
			}

		}

	}
}
