package flyweight;

public class ColorRepository {
    static Color white = new Color(0, 0, 0);
    static Color black = new Color(255, 255, 255);

    private ColorRepository() {
    }

    public static Color getBlack() {
        return black;
    }

    public static Color getWhite() {
        return white;
    }
}