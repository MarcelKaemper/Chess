package main;

import pieces.*;
import statics.Texture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Chess extends JPanel {

    private static String pressed_on = "";
    private static String released_on = "";

    public Chess() {

        setPreferredSize(new Dimension(430, 430));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                String coordinate = Cell.getCellCoordinate(e.getX(), e.getY());
                System.out.println("Coordinated clicked: " + coordinate);
                pressed_on = coordinate;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                String coordinate = Cell.getCellCoordinate(e.getX(), e.getY());
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
    }

    private void processMouseDrag() {
        if (!pressed_on.equals(released_on)) {
            Piece pieceToMove = Cell.getPieceByPos(pressed_on);
            if (pieceToMove != null) {
                Cell moveTo = Cell.getCellByPos(released_on);
                pieceToMove.move(moveTo);
                repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

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
                if (Cell.cells.size() < 64) {
                    EnumColor color = g.getColor().toString().equals("DARK_GRAY") ? EnumColor.BLACK : EnumColor.WHITE;
                    Cell cell = new Cell(x, y, color, letters[j], (8 - i), rect, null);

                    // Pawn
                    if (8 - i == 2) {
                        Piece p = new Pawn(Texture.pawn_white, cell, false, EnumColor.WHITE, EnumPiece.PAWN, false, false);
                        cell.setPiece(p);
                    } else if (8 - i == 7) {
                        Piece p = new Pawn(Texture.pawn_black, cell, false, EnumColor.BLACK, EnumPiece.PAWN, false, false);
                        cell.setPiece(p);
                    }

                    // Rook
                    if (8 - i == 1 && (letters[j] == 'a' || letters[j] == 'h')) {
                        Piece p = new Rook(Texture.rook_white, cell, false, EnumColor.WHITE, EnumPiece.ROOK);
                        cell.setPiece(p);
                    } else if (8 - i == 8 && (letters[j] == 'a' || letters[j] == 'h')) {
                        Piece p = new Rook(Texture.rook_black, cell, false, EnumColor.BLACK, EnumPiece.ROOK);
                        cell.setPiece(p);
                    }

                    // Queen
                    if (8 - i == 1 && (letters[j] == 'd')) {
                        Piece p = new Queen(Texture.queen_white, cell, false, EnumColor.WHITE, EnumPiece.QUEEN);
                        cell.setPiece(p);
                    } else if (8 - i == 8 && (letters[j] == 'd')) {
                        Piece p = new Queen(Texture.queen_black, cell, false, EnumColor.BLACK, EnumPiece.QUEEN);
                        cell.setPiece(p);
                    }

                    // Bishop
                    if (8 - i == 1 && (letters[j] == 'c' || letters[j] == 'f')) {
                        Piece p = new Bishop(Texture.bishop_white, cell, false, EnumColor.WHITE, EnumPiece.BISHOP);
                        cell.setPiece(p);
                    } else if (8 - i == 8 && (letters[j] == 'c' || letters[j] == 'f')) {
                        Piece p = new Bishop(Texture.bishop_black, cell, false, EnumColor.BLACK, EnumPiece.BISHOP);
                        cell.setPiece(p);
                    }

                    // Knight
                    if (8 - i == 1 && (letters[j] == 'b' || letters[j] == 'g')) {
                        Piece p = new Knight(Texture.knight_white, cell, false, EnumColor.WHITE, EnumPiece.KNIGHT);
                        cell.setPiece(p);
                    } else if (8 - i == 8 && (letters[j] == 'b' || letters[j] == 'g')) {
                        Piece p = new Knight(Texture.knight_black, cell, false, EnumColor.BLACK, EnumPiece.KNIGHT);
                        cell.setPiece(p);
                    }

                    // King
                    if (8 - i == 1 && letters[j] == 'e') {
                        Piece p = new King(Texture.king_white, cell, false, EnumColor.WHITE, EnumPiece.KING);
                        cell.setPiece(p);
                    } else if (8 - i == 8 && letters[j] == 'e') {
                        Piece p = new King(Texture.king_black, cell, false, EnumColor.BLACK, EnumPiece.KING);
                        cell.setPiece(p);
                    }
                }
                g.setColor(Color.BLACK);
                g.drawChars(letters, j, 1, (25 * (j + 1) + (25 * j)) + 28, 420);
                x += 50;
            }
            y += 50;
            x = 30;
        }


        // Draw pieces if cells initialized
        if (Cell.cells.size() >= 64) {
            for (Cell cell : Cell.cells) {
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

    }

}
