package com.bgaborg.threadobjects;

import static com.bgaborg.threadobjects.ThreadObjectsPart.threadMessage;

/**
 * Subclass Thread.
 *
 * The Thread class itself implements Runnable, though its run method does nothing.
 * An application can subclass Thread, providing its own implementation of run.
 *
 * Created by bg
 */
public class HelloRunnable implements Runnable {
    public void run() {
        threadMessage("Hello from the thread!");
    }


}
