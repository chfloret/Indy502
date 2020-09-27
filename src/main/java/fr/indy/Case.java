package fr.indy;

import static fr.indy.Constants.PIXELS;

public class Case {

    private final int xIndex;
    private final int yIndex;

    public Case(int xIndex, int yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public int getX() {
        return xIndex * PIXELS;
    }

    public int getY() {
        return yIndex * PIXELS;
    }

}
