package reversi;

import java.awt.Color;

public class Player {
	protected Color color;
	protected Board board;
	protected Master master;
	protected String name;

	protected boolean passFlag = false;

	public Player(Board board, Master master, String name) {
		this.board = board;
		this.master = master;
		this.name = name;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void prepareOnStone(int x1, int y1, int x2, int y2) {
		board.onStone(x1, y1, new Stone(color));
		board.onStone(x2, y2, new Stone(color));
	}

	public void play() {
		if (isOnStone()) {
			passFlag = false;
		} else {
			passFlag = true;
			master.pass(this);
		}
	}

	private boolean isOnStone() {
		boolean onStoneFlag = false;
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			for (int j = 0; j < Board.BOARD_SIZE; j++) {
				if (board.isOnStonePosition(color, i, j, Board.LEFT)
						|| board.isOnStonePosition(color, i, j, Board.RIGHT)
						|| board.isOnStonePosition(color, i, j, Board.UP)
						|| board.isOnStonePosition(color, i, j, Board.DOWN)
						|| board.isOnStonePosition(color, i, j, Board.LEFT_UP)
						|| board.isOnStonePosition(color, i, j, Board.LEFT_DOWN)
						|| board.isOnStonePosition(color, i, j, Board.RIGHT_UP)
						|| board.isOnStonePosition(color, i, j, Board.RIGHT_DOWN)
				) {
					board.onStone(i, j, new Stone(color));
					onStoneFlag = true;
					break;
				}
			}
			if (onStoneFlag) {
				break;
			}
		}

		return onStoneFlag;
	}

	public boolean isPass() {
		return passFlag;
	}

	public int numberOfStone() {
		return board.numberOfStone(color);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (color == Color.BLACK) {
			sb.append("Black");
		} else {
			sb.append("White");
		}
		sb.append(":" + name);
		return sb.toString();
	}

}
