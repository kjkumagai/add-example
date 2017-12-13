package reversi;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ReversiFrame extends JFrame {

	public ReversiFrame() {
		setTitle("Reversi");

		setLayout(new BorderLayout());

		ConsolPanel consolPanel = new ConsolPanel();
		ReversiPanel panel = new ReversiPanel(consolPanel);

		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(consolPanel, BorderLayout.SOUTH);

		pack();
	}


	public static void main(String[] args) {

		GameSettings gameSettings = new GameSettings();
		gameSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameSettings.setBounds(10, 10, 380, 100);
		gameSettings.setTitle("Game Settings");
		gameSettings.setVisible(true);

	}

}


