/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Pack200;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joe
 */
public class CustomHashMapTest {

    public CustomHashMapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of size method, of class CustomHashMap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        assertEquals(0, h.size());

        h.put(0, "zero");
        assertEquals(1, h.size());

        h.put(1, "one");
        assertEquals(2, h.size());

        h.put(1, "two");
        assertEquals(2, h.size());

        h.remove(1);
        assertEquals(1, h.size());

        h.remove(0);
        assertEquals(0, h.size());
    }

    /**
     * Test of isEmpty method, of class CustomHashMap.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");

        CustomHashMap<Integer, String> h = new CustomHashMap();
        assertEquals(true, h.isEmpty());

        h.put(0, "zero");
        assertEquals(false, h.isEmpty());
    }

    /**
     * Test of containsKey method, of class CustomHashMap.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");

        CustomHashMap<Integer, String> h = new CustomHashMap();
        assertEquals(false, h.containsKey(0));

        h.put(0, "zero");
        assertEquals(true, h.containsKey(0));
    }

    /**
     * Test of containsValue method, of class CustomHashMap.
     */
    @Test
    public void testContainsValue() {
        System.out.println("containsValue");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        assertEquals(false, h.containsValue("zero"));

        h.put(0, "zero");
        assertEquals(true, h.containsValue("zero"));
    }

    /**
     * Test of get method, of class CustomHashMap.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        assertEquals(null, h.get(0));

        h.put(0, "zero");
        assertEquals("zero", h.get(0));
    }

    /**
     * Test of put method, of class CustomHashMap.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        assertEquals(0, h.size());
        assertEquals(null, h.put(0, "zero"));
        assertEquals("zero", h.put(0, "one"));
        assertEquals(1, h.size());
    }

    /**
     * Test of remove method, of class CustomHashMap.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        h.put(0, "zero");
        assertEquals("zero", h.remove(0));
        assertEquals(false, h.containsKey(0));
        assertEquals(0, h.size());
    }

    /**
     * Test of putAll method, of class CustomHashMap.
     */
    @Test
    public void testPutAll_Map() {
        System.out.println("putAll");
        CustomHashMap<Integer, String> h = new CustomHashMap();

        HashMap<Integer, String> s = new HashMap<>();
        s.put(1, "one");
        s.put(2, "two");

        h.putAll(s);

        assertEquals("one", h.get(1));
        assertEquals("two", h.get(2));
    }

    /**
     * Test of clear method, of class CustomHashMap.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        h.put(0, "zero");
        h.clear();
        assertEquals(0, h.size());
    }

    /**
     * Test of keySet method, of class CustomHashMap.
     */
    @Test
    public void testKeySet() {
        System.out.println("keySet");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        h.put(1, "one");
        h.put(2, "two");
        Set<Integer> s = h.keySet();

        assertEquals(false, s.contains(0));
        assertEquals(true, s.contains(1));
        assertEquals(true, s.contains(2));
    }

    /**
     * Test of values method, of class CustomHashMap.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        h.put(1, "one");
        h.put(2, "two");
        h.put(3, "one");
        Object[] values = h.values().toArray();
        Arrays.sort(values);

        assertEquals("one", values[0]);
        assertEquals("one", values[1]);
        assertEquals("two", values[2]);
    }

    /**
     * Test of entrySet method, of class CustomHashMap.
     */
    @Test
    public void testEntrySet() {
        System.out.println("entrySet");
        CustomHashMap<Integer, String> h = new CustomHashMap();
        h.put(1, "one");
        h.put(2, "two");
        h.put(3, "one");
        h.put(3, "three");

        Set<Map.Entry<Integer, String>> s = h.entrySet();
        assertEquals(3, s.size());
    }

    /**
     * Test of entrySet method, of class CustomHashMap.
     */
    @Test
    public void testExpandList() {
        System.out.println("entrySet");
        CustomHashMap<Integer, Integer> h = new CustomHashMap();

        for (int i = 1; i <= 65536; i++) {
            h.put(i, i * 10);
        }

        assertEquals(65536, h.size());

        for (int i = 1; i <= 65536; i++) {
            h.put(i, i * 10);
        }

        assertEquals(65536, h.size());

        for (int i = 1; i <= 65536; i++) {
            assertEquals(i * 10, (int) h.remove(i));
        }

        assertEquals(0, h.size());
    }

}
