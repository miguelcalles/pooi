package singleclassespoint2;

import singleclassespoint2.Point;

public class Test {

    public static void main(String[] args) {

        // point con color null mal
        Point p = new Point((byte) -3, (byte) 5, null, '+');
        p.showSimple();
        Point p2 = new Point(p);
        p2.showSimple();
        System.out.println(p == p2);
        // Pruebas up, down, right, left
        Point p10 = new Point((byte) 3, (byte) 5);
        p10.showSimple();

        for (int i = 0; i < 10; i++) {
            System.out.println(p10.down());
            p10.showSimple();
        }
    }
}