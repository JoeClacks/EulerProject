package Euler;

import java.util.BitSet;

/**
 * Created by joe on 2/4/14.
 */
public class PrimeSieve {
    private static BitSet bitSet;

    private int mapIndex(int value) throws Exception {
        if ((value + 1) % 6 == 0) {
            return ((value + 1) / 3);
        } else if ((value - 1) % 6 == 0) {
            return ((value - 1) / 3 + 1);
        } else {
            //failure case - should not be hit as long as value is 6*k ± 1;
            throw new Exception("Index out of bounds");
        }
    }

    private int rmapIndex(int index) {
        if (index % 2 == 0) {
            return index * 3 - 1;
        } else {
            return ((index - 1) * 3) + 1;
        }
    }

    public PrimeSieve(int maximum) throws Exception {
        //we're storing values for 6k±1, so we need 1/3 the space
        bitSet = new BitSet((maximum + 2) / 3);


        for (int i = 1; i < maximum / 6; i++) {
            //-1 case
            //if (is prime) : mark all multiples as not prime
            int num = 6 * i - 1;
            if (!bitSet.get(mapIndex(num))) {
                for (int j = (num) * 2; j < maximum; j += (num)) {
                    if (isValidIndex(j)) {
                        bitSet.set(mapIndex(j));
                    }

                }
            }

            //+1 case
            num = 6 * i + 1;
            if (!bitSet.get(mapIndex(num))) {
                for (int j = (num) * 2; j < maximum; j += (num)) {
                    if (isValidIndex(j)) {
                        bitSet.set(mapIndex(j));
                    }
                }
            }
        }
    }

    private boolean isValidIndex(int value) {
        if ((value - 1) % 6 != 0 && (value + 1) % 6 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isPrime(int i) throws Exception {
        i = Math.abs(i);
        if (i == 0 || i == 1) {
            return false;
        } else if (i < 4) {
            return true;
        } else if (i % 2 == 0) {
            return false;
        } else if (i < 9) {
            return true;
        } else if (i % 3 == 0) {
            return false;
        } else if (mapIndex(i) > bitSet.size()){
            throw new Exception("Index out of bounds");
        } else {
            //false is prime
            return !bitSet.get(mapIndex(i));
        }
    }
}
