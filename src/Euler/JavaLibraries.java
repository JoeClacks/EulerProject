/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

/**
 *
 * @author joe
 */
public class JavaLibraries {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        //Strings.StringCharsUnique_Unicode("\u00a5123\u00a5123");
        long start = System.nanoTime();

//        Test.main();
//        Euler1to10.Problem5();
//        Euler11to20.Problem16();
//        Euler21to30.Problem30();
          Euler31to40.Problem35();

        long end = System.nanoTime();
        long microseconds = ((end - start) / 1000);
        System.out.println(microseconds + " microseconds");
    }

}
