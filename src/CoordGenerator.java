package src;
import java.util.Random;
import java.util.HashMap;

public class CoordGenerator {
    private HashMap<Integer, Integer> x;
    private HashMap<Integer, Integer> y;
    private int rangeX;
    private int rangeY;

    /**
     * Creates a new CoordGenerator Class
     * @param rangeX x range of map
     * @param rangeY y range of map
     */
    public CoordGenerator(int rangeX, int rangeY) {
        Random rd = new Random();
        x = new HashMap<>();
        y = new HashMap<>();
        this.rangeX = rangeX;
        this.rangeY = rangeY;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int xCoord = rd.nextInt(rangeX);
            int yCoord = rd.nextInt(rangeY);
            while (x.containsValue(xCoord) || x.containsValue(xCoord + 15)
                    || x.containsValue(xCoord - 15)) {
                xCoord = rd.nextInt(rangeX);
            }
            while (y.containsValue(yCoord) || y.containsValue(yCoord + 15)
                    || y.containsValue(yCoord - 15)) {
                yCoord = rd.nextInt(rangeY) + 100;
            }
            x.put(count, xCoord);
            y.put(count, yCoord);
            count++;
        }

    }

    /**
     * Gets x.
     *
     * @return Value of x.
     */
    public HashMap<Integer, Integer> getX() {
        return x;
    }

    /**
     * Gets y.
     *
     * @return Value of y.
     */
    public HashMap<Integer, Integer> getY() {
        return y;
    }
}
