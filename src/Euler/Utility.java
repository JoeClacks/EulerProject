/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author joe
 */
public class Utility {

    public static boolean isPalindrome(int number) {
        int original = number;
        int reverse = 0;
        while (number < 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return original == reverse;
    }

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

    public String join(Collection<String> c) {
        StringBuilder sb = new StringBuilder();
        for (String s : c) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String joinInts(Collection<Integer> list, String spacer) {
        StringBuilder sb = new StringBuilder();

        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            sb.append(i.next());
            if (i.hasNext()) {
                sb.append(spacer);
            }
        }
        return sb.toString();
    }

    public static String join(Integer[] list, String spacer) {
        StringBuilder sb = new StringBuilder();

        sb.append(list[0]);
        for (Integer i : list) {
            sb.append(spacer);
            sb.append(i);
        }
        return sb.toString();
    }

    public static Integer[] findFactors(long n) {
        ArrayList<Integer> retList = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                retList.add(i);
                //System.out.println(i);
            }
        }

        retList.add((int) n);

        return retList.toArray(new Integer[retList.size()]);
    }

    public static Integer[] findProperDivisors(long n) {
        ArrayList<Integer> retList = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                retList.add(i);
            }
        }

        return retList.toArray(new Integer[retList.size()]);
    }
}
