package pieces;

import main.Cell;
import main.EnumColor;

import java.net.URL;

public class Bishop extends Piece {

    public Bishop(URL texture, Cell position, boolean hasMoved, EnumColor color, EnumPiece pieceType) {
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

        if (coordDeltaX == coordDeltaY) {
            for (int i = coordDeltaX - 1; i >= 1; i--) {
                Cell cell;
                if (toPosition.getCoord_x() >= getPosition().getCoord_x() && toPosition.getCoord_y() >= getPosition().getCoord_y()) {
                    cell = Cell.getCellByCoords((char) (toPosition.getCoord_x() - i), toPosition.getCoord_y() - i);
                } else if (toPosition.getCoord_x() < getPosition().getCoord_x() && toPosition.getCoord_y() < getPosition().getCoord_y()) {
                    cell = Cell.getCellByCoords((char) (toPosition.getCoord_x() + i), toPosition.getCoord_y() + i);
                } else if (toPosition.getCoord_x() >= getPosition().getCoord_x() && toPosition.getCoord_y() < getPosition().getCoord_y()) {
                    cell = Cell.getCellByCoords((char) (toPosition.getCoord_x() - i), toPosition.getCoord_y() + i);
                } else if (toPosition.getCoord_x() < getPosition().getCoord_x() && toPosition.getCoord_y() >= getPosition().getCoord_y()) {
                    cell = Cell.getCellByCoords((char) (toPosition.getCoord_x() + i), toPosition.getCoord_y() - i);
                } else {
                    cell = null;
                }

                if (cell.getPiece() != null) {
                    return false;
                }
            }

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
