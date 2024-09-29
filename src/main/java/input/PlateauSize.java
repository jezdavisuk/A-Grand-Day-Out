package input;

import java.util.Random;

public class PlateauSize {

    private final int xDim; // x dimension
    private final int yDim; // y dimension

    public PlateauSize(int xDim, int yDim) {
        this.xDim = (xDim >= 20 && xDim <= 100) ? xDim : 50;
        this.yDim = (yDim >= 20 && yDim <= 100) ? yDim : 50;
    }

    public int getxDim() {
        return xDim;
    }

    public int getyDim() {
        return yDim;
    }
}
