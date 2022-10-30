package kz.sabyrzhan;

import org.junit.jupiter.api.Test;

class PatternMatchingPreview3Test {
    /*
    Testing `when` statement. The `x` object is not null in our case.
     */
    @Test
    void testWhenNotNull() {
        Object x = 100;
        switch (x) {
            case Integer i when i != null && i == 100 -> System.out.println("This is Integer and exactly 100");
            case Integer i when i > 10 -> System.out.println("This is integer and > 10");
            default -> System.out.println("I dont know...");
        }
    }

    /*
    Testing `when` statement. The `x` object is null here. But here we are also having `null` case statement.
    This way we will not have NPE which is validated right at `switch` statement.
     */
    @Test
    void testWhenXIsNullAndNullCase() {
        Object x = null;
        switch (x) {
            case null -> System.out.println("The object is null");
            default -> System.out.println("I dont know...");
        }
    }

    /*
    Here we dont have `null` case statement. This way the `switch` block will be terminated with NPE.
     */
    @Test
    void testWhenXIsNullOnly() {
        Object x = null;
        switch (x) {
            default -> System.out.println("I dont know...");
        }
    }
}