package dst.arraylist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    private ArrayList<Object> arrayList;

    @Before
    public void setup() {
        arrayList = new ArrayList<Object>();
    }

    @Test
    public void sizeAndIsEmpty_onEmptyList() {
        assertEquals(0, arrayList.size);
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void sizeAndIsEmpty_onList() {
        arrayList.add(new Object());
        arrayList.add(new Object());

        assertEquals(2, arrayList.size);
        assertFalse(arrayList.isEmpty());

        arrayList.remove(0);
        assertEquals(1, arrayList.size);
    }

    @Test
    public void get_onEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(0);
        });
    }

    @Test
    public void addAndGet_onEmptyList() {
        Object obj = new Object();
        arrayList.add(obj);

        assertEquals(obj, arrayList.get(0));
    }

    @Test
    public void addToIndex_onList() {
        Object obj = new Object();
        arrayList.add(new Object());
        arrayList.add(new Object());

        arrayList.add(1, obj);

        assertEquals(obj, arrayList.get(1));
    }

    @Test
    public void set_onEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set(0, new Object());
        });
    }

    @Test
    public void set_onList() {
        Object obj = new Object();
        arrayList.add(new Object());
        arrayList.add(new Object());
        arrayList.add(new Object());

        arrayList.set(1, obj);
        assertEquals(obj, arrayList.get(1));
    }

    @Test
    public void removeIndex_onEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(0);
        });
    }

    @Test
    public void removeObject_onEmptyList() {
        assertFalse(arrayList.remove(new Object()));
    }

    @Test
    public void removeIndex_onList() {
        Object obj = new Object();
        arrayList.add(new Object());
        arrayList.add(obj);
        arrayList.add(new Object());

        assertEquals(obj, arrayList.remove(1));
    }

    @Test
    public void removeObject_onList() {
        Object obj = new Object();
        arrayList.add(new Object());
        arrayList.add(obj);
        arrayList.add(new Object());

        assertTrue(arrayList.remove(obj));
    }

    @Test
    public void indexOf_onEmptyList() {
        assertEquals(-1, arrayList.indexOf(new Object()));
    }

    @Test
    public void indexOf_onList() {
        Object obj = new Object();
        arrayList.add(new Object());
        arrayList.add(obj);
        arrayList.add(new Object());

        assertEquals(1, arrayList.indexOf(obj));
    }

    @Test
    public void contains_onEmptyList() {
        assertFalse(arrayList.contains(new Object()));
    }

    @Test
    public void contains_onList() {
        Object obj = new Object();
        arrayList.add(obj);

        assertTrue(arrayList.contains(obj));
    }

    @Test
    public void clear_onList() {
        arrayList.add(new Object());
        arrayList.clear();

        assertEquals(0, arrayList.size);
    }

}
