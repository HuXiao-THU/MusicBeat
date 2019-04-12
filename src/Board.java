import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

public class Board extends JFrame {

    public Board() {

    }

    private long startTime;
    private ArrayList<Note> allNotes = new ArrayList<>();

    public void addNoteToDraw(Note note) {
        allNotes.add(note);
        allNotes.sort(Note::compareTo);
    }

    private void drawNote(Graphics g, Note n) {
        int height = n.getLength() / 5;

        int x0 = (n.getTrack() - 1) * 80;
        int y0 = (int) (getRelativeTime() / 5 + 600 - (n.getHitTime() / 5) - height);
        g.fillRect(x0, y0, 80, height);
        System.out.println(x0 + " " + y0 + " " + 80 + " " + height);

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.BLACK);
//        super.paintComponents(g);
//        super.paint(g);
//        g.fillRect(10,10,100,100);
        for (Note n : allNotes) {
            drawNote(g, n);
        }
    }

    public void update() {
        this.repaint();
    }

    private long getStartTime() {
        return startTime;
    }

    private long getRelativeTime() {
        return currentTimeMillis() - getStartTime();
    }

    public void init() {
        startTime = currentTimeMillis();
    }

    public void startUpdate() {
        this.init();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    update();
//                    System.out.println(getRelativeTime());
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {

                    }
                }
            }
        });
        t.start();
    }

}
