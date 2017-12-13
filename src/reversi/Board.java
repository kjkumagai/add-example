package reversi;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board {
	public static final int BOARD_SIZE = 8;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	public static final int LEFT_UP = 4;
	public static final int LEFT_DOWN = 5;
	public static final int RIGHT_UP = 6;
	public static final int RIGHT_DOWN = 7;

	
	private int gWidth;
	private int gHeight;
	private JPanel panel;

	private Masu[][] masus = new Masu[BOARD_SIZE][BOARD_SIZE];

	public Board() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				masus[i][j] = new Masu();
			}
		}
	}

	public Board(int width, int height, JPanel panel) {
		gWidth = width;
		gHeight = height;
		this.panel = panel;
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				masus[i][j] = new Masu(gWidth / BOARD_SIZE, gWidth / BOARD_SIZE
						* i, gHeight / BOARD_SIZE * j);
			}
		}
	}

	public void onStone(int x, int y, Stone stone) {

		int setX, setY;
		int h_dir = 0;
		int w_dir = 0;

		masus[x][y].setStone(stone);
		out();
		Color reversiColor = Stone.getReversiColor(stone.getColor());
		if (turnOverCheckStonePosition(stone.getColor(), x, y, LEFT)) {
			w_dir = -1;
			h_dir = 0;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}
		}
		if (turnOverCheckStonePosition(stone.getColor(), x, y, RIGHT)) {
			w_dir = 1;
			h_dir = 0;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}
		}
		if (turnOverCheckStonePosition(stone.getColor(), x, y, UP)) {
			w_dir = 0;
			h_dir = -1;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}
		}
		if (turnOverCheckStonePosition(stone.getColor(), x, y, DOWN)) {
			w_dir = 0;
			h_dir = 1;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}
		}
		if (turnOverCheckStonePosition(stone.getColor(), x, y, LEFT_UP)) {
			w_dir = -1;
			h_dir = -1;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}
		}
		if (turnOverCheckStonePosition(stone.getColor(), x, y, LEFT_DOWN)) {
			w_dir = -1;
			h_dir = 1;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}

		}
		if (turnOverCheckStonePosition(stone.getColor(), x, y, RIGHT_UP)) {
			w_dir = 1;
			h_dir = -1;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}

		}
		if (turnOverCheckStonePosition(stone.getColor(), x, y, RIGHT_DOWN)) {
			w_dir = 1;
			h_dir = 1;
			setX = x + w_dir;
			setY = y + h_dir;

			for (; masus[setX][setY].getStone().getColor() == reversiColor; setX += w_dir, setY += h_dir) {
				masus[setX][setY].getStone().turnOver();
				out();
			}
		}
	}

	public boolean turnOverCheckStonePosition(Color color, int x, int y, int dir) {

		int h_dir = 0;
		int w_dir = 0;
		int nextX = 0;
		int nextY = 0;
		Stone stone;

		switch (dir) {
		case LEFT:
			w_dir = -1;
			break;
		case RIGHT:
			w_dir = 1;
			break;
		case UP:
			h_dir = -1;
			break;
		case DOWN:
			h_dir = 1;
			break;
		case LEFT_UP:
			w_dir = -1;
			h_dir = -1;
			break;
		case LEFT_DOWN:
			w_dir = -1;
			h_dir = 1;
			break;
		case RIGHT_UP:
			w_dir = 1;
			h_dir = -1;
			break;
		case RIGHT_DOWN:
			w_dir = 1;
			h_dir = 1;
			break;
		}

		Color reversiColor = Stone.getReversiColor(color);

		nextX = x + w_dir;
		nextY = y + h_dir;

		if (((nextX >= 0) && (nextY >= 0))
				&& ((nextX < BOARD_SIZE) && (nextY < BOARD_SIZE))) {

			stone = masus[nextX][nextY].getStone();
			if (stone != null) {
				if (stone.getColor() == reversiColor) {

				} else {

					return false;
				}
			} else {

				return false;
			}
		} else {

			return false;
		}

		while (true) {
			nextX = nextX + w_dir;
			nextY = nextY + h_dir;
			if (((nextX >= 0) && (nextY >= 0))
					&& ((nextX < BOARD_SIZE) && (nextY < BOARD_SIZE))) {

				stone = masus[nextX][nextY].getStone();
				if (stone != null) {
					if (stone.getColor() == reversiColor) {

					} else {
						break;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;

	}

	public boolean isOnStonePosition(Color color, int x, int y, int dir) {

		int h_dir = 0;
		int w_dir = 0;
		int nextX = 0;
		int nextY = 0;
		Stone stone;

		if (masus[x][y].getStone() != null) {
			return false;
		}

		switch (dir) {
		case LEFT:
			w_dir = -1;
			break;
		case RIGHT:
			w_dir = 1;
			break;
		case UP:
			h_dir = -1;
			break;
		case DOWN:
			h_dir = 1;
			break;
		case LEFT_UP:
			w_dir = -1;
			h_dir = -1;
			break;
		case LEFT_DOWN:
			w_dir = -1;
			h_dir = 1;
			break;
		case RIGHT_UP:
			w_dir = 1;
			h_dir = -1;
			break;
		case RIGHT_DOWN:
			w_dir = 1;
			h_dir = 1;
			break;
		}

		Color reversiColor = Stone.getReversiColor(color);

		nextX = x + w_dir;
		nextY = y + h_dir;

		if (((nextX >= 0) && (nextY >= 0))
				&& ((nextX < BOARD_SIZE) && (nextY < BOARD_SIZE))) {

			stone = masus[nextX][nextY].getStone();
			if (stone != null) {
				if (stone.getColor() == reversiColor) {

				} else {

					return false;
				}
			} else {

				return false;
			}
		} else {

			return false;
		}

		while (true) {
			nextX = nextX + w_dir;
			nextY = nextY + h_dir;
			if (((nextX >= 0) && (nextY >= 0))
					&& ((nextX < BOARD_SIZE) && (nextY < BOARD_SIZE))) {

				stone = masus[nextX][nextY].getStone();
				if (stone != null) {
					if (stone.getColor() == reversiColor) {

					} else {
						break;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;

	}

	public int numberOfWhiteStone() {
		int count = 0;
		for (Masu[] masuline : masus) {
			for (Masu masu : masuline) {
				if (masu.getStone() != null) {
					if (masu.getStone().getColor() == Color.WHITE) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public int numberOfStone(Color color) {
		int count = 0;
		for (Masu[] masuline : masus) {
			for (Masu masu : masuline) {
				if (masu.getStone() != null) {
					if (masu.getStone().getColor() == color) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				sb.append(masus[i][j].toString());
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				masus[i][j].draw(g);
			}
		}
	}

	public void out() {
		if (panel != null) {
			panel.update(panel.getGraphics());
		}
		System.out.println(this);

	}
}
