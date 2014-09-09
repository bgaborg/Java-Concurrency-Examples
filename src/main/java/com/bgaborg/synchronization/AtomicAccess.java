package com.bgaborg.synchronization;

/**
 * Atomic Access
 * <p/>
 * In programming, an atomic action is one that effectively happens all at once.
 * An atomic action cannot stop in the middle: it either happens completely, or it doesn't happen at all.
 * No side effects of an atomic action are visible until the action is complete.
 * <p/>
 * We have already seen that an increment expression, such as c++, does not describe an atomic action.
 * Even very simple expressions can define complex actions that can decompose into other actions.
 * However, there are actions you can specify that are atomic:
 * <p/>
 * - Reads and writes are atomic for reference variables and for most primitive variables
 * (all types except long and double).
 * - Reads and writes are atomic for all variables declared volatile
 * (including long and double variables).
 * <p/>
 * Atomic actions cannot be interleaved, so they can be used without fear of thread interference.
 * However, this does not eliminate all need to synchronize atomic actions, because memory consistency
 * errors are still possible. Using volatile variables reduces the risk of memory consistency errors,
 * because any write to a volatile variable establishes a happens-before relationship with subsequent
 * reads of that same variable. This means that changes to a volatile variable are always visible to other
 * threads. What's more, it also means that when a thread reads a volatile variable, it sees not just the latest
 * change to the volatile, but also the side effects of the code that led up the change.
 * <p/>
 * Using simple atomic variable access is more efficient than accessing these variables through synchronized
 * code, but requires more care by the programmer to avoid memory consistency errors. Whether the extra
 * effort is worthwhile depends on the size and complexity of the application.
 * <p/>
 * Some of the classes in the java.util.concurrent package provide atomic methods that do not rely on synchronization.
 * <p/>
 * <hr/>
 * volatile has semantics for memory visibility. Basically, the value of a volatile field becomes visible
 * to all readers (other threads in particular) after a write operation completes on it. Without volatile,
 * readers could see some non-updated value.
 * <p/>
 * Yes, I use a volatile variable to control whether some code continues a loop. The loop tests the volatile
 * value and continues if it is true. The condition can be set to false by calling a "stop" method.
 * The loop sees false and terminates when it tests the value after the stop method completes execution.
 * <p/>
 * The book "Java Concurrency in Practice," which I highly recommend, gives a good explanation of volatile.
 * This book is written by the same person who wrote the IBM article that is referenced in the question
 * (in fact, he cites his book at the bottom of that article). My use of volatile is what his article calls
 * the "pattern 1 status flag."
 * <p/>
 * If you want to learn more about how volatile works under the hood, read up on the Java memory model.
 * If you want to go beyond that level, check out a good computer architecture book like
 * Hennessy & Patterson and read about cache coherence and cache consistency.
 * <p/>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Volatile_variable#In_Java">Volatile Wiki</a>
 * @see <a href="http://stackoverflow.com/a/17748517/761976">StackOverflow explanation</a>
 * <p/>
 * Created by bg
 */
public class AtomicAccess {
    private volatile int val = 0;
    private volatile Object object = new Object();
}
