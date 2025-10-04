package Rule;

import Players.Players;
import board.Board;

/**
 * Strategy pattern
 */

public abstract class RuleStrategy {

	public abstract boolean checkRule(int[][] board, Players player);
}
