package com.bgaborg.threadobjects;

import static com.bgaborg.threadobjects.ThreadObjectsPart.threadMessage;

/**
 * Provide a Runnable object. The Runnable interface defines a single method,
 * run, meant to contain the code executed in the thread.
 *
 * The Runnable object is passed to the Thread constructor.
 *
 * Created by bg
 */
public class HelloThread extends Thread {
    @Override
    public void run() {
        threadMessage("Hello from thread");
    }
}
