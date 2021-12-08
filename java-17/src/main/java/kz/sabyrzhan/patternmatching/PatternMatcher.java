package kz.sabyrzhan.patternmatching;

public class PatternMatcher {
    private static String describeObjectType(Object type) {
        return switch (type) {
            case Integer i -> "This is Integer with value: " + i;
            case String s -> "This is string with value: " + s;
            case null -> "This is a null object";
            default -> {
                String defaultValue = "Something different";
                if (type instanceof Float f) {
                    defaultValue = "Ok. This is Float with value: " + f;
                } else if (type instanceof Double d) {
                    defaultValue = "Ok. This is Double with value: " + d;
                }

                yield defaultValue;
            }
        };
    }
    public static void main(String[] args) {
        System.out.println(describeObjectType("String"));
        System.out.println(describeObjectType("Integer"));
        System.out.println(describeObjectType(null));
        System.out.println(describeObjectType(13.2f));
        System.out.println(describeObjectType(13.3));
        System.out.println(describeObjectType('c'));
    }
}
