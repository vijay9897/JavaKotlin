import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {

    private final Object monitor = new Object();
    private boolean printingCharacter = false;
    private boolean printingNumber = true;
    private final int[] numbers = {1, 2, 3};
    private final char[] characters = {'a', 'b', 'c'};

    public static void main(String[] args) {
        ThreadTest instance = new ThreadTest();
        PrintingIntegers t1 = instance.new PrintingIntegers();
        PrintingCharacters t2 = instance.new PrintingCharacters();
        System.out.println(">>>printing start");
        t1.start();
        t2.start();
//        Thread t1 = new Thread(() -> {
//            for (int ch: instance.numbers) {
//                instance.printInteger(ch);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (char ch: instance.characters) {
//                instance.printCharacter(ch);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();
    }

    void printCharacter(char ch) {
        synchronized (this) {
            while (!printingCharacter) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(" " + ch);
            printingCharacter = true;
            notify();
        }
    }

    void printInteger(int ch) {
        synchronized (this) {
            while (printingCharacter) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(" " + ch);
            printingCharacter = false;
            notify();
        }
    }

    private class PrintingIntegers extends Thread {
        private final int[] numbers = {1, 2, 3};

        @Override
        public void run() {
            super.run();
            for (int ch: numbers) {
//                System.out.println(">>" + ch);
                synchronized (monitor) {
                    System.out.println(">>" + ch);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private class PrintingCharacters extends Thread {
        private final char[] characters = {'a', 'b', 'c'};

        @Override
        public void run() {
            super.run();
            for (char ch: characters) {
//                System.out.println(">>" + ch);
                synchronized (monitor) {
                    System.out.println(">>" + ch);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
