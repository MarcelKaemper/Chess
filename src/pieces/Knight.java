package pieces;

import main.Cell;
import main.EnumColor;

import java.net.URL;

public class Knight extends Piece {

    public Knight(URL texture, Cell position, boolean hasMoved, EnumColor color, EnumPiece pieceType) {
        super(texture, position, hasMoved, color, pieceType);
    }

    @Override
    public boolean validMove(Cell toPosition) {
        int coordDeltaY = getPosition().getCoord_y() - toPosition.getCoord_y();
        int coordDeltaX = getPosition().getCoord_x() - toPosition.getCoord_x();

        if (coordDeltaY < 0) {
            coordDeltaY *= -1;
        }

        if (coordDeltaX < 0) {
            coordDeltaX *= -1;
        }

        if ((coordDeltaX == 2 && coordDeltaY == 1) || (coordDeltaX == 1 && coordDeltaY == 2)) {
            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() == getColor()) {
                return false;
            }

            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() != getColor()) {
                return true;
            }

            return true;
        }

        return false;
    }

}
