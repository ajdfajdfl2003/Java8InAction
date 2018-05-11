package lambdasinaction.chap3;

public class SimpleFunInterfaceImpl {
    public static void main(String[] args) {
        carryOutWork(new SimpleFuncInterface() {
            @Override
            public void doWork() {
                System.out.println("Do work in SimpleFun impl...");
            }
        });
        carryOutWork(() -> System.out.println("Do work in lambda exp impl..."));
    }
    public static void carryOutWork(SimpleFuncInterface sfi){
        sfi.doWork();
    }
}
