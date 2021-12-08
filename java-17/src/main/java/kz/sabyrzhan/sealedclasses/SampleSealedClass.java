package kz.sabyrzhan.sealedclasses;

public sealed class SampleSealedClass permits PermittedClass, PermittedAndSealedClass {
    protected void printICanOverride() {
        System.out.println("I can override");
    }
}
