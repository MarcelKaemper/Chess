package main;

import pieces.Pawn;
import pieces.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Chess extends JPanel {

    private static final List<Cell> cells = new ArrayList<>();
    private static URL pawn_white;
    private static URL pawn_black;

    private static String pressed_on = "";
    private static String released_on = "";

    public Chess() {

        setPreferredSize(new Dimension(430, 430));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String coordinate = getCellCoordinate(e.getX(), e.getY());
                System.out.println("Coordinated clicked: " + coordinate);
                pressed_on = coordinate;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                String coordinate = getCellCoordinate(e.getX(), e.getY());
                System.out.println("Coordinated released: " + coordinate);
                released_on = coordinate;
                processMouseDrag();
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Chess());
            frame.setResizable(false);
            frame.pack();

            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });
        pawn_white = Chess.class.getClassLoader().getResource("textures/white_pawn.png");
        pawn_black = Chess.class.getClassLoader().getResource("textures/black_pawn.png");
    }

    private void processMouseDrag() {
        if (!pressed_on.equals(released_on)) {
            System.out.println("Processing move");
            Piece pieceToMove = getPieceByCoordinate(pressed_on);
            if (pieceToMove != null) {
                System.out.println("Piece found on cell");
                System.out.println(pieceToMove.toString());
                Cell moveTo = getCellByCoordinate(released_on);
                pieceToMove.move(moveTo);
                repaint();
            } else {
                System.out.println("No piece on cell");
            }
            // piece.move() ----> validMove()
        } else {
            System.out.println("Pressed on equals released on. Not processing action.");
        }
    }

    private void addPieces() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        System.out.println(cells.size());

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        // Draw chessboard
        int x = 30;
        int y = 0;
        int number = 8;
        for (int i = 0; i < 8; i++) {
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(number), 10, (25 * (i + 1) + (25 * i)) + 4);
            number--;
            for (int j = 0; j < 8; j++) {
                if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        g.setColor(Color.DARK_GRAY);
                    } else {
                        g.setColor(Color.LIGHT_GRAY);
                    }
                } else {
                    if (j % 2 == 0) {
                        g.setColor(Color.LIGHT_GRAY);
                    } else {
                        g.setColor(Color.DARK_GRAY);
                    }
                }
                Shape rect = new Rectangle(x, y, 50, 50);
                g2d.fill(rect);
                // Initialize cells array / create cells
                if (cells.size() < 64) {
                    EnumColor color = g.getColor().toString().equals("DARK_GRAY") ? EnumColor.BLACK : EnumColor.WHITE;
                    Cell cell = new Cell(x, y, color, letters[j] + String.valueOf(8 - i), rect, null);
                    cells.add(cell);
                    if (8 - i == 2) {
                        Piece p = new Pawn(pawn_white, cell, false, EnumColor.WHITE);
                        cell.setPiece(p);
                    }else if(8 - i == 7){
                        Piece p = new Pawn(pawn_black, cell, false, EnumColor.BLACK);
                        cell.setPiece(p);
                    }
                }
                /*if (8 - i == 7 || 8 - i == 2) {
                    Cell cell = getCellByCoordinate(letters[j] + String.valueOf(8 - i));
                    Pawn p = new Pawn(pawn_t, cell, false, EnumColor.WHITE);
                    cell.setPiece(p);


                    try {
                        g2d.drawImage(ImageIO.read(p.getTexture()), x - 6, y - 6, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } */
                g.setColor(Color.BLACK);
                g.drawChars(letters, j, 1, (25 * (j + 1) + (25 * j)) + 28, 420);
                x += 50;
            }
            y += 50;
            x = 30;
        }


        // Draw pieces if cells initialized
        if (cells.size() >= 64) {
            for (Cell cell : cells) {
                Piece p = cell.getPiece();
                int cell_x = cell.getPos_x();
                int cell_y = cell.getPos_y();
                // If piece on cell
                if (p != null) {
                    try {
                        g2d.drawImage(ImageIO.read(p.getTexture()), cell_x - 6, cell_y - 6, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(cells.get(0).getCoordinate());
        System.out.println(cells.get(0).getColor().toString());
        System.out.println("X: " + cells.get(0).getPos_x());
        System.out.println("Y: " + cells.get(0).getPos_y());
    }

    private String getCellCoordinate(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getRect().contains(x, y)) {
                return cell.getCoordinate();
            }
        }
        return "";
    }

    private Cell getCellByCoordinate(String coordinate) {
        for (Cell cell : cells) {
            if (cell.getCoordinate().equals(coordinate)) {
                return cell;
            }
        }
        return null;
    }


    private Cell getCell(int x, int y) {
        for (Cell cell : cells) {
            if (cell.getRect().contains(x, y)) {
                return cell;
            }
        }
        return null;
    }

    private Piece getPieceByCoordinate(String coordinate) {
        for (Cell cell : cells) {
            if (cell.getCoordinate().equals(coordinate)) {
                return cell.getPiece();
            }
        }
        return null;
    }

}
