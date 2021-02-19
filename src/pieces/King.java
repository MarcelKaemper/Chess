package pieces;

import main.Cell;
import main.EnumColor;

import java.net.URL;

public class King extends Piece {

    public King(URL texture, Cell position, boolean hasMoved, EnumColor color, EnumPiece pieceType) {
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

        if (coordDeltaX == 0 && coordDeltaY == 1) {
            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() == getColor()) {
                return false;
            }

            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() != getColor()) {
                return true;
            }

            return true;
        } else if (coordDeltaX == 1 && coordDeltaY == 0) {
            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() == getColor()) {
                return false;
            }

            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() != getColor()) {
                return true;
            }

            return true;
        } else if (coordDeltaX == 1 && coordDeltaY == 1) {
            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() == getColor()) {
                return false;
            }

            if (toPosition.getPiece() != null && toPosition.getPiece().getColor() != getColor()) {
                return true;
            }

            return true;
        } else if ((coordDeltaX == 2 && coordDeltaY == 0) && !getHasMoved()) {
            Cell cellRook;
            if (toPosition.getCoord_x() >= getPosition().getCoord_x()) {
                cellRook = Cell.getCellByCoords((char) (toPosition.getCoord_x() + 1), toPosition.getCoord_y());
            } else {
                cellRook = Cell.getCellByCoords((char) (toPosition.getCoord_x() - 2), toPosition.getCoord_y());
            }

            if (cellRook.getPiece() != null) {
                if (cellRook.getPiece().getPieceType() != EnumPiece.ROOK && cellRook.getPiece().getColor() != getColor()) {
                    return false;
                } else if (cellRook.getPiece().getPieceType() == EnumPiece.ROOK && cellRook.getPiece().getColor() != getColor()) {
                    return false;
                } else if (cellRook.getPiece().getPieceType() != EnumPiece.ROOK && cellRook.getPiece().getColor() == getColor()) {
                    return false;
                } else if (cellRook.getPiece().getPieceType() == EnumPiece.ROOK && cellRook.getPiece().getColor() == getColor()) {
                    if (cellRook.getPiece().getHasMoved()) {
                        return false;
                    }
                }
            }

            for (int i = coordDeltaX - 1; i >= 0; i--) {
                Cell cell;
                if (toPosition.getCoord_x() >= getPosition().getCoord_x()) {
                    cell = Cell.getCellByCoords((char) (toPosition.getCoord_x() - i), toPosition.getCoord_y());
                } else {
                    cell = Cell.getCellByCoords((char) (toPosition.getCoord_x() + i), toPosition.getCoord_y());
                }

                if (cell.getPiece() != null) {
                    return false;
                }

                if (i == 0) {
                    if (toPosition.getCoord_x() < getPosition().getCoord_x()) {
                        Cell lastCell = Cell.getCellByCoords((char) (toPosition.getCoord_x() - 1), toPosition.getCoord_y());
                        if (lastCell.getPiece() != null) {
                            return false;
                        }
                    }

                    Piece tmpRook = cellRook.getPiece();
                    cellRook.setPiece(null);
                    Cell newRookPos;
                    if (toPosition.getCoord_x() < getPosition().getCoord_x()) {
                        newRookPos = Cell.getCellByCoords((char) (getPosition().getCoord_x() - 1), getPosition().getCoord_y());
                    } else {
                        newRookPos = Cell.getCellByCoords((char) (getPosition().getCoord_x() + 1), getPosition().getCoord_y());
                    }
                    tmpRook.setPosition(newRookPos);
                    newRookPos.setPiece(tmpRook);
                }
            }

            return true;
        }

        return false;
    }

}
