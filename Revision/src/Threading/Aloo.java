package Threading;


class MyThreadRunnable1 implements Runnable {
    @Override
    public void run(){
        for(int i = 0;i<5;i++) {
            System.out.println("My thread 1 is running!");
            System.out.println("I am happy");

        }
    }
}

class MyThreadRunnable2 implements Runnable{
    @Override
    public void run(){
        for(int i = 0;i<5;i++) {
            System.out.println("My thread 2 is running!");
            System.out.println("I am sad");
        }
    }
}

public class Aloo{
    public static void main(String[] args) throws InterruptedException {
        MyThreadRunnable1 myThread1 = new MyThreadRunnable1();
        MyThreadRunnable2 myThread2 = new MyThreadRunnable2();

        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread2);

        t1.start();
        t2.start();


    }
}