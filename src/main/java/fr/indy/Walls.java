package fr.indy;

import java.awt.*;
import java.util.LinkedList;

import static fr.indy.Constants.PIXELS;

public class Walls {

    private final LinkedList<Case> rightWall;
    private final LinkedList<Case> leftWall;

    public Walls() {
        rightWall = new LinkedList<Case>();
        leftWall = new LinkedList<Case>();

        for (int i = 1; i <= 7; i++) {
            leftWall.add(new Case(5, i));
            rightWall.add(new Case(13, i));
        }
    }

    public void draw(Graphics graphics) {
        for (int i = 1; i < rightWall.size(); i++) {
            Case rightCase = rightWall.get(i);
            graphics.drawString(")", rightCase.getX(), rightCase.getY() - i * PIXELS);

            Case leftCase = leftWall.get(i);
            graphics.drawString("(", leftCase.getX(), leftCase.getY() - i * PIXELS);
        }
    }

    public void setRight(Case right) {
        rightWall.addFirst(right);
        rightWall.removeLast();
    }

    public void setLeft(Case left) {
        leftWall.addFirst(left);
        leftWall.removeLast();
    }

}
