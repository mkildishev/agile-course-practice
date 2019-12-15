package ru.unn.agile.crosssections.model;

public class CrossChecker {

    public CrossChecker() {
    }

    public boolean check(final Section section1, final Section section2) {
        return cross(section1.getA(), section1.getB(), section2.getA(), section2.getB());
    }

    private int getArea(final Point a, final Point b, final Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY())
                - (b.getY() - a.getY()) * (c.getX() - a.getX());
    }

    private boolean innerCross(final int a, final int b, final int c, final int d) {
        return Math.max(Math.min(a, b), Math.min(c, d))
                <= Math.min(Math.max(a, b), Math.max(c, d));
    }

    private boolean cross(final Point a, final Point b, final Point c, final Point d) {
        return innerCross(a.getX(), b.getX(), c.getX(), d.getX())
                && innerCross(a.getY(), b.getY(), c.getY(), d.getY())
                && getArea(a, b, c) * getArea(a, b, d) <= 0
                && getArea(c, d, a) * getArea(c, d, b) <= 0;
    }
}
