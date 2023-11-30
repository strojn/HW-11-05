package org.example;

public class Main {
    public static void main(String[] args)
    {
        Object class_1 = new Object();
        Object class_2 = new Object();

        Runnable task12 = new Runnable() {
            public void run() {
                synchronized (class_1) {
                    System.out.println( Thread.currentThread().getName() + ": locked class_1");

                    synchronized (class_2) {
                        System.out.println( Thread.currentThread().getName() + ": locked class_2");
                    }
                }
            }
        };
        Runnable task21 = new Runnable() {
            public void run() {
                synchronized (class_2) {
                    System.out.println( Thread.currentThread().getName() + ": locked class_2");

                    synchronized (class_1) {
                        System.out.println( Thread.currentThread().getName() + ": locked class_1");
                    }
                }
            }
        };
        //важлива послідовність локів в тасках: 12->21

        Thread thread1 = new Thread(task12, "thread1");
        Thread thread2 = new Thread(task21, "thread2");
        thread1.start();
        thread2.start();
    }
}