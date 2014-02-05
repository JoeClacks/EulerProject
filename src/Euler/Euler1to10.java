/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.ArrayList;
import java.util.BitSet;

/**
 *
 * @author joe
 */
public class Euler1to10 {

    //If we list all the natural numbers below 10 that are multiples of 3 or 5, 
    //  we get 3, 5, 6 and 9. The sum of these multiples is 23.
    //Find the sum of all the multiples of 3 or 5 below 1000.
    public static void Problem1() {
        long total = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                total += i;
            }
        }

        System.out.println(total);
    }

    public static void Problem2() {
        //using the dynamic programming approach
        ArrayList<Integer> fib = new ArrayList<>();

        fib.add(1);
        fib.add(1);

        //build the array
        int max = 0;
        for (int i = 2; fib.get(i - 1) <= 4000000; i++) {
            int newValue = fib.get(i - 1) + fib.get(i - 2);
            fib.add(newValue);
            max = i;
        }

        //add every even value
        //  (always every third value)
        long total = 0;
        for (int i = 2; i < max; i += 3) {
            total += fib.get(i);
        }

        System.out.println(total);
    }

    public static void Problem3() {
        long number = 600851475143L;

        for (long i = 2;; i++) {
            while (number % i == 0) {
                System.out.println(i);

                number = number / i;

                if (number == 1) {
                    return;
                }
            }
        }
    }



    public static void Problem4() {
        int besta = 0;
        int bestb = 0;
        int bestSum = 0;
        for (int i = 999; i >= 100; i--) {

            if (i * i < bestSum) {
                System.out.println(besta);
                System.out.println(bestb);
                System.out.println(bestSum);
                return;
            }

            for (int j = i; j >= 100; j--) {
                int sum = i * j;

                if (sum < bestSum) {
                    break;
                } else if (Utility.isPalindrome(sum) && sum > bestSum) {
                    besta = i;
                    bestb = j;
                    bestSum = sum;
                    break;
                }
            }
        }
    }

    private static boolean Problem5_Solution(int num) {
        for (int i = 11; i <= 20; i++) {
            if (num % i != 0) {
                return false;
            }
        }

        return true;
    }

    //todo: there is a much better solution
    public static void Problem5() {
        //the number must have all the primes as factors;
        int number = 1;
        for (int i = 2; i <= 20; i++) {
            if (Utility.isPrime(i)) {
                number *= i;
            }
        }

        System.out.println(number);

        //the number must be evenly divisible by 20
        while (number % 20 != 0) {
            number++;
        }

        System.out.println(number);

        //now run up by 20 until we get an answer
        while (!Problem5_Solution(number)) {
            number += 20;
        }

        System.out.println(number);
    }

    public static void Problem6() {
        int sumSquares = 0;

        for (int i = 1; i <= 100; i++) {
            sumSquares += i * i;
        }

        System.out.println(sumSquares);

        int squareOfSum = 0;

        for (int i = 1; i <= 100; i++) {
            squareOfSum += i;
        }

        squareOfSum = squareOfSum * squareOfSum;

        System.out.println(squareOfSum);

        System.out.println(squareOfSum - sumSquares);
    }

    public static void Problem7() {
        int nthPrime = 3;
        int num = 3;
        while (nthPrime <= 10001) {
            num += 2;

            if (Utility.isPrime(num)) {
                nthPrime++;
            }
        }

        System.out.println(num);
    }

    public static void Problem8() {
        String s = "73167176531330624919225119674426574742355349194934"
                + "96983520312774506326239578318016984801869478851843"
                + "85861560789112949495459501737958331952853208805511"
                + "12540698747158523863050715693290963295227443043557"
                + "66896648950445244523161731856403098711121722383113"
                + "62229893423380308135336276614282806444486645238749"
                + "30358907296290491560440772390713810515859307960866"
                + "70172427121883998797908792274921901699720888093776"
                + "65727333001053367881220235421809751254540594752243"
                + "52584907711670556013604839586446706324415722155397"
                + "53697817977846174064955149290862569321978468622482"
                + "83972241375657056057490261407972968652414535100474"
                + "82166370484403199890008895243450658541227588666881"
                + "16427171479924442928230863465674813919123162824586"
                + "17866458359124566529476545682848912883142607690042"
                + "24219022671055626321111109370544217506941658960408"
                + "07198403850962455444362981230987879927244284909188"
                + "84580156166097919133875499200524063689912560717606"
                + "05886116467109405077541002256983155200055935729725"
                + "71636269561882670428252483600823257530420752963450";

        char[] charArray = s.toCharArray();
        int[] intArray = new int[5];

        int greatestProduct = -1;

        //prefill array
        for (int i = 0; i < 5; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        for (int i = 5; i < charArray.length; i++) {
            int newProduct = 1;
            for (int j = 0; j < 5; j++) {
                newProduct *= intArray[j];
            }

            if (newProduct > greatestProduct) {
                greatestProduct = newProduct;
            }

            intArray[i % 5] = Character.getNumericValue(charArray[i]);
        }

        System.out.println(greatestProduct);
    }

    public static void Problem9() {
        for (int a = 1; a < 1000 / 3; a++) {
            for (int b = a + 1; b < 1000 / 2; b++) {
                int cBySubtraction = 1000 - (b + a);
                int cByRoots = a * a + b * b;

                if (cBySubtraction * cBySubtraction == cByRoots) {
                    System.out.println(a);
                    System.out.println(b);
                    System.out.println(cBySubtraction);

                    System.out.println(a * b * cBySubtraction);
                    return;
                }
            }
        }
    }

    public static void Problem10() {
        //start off at 5
        long total = 2 + 3;

        //from our prime function all primes are 6k +/- 1 
        //  first loop for the -1, second for the +1
        for (long j = 5; j < 2000000; j += 6) {
            if (Utility.isPrime(j)) {
                total += j;
            }
        }

        for (long j = 7; j < 2000000; j += 6) {
            if (Utility.isPrime(j)) {
                total += j;
            }
        }

        System.out.println(total);
    }

    //TODO: apply to a version of our isPrime function,
    // and optimize the sieve (we could omit all numbers except 6k +/- 1)
    public static void Problem10_2() {
        int MAX = 2000000;
        BitSet bitSet = new BitSet(MAX);

        double sqrt = Math.sqrt(MAX);

        //we will use false to represent prime or unknown
        for (int i = 3; i < sqrt; i += 2) {
            if (bitSet.get(i) == false) {//i.e. prime
                for (int j = i * 2; j < MAX; j += i) {
                    bitSet.set(j, true);
                }
            }
        }

        long total = 2;
        for (int i = 3; i < MAX; i += 2) {
            if (bitSet.get(i) == false) {//i.e. prime
                total += i;
            }
        }

        System.out.println(total);
    }
}
