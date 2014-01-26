/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Euler;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author joe
 */
public class Strings {
    
    //  O(s) time complexity
    //  O(1) space complexity
    public static boolean StringCharsUnique_Ascii(String s) throws Exception
    {
        if(s == null)
        {
            throw new Exception("Passed string was null");
        }
        
        //basic ascii table stops at 128
        int MAX_SIZE = 128;
        
        //allocates to heap, inits to false by spec
        boolean[] seen = new boolean[MAX_SIZE]; 
        
        for(int i = 0; i < s.length(); i++)
        {
            //chars in java ar 16 bits, ints are 32 bits, conversion works 
            //  automatically
            if(s.charAt(i) >= MAX_SIZE)
            {
                throw new Exception("Passed string was not ascii");
            }
            
            if(seen[s.charAt(i)])
            {
                return false;
            }
            else
            {
                seen[s.charAt(i)] = true;
            }
        }
        
        return true;
    }
   
    public static boolean StringCharsUnique_Unicode(String s) throws Exception
    {
        if(s == null)
        {
            throw new Exception("Passed string was null");
        }
               
        HashSet<Integer> h = new HashSet<>();
        
        for(int i = 0; i < s.length();)
        {
            int cp = s.codePointAt(i);
            
            if(h.contains(cp))
            {
                return false;
            }
            else
            {
                h.add(cp);
            }
            
            i += Character.charCount(cp);
        }
        
        return true;
    }
    
}
