package pieces;

import main.Cell;
import main.EnumColor;

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
