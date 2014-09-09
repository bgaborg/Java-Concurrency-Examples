package com.bgaborg.liveness;

/**
 * Deadlock
 * <p/>
 * Deadlock describes a situation where two or more threads are blocked forever,
 * waiting for each other. Here's an example.
 * <p/>
 * Alphonse and Gaston are friends, and great believers in courtesy. A strict rule of courtesy
 * is that when you bow to a friend, you must remain bowed until your friend has a chance to
 * return the bow. Unfortunately, this rule does not account for the possibility that two friends
 * might bow to each other at the same time. This example application, Deadlock, models this possibility.
 * <p/>
 * When Deadlock runs, it's extremely likely that both threads will block when they attempt to invoke bowBack. Neither block will ever end, because each thread is waiting for the other to exit bow.
 * <p/>
 * Created by bg
 */
public class DeadLock implements Runnable {

    @Override
    public void run() {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        Thread alphonseThread = new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        });

        Thread gastonThread = new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        });

        alphonseThread.start();
        gastonThread.start();
        try {
            alphonseThread.join();
            gastonThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }
}
