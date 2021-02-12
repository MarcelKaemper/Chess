package pieces;


import main.Cell;
import main.EnumColor;

public abstract class Piece implements IMovement {

    private String texture;
    private Cell position;
    private Boolean hasMoved;
    private EnumColor color;

    public abstract void move();

    public abstract boolean validMove(Cell toPosition);


    public EnumColor getColor() {
        return color;
    }

    public void setColor(EnumColor color) {
        this.color = color;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public Boolean getHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(Boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
