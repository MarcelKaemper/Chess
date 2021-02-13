package pieces;

import main.Cell;
import main.EnumColor;

import java.net.URL;

public class Pawn extends Piece {

    public Pawn(URL texture, Cell position, Boolean hasMoved, EnumColor color) {
        super(texture, position, hasMoved, color);
    }

    @Override
    public boolean validMove(Cell toPosition) {
        System.out.println("checking validity of move");
        return true;
    }

}
