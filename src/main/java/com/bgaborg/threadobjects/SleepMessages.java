package com.bgaborg.threadobjects;

import static com.bgaborg.threadobjects.ThreadObjectsPart.threadMessage;

/**
 * Pausing Execution with Sleep
 *
 * Thread.sleep causes the current thread to suspend execution for a specified period.
 * This is an efficient means of making processor time available to the other threads of an application or other
 * applications that might be running on a computer system.
 * The sleep method can also be used for pacing, as shown in the example that follows, and waiting for another thread
 * with duties that are understood to have time requirements, as with the SimpleThreads example in a later section.
 *
 * Two overloaded versions of sleep are provided: one that specifies the sleep time to the millisecond and one that
 * specifies the sleep time to the nanosecond.
 * However, these sleep times are not guaranteed to be precise, because they are limited by the facilities provided
 * by the underlying OS. Also, the sleep period can be terminated by interrupts, as we'll see in a later section.
 * In any case, you cannot assume that invoking sleep will suspend the thread for precisely the time period specified.
 * <hr>
 * <b>InterruptedException</b>
 * This is an exception that sleep throws when another thread interrupts the current thread while sleep is active.
 *
 * Created by bg
 */
public class SleepMessages extends Thread {
    String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };


    @Override
    public void run() {
        for(String str : importantInfo){
            try {
                threadMessage(str);
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
