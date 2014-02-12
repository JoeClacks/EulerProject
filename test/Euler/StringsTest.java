/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Euler;

import Euler.Strings;
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
public class StringsTest {
    //Wrapping so we don't have to re-write tests
    interface boolStringFunction{
        public boolean f(String s) throws Exception;
    }

    private boolStringFunction f;

    public StringsTest() {
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


    private void setUp_testStringCharsUnique_Ascii()
    {
        f = new boolStringFunction(){
            @Override
            public boolean f(String s) throws Exception
            {
                return Strings.StringCharsUnique_Ascii(s);
            }
        };
    }

    private void setUp_testStringCharsUnique_Unicode()
    {
        f = new boolStringFunction(){
            @Override
            public boolean f(String s) throws Exception
            {
                return Strings.StringCharsUnique_Unicode(s);
            }
        };
    }


    /**
     * Test of StringCharsUnique_Ascii method, of class Strings.
     * @throws java.lang.Exception
     */
    @Test
    public void testStringCharsUnique_Ascii() throws Exception {
        setUp_testStringCharsUnique_Ascii();

        assertEquals(true, f.f(""));
        assertEquals(true, f.f("`1234567890-=\\][poiuytrewsdfghjkl;'/.,mnbvcxzZXCVBNM<>?ASDFGHJKL:\"QWERTYUIOP{}|!@#$%^&*()_+"));
        assertEquals(false, f.f("aa"));
    }

    @Test(expected = Exception.class)
    public void testStringCharsUnique_Ascii_NullCheck() throws Exception {
        setUp_testStringCharsUnique_Ascii();

        f.f(null);
    }

    @Test(expected = Exception.class)
    public void testStringCharsUnique_Ascii_BoundsCheck() throws Exception {
        setUp_testStringCharsUnique_Ascii();

        f.f("\u00a5123");
    }

    @Test
    public void testStringCharsUnique_Unicode() throws Exception {
        setUp_testStringCharsUnique_Unicode();

        assertEquals(true, f.f(""));
        assertEquals(true, f.f("`1234567890-=\\][poiuytrewsdfghjkl;'/.,mnbvcxzZXCVBNM<>?ASDFGHJKL:\"QWERTYUIOP{}|!@#$%^&*()_+"));
        assertEquals(true, f.f("\u00a5123"));
        assertEquals(false, f.f("\u00a5123\u00a5123"));
        assertEquals(false, f.f("aa"));
        assertEquals(true, f.f("\uD801\uDC02"));
        assertEquals(false, f.f("\uD801\uD801"));
    }

    @Test(expected = Exception.class)
    public void testStringCharsUnique_Unicode_NullCheck() throws Exception {
        setUp_testStringCharsUnique_Unicode();

        f.f(null);
    }
}
