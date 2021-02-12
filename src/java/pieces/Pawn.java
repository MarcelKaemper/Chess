package pieces;

import main.Cell;

public class Pawn extends Piece {
    @Override
    public boolean validMove() {
        return false;
    }

    @Override
    public void move() {

    }

    @Override
    public boolean validMove(Cell toPosition) {
        return false;
    }
}
