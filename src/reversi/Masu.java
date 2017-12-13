package reversi;

import java.awt.Color;
import java.awt.Graphics;

public class Masu {
	private Stone stone = null;
	private Color backgroundColor = Color.GREEN;
	private Color frameColor = Color.BLACK;

	private static final double stoneCoefficient = 0.8;
	public static int gSize;
	private int gX;
	private int gY;

	public Masu() {

	}

	public Masu(int size, int x, int y) {
		gSize = size;
		gX = x;
		gY = y;
	}

	public void setStone(Stone stone) {
		this.stone = stone;
	}

	public Stone getStone() {
		return stone;
	}

	public void removeStone() {
		stone = null;
	}

	public String toString() {
		if (stone == null) {
			return "empty";
		} else {
			return stone.toString();
		}
	}

	public void draw(Graphics g) {
		g.setColor(backgroundColor);
		g.fillRect(gX, gY, gSize, gSize);
		g.setColor(frameColor);
		g.drawRect(gX, gY, gSize, gSize);

		if (stone != null) {
			stone.draw(g, (int) (gSize * stoneCoefficient), gX + (gSize / 2),
					gY + (gSize / 2));
		}
	}
}
