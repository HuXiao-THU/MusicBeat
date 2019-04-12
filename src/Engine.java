import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Engine {

    public static void main(String[] args) {
        Board board = new Board();
        board.setVisible(true);
        board.setSize(new Dimension(800, 800));
//        MBPanel main_panel = new MBPanel();
//        board.setContentPane(main_panel);
//        main_panel.run();
        Model model = new Model();
        model.setBoard(board);
        model.init();
        model.start();
        board.startUpdate();
    }
}


