package com.bgaborg.liveness;

import com.bgaborg.AppPart;

/**
 * Liveness
 * <p/>
 * A concurrent application's ability to execute in a timely manner is known as its liveness.
 * This section describes the most common kind of liveness problem, deadlock, and goes on to briefly
 * describe two other liveness problems, starvation and livelock.
 * <p/>
 * Created by bg
 */
public class LivenessPart implements AppPart {

    @Override
    public void startExample() throws Exception {
        threadMessage("Liveness Part Start\n");

        Thread deadlockThread = new Thread(new DeadLock());
        threadMessage("Starting Deadlock thread....");
        deadlockThread.start();
        Thread.sleep(5000);
        deadlockThread.interrupt();
        deadlockThread.join();

        threadMessage("Liveness Part End\n");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                threadName,
                message);
    }
}
