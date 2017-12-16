package reversi;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ReversiFrame4 extends JFrame {

	public ReversiFrame4() {
		setTitle("Reversi");

		setLayout(new BorderLayout());

		ConsolPanel consolPanel = new ConsolPanel();
		ReversiPanel4 panel = new ReversiPanel4(consolPanel);

		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(consolPanel, BorderLayout.SOUTH);

		pack();
	}

}


