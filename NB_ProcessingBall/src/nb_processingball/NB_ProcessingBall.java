/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb_processingball;

import processing.core.PApplet;

/**
 *
 * @author scuola
 */
public class NB_ProcessingBall extends PApplet {

    static DatiCondivisi datiC; // dati condivisi
    static ThBall[] thBalls;    // vettore con i threads
    static int numBalls;        // numero di balls e di thread

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        numBalls = 2;
        datiC = new DatiCondivisi(numBalls);
        thBalls = new ThBall[numBalls];
        for (int i = 0; i < thBalls.length; i++) {
            thBalls[i] = new ThBall(datiC, i);
        }

        PApplet.main(new String[]{"nb_processingball.NB_ProcessingBall"});

        SwingGui swingGui = new SwingGui(datiC);
        // shows Swing windows
        swingGui.show();
    }

    public void settings() {
        size(640, 360);
        datiC.setScreen(width, height);
        for (int i = 0; i < thBalls.length; i++) {
            thBalls[i].start();
        }
    }

    public void setup() {
        noStroke();
        frameRate(30);
        ellipseMode(RADIUS);
    }

    public void draw() {
        if (!datiC.isRunning()) {
            exit();
        }

        // clean the screen
        background(datiC.getRed(), datiC.getGreen(), datiC.getBlue());

        // display all "balls"
        for (int i = 0; i < datiC.numBalls(); i++) {
            display(datiC.getBalls(i));
        }
    }

// Draw ball
    void display(Ball ball) {
        // set the color of the ball
        fill(color(240, 0, 0));
        noStroke();

        // Draw the ball
        ellipse(ball.getXpos(), ball.getYpos(), ball.getRad(), ball.getRad());
    }
}
