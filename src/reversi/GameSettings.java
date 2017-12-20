package reversi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameSettings extends JFrame implements ActionListener{

    private JComboBox<String> startCombo;
    private JComboBox<String> endCombo;

    GameSettings(){

        JLabel label;

        String[] player1 = {"Choose", "MyPlayer", "Computer", "Random"};

        String[] player2 = {"Choose", "MyPlayer", "Computer", "Random"};

        startCombo = new JComboBox<>(player1);
        startCombo.setPreferredSize(new Dimension(115, 30));

        startCombo.addActionListener(this);

        endCombo = new JComboBox<>(player2);
        endCombo.setPreferredSize(new Dimension(115, 30));

        endCombo.addActionListener(this);

        JPanel p = new JPanel();
        p.add(new JLabel("player 1:"));
        p.add(startCombo);
        p.add(new JLabel("player 2:"));
        p.add(endCombo);


        JButton button3 = new JButton("Start a Game");
        button3.addActionListener(this);
        p.add(button3);


        label = new JLabel();
        JPanel labelPanel = new JPanel();
        labelPanel.add(label);

        getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(labelPanel, BorderLayout.PAGE_END);
    }

    public void actionPerformed(ActionEvent e) {
        String firstP;
        String lastP;
        String cmd = e.getActionCommand();

        if (cmd.equals("Start a Game")) {

            firstP = (String)startCombo.getSelectedItem();
            lastP = (String)endCombo.getSelectedItem();


            if ("MyPlayer".equals(firstP)){
                if ("Computer".equals(lastP)){

                    ReversiFrame frame = new ReversiFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);


                }else if ("MyPlayer".equals(lastP)){

                    ReversiFrame1 frame = new ReversiFrame1();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    /*
                    ReversiFrame frame = new ReversiFrame();
                    frame.ReversiFrame1();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    */

                }else if ("Random".equals(lastP)){

                    ReversiFrame4 frame = new ReversiFrame4();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            }else if ("Computer".equals(firstP)){
                if ("Computer".equals(lastP)){

                    ReversiFrame2 frame = new ReversiFrame2();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                }else if ("MyPlayer".equals(lastP)){

                    ReversiFrame3 frame = new ReversiFrame3();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                }
            }

            if (!("Choose".equals(firstP) || "Choose".equals(lastP))) {
                setVisible(false);
            }
        }
    }
}