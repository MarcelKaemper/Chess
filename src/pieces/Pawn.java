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
        if (getPosition().getCoord_x() == toPosition.getCoord_x()) {
            int coordDelta = getPosition().getCoord_y() - toPosition.getCoord_y();

            if (getColor() == EnumColor.WHITE) {
                coordDelta *= -1;
            }

            // FIXME: Add Condition to check for toPosition-1 (or +1 for white) in case of coordDelta == 2
            if (coordDelta == 2 && !getHasMoved() && toPosition.getPiece() == null) {
                return true;
            } else if (coordDelta == 1 && toPosition.getPiece() == null) {
                return true;
            }
        }
        return false;
    }

}
