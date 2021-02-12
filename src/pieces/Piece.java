package pieces;

import main.Cell;
import main.EnumColor;

import java.net.URL;

public abstract class Piece implements IMovement {

    private URL texture;
    private Cell position;
    private Boolean hasMoved;
    private EnumColor color;

    public Piece(URL texture, Cell position, Boolean hasMoved, EnumColor color) {
        setTexture(texture);
        setPosition(position);
        setHasMoved(hasMoved);
        setColor(color);
    }

    public abstract void move();

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

    private void setPosition(Cell position) {
        this.position = position;
    }

    public Boolean getHasMoved() {
        return hasMoved;
    }

    private void setHasMoved(Boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

}
