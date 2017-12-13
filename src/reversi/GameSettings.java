package reversi;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.*;

public class GameSettings extends JFrame implements ActionListener{

    JComboBox<String> startCombo = null;
    JComboBox<String> endCombo = null;
    JLabel label;

    public String firstP;
    public String lastP;


    public GameSettings(){

        String[] player1 = {"Choose", "MyPlayer", "Computer"};

        String[] player2 = {"Choose", "MyPlayer", "Computer"};

        startCombo = new JComboBox(player1);
        startCombo.setPreferredSize(new Dimension(115, 30));

        startCombo.addActionListener(this);

        endCombo = new JComboBox(player2);
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
        String cmd = e.getActionCommand();

        if (cmd.equals("Start a Game")) {

            firstP = (String)startCombo.getSelectedItem();
            lastP = (String)endCombo.getSelectedItem();

            //label.setText("START:" + start + ", END:" + end);


            if (firstP.equals("MyPlayer")){
                if (lastP.equals("Computer")){

                    ReversiFrame frame = new ReversiFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                }else if (lastP.equals("MyPlayer")){

                    ReversiFrame1 frame = new ReversiFrame1();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                }
            }else if (firstP.equals("Computer")){
                if (lastP.equals("Computer")){

                    ReversiFrame2 frame = new ReversiFrame2();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                }else if (lastP.equals("MyPlayer")){

                    ReversiFrame3 frame = new ReversiFrame3();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                }
            }
        }
    }
}