package com.bgaborg.synchronization;

/**
 * The Java programming language provides two basic synchronization idioms: synchronized methods and
 * synchronized statements. The more complex of the two, synchronized statements, are described in
 * the next section. This section is about synchronized methods.
 * <p/>
 * To make a method synchronized, simply add the synchronized keyword to its declaration:
 * <p/>
 * If count is an instance of SynchronizedCounter, then making these methods synchronized has two effects:
 * <p/>
 * - First, it is not possible for two invocations of synchronized methods on the same object to interleave.
 * When one thread is executing a synchronized method for an object, all other threads that invoke
 * synchronized methods for the same object block (suspend execution) until the first thread is done
 * with the object.
 * - Second, when a synchronized method exits, it automatically establishes a happens-before relationship
 * with any subsequent invocation of a synchronized method for the same object. This guarantees that changes
 * to the state of the object are visible to all threads.
 * <p/>
 * Note that constructors cannot be synchronized — using the synchronized keyword with a constructor is a
 * syntax error. Synchronizing constructors doesn't make sense, because only the thread that creates an object
 * should have access to it while it is being constructed.
 * <p/>
 *
 * Created by bg
 */
public class SynchronizedMethods {

    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
