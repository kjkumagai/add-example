package reversi;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ReversiFrame1 extends JFrame {

	public ReversiFrame1() {
		setTitle("Reversi");

		setLayout(new BorderLayout());

		ConsolPanel consolPanel = new ConsolPanel();
		ReversiPanel1 panel = new ReversiPanel1(consolPanel);

		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(consolPanel, BorderLayout.SOUTH);

		pack();
	}

}


