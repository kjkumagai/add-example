package reversi;

public class Main {

	public static void main(String[] args) {

		Master master = new Master();
		Board board = new Board();
		Player player1 = new Player(board, master, "Player 1");
		Player player2 = new Player(board, master, "Player 2");
		master.addPlayer(player1, player2);
		master.prepareGame();
		master.startGame();
	}

}
