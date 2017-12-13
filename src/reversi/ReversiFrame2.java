package reversi;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ReversiFrame2 extends JFrame {

	public ReversiFrame2() {
		setTitle("Reversi");

		setLayout(new BorderLayout());

		ConsolPanel consolPanel = new ConsolPanel();
		ReversiPanel2 panel = new ReversiPanel2(consolPanel);

		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(consolPanel, BorderLayout.SOUTH);

		pack();
	}

}


