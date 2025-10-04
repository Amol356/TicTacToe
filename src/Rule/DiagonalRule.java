package Rule;

import Players.Players;
import board.Board;

public class DiagonalRule extends RuleStrategy {

	@Override
	public boolean checkRule(int[][] boardMatrix, Players player) {
		int row = 0;
		// diagonal 1
		for (int col = 0; col < boardMatrix[col].length; col++) {
			if (boardMatrix[row][col] != player.getSymbol()) {
				break;
			}
			if (row == boardMatrix.length-1) {
				return true;
			}
			row++;
		}
		
		//diagonal 2
		row = boardMatrix.length-1;
		for (int col = 0; col < boardMatrix[col].length; col++) {
			if (boardMatrix[row][col] != player.getSymbol()) {
				break;
			}
			if (row == 0) {
				return true;
			}
			row--;
		}
		

		return false;
	}

}
