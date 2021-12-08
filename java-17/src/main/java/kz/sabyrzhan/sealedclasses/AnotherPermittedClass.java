package kz.sabyrzhan.sealedclasses;

public final class AnotherPermittedClass extends PermittedAndSealedClass {
    @Override
    protected void printICanOverride2() {
        super.printICanOverride2();
        System.out.println("Yes, this is also overriden");
    }


    public static void main(String[] args) {
        AnotherPermittedClass p = new AnotherPermittedClass();
        p.printICanOverride();
        p.printICanOverride2();
    }
}
