/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.ArrayList;

/**
 *
 * @author joe
 */
public class Utility {

    public static boolean isPrime(long i) {
        if (i == 0 || i == 1 || i == -1) {
            return false;
        } else if (i < 4) {
            return true;
        } else if (i % 2 == 0) {
            return false;
        } else if (i < 9) {
            return true;
        } else if (i % 3 == 0) {
            return false;
        } else {
            double sqrt = Math.sqrt(i);
            for (int j = 5; sqrt >= j; j += 6) {
                if (i % j == 0 || i % (j + 2) == 0) {
                    return false;
                }
            }

            return true;
        }
    }
    
    public static Integer[] findPrimeFactorication(int n) {
        ArrayList<Integer> retList = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                retList.add(i);
            }
        }

        retList.add(n);

        return retList.toArray(new Integer[retList.size()]);
    }
    
    public static boolean isPalindrome(int number) {
        int original = number;
        int reverse = 0;
        while (number < 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return original == reverse;
    }
}
