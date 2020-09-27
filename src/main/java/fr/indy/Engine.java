package fr.indy;

import java.awt.*;
import java.awt.event.KeyEvent;

import static fr.indy.Constants.PIXELS;

public class Engine {

    private int leftWallPos = 5;
    private int carPosition = 9;
    private int sizeOfRoad = 8;
    private int shrinkRoad = 0;
    private int limit = 5;
    private int score = 0;

    private boolean loser;
    private boolean winner;

    private final Walls walls;
    private final Car car;

    public Engine() {
        walls = new Walls();
        car = new Car();
    }

    public void compute(Graphics graphics) {

        limit = leftWallPos;

        leftWallPos = leftWallPos + getRandomNumber(-2, 2);

        if (leftWallPos < 3) {
            leftWallPos = 3;
        }

        if (leftWallPos + sizeOfRoad > 14) {
            leftWallPos = 14 - sizeOfRoad;
        }

        car.setCar(new Case(carPosition, 5));
        car.draw(graphics);

        walls.setLeft(new Case(leftWallPos, 8));
        walls.setRight(new Case(leftWallPos + sizeOfRoad, 8));
        walls.draw(graphics);

        shrinkRoad = shrinkRoad + 1;
        score = score + 10;

        if (shrinkRoad == 20) {
            sizeOfRoad = sizeOfRoad - 1;
            shrinkRoad = 0;
        }

        // Score
        graphics.drawString(String.valueOf(score), PIXELS, PIXELS);

        // Winner ! End of game
        if (sizeOfRoad == 0) {
            winner = true;

            graphics.drawString("You Win !!!!", 5 * PIXELS, 9 * PIXELS);

            // Stop game
            carPosition = limit - 2;
        }

        if (loser) {
            graphics.drawString("You lose !!!!", 5 * PIXELS, 9 * PIXELS);
        }
    }

    public void keyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            carPosition = carPosition + 1;
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            carPosition = carPosition - 1;
        }
    }

    public int getRandomNumber(double low, double high) {
        return (int) (low + Math.random() * (high - low));
    }

    public boolean isGameOver() {
        return carPosition <= limit || carPosition >= limit + sizeOfRoad;
    }

    public void setLoser(boolean loser) {
        this.loser = loser;
    }

    public boolean getWinner() {
        return winner;
    }

}
