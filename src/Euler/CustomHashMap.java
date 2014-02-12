package Euler;

import java.util.*;

/**
 * Created by Joseph Clark on 2/11/14.
 */
public class CustomHashMap<K, V> implements Map<K, V> {
    private Collection<Entry<K, V>>[] array;

    private static final int STARTING_HASH_SIZE = 128;
    private static final int HASH_MULTIPLIER = 2;
    private static final int MAX_SIZE_MULTIPLER = 2;

    private int size;
    private int hashSize;

    public class CustomEntry<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;

            return old;
        }
    }

    public CustomHashMap() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int h = key.hashCode() % hashSize;

        if (array[h] != null) {
            for (Entry<K, V> e : array[h]) {
                if (e == null) {
                    return false;
                } else if (e.getKey().getClass() == key.getClass()
                        && e.getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Collection<Entry<K, V>> innerList : array) {
            if (innerList != null) {
                for (Entry<K, V> e : innerList) {
                    if (e.getValue().getClass() == value.getClass()
                            && e.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public V get(Object key) {
        int h = key.hashCode() % hashSize;

        if (array[h] != null) {
            for (Entry<K, V> e : array[h]) {
                if (e == null) {
                    return null;
                } else if (e.getKey().getClass() == key.getClass()
                        && e.getKey().equals(key)) {
                    return e.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        int h = key.hashCode() % hashSize;

        Collection<Entry<K, V>> subList = array[h];
        if (subList == null) {
            array[h] = getNewInnerCollection();
            subList = array[h];
        }

        Entry<K, V> entry = null;
        for (Entry<K, V> e : subList) {
            if (e.getKey().getClass() == key.getClass()
                    && e.getKey().equals(key)) {
                entry = e;
                break;
            }
        }

        V old = null;
        if (entry != null) {
            old = entry.getValue();
            entry.setValue(value);
        } else {
            entry = new CustomEntry<>(key, value);
            subList.add(entry);

            size++;

            if (size > hashSize * MAX_SIZE_MULTIPLER) {
                expandList();
            }
        }

        return old;
    }

    @Override
    public V remove(Object key) {
        int h = key.hashCode() % hashSize;

        if (array[h] != null) {
            for (Entry<K, V> e : array[h]) {
                if (e == null) {
                    return null;
                } else if (e.getKey().getClass() == key.getClass()
                        && e.getKey().equals(key)) {

                    V value = e.getValue();

                    array[h].remove(e);

                    size--;

                    return value;
                }
            }
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    private void putAll(Set<Entry<K, V>> s) {
        for (Entry<K, V> e : s) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        size = 0;
        hashSize = STARTING_HASH_SIZE;
        array = (Collection<Entry<K, V>>[]) new Collection[hashSize];
    }

    @Override
    public Set<K> keySet() {
        Set<K> ret = new HashSet<>();

        for (Collection<Entry<K, V>> innerList : array) {
            if (innerList != null) {
                for (Entry<K, V> e : innerList) {
                    ret.add(e.getKey());
                }
            }
        }

        return ret;
    }

    @Override
    public Collection<V> values() {
        List<V> ret = new ArrayList<>();

        for (Collection<Entry<K, V>> innerList : array) {
            if (innerList != null) {
                for (Entry<K, V> e : innerList) {
                    ret.add(e.getValue());
                }
            }
        }

        return ret;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> ret = new HashSet<>();

        for (Collection<Entry<K, V>> innerList : array) {
            if (innerList != null) {
                for (Entry<K, V> e : innerList) {
                    ret.add(e);
                }
            }
        }

        return ret;
    }

    private Collection<Entry<K, V>> getNewInnerCollection() {
        //abstracted to we can switch between array list, linked list, or tree set
        return new ArrayList<>();
    }

    private void expandList() {
        Set<Entry<K, V>> s = entrySet();

        hashSize = hashSize * HASH_MULTIPLIER;
        size = 0;

        array = (Collection<Entry<K, V>>[]) new Collection[hashSize];

        putAll(s);
    }
}
