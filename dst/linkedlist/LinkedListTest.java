package dst.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    private LinkedList<Object> linkedList;

    @BeforeEach
    public void setup() {
        linkedList = new LinkedList<Object>();
    }

    @Test
    public void add_toEmptyList() {
        assertTrue(linkedList.isEmpty());

        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        linkedList.add(obj1);
        linkedList.add(obj2);
        linkedList.add(obj3);

        assertFalse(linkedList.isEmpty());
        assertEquals(3, linkedList.size());
        assertEquals(obj1, linkedList.get(0));
        assertEquals(obj2, linkedList.get(1));
        assertEquals(obj3, linkedList.get(2));
    }

    @Test
    public void add_toInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add(69, new Object());
        });
    }

    @Test
    public void add_toValidIndex() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        linkedList.add(0, obj1);
        assertEquals(obj1, linkedList.get(0));

        linkedList.add(0, obj2);
        assertEquals(obj2, linkedList.get(0));
        assertEquals(obj1, linkedList.get(1));

        linkedList.add(1, obj3);
        assertEquals(obj3, linkedList.get(1));
        assertEquals(obj1, linkedList.get(2));
        assertEquals(3, linkedList.size());
    }

    @Test
    public void contains_onEmptyList() {
        assertFalse(linkedList.contains(new Object()));
    }

    @Test
    public void contains_onList() {
        Object obj = new Object();
        linkedList.add(obj);

        assertTrue(linkedList.contains(obj));
    }

    @Test
    public void get_onEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(69);
        });
    }

    @Test
    public void remove_onEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.remove(69);
        });

        assertFalse(linkedList.remove(new Object()));

    }

    @Test
    public void remove_onList() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        linkedList.add(obj1);
        linkedList.add(obj2);
        linkedList.add(obj3);

        assertEquals(obj2, linkedList.remove(1));
        assertTrue(linkedList.remove(obj1));
        assertEquals(obj3, linkedList.remove(0));
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void clear_onList() {
        linkedList.add(new Object());
        linkedList.add(new Object());
        linkedList.add(new Object());

        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }

}
