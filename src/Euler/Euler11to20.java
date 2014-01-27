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
public class Euler10to20 {
    
    public static void Problem11() {
        String s = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n"
                + "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n"
                + "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"
                + "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"
                + "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"
                + "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"
                + "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"
                + "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"
                + "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n"
                + "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"
                + "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"
                + "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"
                + "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"
                + "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n"
                + "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n"
                + "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n"
                + "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n"
                + "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n"
                + "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n"
                + "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
        String[] rows = s.split("\n");

        int[][] grid = new int[rows.length][rows.length];//assumes square grid;

        for (int i = 0; i < rows.length; i++) {
            String[] cells = rows[i].split(" ");
            for (int j = 0; j < rows.length; j++) {
                grid[i][j] = Integer.parseInt(cells[j]);
            }
        }

        int size = rows.length;
        int bestProduct = -1;
        //first from right to left
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size - 3; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row][col + i];
//                    System.out.print(grid[row][col + i] + " ");

                }
//                    System.out.println("");
//                    System.out.println("product: " + product);
                if (product > bestProduct) {
                    bestProduct = product;
//                    System.out.println("row: " + row + " col: " + col);
                }
            }
        }

        //now top to bottom
        for (int row = 0; row < size - 3; row++) {
            for (int col = 0; col < size; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row + i][col];
                }

                if (product > bestProduct) {
                    bestProduct = product;
                }
            }
        }

        //diagonal left to right
        for (int row = 0; row < size - 3; row++) {
            for (int col = 0; col < size - 3; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row + i][col + i];
                }

                if (product > bestProduct) {
                    bestProduct = product;
                }
            }
        }

        //diagonal right to left
        for (int row = 3; row < size; row++) {
            for (int col = 0; col < size - 3; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row - i][col + i];
                }

                if (product > bestProduct) {
                    bestProduct = product;
                }
            }
        }

        System.out.println(bestProduct);
    }

    public static Integer[] findFactors(int n) {
        ArrayList<Integer> retList = new ArrayList<>();

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                retList.add(i);
                System.out.println(i);
            }
        }

        retList.add(n);

        return retList.toArray(new Integer[retList.size()]);
    }



    public static void Problem12() {
        //...so we can find all triangle numbers through the equation
        //  n(n+1)/2 , we can do a binary search for the first one with 500 factors
//        Euler.
//                findFactors(100);
//        int factorCount = -1;
//        for (int i = 1; factorCount <= 500; i++) {
//            int t = (i * (i + 1)) / 2;
//            
//            Integer[] factors = findFactors(t);
//            factorCount = factors.length;
//
//            if(factorCount >= 500)
//            {
//                System.out.println(t);
//                System.out.println(factorCount);
//            }
//                
//
//        }
    }
}
