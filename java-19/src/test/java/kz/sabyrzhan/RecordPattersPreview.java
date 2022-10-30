package kz.sabyrzhan;

import org.junit.jupiter.api.Test;

class RecordPattersPreview {
    record Point(int x, int y) {}
    enum Color { RED, GREEN, BLUE }
    record ColoredPoint(Point p, Color c) {}

    /*
    Record mathcing with primary constructor parameters. Previously it was only possible in general
    way through named variable which is not limited to only records though.
     */
    @Test
    void recordMatchingWithParameters() {
        var point = createRecord();
        if (point instanceof Point(int x, int y)) {
            System.out.println("X: " + x);
            System.out.println("Y: " + y);
        }

        // Old way
        if (point instanceof Point p) {
            System.out.println("Old way X: " + p.x);
            System.out.println("Old way Y: " + p.y);
        }
    }

    /*
    Using named record pattern through named variable.
     */
    @Test
    void namedRecordMatching() {
        var point = createRecord();
        if (point instanceof Point(int x, int y) p) {
            System.out.println("X: " + p.x);
            System.out.println("Y: " + p.y);
        }
    }

    /*
    Matching also using another custom type.
     */
    @Test
    void nestedRecordMatching() {
        var coloredPoint = createColoredRecord();
        if (coloredPoint instanceof ColoredPoint(Point(var x, var y) point, var color)) {
            System.out.println("Point: " + point);
            System.out.println("Color: " + color);
        }
    }

    /*
    Using record patterns in pattern matching.
     */
    @Test
    void usingInPatternMatching() {
        var coloredPoint = createColoredRecord();
        switch(coloredPoint) {
            case ColoredPoint(Point(var x, var y) point, Color color) when x >= 10 && color == Color.GREEN ->
                    System.out.println("This is the colored point with x = " + 10);
            default -> System.out.println("Unknown point");
        }

        var simplePoint = createRecord();
        switch(simplePoint) {
            case ColoredPoint(Point(var x, var y) point, Color color) when x >= 10 && color == Color.GREEN ->
                    System.out.println("This is the colored point");
            case Point(var x, var y) when y > 15 -> System.out.println("This is the simple point with y = " + y);
            default -> System.out.println("Unknown point");
        }
    }

    // Utility function
    Object createRecord() {
        return new Point(10, 20);
    }

    Object createColoredRecord() {
        return new ColoredPoint(new Point(10, 10), Color.GREEN);
    }
}
