package com.bgaborg.threadobjects;

import com.bgaborg.AppExample;

/**
 * Created by bg
 */
public class ThreadObjectsPart implements AppExample {

    @Override
    public void startExample() throws Exception {
        threadMessage("----end of threadobjects examples----\n");
        Thread helloRunnable = new Thread(new HelloRunnable());
        Thread helloThread = new HelloThread();
        Thread sleepMessages = new SleepMessages();

        /**
         * Interrupts with some logic
         */
        Thread interruptThread = new Thread(new Interrupts());
        interruptThread.start();
        Thread.sleep(500);
        interruptThread.interrupt();
        Thread.sleep(1000);
        interruptThread.interrupt();

        /**
         * The join method allows one thread to wait for the completion of another.
         * If t is a Thread object whose thread is currently executing, causes the current
         * thread to pause execution until t's thread terminates. Overloads of join allow the programmer to
         * specify a waiting period. However, as with sleep, join is dependent on the OS for timing, so you
         * <b>should not assume that join will wait exactly as long as you specify</b>
         *
         * Like sleep, join responds to an interrupt by exiting with an InterruptedException.
         */
        interruptThread.join();

        helloRunnable.start();
        helloThread.start();

        helloRunnable.join();
        helloThread.join();

        /**
         * Testing sleepMessages with join and interrupt
         */
        sleepMessages.start();
        long startTime = System.currentTimeMillis();
        threadMessage("Waiting to sleepMessages to finish.");
        while(sleepMessages.isAlive()){
            threadMessage("Still waiting...");
            sleepMessages.join(500);
            if(((System.currentTimeMillis() - startTime) > 2000) && sleepMessages.isAlive()){
                threadMessage("Interrputing thread.");
                sleepMessages.interrupt();
                sleepMessages.join();
            }
        }
        threadMessage("SleepMessages stopped.");
        threadMessage("----end of threadobjects examples----\n\n");
    }

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }
}
