package com.bgaborg.synchronization;

import java.util.ArrayList;

/**
 * Intrinsic Locks and Synchronization
 *
 * Created by bg
 */
public class IntristicLocks {
    String lastName = "";
    int nameCount = 0;
    ArrayList<String> nameList = new ArrayList<>();

    /**
     * Another way to create synchronized code is with synchronized statements. Unlike synchronized methods,
     * synchronized statements must specify the object that provides the intrinsic lock:
     *
     * In this example, the addName method needs to synchronize changes to lastName and nameCount, but
     * also needs to avoid synchronizing invocations of other objects' methods. (Invoking other objects'
     * methods from synchronized code can create problems that are described in the section on Liveness.)
     * Without synchronized statements, there would have to be a separate, unsynchronized method for the
     * sole purpose of invoking nameList.add.
     *
     * @param name
     */
    public void addName(String name) {
        synchronized(this) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }


    /**
     * Synchronized statements are also useful for improving concurrency with fine-grained synchronization.
     * Suppose, for example, class MsLunch has two instance fields, c1 and c2, that are never used together.
     * All updates of these fields must be synchronized, but there's no reason to prevent an update of c1 from
     * being interleaved with an update of c2 — and doing so reduces concurrency by creating unnecessary blocking.
     * Instead of using synchronized methods or otherwise using the lock associated with this, we create
     * two objects solely to provide locks.
     *
     * Use this idiom with extreme care. You must be absolutely sure that it really is safe to interleave access of the affected fields.
     */
    private long c1 = 0;
    private long c2 = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void inc1() {
        synchronized(lock1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized(lock2) {
            c2++;
        }
    }

    /**
     * Reentrant Synchronization
     *
     * Recall that a thread cannot acquire a lock owned by another thread. But a thread can acquire a lock
     * that it already owns. Allowing a thread to acquire the same lock more than once enables
     * reentrant synchronization. This describes a situation where synchronized code, directly or indirectly,
     * invokes a method that also contains synchronized code, and both sets of code use the same lock.
     * Without reentrant synchronization, synchronized code would have to take many additional precautions to
     * avoid having a thread cause itself to block.
     */
}
