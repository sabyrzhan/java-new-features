package kz.sabyrzhan.sealedclasses;

public non-sealed class PermittedClass extends SampleSealedClass {
    @Override
    protected void printICanOverride() {
        super.printICanOverride();
        System.out.println("Yes, this method is overriden");
    }
}
