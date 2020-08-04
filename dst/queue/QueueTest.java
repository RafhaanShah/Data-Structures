package dst.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

    private Queue<Object> queue;

    @BeforeEach
    public void setup() {
        queue = new Queue<Object>();
    }

    public void empty_onEmptyQueue() {
        assertTrue(queue.empty());
    }

    @Test
    public void empty_onQueue() {
        queue.enqueue(new Object());
        assertFalse(queue.empty());
    }

    @Test
    public void enqueueAndHead_onQueue() {
        Object obj = new Object();
        assertEquals(obj, queue.enqueue(obj));

        queue.enqueue(new Object());
        assertEquals(obj, queue.head());
    }

    @Test
    public void enqueueAndDequeue_onQueue() {
        Object obj = new Object();
        assertEquals(obj, queue.enqueue(obj));

        queue.enqueue(new Object());
        assertEquals(obj, queue.dequeue());

        queue.dequeue();
        assertTrue(queue.empty());
    }

    @Test
    public void head_onEmptyQueue() {
        assertNull(queue.head());
    }

    @Test
    public void dequeue_onEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        });
    }

}
