package dst.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetTest {

    private Set<Object> set;

    @BeforeEach
    public void setup() {
        set = new Set<Object>();
    }

    @Test
    public void sizeAndIsEmpty_onEmptySet() {
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    public void sizeAndIsEmpty_onSet() {
        Object obj = new Object();
        set.add(obj);
        set.add(new Object());

        assertEquals(2, set.size());
        assertFalse(set.isEmpty());

        set.remove(obj);
        assertEquals(1, set.size());
    }

    @Test
    public void add_onEmptySet() {
        assertTrue(set.add(new Object()));
    }

    @Test
    public void add_existingObject() {
        Object obj = new Object();
        set.add(obj);

        assertFalse(set.add(obj));
    }

    public void get_onEmptySet() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            set.get(0);
        });
    }

    @Test
    public void get_existingObject() {
        Object obj = new Object();
        set.add(obj);

        assertEquals(obj, set.get(0));
    }

    @Test
    public void remove_onEmptySet() {
        assertFalse(set.remove(new Object()));
    }

    @Test
    public void remove_onSet() {
        Object obj = new Object();
        set.add(new Object());
        set.add(obj);
        set.add(new Object());

        assertTrue(set.remove(obj));
    }

    @Test
    public void contains_onEmptySet() {
        assertFalse(set.contains(new Object()));
    }

    @Test
    public void contains_onSet() {
        Object obj = new Object();
        set.add(obj);

        assertTrue(set.contains(obj));
    }

    @Test
    public void clear_onSet() {
        set.add(new Object());
        set.clear();

        assertEquals(0, set.size());
    }

}
