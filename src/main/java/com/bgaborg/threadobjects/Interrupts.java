package com.bgaborg.threadobjects;

import java.util.UUID;

import static com.bgaborg.threadobjects.ThreadObjectsPart.threadMessage;

/**
 * Interrupts
 * <p/>
 * <p>An interrupt is an indication to a thread that it should stop what it is doing and do something else.
 * It's up to the programmer to decide exactly how a thread responds to an interrupt, but it is very
 * common for the thread to terminate.
 * <p/>
 * <p>A thread sends an interrupt by invoking interrupt on the Thread object for the thread to be interrupted.
 * For the interrupt mechanism to work correctly, the interrupted thread must support its own interruption.
 * <p/>
 * <p/>
 * <b>The Interrupt Status Flag<b/>
 * The interrupt mechanism is implemented using an internal flag known as the interrupt status.
 * Invoking Thread.interrupt sets this flag. When a thread checks for an interrupt by invoking the static
 * method Thread.interrupted, interrupt status is cleared. The non-static isInterrupted method, which is
 * used by one thread to query the interrupt status of another, does not change the interrupt status flag.
 * <p/>
 * By convention, any method that exits by throwing an InterruptedException clears interrupt status when it does so.
 * However, it's always possible that interrupt status will immediately be set again, by another thread invoking
 * interrupt.
 * <p/>
 *
 * Created by bg
 */
public class Interrupts implements Runnable {
    String[] importantInfo = new String[100];


    @Override
    public void run() {
        /**
         * How does a thread support its own interruption? This depends on what it's currently doing.
         * If the thread is frequently invoking methods that throw InterruptedException, it simply
         * returns from the run method after it catches that exception. For example, suppose the central
         * message loop in the SleepMessages example were in the run method of a thread's Runnable object.
         * Then it might be modified to support interrupts.
         */
        for (int i = 0; i < importantInfo.length; i++) {
            importantInfo[i] = UUID.randomUUID().toString();
        }

        iFor:
        for (String str : importantInfo) {
            System.out.println(str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // We've been interrupted: no more messages.
                threadMessage("Thread interrupted at message. (InterruptedException thrown)");
                break iFor;
            }
        }

        /**
         * What if a thread goes a long time without invoking a method that throws InterruptedException?
         * Then it must periodically invoke Thread.interrupted, which returns true if an interrupt has been received.
         */
        iWhile:
        while (true) {
            if (Thread.interrupted()) {
                threadMessage("Thread interrupted with checking Thread.interrupted(), so interrupt status is cleared. ");
                break iWhile;
            }
        }

        /**
         * In this simple example, the code simply tests for the interrupt and exits the thread if one has been received. In more complex applications, it might make more sense to throw an InterruptedException:
         *
         * if (Thread.interrupted()) {
         *      throw new InterruptedException();
         * }
         *
         * This allows interrupt handling code to be centralized in a catch clause.
         */
    }
}
