package dst.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MapTest {

    private Map<Object, Object> map;

    @BeforeEach
    public void setup() {
        map = new Map<Object, Object>();
    }

    @Test
    public void isEmpty_onEmptyMap() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    public void put_onEmptyMap() {
        Object key = new Object();
        Object value = new Object();

        assertEquals(value, map.put(key, value));
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
    }

    @Test
    public void put_onExistingKey() {
        Object key = new Object();
        Object value = new Object();
        Object newValue = new Object();

        map.put(key, value);
        map.put(key, newValue);

        assertEquals(newValue, map.get(key));
    }

    @Test
    public void get_onEmptyMap() {
        assertNull(map.get(new Object()));
    }

    @Test
    public void get_onMap() {
        Object key = new Object();
        Object value = new Object();

        assertEquals(value, map.put(key, value));
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
    }

    @Test
    public void remove_onEmptyMap() {
        assertNull(map.remove(new Object()));
    }

    @Test
    public void remove_onMap() {
        Object key = new Object();
        Object value = new Object();

        map.put(key, value);

        assertEquals(value, map.remove(key));
        assertTrue(map.isEmpty());
    }

    @Test
    public void containsKey_onEmptyMap() {
        assertFalse(map.containsKey(new Object()));
    }

    @Test
    public void containsKey_onMap() {
        Object key = new Object();
        Object value = new Object();
        map.put(key, value);

        assertTrue(map.containsKey(key));
    }

    @Test
    public void containsValue_onEmptyMap() {
        assertFalse(map.containsValue(new Object()));
    }

    @Test
    public void containsValue_onMap() {
        Object key = new Object();
        Object value = new Object();
        map.put(key, value);

        assertTrue(map.containsValue(value));
    }

    @Test
    public void keys_onEmptyMap() {
        assertEquals(0, map.keys().length);
    }

    @Test
    public void keys_containsAllKeys() {
        Object key = new Object();
        Object value = new Object();
        map.put(key, value);
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());

        Object[] keys = map.keys();
        assertEquals(3, keys.length);
        assertTrue(contains(key, keys));
    }

    @Test
    public void values_onEmptyMap() {
        assertEquals(0, map.values().length);
    }

    @Test
    public void values_containsAllValues() {
        Object key = new Object();
        Object value = new Object();
        map.put(key, value);
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());

        Object[] values = map.values();
        assertEquals(3, values.length);
        assertTrue(contains(value, values));
    }

    @Test
    public void clear_emptiesList() {
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());
        map.put(new Object(), new Object());

        map.clear();
        assertTrue(map.isEmpty());
    }

    private boolean contains(Object element, Object[] elements) {
        for (Object o : elements) {
            if (element.equals(o)) {
                return true;
            }
        }

        return false;
    }

}
