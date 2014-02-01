/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;

import static Euler.Utility.findProperDivisors;

/**
 * @author joe
 */
public class Euler21to30 {

    public static boolean isAbundant(long i) {
        long sum = 0;

        for (Integer divisor : findProperDivisors(i)) {
            sum += divisor;
        }

        return sum > i;
    }

    public static void Problem23() {
        //28123 is our max

        final int LIMIT = 30000;
        BitSet sumSet = new BitSet(LIMIT);
        ArrayList<Integer> abundantList = new ArrayList<>();

        //find all the abundant numbers
        for (int i = 1; i < LIMIT; i++) {
            if (isAbundant(i)) {
                abundantList.add(i);
//                System.out.println(i);
            }
        }

        //now flip the bits for all numbers that are the sum of two abundant numbers
        for (int i = 0; i < abundantList.size(); i++) {
            Integer a = abundantList.get(i);
            for (int j = i; j < abundantList.size(); j++) {
                Integer b = abundantList.get(j);

                //System.out.println(a + ":" + b + ":" + (a + b));

                if (a + b < LIMIT) {
                    sumSet.set(a + b);
                } else {
                    break;
                }

            }
        }

        long sum = 0;
        for (int j = 0; j < LIMIT; j++) {

            if (sumSet.get(j) == false) {
//                System.out.println(j);
                sum += j;
            }
        }

        System.out.println(sum);
    }

    public static void Problem24() {
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 1; i < 1000000; i++) {

            int k = 8;
            for (; k >= 0; k--) {
                if (values[k] < values[k + 1]) {
                    break;
                }
            }

            int l = 9;
            for (; l >= 0; l--) {
                if (values[k] < values[l]) {
                    break;
                }
            }

            int tmp = values[k];
            values[k] = values[l];
            values[l] = tmp;

            l = 9;
            k++;
            while (k < l) {
                tmp = values[k];
                values[k] = values[l];
                values[l] = tmp;

                k++;
                l--;
            }

//            System.out.println(Utility.join(values, ":"));
        }
        System.out.println(Utility.join(values, ":"));
    }

    public static void Problem25() {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c;

        int i = 3;
        while (true) {
            c = b.add(a);

            if (c.toString().length() >= 1000) {
                break;
            }

            a = b;
            b = c;
            i++;
        }

        System.out.println(i);
    }

}
