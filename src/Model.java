import java.util.Random;

public class Model {

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    private  Board board;

    public  void init(){
        //generate 32 random notes
        Random random = new Random(10000);
        for (int i = 0; i < 32; i++) {
            int track = random.nextInt(9);
            Note n = new Note(i*300+3000,track, 1000);
            board.addNoteToDraw(n);
        }
    }

    public  void start(){

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                while (true) {
//                    update();
////                    System.out.println();
//                    try {
//                        Thread.sleep(10);
//                    } catch (Exception e) {
//
//                    }
//                }
            }
        });
        t.start();


    }

    public void update(){

    }

}
