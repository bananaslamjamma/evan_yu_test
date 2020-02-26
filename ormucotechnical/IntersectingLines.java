
package ormucotechnical;
import java.util.*;
import java.util.stream.IntStream;
import java.util.Scanner;

/**
 * February 17th 2020
 * @author EVAN YU
 */
public class IntersectingLines {

    public static void main(String[] args) {
        int x1, x2, x3, x4;
        Scanner keyboard = new Scanner(System.in);
        
        //User input
        System.out.println("Please enter the coordinates for the first line: ");
        System.out.println("x1: ");
        x1 = keyboard.nextInt();
        System.out.println("x2: ");
        x2 = keyboard.nextInt();
        System.out.println("Please enter the coordinates for the second line: ");
        System.out.println("x3: ");
        x3 = keyboard.nextInt();
        System.out.println("x4: ");
        x4 = keyboard.nextInt();
        
        
        //Take user input, generate a range of numbers, based on the min and max received
        //Convert that into an array
        IntStream stream1 = IntStream.range(x1,x2+1);
        IntStream stream2 = IntStream.range(x3,x4+1);    
        int [] line1Array = stream1.toArray();
        int [] line2Array = stream2.toArray();
        boolean result  = intersect(line1Array, x3,x4);
        
        //case where line1 is encapsulated in line 2
        if(line2Array.length > line1Array.length){
            result  = intersect(line2Array, x1,x2);   
        }
        System.out.println(result);
    }
    
    static boolean intersect(int array[], int min, int max){       
        for(int i =0; i < array.length; i++){
            //checks if the array contains the min or max of the second line
            if(array[i] == min || array[i] == max){
                return true;
            }
        }     
        return false;
    }  
}
