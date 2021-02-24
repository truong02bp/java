package point;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public MyPoint(MyPoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double distance(MyPoint secondPoint){
        double x = this.x - secondPoint.getX();
        double y = this.y - secondPoint.getY();
        return Math.sqrt(x*x + y*y);
    }
    public static double distance(MyPoint firstPoint , MyPoint secondPoint){
        double x = firstPoint.getX() - secondPoint.getX();
        double y = firstPoint.getY() - secondPoint.getY();
        return Math.sqrt(x*x + y*y);
    }
}
