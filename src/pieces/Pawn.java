package pieces;

import main.Cell;
import main.EnumColor;

import java.net.URL;

public class Pawn extends Piece {

    private boolean doubleMoved;
    private boolean enPassant;

    public Pawn(URL texture, Cell position, boolean hasMoved, EnumColor color, EnumPiece pieceType, boolean doubleMoved, boolean enPassant) {
        super(texture, position, hasMoved, color, pieceType);
        setDoubleMoved(doubleMoved);
        setEnPassant(enPassant);
    }

    @Override
    public boolean validMove(Cell toPosition) {
        int coordDeltaY = getPosition().getCoord_y() - toPosition.getCoord_y();
        int coordDeltaX = getPosition().getCoord_x() - toPosition.getCoord_x();

        if (getColor() == EnumColor.WHITE) {
            coordDeltaY *= -1;
        }

        if (coordDeltaX < 0) {
            coordDeltaX *= -1;
        }

        if (coordDeltaX == 0) {
            if (coordDeltaY == 2 && !getHasMoved() && toPosition.getPiece() == null) {
                Cell cell;
                if (getColor() == EnumColor.WHITE) {
                    cell = Cell.getCellByCoords(toPosition.getCoord_x(), toPosition.getCoord_y() - 1);
                } else {
                    cell = Cell.getCellByCoords(toPosition.getCoord_x(), toPosition.getCoord_y() + 1);
                }

                if (cell.getPiece() == null) {
                    setDoubleMoved(true);

                    Cell left = Cell.getCellByCoords((char) (toPosition.getCoord_x() - 1), toPosition.getCoord_y());
                    Cell right = Cell.getCellByCoords((char) (toPosition.getCoord_x() + 1), toPosition.getCoord_y());

                    if (left.getPiece() != null && left.getPiece().getPieceType() == EnumPiece.PAWN) {
                        setEnPassant(true);
                        Piece leftPiece = left.getPiece();
                        ((Pawn) leftPiece).setEnPassant(true);
                    }

                    if (right.getPiece() != null && right.getPiece().getPieceType() == EnumPiece.PAWN) {
                        setEnPassant(true);
                        Piece rightPiece = right.getPiece();
                        ((Pawn) rightPiece).setEnPassant(true);
                    }

                    return true;
                }
            } else if (coordDeltaY == 1 && toPosition.getPiece() == null) {
                if (isDoubleMoved()) {
                    setDoubleMoved(false);
                }
                if (isEnPassant()) {
                    setEnPassant(false);
                }
                return true;
            }
        } else if (coordDeltaX == 1 && coordDeltaY == 1) {
            Cell cell = Cell.getCellByCoords(toPosition.getCoord_x(), toPosition.getCoord_y());
            if (cell.getPiece() != null && cell.getPiece().getColor() != getColor()) {
                if (isDoubleMoved()) {
                    setDoubleMoved(false);
                }
                if (isEnPassant()) {
                    setEnPassant(false);
                }
                return true;
            } else if (cell.getPiece() == null) {
                Cell cellBottom = Cell.getCellByCoords(toPosition.getCoord_x(), toPosition.getCoord_y() - 1);
                if (cellBottom.getPiece() != null && cellBottom.getPiece().getPieceType() == EnumPiece.PAWN && cellBottom.getPiece().getColor() != getColor() && ((Pawn) cellBottom.getPiece()).isDoubleMoved() && ((Pawn) cellBottom.getPiece()).isEnPassant() && isEnPassant()) {
                    cellBottom.setPiece(null);
                    if (isDoubleMoved()) {
                        setDoubleMoved(false);
                    }
                    if (isEnPassant()) {
                        setEnPassant(false);
                    }
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isDoubleMoved() {
        return doubleMoved;
    }

    private void setDoubleMoved(boolean doubleMoved) {
        this.doubleMoved = doubleMoved;
    }

    public boolean isEnPassant() {
        return enPassant;
    }

    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }

}
