package src;
import java.util.Random;
import java.util.HashMap;

public class CoordGenerator {
    private HashMap<Integer, Integer> x;
    private HashMap<Integer, Integer> y;
    private int range;

    /**
     * Creates a new CoordGenerator Class
     * @param range range of map
     */
    public CoordGenerator(int range) {
        Random rd = new Random();
        x = new HashMap<>();
        y = new HashMap<>();
        this.range = range;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int xCoord = rd.nextInt(range);
            int yCoord = rd.nextInt(range);
            while (x.containsValue(xCoord) || x.containsValue(xCoord + 5) || x.containsValue(xCoord - 5)) {
                xCoord = rd.nextInt(range);
            }
            x.put(count, xCoord);
            y.put(count, yCoord);
            count ++;
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
