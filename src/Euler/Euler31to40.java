package Euler;

/**
 * Created by joe on 2/4/14.
 */


public class Euler31to40 {

    public static void Problem35() throws Exception {
        int max = 1000000;
        PrimeSieve ps = new PrimeSieve(max);

        long count = 0;
        for (int i = 1; i < max; i++) {
//            System.out.println("::" + i);
            boolean stillPrime = true;
            int value = i;
            int limit = (int) Math.floor(Math.log10(i));
            for (int j = 0; j <= limit; j++) {
                if (!ps.isPrime(value)) {
                    stillPrime = false;
                    break;
                }
                int mod = value % 10;
                value = (value / 10) + (mod * (int) Math.pow(10, limit));
//                System.out.println(":" + value);
            }

            if (stillPrime) {
//                System.out.println(i);
                count++;
            }
        }

        System.out.println("Count: " + count);
    }
}
