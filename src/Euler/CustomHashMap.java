package Euler;

import java.util.*;

/**
 * Created by Joseph Clark on 2/11/14.
 */
public class CustomHashMap<K, V> implements Map<K, V> {
    private List<Collection<Entry<K, V>>> list;

    private static final boolean useList = false;
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

        for (Entry<K, V> e : list.get(h)) {
            if (e == null) {
                return false;
            } else if (e.getKey().getClass() == key.getClass()
                    && e.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }


    @Override
    public boolean containsValue(Object value) {
        for (Collection<Entry<K, V>> innerList : list) {
            for (Entry<K, V> e : innerList) {
                if (e.getValue().getClass() == value.getClass()
                        && e.getValue().equals(value))
                    return true;
            }
        }

        return false;
    }

    @Override
    public V get(Object key) {
        int h = key.hashCode() % hashSize;

        for (Entry<K, V> e : list.get(h)) {
            if (e == null) {
                return null;
            } else if (e.getKey().getClass() == key.getClass()
                    && e.getKey().equals(key)) {
                return e.getValue();
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        int h = key.hashCode() % hashSize;

        Collection<Entry<K, V>> subList = list.get(h);
        if (subList == null) {
            subList = list.set(h, getNewInnerCollection());
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

            if(size > hashSize * MAX_SIZE_MULTIPLER) {
                expandList();
            }
        }

        return old;
    }

    @Override
    public V remove(Object key) {
        int h = key.hashCode() % hashSize;

        for (Entry<K, V> e : list.get(h)) {
            if (e == null) {
                return null;
            } else if (e.getKey().getClass() == key.getClass()
                    && e.getKey().equals(key)) {

                V value = e.getValue();

                list.get(h).remove(e);

                size--;

                return value;
            }
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    public void putAll(Set<Entry<K, V>> s) {
        for(Entry<K, V> e : s) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        size = 0;
        hashSize = STARTING_HASH_SIZE;
        list = getNewOuterCollection(hashSize);
    }

    @Override
    public Set<K> keySet() {
        Set<K> ret = new HashSet<>();

        for (Collection<Entry<K, V>> innerList : list) {
            for (Entry<K, V> e : innerList) {
                ret.add(e.getKey());
            }
        }

        return ret;
    }

    @Override
    public Collection<V> values() {
        Set<V> ret = new HashSet<>();

        for (Collection<Entry<K, V>> innerList : list) {
            for (Entry<K, V> e : innerList) {
                ret.add(e.getValue());
            }
        }

        return ret;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> ret = new HashSet<>();

        for (Collection<Entry<K, V>> innerList : list) {
            for (Entry<K, V> e : innerList) {
                ret.add(e);
            }
        }

        return ret;
    }

    private Collection<Entry<K, V>> getNewInnerCollection() {
        //abstracted to we can switch between array list, linked list, or tree set
        return new ArrayList<>();
    }

    private List<Collection<Entry<K, V>>> getNewOuterCollection(int size) {
        return new ArrayList<>(size);
    }

    private void expandList() {
        Set<Entry<K, V>> s = entrySet();

        hashSize = hashSize * HASH_MULTIPLIER;

        list = getNewOuterCollection(hashSize);

        putAll(s);
    }
}
