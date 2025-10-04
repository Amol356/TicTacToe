package Rule;

import Players.Players;
import board.Board;

public class HorizontalRule extends RuleStrategy {


	@Override
	public boolean checkRule(int[][] boardMatrix, Players player) {
		
		for(int i=0; i<boardMatrix.length; i++) {
			for(int j=0; j<boardMatrix[i].length; j++) {
				if(boardMatrix[i][j] != player.getSymbol()) {
					break;
				}
				if(j==boardMatrix[i].length-1) {
					return true;
				}
			}
		}
		return false;
	}
}
