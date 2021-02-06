package dev.marcelkaemper.chess;

import java.awt.*;
import javax.swing.*;

public class Chess extends Canvas{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
        Canvas canvas = new Chess();
        canvas.setSize(430, 430);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void paint(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 430, 430);
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        // Draw chessboard
        int x = 30;
        int y = 0;
        int number = 8;
        for (int i = 0; i<8; i++) {
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(number), 10, (25*(i+1)+(25*i))+4);
            number--;
            for (int j = 0; j < 8; j++) {
                if(i % 2 != 0) {
                    if(j % 2 == 0) { g.setColor(Color.DARK_GRAY); }
                    else { g.setColor(Color.LIGHT_GRAY); }
                } else {
                    if(j % 2 == 0) { g.setColor(Color.LIGHT_GRAY); }
                    else { g.setColor(Color.DARK_GRAY); }
                }
                g.fillRect(x, y, 50, 50);
                g.setColor(Color.BLACK);
                g.drawChars(letters, j,1,(25*(j+1)+(25*j))+28, 420);
                x += 50;
            }
            y += 50;
            x = 30;
        }

        //g.setFont(Font.getFont(Font.SERIF));

    }
}
