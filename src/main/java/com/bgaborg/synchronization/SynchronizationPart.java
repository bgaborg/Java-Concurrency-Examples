package com.bgaborg.synchronization;

import com.bgaborg.AppPart;

/**
 * Synchronization
 * <p/>
 * Threads communicate primarily by sharing access to fields and the objects reference fields refer to.
 * This form of communication is extremely efficient, but makes two kinds of errors possible:
 * thread interference and memory consistency errors. The tool needed to prevent these errors is synchronization.
 * <p/>
 * However, synchronization can introduce thread contention, which occurs when two or more threads try to access
 * the same resource simultaneously and cause the Java runtime to execute one or more threads more slowly,
 * or even suspend their execution. Starvation and livelock are forms of thread contention.
 * See the section Liveness for more information.
 *
 * @see <a href="http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html#MemoryVisibility">Memory visibility</a>
 * <p/>
 * Created by bg
 */
public class SynchronizationPart implements AppPart {
    @Override
    public void startExample() throws Exception {
        System.out.println("SynchronizationPart: Read the code, and the comments provided for the code. \n");
    }
}
