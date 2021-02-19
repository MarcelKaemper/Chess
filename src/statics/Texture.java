package statics;

import main.Chess;

import java.net.URL;

public class Texture {

    public static final URL pawn_white = Chess.class.getClassLoader().getResource("textures/white_pawn.png");
    public static final URL pawn_black = Chess.class.getClassLoader().getResource("textures/black_pawn.png");

    public static final URL rook_white = Chess.class.getClassLoader().getResource("textures/white_rook.png");
    public static final URL rook_black = Chess.class.getClassLoader().getResource("textures/black_rook.png");

    public static final URL queen_white = Chess.class.getClassLoader().getResource("textures/white_queen.png");
    public static final URL queen_black = Chess.class.getClassLoader().getResource("textures/black_queen.png");

    public static final URL bishop_white = Chess.class.getClassLoader().getResource("textures/white_bishop.png");
    public static final URL bishop_black = Chess.class.getClassLoader().getResource("textures/black_bishop.png");

    public static final URL knight_white = Chess.class.getClassLoader().getResource("textures/white_knight.png");
    public static final URL knight_black = Chess.class.getClassLoader().getResource("textures/black_knight.png");

    public static final URL king_white = Chess.class.getClassLoader().getResource("textures/white_king.png");
    public static final URL king_black = Chess.class.getClassLoader().getResource("textures/black_king.png");

}
