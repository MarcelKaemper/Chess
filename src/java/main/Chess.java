package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Chess extends JPanel {

    public Chess() {

        setPreferredSize(new Dimension(430, 430));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("Click X: " + e.getX() + " Y: " + e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println("Release X: " + e.getX() + " Y: " + e.getY());
            }
        });

    }

    List<Cell> cells = new ArrayList<>();

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

    @Override
    protected void paintComponent(Graphics g) {
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
                if (cells.size() < 64) {
                    EnumColor color = g.getColor().toString().equals("DARK_GRAY") ? EnumColor.BLACK : EnumColor.WHITE;
                    Cell cell = new Cell(x, y, color, letters[j] + String.valueOf(8 - j));
                    cells.add(cell);
                }

                g.fillRect(x, y, 50, 50);
                g.setColor(Color.BLACK);
                g.drawChars(letters, j, 1, (25 * (j + 1) + (25 * j)) + 28, 420);
                x += 50;
            }
            y += 50;
            x = 30;
        }
        System.out.println(cells.get(0).getCoordinate());
        System.out.println(cells.get(0).getColor().toString());
        System.out.println("X: " + cells.get(0).getPos_x());
        System.out.println("Y: " + cells.get(0).getPos_y());
    }
}
