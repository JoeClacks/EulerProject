/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Euler;

import java.math.BigInteger;

/**
 *
 * @author joe
 */
public class Euler21to30 {
    public static void Problem25(){
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c;
        
        int i = 3;
        while(true){
            c = b.add(a);
            
            if(c.toString().length() >= 1000)
            {
                break;
            }
            
            a = b;
            b = c;
            i++;
        }    
        
        System.out.println(i);
    }
}
