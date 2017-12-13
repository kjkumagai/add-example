package reversi;

public class MyPlayer extends Player {

	private boolean inputState = false;
	private boolean inputFlag = false;
	private int mauseX = 0;
	private int mauseY = 0;

	public MyPlayer(Board board, Master master, String name) {
		
		super(board, master, name);
	}

	@Override
	public void play() {
		int setFlag = 0;
		int x = 0;
		int y = 0;

		if (isOnStone()) {
			passFlag = false;
		} else {
			passFlag = true;
			master.pass(this);
			return;
		}

		while (setFlag == 0) {

			inputState = true;
			while (!inputFlag) {
				try {
					System.out.wait(10);
				} catch (Exception e) {
					
				}

			}
			inputFlag = false;
			inputState = false;
			for (int i = 0; i < Board.BOARD_SIZE; i++) {
				for (int j = 0; j < Board.BOARD_SIZE; j++) {
					if (Masu.gSize * i < mauseX
							&& Masu.gSize * (i + 1) > mauseX) {
						if (Masu.gSize * j < mauseY
								&& Masu.gSize * (j + 1) > mauseY) {
							x = i;
							y = j;
						}
					}
				}
			}
			if (super.board.isOnStonePosition(color, x, y, Board.LEFT)
					|| board.isOnStonePosition(color, x, y, Board.RIGHT)
					|| board.isOnStonePosition(color, x, y, Board.UP)
					|| board.isOnStonePosition(color, x, y, Board.DOWN)
					|| board.isOnStonePosition(color, x, y, Board.LEFT_UP)
					|| board.isOnStonePosition(color, x, y, Board.LEFT_DOWN)
					|| board.isOnStonePosition(color, x, y, Board.RIGHT_UP)
					|| board.isOnStonePosition(color, x, y, Board.RIGHT_DOWN)) {
				board.onStone(x, y, new Stone(color));
				setFlag = 1;
			}
		}
	}

	private boolean isOnStone() {
		boolean onStoneFag = false;
		for (int i = 0; i < Board.BOARD_SIZE; i++) {
			for (int j = 0; j < Board.BOARD_SIZE; j++) {
				if (board.isOnStonePosition(color, i, j, Board.LEFT)
						|| board.isOnStonePosition(color, i, j, Board.RIGHT)
						|| board.isOnStonePosition(color, i, j, Board.UP)
						|| board.isOnStonePosition(color, i, j, Board.DOWN)
						|| board.isOnStonePosition(color, i, j, Board.LEFT_UP)
						|| board.isOnStonePosition(color, i, j, Board.LEFT_DOWN)
						|| board.isOnStonePosition(color, i, j, Board.RIGHT_UP)
						|| board.isOnStonePosition(color, i, j,
								Board.RIGHT_DOWN)) {
					onStoneFag = true;
					break;
				}
			}
			if (onStoneFag) {
				break;
			}
		}
		return onStoneFag;
	}

	public void clickOnStone(int x, int y) {
		if (inputState) {
			mauseX = x;
			mauseY = y;
			inputFlag = true;
		}
	}
}
