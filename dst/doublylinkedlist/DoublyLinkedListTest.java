package dst.doublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Object> doublyLinkedList;

    @BeforeEach
    public void setup() {
        doublyLinkedList = new DoublyLinkedList<Object>();
    }

    @Test
    public void add_toEmptyList() {
        assertTrue(doublyLinkedList.isEmpty());

        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        doublyLinkedList.add(obj1);
        doublyLinkedList.add(obj2);
        doublyLinkedList.add(obj3);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(3, doublyLinkedList.size());
        assertEquals(obj1, doublyLinkedList.get(0));
        assertEquals(obj2, doublyLinkedList.get(1));
        assertEquals(obj3, doublyLinkedList.get(2));
    }

    @Test
    public void add_toInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.add(69, new Object());
        });
    }

    @Test
    public void add_toValidIndex() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        doublyLinkedList.add(0, obj1);
        assertEquals(obj1, doublyLinkedList.get(0));

        doublyLinkedList.add(0, obj2);
        assertEquals(obj2, doublyLinkedList.get(0));
        assertEquals(obj1, doublyLinkedList.get(1));

        doublyLinkedList.add(1, obj3);
        assertEquals(obj3, doublyLinkedList.get(1));
        assertEquals(obj1, doublyLinkedList.get(2));
        assertEquals(3, doublyLinkedList.size());
    }

    @Test
    public void contains_onEmptyList() {
        assertFalse(doublyLinkedList.contains(new Object()));
    }

    @Test
    public void contains_onList() {
        Object obj = new Object();
        doublyLinkedList.add(obj);

        assertTrue(doublyLinkedList.contains(obj));
    }

    @Test
    public void get_onEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.get(69);
        });
    }

    @Test
    public void remove_onEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            doublyLinkedList.remove(69);
        });

        assertFalse(doublyLinkedList.remove(new Object()));

    }

    @Test
    public void remove_onList() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        doublyLinkedList.add(obj1);
        doublyLinkedList.add(obj2);
        doublyLinkedList.add(obj3);

        assertEquals(obj2, doublyLinkedList.remove(1));
        assertTrue(doublyLinkedList.remove(obj1));
        assertEquals(obj3, doublyLinkedList.remove(0));
        assertTrue(doublyLinkedList.isEmpty());
    }

    @Test
    public void clear_onList() {
        doublyLinkedList.add(new Object());
        doublyLinkedList.add(new Object());
        doublyLinkedList.add(new Object());

        doublyLinkedList.clear();
        assertTrue(doublyLinkedList.isEmpty());
    }

}
