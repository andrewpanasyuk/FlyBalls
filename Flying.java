package bolls;

import javax.swing.*;

/**
 * Created by panasyuk on 20.09.2015.
 */
public class Flying extends JPanel implements Runnable {
    private FlyBalls flyBalls;
    private Ball ball;
    private int speed=1;



    public Flying(FlyBalls flyBalls, Ball ball) {

        this.flyBalls = flyBalls;
        this.ball = ball;

    }

    @Override

    public void run() {
        System.out.println(Thread.currentThread().getName());
        int c = 0;
        int count = 0;
        while (true) {
            if (c < FlyBalls.getWIGHT()-20 && count == 0) {
                c++;
            } else {
                count = 1;
                c--;
                if (c == 0) {
                    count = 0;
                }
            }
            ball.setX(c);
            try {
                Thread.sleep(ball.getV());
                repaint();
            } catch (InterruptedException ex) {
            }
        }
    }

}

