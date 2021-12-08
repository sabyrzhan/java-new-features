package kz.sabyrzhan.sealedclasses;

public sealed class PermittedAndSealedClass extends SampleSealedClass permits AnotherPermittedClass {
    @Override
    protected void printICanOverride() {
        super.printICanOverride();
        System.out.println("Yes, this is overriden!");
    }

    protected void printICanOverride2() {
        System.out.println("This also can be overriden");
    }
}
