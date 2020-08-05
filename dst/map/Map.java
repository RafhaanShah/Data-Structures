package dst.map;

public class Map<K, V> {

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    private MapEntry<K, V>[] data = new MapEntry[DEFAULT_CAPACITY];

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < size; i++) {
            if (data[i].value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(key)) {
                return data[i].value;
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public K[] keys() {
        K[] keys = (K[]) new Object[size];

        for (int i = 0; i < size; i++) {
            keys[i] = data[i].key;
        }

        return keys;
    }

    public V put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(key)) {
                data[i].value = value;
                return value;
            }
        }

        ensureCapacity();
        data[size] = new MapEntry<K, V>(key, value);
        size++;
        return value;
    }

    public V remove(K key) {
        for (int i = 0; i < size; i++) {
            if (data[i].key.equals(key)) {
                V value = data[i].value;
                shrinkMap(i);
                return value;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public V[] values() {
        V[] values = (V[]) new Object[size];

        for (int i = 0; i < size; i++) {
            values[i] = data[i].value;
        }

        return values;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (data.length == size) {
            MapEntry<K, V>[] temp = new MapEntry[DEFAULT_CAPACITY];
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    private void shrinkMap(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size] = null;
        size--;
    }

    private class MapEntry<A, B> {

        private final A key;
        private B value;

        public MapEntry(A k, B v) {
            key = k;
            value = v;
        }

    }

}
