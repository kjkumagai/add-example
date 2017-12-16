package reversi;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RandomPlayer extends Player{

    int rani = 0;
    int ranj = 0;

    Random random = new Random();

    public RandomPlayer(Board board, Master master, String name){
        super(board, master, name);
    }

    public void play() {
        if (isOnStone()) {
            passFlag = false;
        } else {
            passFlag = true;
            master.pass(this);
        }
    }

    private boolean isOnStone() {

        boolean onStoneFg = false;
        List<Integer> listA = new ArrayList();
        List<Integer> listB = new ArrayList();

        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (board.isOnStonePosition(color, i, j, Board.LEFT)
                        || board.isOnStonePosition(color, i, j, Board.RIGHT)
                        || board.isOnStonePosition(color, i, j, Board.UP)
                        || board.isOnStonePosition(color, i, j, Board.DOWN)
                        || board.isOnStonePosition(color, i, j, Board.LEFT_UP)
                        || board.isOnStonePosition(color, i, j, Board.LEFT_DOWN)
                        || board.isOnStonePosition(color, i, j, Board.RIGHT_UP)
                        || board.isOnStonePosition(color, i, j, Board.RIGHT_DOWN)
                        ) {

                    listA.add(i);
                    listB.add(j);

                    onStoneFg = true;
                }
            }

        }

        if (onStoneFg) {
            int rdm = random.nextInt(listA.size());

            rani = listA.get(rdm);
            ranj = listB.get(rdm);
            board.onStone(rani, ranj, new Stone(color));
        }

        return onStoneFg;
    }
}
