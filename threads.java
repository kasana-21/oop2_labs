package threads_assign;

public class threads {
    public static void main(String[] args) {
        // Instances of the thread class
        Thread thread1 = new Thread(new MyRunnable("Thread 1"));
        Thread thread2 = new Thread(new MyRunnable("Thread 2"));
        Thread thread3 = new Thread(new MyRunnable("Thread 3"));

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable implements Runnable {
    private String threadName;

    public MyRunnable(String name) {
        threadName = name;
    }

    public void run() {
        System.out.println("Thread " + threadName + " started.");

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + ": " + i);
                Thread.sleep(1000); // Time-consuming operation
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }

        System.out.println("Thread " + threadName + " finished.");
    }
}

