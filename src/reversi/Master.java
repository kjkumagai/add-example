package reversi;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Master {

	private static final Color FIRST_PLAYER_COLOR = Color.BLACK;
	private static final Color SECOND_PLAYER_COLOR = Color.WHITE;
	private static final int PREPARE_BLACK_POSITION_X1 = 3;
	private static final int PREPARE_BLACK_POSITION_X2 = 4;
	private static final int PREPARE_BLACK_POSITION_Y1 = 3;
	private static final int PREPARE_BLACK_POSITION_Y2 = 4;
	private static final int PREPARE_WHITE_POSITION_X1 = 4;
	private static final int PREPARE_WHITE_POSITION_X2 = 3;
	private static final int PREPARE_WHITE_POSITION_Y1 = 3;
	private static final int PREPARE_WHITE_POSITION_Y2 = 4;

	private Player firstPlayer;
	private Player secondPlayer;
	private List<Player> playerList = new ArrayList<>();

	private ConsolPanel consolPanel;

	public Master() {

	}

	public Master(ConsolPanel consolPanel) {
		this.consolPanel = consolPanel;
	}

	public void addPlayer(Player firstPlayer, Player secondPlayer) {

		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		playerList.add(firstPlayer);
		playerList.add(secondPlayer);
	}

	public void prepareGame() {
		firstPlayer.setColor(FIRST_PLAYER_COLOR);
		secondPlayer.setColor(SECOND_PLAYER_COLOR);
		firstPlayer.prepareOnStone(PREPARE_BLACK_POSITION_X1,
				PREPARE_BLACK_POSITION_Y1, PREPARE_BLACK_POSITION_X2,
				PREPARE_BLACK_POSITION_Y2);
		secondPlayer.prepareOnStone(PREPARE_WHITE_POSITION_X1,
				PREPARE_WHITE_POSITION_Y1, PREPARE_WHITE_POSITION_X2,
				PREPARE_WHITE_POSITION_Y2);
	}

	public void startGame() {
		out("Start Game");
		for (int i = 0; (!firstPlayer.isPass() || !secondPlayer.isPass()); i++) {
			out(playerList.get(i % playerList.size()) + "'s turn");
			playerList.get(i % playerList.size()).play();
		}
		out("End Game");
		gameSet();
	}

	public void pass(Player player) {
		out(player + "nowhere to place");
	}

	private void gameSet() {
		Player winPlayer = null;
		int blackStoneNumber = firstPlayer.numberOfStone();
		int whiteStoneNumber = secondPlayer.numberOfStone();

		if (blackStoneNumber > whiteStoneNumber) {
			winPlayer = firstPlayer;
		} else if (blackStoneNumber < whiteStoneNumber) {
			winPlayer = secondPlayer;
		}
		if (winPlayer != null) {
			out("Black:" + blackStoneNumber + "  White:" + whiteStoneNumber + "  "
					+ winPlayer + " won it");
		} else {
			out("Black:" + blackStoneNumber + " White:" + whiteStoneNumber + " draw");
		}
	}

	private void out(String str) {
		if (consolPanel != null) {
			consolPanel.setString(str);
			consolPanel.update(consolPanel.getGraphics());
		}
		System.out.println(str);
	}
}
