package reversi;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ReversiFrame3 extends JFrame {

	public ReversiFrame3() {
		setTitle("Reversi");

		setLayout(new BorderLayout());

		ConsolPanel consolPanel = new ConsolPanel();
		ReversiPanel3 panel = new ReversiPanel3(consolPanel);

		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(consolPanel, BorderLayout.SOUTH);

		pack();
	}

}


