/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;

import static Euler.Utility.findProperDivisors;
import static Euler.Utility.isPrime;

/**
 * @author joe
 */
public class Euler21to30 {

    public static int sumOfDivisors(int n) {
        int sum = 1;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                sum += n/ i;
            }
        }

        return sum;
    }

    public static boolean isAbundant(long i) {
        return sumOfDivisors((int)i) > i;

//        long sum = 0;

//        for (Integer divisor : findProperDivisors(i)) {
//            sum += divisor;
//        }

//        return sum > i;
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

    private static int Problem26_helper(int numerator, int denominator) {
        List<Integer> dpList = new ArrayList<>();

        while (true) {
            if (numerator % denominator == 0) {
                //terminated
                return 0;
            } else {
                while (numerator < denominator) {
                    numerator *= 10;
                    dpList.add(-1);
                }

                for (int i = 0; i < dpList.size(); i++) {
                    if (dpList.get(i) == numerator) {
                        return dpList.size() - i;
                    }
                }

                dpList.add(numerator);

                numerator = numerator % denominator;
                numerator *= 10;
            }

        }
    }

    public static void Problem26() {
        int bLength = -1;
        for (int i = 1; i < 1000; i++) {
            if (isPrime(i)) {
                int length = Problem26_helper(1, i);
                if (length > bLength) {
                    bLength = length;
                    System.out.println(i + ":" + bLength);
                }
            }
        }
    }

    public static void Problem27() {
        int best = -1;
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                for (int n = 0; ; n++) {
                    int value = n * n + n * a + b;
                    if (isPrime(value)) {
                        if (best < n) {
                            best = n;
                            System.out.println(a + ":" + b + ":" + n + ":" + value + ":" + a * b);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void Problem28() {
        long sum = 1;
        for (int i = 3; i <= 1001; i += 2) {
            long iSqr = i * i;
            long iMin1 = i - 1;
            sum += (iSqr - iMin1 * 0) + (iSqr - iMin1 * 1) + (iSqr - iMin1 * 2) + (iSqr - iMin1 * 3);
        }

        System.out.println(sum);
    }

    public static void Problem29() {
        HashSet<Double> set = new HashSet<>();

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                set.add(Math.pow(a, b));
            }
        }
        for (Double d : set) {
            System.out.print(d + ":");
        }
        System.out.println();
        System.out.println(set.size());
    }

    public static void Problem30() {
        List<Long> outList = new ArrayList<>();
        for (long i = 2; i < 10000000; i++) {
            long a = i % 10;
            long b = (i / 10) % 10;
            long c = (i / 100) % 10;
            long d = (i / 1000) % 10;
            long e = (i / 10000) % 10;
            long f = (i / 100000) % 10;
            long g = (i / 1000000) % 10;

            if (i ==  a * a * a * a * a
                    + b * b * b * b * b
                    + c * c * c * c * c
                    + d * d * d * d * d
                    + e * e * e * e * e
                    + f * f * f * f * f
                    + g * g * g * g * g) {
                outList.add(i);
                System.out.println(i);
            }
        }

        long sum = 0;
        for(Long l : outList) {
            sum += l;
        }

        System.out.println(sum);
    }
}
