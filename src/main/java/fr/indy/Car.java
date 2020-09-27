package fr.indy;

import java.awt.*;

import static fr.indy.Constants.PIXELS;

public class Car {

    private Case carPosition;

    public Car() {
        carPosition = new Case(9, 5);
    }

    public void draw(Graphics graphics) {
        graphics.drawString("W", carPosition.getX(), carPosition.getY());
        graphics.drawString("'", carPosition.getX(), carPosition.getY() - PIXELS);
    }

    public void setCar(Case carPosition) {
        this.carPosition = carPosition;
    }

}
