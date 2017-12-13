package reversi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConsolPanel extends JPanel {
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 50;

	private String str;

	public ConsolPanel() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.BLACK);

	}

	public void setString(String str) {
		this.str = str;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		if (str != null) {
			g.drawString(str, 10, 20);
		}
	}
}
