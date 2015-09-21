package bolls;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by panasyuk on 20.09.2015.
 */
public class FlyBalls extends JPanel {
    public static void main(String[] args) throws Exception {
        new FlyBalls();

    }

    private static final int WIGHT = 400;
    private static final Color[] colors = new Color[]{
            Color.blue,
            Color.green,
            Color.BLACK,
            Color.RED,
            Color.cyan,
            Color.GRAY,
            Color.magenta,
            Color.yellow,
            Color.gray,
            Color.PINK

    };

    private List<Ball> ballList;

    public FlyBalls() throws Exception {
        ballList = new ArrayList<>();
        JFrame frame = new JFrame("Balls");
        frame.setLocation(450, 50);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = makePanel();


        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        creatBalls();
        actions();

    }


    public JPanel makePanel() {
        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < ballList.size(); i++) {
                    g.setColor(ballList.get(i).getColor());
                    g.fillOval(ballList.get(i).getX(), ballList.get(i).getY(), 20, 20);
                }

                try {
                    Thread.sleep(17);
                    repaint();
                } catch (InterruptedException ex) {

                }
            }
        };

        return panel;
    }


    public void creatBalls() {
        int startY = 0;
        int spied = 3;
        for (int i = 0; i < colors.length; i++) {
            Ball ball = new Ball(0, startY, spied, colors[ballList.size()]);
            ballList.add(ball);
            startY += 35;
            spied += 1;
        }


    }


    public void actions() throws Exception {

        for (int i = 0; i < ballList.size(); i++) {
            new Thread(new Flying(this, ballList.get(i))).start();
        }
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public void setBallList(List<Ball> ballList) {
        this.ballList = ballList;
    }

    public static Color[] getColors() {
        return colors;
    }

    public static int getWIGHT() {
        return WIGHT;
    }
}
