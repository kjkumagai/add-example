package reversi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class ReversiPanel1 extends JPanel implements MouseListener, Runnable {
	private static final int PANEL_WIDTH = 800;
	private static final int PANEL_HEIGHT = 801;
	private static final int BOARD_SIZE = 800;
	private Thread gameThread;

	private Master master;
	private Board board;
	private Player firstPlayer;
	private Player secondPlayer;

	private GameSettings gameSettings;

	public ReversiPanel1(ConsolPanel consolPanel) {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		addMouseListener(this);

		master = new Master(consolPanel);
		board = new Board(BOARD_SIZE, BOARD_SIZE, this);

		firstPlayer = new MyPlayer(board, master, "Player 1");
		secondPlayer = new MyPlayer(board, master, "Player 2");


		master.addPlayer(firstPlayer, secondPlayer);

		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		board.draw(g);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		master.prepareGame();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		update(getGraphics());
		master.startGame();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		if (firstPlayer instanceof MyPlayer) {
			((MyPlayer) firstPlayer).clickOnStone(arg0.getX(), arg0.getY());
		}
		if (secondPlayer instanceof MyPlayer) {
			((MyPlayer) secondPlayer).clickOnStone(arg0.getX(), arg0.getY());
		}
		update(getGraphics());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
}
