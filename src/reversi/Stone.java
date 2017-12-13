package reversi;

import java.awt.Color;
import java.awt.Graphics;

public class Stone {
	private Color color;

	public Stone(Color color) {

		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void turnOver() {
		this.color = getReversiColor(this.color);
	}

	public static Color getReversiColor(Color color) {
		Color reversiColor = color;
		if (reversiColor == Color.BLACK) {
			reversiColor = Color.WHITE;
		} else {
			reversiColor = Color.BLACK;
		}
		return reversiColor;
	}

	public String toString() {
		if (color == Color.BLACK) {
			return "Black";
		} else {
			return "White";
		}
	}

	public void draw(Graphics g, int size, int x, int y) {
		g.setColor(color);
		g.fillOval(x - size / 2, y - size / 2, size, size);
	}
}
