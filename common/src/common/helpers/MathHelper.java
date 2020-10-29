package common.helpers;

public class MathHelper {
    public static final double E = 2.71d;
    public static final double PI = 3.14d;

    public static int square(int val) {
        return val * val;
    }

    public static int cubed(int val) {
        return val * val * val;
    }

    public static int areaOfRectangle(int length, int width) {
       return length * width;
    }

    public static int perimeterOfRectangle(int length, int width) {
        return 2 * (length + width);
    }
}
