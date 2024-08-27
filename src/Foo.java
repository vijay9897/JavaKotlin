class Foo {

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread1 t1 = new Thread1(foo);
        Thread3 t3 = new Thread3(foo);
        Thread2 t2 = new Thread2(foo);
    }

    static class Thread1 implements Runnable {

        Thread1(Foo foo) {
            try {
                foo.first(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.print("first");
        }
    }

    static class Thread2 implements Runnable {

        Thread2(Foo foo) {
            try {
                foo.second(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.print("second");
        }
    }

    static class Thread3 implements Runnable {

        Thread3(Foo foo) {
            try {
                foo.third(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.print("third");
        }
    }
}
