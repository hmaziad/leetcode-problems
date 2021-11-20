package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RectangleArea {
    public static void main(String[] args) {

//        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(computeArea(-2, -2, 2, 2, -1, 4, 1, 6));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        var pax1 = new Point('a', ax1);
        var pay1 = new Point('a', ay1);
        var pax2 = new Point('a', ax2);
        var pay2 = new Point('a', ay2);
        var pbx1 = new Point('b', bx1);
        var pby1 = new Point('b', by1);
        var pbx2 = new Point('b', bx2);
        var pby2 = new Point('b', by2);

        List<Point> xCoordinates = new ArrayList<>();
        List<Point> yCoordinates = new ArrayList<>();

        xCoordinates.add(pax1);
        xCoordinates.add(pax2);
        xCoordinates.add(pbx1);
        xCoordinates.add(pbx2);
        yCoordinates.add(pay1);
        yCoordinates.add(pay2);
        yCoordinates.add(pby1);
        yCoordinates.add(pby2);

        xCoordinates.sort(Comparator.comparing(Point::getVal));
        yCoordinates.sort(Comparator.comparing(Point::getVal));

        int areaA = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int areaB = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        int commonArea = getCommonArea(xCoordinates, yCoordinates);

        return areaA + areaB - commonArea;
    }

    private static int getCommonArea(List<Point> xCoordinates, List<Point> yCoordinates) {
        if (xCoordinates.get(0).rectangle == xCoordinates.get(1).rectangle || yCoordinates.get(0).rectangle == yCoordinates.get(1).rectangle ) {
            return 0;
        }
        return Math.abs(xCoordinates.get(1).val - xCoordinates.get(2).val) * Math.abs(yCoordinates.get(1).val - yCoordinates.get(2).val);
    }

    private static class Point {
        private char rectangle;
        private int val;

        public Point(char rectangle, int val) {
            this.rectangle = rectangle;
            this.val = val;
        }

        public char getRectangle() {
            return rectangle;
        }

        public int getVal() {
            return val;
        }
    }

}
