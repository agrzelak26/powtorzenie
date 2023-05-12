import java.util.Locale;

public class Polygon {
    private Point[] arr;
    private Style style;

    public Polygon(int count, Style style) {
        this.style = style;
        arr = new Point[count];
    }
    public Polygon(int count){
        arr = new Point[count];
    }

    public void setPoint(int index, Point point) {
        arr[index] = point;
    }

    public void setPoints(Point[] points){
        arr = points;
    }

    public String toSvg() {
        String pointsString = "";
        for(Point point : arr)
            pointsString += point.x + "," + point.y + " ";

        return String.format(Locale.ENGLISH,"<polygon points=\"%s\" />",
                pointsString);
    }
}