package pieces;

import main.Cell;
import main.EnumColor;
import statics.Texture;

import java.net.URL;

public abstract class Piece implements IMovement {

    private URL texture;
    private Cell position;
    private boolean hasMoved;
    private EnumColor color;
    private EnumPiece pieceType;

    public Piece(URL texture, Cell position, boolean hasMoved, EnumColor color, EnumPiece pieceType) {
        setTexture(texture);
        setPosition(position);
        setHasMoved(hasMoved);
        setColor(color);
        setPieceType(pieceType);
    }

    public void move(Cell toPosition) {
        if (toPosition != null && validMove(toPosition)) {
            setHasMoved(true);
            System.out.println("Move is valid");
            getPosition().setPiece(null);
            setPosition(toPosition);
            toPosition.setPiece(this);
        } else {
            System.out.println("Move is invalid");
        }
    }

    public abstract boolean validMove(Cell toPosition);

    public static void createInitPiece(Cell cell, int i, int j, char[] letters) {
        // Pawn
        if (8 - i == 2) {
            Piece p = new Pawn(Texture.pawn_white, cell, false, EnumColor.WHITE, EnumPiece.PAWN, false, false);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        } else if (8 - i == 7) {
            Piece p = new Pawn(Texture.pawn_black, cell, false, EnumColor.BLACK, EnumPiece.PAWN, false, false);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        }

        // Rook
        if (8 - i == 1 && (letters[j] == 'a' || letters[j] == 'h')) {
            Piece p = new Rook(Texture.rook_white, cell, false, EnumColor.WHITE, EnumPiece.ROOK);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        } else if (8 - i == 8 && (letters[j] == 'a' || letters[j] == 'h')) {
            Piece p = new Rook(Texture.rook_black, cell, false, EnumColor.BLACK, EnumPiece.ROOK);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        }

        // Queen
        if (8 - i == 1 && (letters[j] == 'd')) {
            Piece p = new Queen(Texture.queen_white, cell, false, EnumColor.WHITE, EnumPiece.QUEEN);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        } else if (8 - i == 8 && (letters[j] == 'd')) {
            Piece p = new Queen(Texture.queen_black, cell, false, EnumColor.BLACK, EnumPiece.QUEEN);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        }

        // Bishop
        if (8 - i == 1 && (letters[j] == 'c' || letters[j] == 'f')) {
            Piece p = new Bishop(Texture.bishop_white, cell, false, EnumColor.WHITE, EnumPiece.BISHOP);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        } else if (8 - i == 8 && (letters[j] == 'c' || letters[j] == 'f')) {
            Piece p = new Bishop(Texture.bishop_black, cell, false, EnumColor.BLACK, EnumPiece.BISHOP);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        }

        // Knight
        if (8 - i == 1 && (letters[j] == 'b' || letters[j] == 'g')) {
            Piece p = new Knight(Texture.knight_white, cell, false, EnumColor.WHITE, EnumPiece.KNIGHT);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        } else if (8 - i == 8 && (letters[j] == 'b' || letters[j] == 'g')) {
            Piece p = new Knight(Texture.knight_black, cell, false, EnumColor.BLACK, EnumPiece.KNIGHT);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        }

        // King
        if (8 - i == 1 && letters[j] == 'e') {
            Piece p = new King(Texture.king_white, cell, false, EnumColor.WHITE, EnumPiece.KING);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        } else if (8 - i == 8 && letters[j] == 'e') {
            Piece p = new King(Texture.king_black, cell, false, EnumColor.BLACK, EnumPiece.KING);
            cell.setPiece(p);
            cell.getPiece().setPosition(cell);
        }
    }

    public EnumColor getColor() {
        return color;
    }

    private void setColor(EnumColor color) {
        this.color = color;
    }

    public URL getTexture() {
        return texture;
    }

    private void setTexture(URL texture) {
        this.texture = texture;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    private void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public EnumPiece getPieceType() {
        return pieceType;
    }

    private void setPieceType(EnumPiece pieceType) {
        this.pieceType = pieceType;
    }

}
