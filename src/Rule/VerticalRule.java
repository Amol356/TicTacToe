package Rule;

import Players.Players;
import board.Board;

public class VerticalRule extends RuleStrategy{

	@Override
	public boolean checkRule(int[][] boardMatrix, Players player) {
		
		for(int col=0; col<boardMatrix.length; col++) {
			for(int row=0; row<boardMatrix[col].length; row++) {
				if(boardMatrix[row][col] != player.getSymbol()) {
					break;
				}
				if(row==boardMatrix[col].length-1) {
					return true;
				}
			}
		}
		return false;
	}
}
